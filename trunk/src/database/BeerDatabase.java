package database;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import beverage.Beer;
import beverage.Beverage;

import parser.BeerParser;
import parser.URLParser;

public class BeerDatabase extends SystemBolagetDatabase implements Serializable{	
	private Map<Integer, Beer> database;
	
	public BeerDatabase() {	
		database = new HashMap<Integer, Beer>();
		database = Collections.synchronizedMap(database);
	}

	public void update() {

	}
	
	public String toString(){
		return database.toString();
	}

	public void reScrape() throws MalformedURLException {
		for (int i = 1; i<=14; ++i){
			URL url = new URL("http://systembolaget.se/Applikationer/Sok/ResultatLis" +
					"ta.htm?NRMODE=Published&NRNODEGUID=%7bDCD7DFFB-CD43-4B8B-BD46-C" +
					"35D089B8739%7d&NRORIGINALURL=%2fApplikationer%2fSok%2fResultatList" +
					"a.htm%3fSok%3dAv%26SokKriteria%3dOl%3a0%3a0%3a%3a0%3a0%3a0%3a9999%" +
					"3a0%3a0%3a%3a%3a%3a%3a0%3a0%3a0%3a0%3a0%3a0%3a%3a%3a%3a%3a%3a%3a%3a%" +
					"3a%3a%3a%3a%3a%3a0%3a100%3a0%3a%3aTrue%3a%3a%3a%26Butik%3d0%26SidNr%3" +
					"d1%26SortKol%3dnamn%26Asc%3d1%26SokOrdinarieSort%3dTrue%26SokVarugrup" +
					"p%3dOl%26SokStrangar%3d%25u00d6L%3aAlla%2bl%25u00e4nder%3aAlla%2bstorl" +
					"ekar%3a%3a%3aBeska%3aFyllighet%3aS%25u00f6tma%3a&NRCACHEHINT=Guest&SokV" +
					"arugrupp=Ol&SokKriteria=Ol%3a0%3a0%3a%3a0%3a0%3a0%3a9999%3a0%3a0%3a%3a%3" +
					"a%3a%3a0%3a0%3a0%3a0%3a0%3a0%3a%3a%3a%3a%3a%3a%3a%3a%3a%3a%3a%3a%3a%3a0%" +
					"3a100%3a0%3a%3aTrue%3a%3a%3a&SokOrdinarieSort=True&Sok=Av&SokStrangar=%u" +
					"00d6L%3aAlla+l%u00e4nder%3aAlla+storlekar%3a%3a%3aBeska%3aFyllighet%3aS%" +
					"u00f6tma%3a&Asc=1&Butik=0&SortKol=namn&sidNr="+i);
			Brewenizer b = new Brewenizer(url, database);
			b.start();
		}
	}
	
	public Beverage getRandomBeverage() {
		ArrayList<Beer> list = new ArrayList<Beer>();
		for(Beer beer : database.values()){
			list.add(beer);			
		}
		Random rand = new Random();
		return list.get(rand.nextInt(list.size()));
		
	}
}
