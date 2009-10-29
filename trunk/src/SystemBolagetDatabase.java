import java.util.HashMap;


public abstract class SystemBolagetDatabase {
	protected HashMap<Integer, ? extends Beverage> database;
	
	public abstract void reScrape();
	public abstract void update();
		
	

}
