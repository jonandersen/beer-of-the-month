import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import beverage.Beverage;


public class Database {
	private HashMap<String,Beverage> map = new HashMap<String,Beverage>();
	
	public Database(){
		
	}
	
	public void refreshDatabase(){
		
	}

	public int size() {
		return map.size();
	}

	public void add(Beverage beverage) {
		map.put(beverage.getId(), beverage);
		
	}

	public Beverage get(String id) {
		return map.get(id);
	}

	public ArrayList<Beverage> makeList() {
		Iterator<Beverage> itr = map.values().iterator();		
		Beverage b;
		ArrayList<Beverage> list = new ArrayList<Beverage>();
		while(itr.hasNext()){
			b = (Beverage) itr.next();
			list.add(b);
		}
		return list;
	}
	
	
}
