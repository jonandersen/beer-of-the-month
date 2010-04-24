package reworked;

import java.util.List;
import java.util.Observable;
import java.util.Random;

import model.Beverage;

public class RollModel extends Observable{
	private int total;
	private String result;
	
	public RollModel(){
		result = "Nothing rolled";
	}
	
	public void roll(List<Beverage> list){
		Random rand = new Random();
		result = list.get(rand.nextInt(list.size())).toString();
		setChanged();
		notifyObservers();
	}
	
	public String getResult(){
		return result;
	}
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int i) {
		total = i;
		setChanged();
		notifyObservers();
		
	}
	
	
}
