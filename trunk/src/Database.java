import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;


public class Database implements Serializable{
	private static final long serialVersionUID = -3112184169542680377L;
	
	private ArrayList<SystemBolagetDatabase> list;
	public static final int BEER = 0;
	public static final int WINE = 1;
	public static final int BOOZE = 2;	
	
	
	public Database(ArrayList<SystemBolagetDatabase> list){
		if(list == null){
			this.list = new ArrayList<SystemBolagetDatabase>();
			this.list.add(BEER, new BeerDatabase());
			
		} else{
			this.list = list;
		}		
	}
	
	public void reScrapeAll(){
		for(int i = 0; i < list.size(); i ++){
			list.get(i).reScrape();
		}
	}
	
	public void reScrape(int beverageType){
		list.get(beverageType).reScrape();
	}
	
	public void updateAll(){
		
	}
	
	public void update(int beverageType){
		
	}
	
	public void save() throws IOException{
		System.out.println("Saving");
		// Write to disk with FileOutputStream
		FileOutputStream f_out = new 
			FileOutputStream("db.data");

		// Write object with ObjectOutputStream
		ObjectOutputStream obj_out = new
			ObjectOutputStream (f_out);

		// Write object out to disk
		obj_out.writeObject ( this );
		
		System.out.println("Saved");
	}
	
}
