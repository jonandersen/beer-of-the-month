package model;

import java.io.FileNotFoundException;
import java.io.PrintStream;




public class BeerOfTheMonthSaver extends PrintStream {
	private Beverage beverage;
	
	public BeerOfTheMonthSaver(Beverage beverage,String filename) throws FileNotFoundException{		
		super(filename);
		this.beverage = beverage;	
			
	}

	public void save() {		
		print(beverage.toString());
		flush();
	    close();
	}
}
