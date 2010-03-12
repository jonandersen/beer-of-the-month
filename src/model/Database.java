package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class Database {
	private HashMap<String, Beverage> map;

	public Database() {
		map = new HashMap<String, Beverage>();
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

	public ArrayList<Beverage> getBeerList(int price, int[] volume, int[] alco) {
		return getList("ÖL", price, volume, alco);
	}

	public ArrayList<Beverage> getWineList() {
		ArrayList<Beverage> rlist = getList("VITA VINER");
		ArrayList<Beverage> vlist = getList("RÖDA VINER");
		rlist.addAll(vlist);
		return rlist;
	}

	public ArrayList<Beverage> getWineList(int price, int[] volume, int[] alco) {
		ArrayList<Beverage> rlist = getList("VITA VINER", price, volume, alco);
		ArrayList<Beverage> vlist = getList("RÖDA VINER", price, volume, alco);
		rlist.addAll(vlist);
		return rlist;
	}

	private ArrayList<Beverage> getList(String type) {
		Iterator<Beverage> itr = map.values().iterator();
		Beverage b;
		ArrayList<Beverage> list = new ArrayList<Beverage>();
		while (itr.hasNext()) {
			b = (Beverage) itr.next();
			if (type == null || b.getType().equals(type)) {
				list.add(b);
			}
		}
		return list;
	}

	private ArrayList<Beverage> getList(String type, int price, int[] volume,
			int[] alco) {
		Iterator<Beverage> itr = map.values().iterator();
		Beverage b;
		ArrayList<Beverage> list = new ArrayList<Beverage>();
		double beerPrice = 0;
		double bevVolume = 0;
		double bevAlco = 0;
		while (itr.hasNext()) {
			b = (Beverage) itr.next();

			try {
				beerPrice = Double.parseDouble(b.getPrice().trim().replace(',',
						'.'));
				bevVolume = Double.parseDouble(b.getVolume().trim().replace(
						',', '.'));
				bevAlco = Double.parseDouble(b.getAlcohol().replace(',', '.')
						.replace('%', ' ').trim());
			} catch (NumberFormatException e) {
				// list.add(b);
				e.printStackTrace();
			}

			// if (type == null) {
			// list.add(b);
			// continue;
			// }
			if (b.getType().equals(type)) {

				if (price > 0) {
					if (beerPrice <= (double) price);
					else
						continue;
				}

				if (volume[0] > 0 || volume[1] > 0) {
					if ((bevVolume >= volume[0] && bevVolume <= volume[1])
							|| (bevVolume >= volume[0] && volume[1] == 0));
					else
						continue;
				}

				if (alco[0] > 0 || alco[1] > 0) {
					if ((bevAlco >= (double) alco[0] && bevAlco <= (double) alco[1])
							|| (bevAlco >= alco[0] && alco[1] == 0));
					else
						continue;
				}

				
					list.add(b);
				

			}
		}
		return list;
	}

}
