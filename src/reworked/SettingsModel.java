package reworked;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import model.Beverage;
import model.Database;

public class SettingsModel extends Observable {
	private boolean[] list;
	private boolean[] tempList;	
	private Database db;
	//Change if you add more settings (only booleans)
	//UPDATE THE SIZE IF YOU CHANGE
	private  final int SIZE = 6;	
	
	public final int BEER = 0;
	public final int WINE = 1;
	public final int BEVERAGE = 2;
	public final int BFB = 3;
	public final int STOCK = 4;
	public  final int ROLL = 5;	
	
	
	public SettingsModel(Database db){
		this.db = db;
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
	
	public ArrayList<Beverage> getRoll(){
		if(list[ROLL]){
			return getForRoll();
		}else{
			return new ArrayList<Beverage>();
		}
	}
	
	private ArrayList<Beverage> getForRoll(){
		ArrayList<Beverage> bev = new ArrayList<Beverage>();
		if(list[BEER]){
			bev.addAll(db.getBeerList());
		}
		if(list[WINE]){
			bev.addAll(db.getWineList());
		}
		if(list[BEVERAGE]){
			return db.getList();
		}
		return bev;
	}
	
	public ArrayList<Beverage> getBangForBuck(){
		if(list[BFB]){
			return getForRoll();
		}else{
			return new ArrayList<Beverage>();
		}		
	}
	
	
}
