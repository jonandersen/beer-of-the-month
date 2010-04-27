package util;

import java.io.IOException;
import java.net.URL;

import model.Beverage;

public class StockChecker {
	
	public int checkInStock(Beverage bev) throws IOException{
		HtmlParser parse = new HtmlParser();
		URL ur = null;
		String s="";
		ur = new URL("http://www.systembolaget.se/SokDrycker/Produkt?VaruNr="+bev.getId()+"&Butik=226&SokStrangar=");
		s = parse.getHtmlSource(ur, bev.getId());
		boolean instock = parse.isInHouse(s);
		if(instock){
			return parse.getStockCount(s);
		}else{
			return 0;
		}
		
	}
}
