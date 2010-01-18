package beerfunctionality;



import java.util.List;
import java.util.Random;

import database.Database;

import beverage.Beverage;

public class BeerFunctionality {
	private Database db;
	
	
	public BeerFunctionality(Database db){
		this.db = db;
	}
	
	public Beverage BeerOfTheMonth(){
	  List<Beverage> beerList = db.getBeerList();
	  if(beerList == null){
		  return null;
	  }
	  Random rand = new Random();
	  
		return beerList.get(rand.nextInt(beerList.size()-1));
	}
	
	public Beverage BeverageOfTheMonth(){
		List<Beverage> beverageList = db.getList();
		  if(beverageList == null){
			  return null;
		  }
		Random rand = new Random();
		return beverageList.get(rand.nextInt(beverageList.size() - 1));
	}
	
	public Beverage bangForTheBuck(){
		List<Beverage> beverageList = db.getList();
		double price, volume, alcohol, currentBang = 0, tempBang;
		Beverage bestBang = null;
		for(Beverage b: beverageList){
			price = Double.parseDouble(b.getPrice().replace(",", "."));
			volume = Double.parseDouble(b.getVolume());
			alcohol = Double.parseDouble(b.getAlcohol().replace("%", ""));
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
}


