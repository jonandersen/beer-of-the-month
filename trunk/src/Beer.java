import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Beer extends Beverage{
	private String id,name,country,alchohol;
	
	
	public Beer(String id) throws MalformedURLException, IOException{
		this.id = id;		
		makeBeer();	
		System.out.println(name);
		System.out.println(alchohol);
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
			//System.out.println(line);
			String tempName = beerParse("var __varuNamn = \"(.+)\"", line);
			if(!tempName.equals("Finns ej")){
				name = tempName;
			}
			String tempAlchohol = beerParse("Alkoholhalt (.+) %", line) + " %";
			if(!tempAlchohol.equals("Finns ej")){
				alchohol = tempAlchohol;
			}
			line = scan.nextLine();			
		}
		

		//System.out.println(htmlcode.replaceAll("\\<.*?>",""));		

	}
	
	private String beerParse(String pattern, String site){
        Pattern p = Pattern.compile(pattern, Pattern.MULTILINE);
        Matcher m = p.matcher(site);        
        while (m.find()) {                
                return m.group(1);
        }

        return "Finns ej";
	}
}
