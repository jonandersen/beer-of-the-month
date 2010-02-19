package gui;

public class Settings {
	private Boolean beer;
	private Boolean wine;
	private Boolean beverage;
	private Boolean checkStock;
	
	public Settings(){
		beer = false;
		wine = false;
		beverage = false;
		checkStock = false;
	}
	
	
	public Boolean rollBeer(){
		return beer;
	}
	
	public void setBeer(Boolean beer){
		this.beer = beer;
	}
	
	public Boolean rollWine(){
		return wine;
	}
	
	public void setWine(Boolean wine){
		this.wine = wine;
	}
	
	public Boolean rollBeverage(){		
		return beverage;
	}
	
	public void setBeverage(Boolean beverage){
		this.beverage = beverage;
	}
	
	public void checkStock(Boolean checkStock){
		this.checkStock = checkStock;
	}
	
	public boolean checkStock(){
		return checkStock;
	}
	
	public void copySet(Settings set){
		if(set.beer){
			beer = true;
		} else{
			beer = false;
		}
		if(set.wine){
			wine = true;
		}else{
			wine = false;
		}
		if(set.beverage){
			beverage = true;
		}else{
			beverage = false;
		}
		if(set.checkStock){
			checkStock = true;
		} else{
			checkStock = false;
		}
	}
}
