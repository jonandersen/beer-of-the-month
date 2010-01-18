import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import beverage.Beverage;


public class Database {
	private HashMap<String,Beverage> map;
	
	public Database(){
		map = new HashMap<String,Beverage>();
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
		return getList(null);
	}


	public void remove(String id) {
		map.remove(id);
		
	}


	public ArrayList<Beverage> getBeerList() {
		return getList("ÖL");
	}
	
	private ArrayList<Beverage> getList(String type){
		Iterator<Beverage> itr = map.values().iterator();		
		Beverage b;
		ArrayList<Beverage> list = new ArrayList<Beverage>();
		while(itr.hasNext()){
			b = (Beverage) itr.next();			
			if(b.getType().equals(type) || type == null){				
				list.add(b);
			}			
		}
		return list;
	}
	
	
}
