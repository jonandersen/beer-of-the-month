package database;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

import parser.BeerParser;
import parser.URLParser;

public class Brewenizer extends Thread {
	private URL url;
	private Map map;	
	private PropertyChangeListener pcl;
	private BeerParser bp;

	public Brewenizer(URL url, Map map, PropertyChangeListener pcl) {
		this.url = url;
		this.map = map;		
		this.pcl = pcl;
		bp = new BeerParser();
	}
	
	public int Status(){
		return bp.status();
	}
	public boolean done(){
		return bp.done();
	}

	public void run() {		
		try {			
			map.putAll(bp.beerID(URLParser.parseURL(url), pcl));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}