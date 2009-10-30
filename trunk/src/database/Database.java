package database;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import beverage.Beverage;


public class Database implements Serializable{
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
	
	public void updateAll(){
		
	}
	
	public void update(int beverageType){
		
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(list.get(BEER));
		return sb.toString();
	}
	
//	public void save() throws IOException{
//		System.out.println("Saving please enter a name for the database");
//		Scanner scan = new Scanner(System.in);		
//		FileOutputStream f_out = new FileOutputStream(scan.next()+".data");		
//		ObjectOutputStream obj_out = new ObjectOutputStream (f_out);		
//		obj_out.writeObject ( this );		
//		System.out.println("Successfully saved");
//	}
	
	public Beverage getRandomBeverage(){
		return list.get(BEER).getRandomBeverage();
	}
	
	public void printMe(){
		for(SystemBolagetDatabase db : list){
			System.out.println(db.toString());
		}
	}
}
