package database;
import java.beans.PropertyChangeListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Scanner;

import control.ReScrapeBeerButton;

import beverage.Beverage;


public class Database extends Observable implements Serializable{
	private ArrayList<SystemBolagetDatabase> list;
	
	public static final int BEER = 0;
	public static final int WINE = 1;
	public static final int BOOZE = 2;
	
	
	
	
	
	public Database(){
			list = new ArrayList<SystemBolagetDatabase>();
			list.add(BEER, new BeerDatabase());
	}
	
	public void reScrapeAll() throws MalformedURLException{
		for(int i = 0; i < list.size(); i ++){
			list.get(i).reScrape();
		}
	}
	
	public void reScrape(int beverageType) throws MalformedURLException{
		list.get(beverageType).reScrape();
	}
	/**
	 * Returns the status of the currently working process
	 * @return a number between 0 and 100, a negative number means it isn't working
	 */
	public int status(){
		return list.get(BEER).status();
	}
	
	public void updateAll(){
		
	}
	
	public void update(int beverageType){
		
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(list.get(BEER));
		return sb.toString();
	}
	
	public Beverage getRandomBeverage(){
		return list.get(BEER).getRandomBeverage();
	}
	
	public void printMe(){
		for(SystemBolagetDatabase db : list){
			System.out.println(db.toString());
		}
	}
	
	public void replaceDatabase(Database db){
		this.list = db.list;		
		setChanged();
		notifyObservers();
	}

	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		list.get(BEER).addPropertyChangeListener(pcl);
	}
	
	public boolean done(){
		return list.get(BEER).done();
	}
}
