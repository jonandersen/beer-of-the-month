package parser;

import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import beverage.Beer;

public class BeerParser {
	private double status = 0;
	private boolean done;

	public HashMap<Integer, Beer> beerID(String s, PropertyChangeListener pcl) throws IOException {
		HashMap<Integer, Beer> map = new HashMap<Integer, Beer>();		
		done = false;
		
		Pattern pid = Pattern.compile("name=\"checkbox\" value=\"(\\w+)\"", Pattern.MULTILINE);
		Matcher mid = pid.matcher(s);
		
		Pattern ptype = Pattern.compile("<td nowrap=\"nowrap\" align=\"Left\" width=\"40\">(.+)</td><td al" +
				"ign=\"Right\" width=\"55\">", Pattern.MULTILINE);
		Matcher mtype = ptype.matcher(s);

		Pattern pvolume = Pattern.compile("<td align=\"Right\" width=\"55\">(.+)</td><td align=\"Right\" width=\"62\">", Pattern.MULTILINE);
		Matcher mvolume = pvolume.matcher(s);
		
											  
		Pattern plitreprice = Pattern.compile("<td align=\"Right\" width=\"62\">(.+)</td>", Pattern.MULTILINE);
		Matcher mlitreprice = plitreprice.matcher(s);
		
		Pattern punitprice = Pattern.compile("align=\"Right\" width=\"57\"><b>(.+)</b>", Pattern.MULTILINE);
		Matcher munitprice = punitprice.matcher(s);


		while (mid.find()) {			
			mtype.find();			
			mvolume.find();
			mlitreprice.find();
			munitprice.find();
			Beer beer = new Beer(mid.group(1), mtype.group(1),mvolume.group(1),mlitreprice.group(1),munitprice.group(1));			
			map.put(new Integer(beer.hashCode()), beer);
			System.out.println(beer.toString());			
			status += (100/30);			
			pcl.propertyChange(null);
			}
		done = true;
		pcl.propertyChange(null);
		return map;
	}
	
	public int status(){
		int tempStatus = (int) status;
		return tempStatus;
	}
	
	public boolean done(){
		return done;
	}
	
	
}
