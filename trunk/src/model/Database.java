package model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;




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

	public ArrayList<Beverage> getList() {
		return getList(null);
	}

	public void remove(String id) {
		map.remove(id);		
	}

	public ArrayList<Beverage> getBeerList() {
		return getList("ÖL");
	}
	public ArrayList<Beverage> getBeerList(int price) {
		return getList("ÖL", price);
	}
	
	public ArrayList<Beverage> getWineList() {
		ArrayList<Beverage> rlist = getList("VITA VINER");
		ArrayList<Beverage> vlist = getList("RÖDA VINER");
		rlist.addAll(vlist);
		return rlist;
	}
	
	private ArrayList<Beverage> getList(String type){
		Iterator<Beverage> itr = map.values().iterator();		
		Beverage b;
		ArrayList<Beverage> list = new ArrayList<Beverage>();
		while(itr.hasNext()){
			b = (Beverage) itr.next();			
			if(type == null || b.getType().equals(type)){				
				list.add(b);
			}			
		}
		return list;
	}
	
	private ArrayList<Beverage> getList(String type, int price){
		Iterator<Beverage> itr = map.values().iterator();		
		Beverage b;
		ArrayList<Beverage> list = new ArrayList<Beverage>();
		double beerPrice=0;
		while(itr.hasNext()){
			b = (Beverage) itr.next();	
			
			try{
				beerPrice = Double.parseDouble(b.getPrice().trim().replace(',','.'));
			}catch(NumberFormatException e){
				list.add(b);
			}
			
			if(type == null || (b.getType().equals(type) &&  beerPrice <= (double)price)){				
				list.add(b);
				
			}
			
		}
		return list;
	}
	
	
}
