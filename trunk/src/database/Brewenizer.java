package database;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

import parser.BeerParser;
import parser.URLParser;

public class Brewenizer extends Thread {
	private URL url;
	private Map map;

	public Brewenizer(URL url, Map map) {
		this.url = url;
		this.map = map;
	}

	public void run() {
		BeerParser bp = new BeerParser();
		try {
			map.putAll(bp.beerID(URLParser.parseURL(url)));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}