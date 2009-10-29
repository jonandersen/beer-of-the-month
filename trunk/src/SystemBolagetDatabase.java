import java.io.Serializable;
import java.util.HashMap;


public abstract class SystemBolagetDatabase implements Serializable{

	private static final long serialVersionUID = -5868559341208985931L;	
	protected HashMap<Integer, ? extends Beverage> database;
	
	public abstract void reScrape();
	public abstract void update();
		
	

}
