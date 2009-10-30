package database;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.HashMap;

import beverage.Beverage;


public abstract class SystemBolagetDatabase implements Serializable{

	private static final long serialVersionUID = -5868559341208985931L;	
	
	
	public abstract void reScrape() throws MalformedURLException;
	public abstract void update();
	public abstract Beverage getRandomBeverage();
		
	

}
