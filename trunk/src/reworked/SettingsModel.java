package reworked;

import java.util.Observable;

public class SettingsModel extends Observable {
	private boolean[] list;
	private boolean[] tempList;	
	//Change if you add more settings (only booleans)
	private static final int SIZE = 3;
	public static final int BEER = 0;
	public static final int WINE = 1;
	public static final int BEVERAGE = 2;
	
	
	public SettingsModel(){
		list = new boolean[SIZE];
		tempList = new boolean[SIZE];
		for(int i = 0; i < SIZE; i ++){
			list[i] = false;
			tempList[i] = false;
		}
	}
	
	public boolean get(int type){
		return list[type];
	}
	
	public void set(int type, boolean value){
		tempList[type] = value;		
	}
	
	public void save(){
		list = tempList;
		tempList = new boolean[SIZE];
		for(int i = 0; i < SIZE; i ++){
			if(list[i]){
				tempList[i] = true;
			}else{
				tempList[i] = false;
			}			
		}
		setChanged();
		notifyObservers();
	}
	
	public void dispatch(){		
		for(int i = 0; i < SIZE; i ++){
			if(list[i]){
				tempList[i] = true;
			}else{
				tempList[i] = false;
			}	
		}
		setChanged();
		notifyObservers();
	}
	
	
}
