package reworked;

import java.util.Observable;

public class Model extends Observable{
	private int total;
	
	
	
	public Model(){
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
