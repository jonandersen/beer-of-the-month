package beverage;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import parser.URLParser;


public class Beer extends Beverage implements Serializable{
	private String id,name,country,alchohol,taste,type,volume,litrePrice,unitPrice;
	
	
	public Beer(String id, String type, String volume, String litrePrice, String unitPrice) throws MalformedURLException, IOException{
		this.volume = volume;
		this.litrePrice = litrePrice;
		this.unitPrice = unitPrice;
		this.id = id;
		this.type = type;
		makeBeer();	
		System.out.println(name);
	}
	
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Beer){
			Beer beer = (Beer) obj;
			return id.equals(beer.id);
		}
		return false;
	}
	
	public int getBeerBang(){	
		return 0;
	}

	
	public int hashCode() {		
		return (id + type + volume).hashCode();
	}
	
	public String toString(){
		return id + " " + name;
	}
	
	private void makeBeer() throws MalformedURLException, IOException{
		String htmlcode =URLParser.parseURL(new URL("http://www.systembolaget" +
				".se/SokDrycker/Produkt?VaruNr=" + id + "&Butik" +
		"=0&SokStrangar= ")).replaceAll("\\<.*?>","");
		Scanner scan = new Scanner(htmlcode);
		String line = scan.nextLine();
		while(scan.hasNextLine()){			
			String tempName = beerParse("var __varuNamn = \"(.+)\"", line);
			if(!tempName.equals("Finns ej")){
				name = tempName;
			}
			if(line.contains("Alkoholhalt")){
				line  = scan.nextLine();
				alchohol = line.trim();
			}
			if(line.contains("Land")){
				line  = scan.nextLine();
				country = line.trim();
			}	
			if(line.contains("Smak")){
				line  = scan.nextLine();
				taste = line.trim();
			}	
			
			line = scan.nextLine();			
		}
	}
}
