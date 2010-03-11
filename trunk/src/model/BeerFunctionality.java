package model;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Random;

public class BeerFunctionality {
	private Database db;

	public BeerFunctionality(Database db) {
		this.db = db;
	}

	public Beverage BeerOfTheMonth() {
		return randomBeverage(db.getBeerList());
	}
	
	public Beverage BeerOfTheMonth(int price) {
		return randomBeverage(db.getBeerList(price));
	}
	
	public Beverage BeerOfTheMonthInStock() throws IOException {
		return randomBeverageInStock(db.getBeerList());
	}
	
	public Beverage BeerOfTheMonthInStock(int price) throws IOException {
		return randomBeverageInStock(db.getBeerList(price));
	}

	public Beverage WineOfTheMonth() {
		return randomBeverage(db.getWineList());
	}
	
	public Beverage WineOfTheMonthInStock() throws IOException {
		return randomBeverageInStock(db.getWineList());
	}

	public Beverage BeverageOfTheMonth() {
		return randomBeverage(db.getList());
	}
	
	public Beverage BeverageOfTheMonthInStock() throws IOException {
		return randomBeverageInStock(db.getList());
	}

	public Beverage bangForTheBuck() {
		List<Beverage> beverageList = db.getList();
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

	private Beverage randomBeverage(List<Beverage> list) {
		if (list == null || list.isEmpty()) {
			return null;
		}
		Random rand = new Random();
		return list.get(rand.nextInt(list.size()));

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
		do {
			if(list.isEmpty())
				return null;
			randomInt = rand.nextInt(list.size());
			bev = list.get(randomInt);
			list.remove(randomInt);
			ur = new URL("http://www.systembolaget.se/SokDrycker/Produkt?VaruNr="+bev.getId()+"&Butik=226&SokStrangar=");
		} while (!parse.isInHouse(parse.getHtmlSource(ur, bev.getId())));
			
		return bev;

	}

}
