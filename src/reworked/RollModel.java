package reworked;

import java.util.Observable;

public class RollModel extends Observable{
	private int total;
	
	
	
	public RollModel(){
		total = 0;
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
