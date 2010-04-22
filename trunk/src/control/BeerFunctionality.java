package control;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Random;

import model.Beverage;
import model.Database;
import model.HtmlParser;

public class BeerFunctionality {
	private Database db;

	public BeerFunctionality(Database db) {
		this.db = db;
	}

	public Beverage BeerOfTheMonth() {
		return randomBeverage(db.getBeerList());
	}
	
	public Beverage BeerOfTheMonth(int price,int[] volume,int[] alco) {
		return randomBeverage(db.getBeerList(price,volume,alco));
	}
	
	public Beverage BeerOfTheMonthInStock() throws IOException {
		return randomBeverageInStock(db.getBeerList());
	}
	
	public Beverage BeerOfTheMonthInStock(int price,int[] volume,int[] alco) throws IOException {
		return randomBeverageInStock(db.getBeerList(price,volume,alco));
	}

	public Beverage WineOfTheMonth() {
		return randomBeverage(db.getWineList());
	}
	
	public Beverage WineOfTheMonth(int price,int[] volume,int[] alco) {
		return randomBeverage(db.getWineList(price,volume,alco));
	}
	
	public Beverage WineOfTheMonthInStock() throws IOException {
		return randomBeverageInStock(db.getWineList());
	}
	
	public Beverage WineOfTheMonthInStock(int price,int[] volume,int[] alco) throws IOException {
		return randomBeverageInStock(db.getWineList(price,volume,alco));
	}

	public Beverage BeverageOfTheMonth() {
		return randomBeverage(db.getList());
	}
	
	public Beverage BeverageOfTheMonthInStock() throws IOException {
		return randomBeverageInStock(db.getList());
	}

	public Beverage bangForTheBuck() {
		List<Beverage> beverageList = db.getList();
		return bang(beverageList);
	}

	public Beverage randomBeverage(List<Beverage> list) {
		if (list == null || list.isEmpty()) {
			return null;
		}
		Random rand = new Random();
		return list.get(rand.nextInt(list.size()));

	}
	public boolean checkInStock(Beverage bev) throws IOException{
		HtmlParser parse = new HtmlParser();
		URL ur = null;
		String s="";
		ur = new URL("http://www.systembolaget.se/SokDrycker/Produkt?VaruNr="+bev.getId()+"&Butik=226&SokStrangar=");
		s = parse.getHtmlSource(ur, bev.getId());
		boolean instock = parse.isInHouse(s);
		if(instock){
			bev.setStockCount(parse.getStockCount(s));
		}		
		return instock;
	}
	
	private Beverage randomBeverageInStock(List<Beverage> list) throws IOException	{		
		if (list == null) {
			return null;
		}
		Random rand = new Random();
		HtmlParser parse = new HtmlParser();
		URL ur = null;
		Beverage bev = null;
		int randomInt;
		String s="";
		do {
			if(list.isEmpty())
				return null;
			randomInt = rand.nextInt(list.size());
			bev = list.get(randomInt);
			list.remove(randomInt);
			ur = new URL("http://www.systembolaget.se/SokDrycker/Produkt?VaruNr="+bev.getId()+"&Butik=226&SokStrangar=");
			s = parse.getHtmlSource(ur, bev.getId());
		} while (!parse.isInHouse(s));
		bev.setStockCount(parse.getStockCount(s));
		return bev;

	}

	public Beverage bangForTheBuckInStock() throws IOException {		
		List<Beverage> beverageList = db.getList();
		return bfbs(beverageList);		
	}
	
	private Beverage bfbs(List<Beverage> beverageList) throws IOException{
		Beverage bestBang = bang(beverageList);
		if(bestBang == null){
			return null;
		}
		if(checkInStock(bestBang)){
			return bestBang;
		}else{
			System.out.println("Checked: " + bestBang.toString() + "wasn't in stock, sorry :(");
			beverageList.remove(bestBang);
			return bfbs(beverageList);
		}
	}
	
	public Beverage bang(List<Beverage> beverageList){
		double price, volume, alcohol, currentBang = 0, tempBang;
		Beverage bestBang = null;
		for (Beverage b : beverageList) {
			String s = b.getPrice().replace(",", ".");
			price = Double.parseDouble(s);
			volume = Double.parseDouble(b.getVolume());
			alcohol = Double.parseDouble(b.getAlcohol().replace("%", "")
					.replace(",", "."));
			tempBang = price / (volume * alcohol);
			if (currentBang == 0) {
				currentBang = tempBang;
			}
			if (tempBang < currentBang) {
				bestBang = b;
				currentBang = tempBang;
			}
		}
		return bestBang;
	}
	
	public List<Beverage> beverageList(){
		return db.getList();
	}
	
	public Database getDb(){
		return db;
	}
}
