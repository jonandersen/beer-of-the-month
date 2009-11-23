package database;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.net.MalformedURLException;
import beverage.Beverage;


public abstract class SystemBolagetDatabase implements Serializable{
	public abstract void reScrape() throws MalformedURLException;
	public abstract void update();
	public abstract Beverage getRandomBeverage();
	public abstract int status();
	public abstract void addPropertyChangeListener(PropertyChangeListener pcl);
	public abstract boolean done(); 
		
	

}
