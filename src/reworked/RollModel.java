package reworked;

import java.util.List;
import java.util.Observable;
import java.util.Random;

import model.Beverage;

public class RollModel extends Observable{	
	private String result;
	private List<Beverage> list;
	
	public RollModel(){
		result = "Nothing rolled";
	}
	
	public void setRollList(List<Beverage> list){
		this.list = list;		
	}
	
	public void roll(){
		if(list == null || list.size() == 0){
			result = "Nothing rolled";
		}else{
			Random rand = new Random();
			result = list.get(rand.nextInt(list.size())).toString();	
		}
		setChanged();
		notifyObservers();
	}
	
	public String getResult(){
		return result;
	}


	
	
}
