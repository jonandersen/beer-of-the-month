package model;



import java.util.List;
import java.util.Random;



public class BeerFunctionality {
	private Database db;
	
	
	public BeerFunctionality(Database db){
		this.db = db;
	}
	
	public Beverage BeerOfTheMonth(){
		return RandomBeverage(db.getBeerList());
	}
	
	public Beverage WineOfTheMonth() {		
		return RandomBeverage(db.getWineList());
	}
	
	public Beverage BeverageOfTheMonth(){
		return RandomBeverage(db.getList());
	}
	
	public Beverage bangForTheBuck(){
		List<Beverage> beverageList = db.getList();
		double price, volume, alcohol, currentBang = 0, tempBang;
		Beverage bestBang = null;
		for(Beverage b: beverageList){
			String s = b.getPrice().replace(",", ".");
			price = Double.parseDouble(s);
			volume = Double.parseDouble(b.getVolume());
			alcohol = Double.parseDouble(b.getAlcohol().replace("%", "").replace(",", "."));
			tempBang = price / (volume * alcohol);
			if(currentBang == 0){
				currentBang = tempBang;
			}
			if(tempBang < currentBang){
				bestBang = b;
				currentBang = tempBang;
			}
		}
		return bestBang;
	}
	
	private Beverage RandomBeverage(List<Beverage> list){
		if(list == null){
			  return null;
		  }
		Random rand = new Random();
		return list.get(rand.nextInt(list.size()));
		
	}


}


