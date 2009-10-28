import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Beer implements Beverage{
	private String id,name,country,alchohol;
	
	
	public Beer(String id) throws MalformedURLException, IOException{
		this.id = id;
		System.out.println("en öl skapas snart");
		makeBeer();	
		System.out.println(name);
	}
	
	public String toString(){
		return id + " " + name;
	}
	
	private void makeBeer() throws MalformedURLException, IOException{
		String htmlcode =URLParser.parseURL(new URL("http://www.systembolaget" +
				".se/SokDrycker/Produkt?VaruNr=" + id + "&Butik" +
		"=0&SokStrangar= ")).replaceAll("\\<.*?>","");		;
		
		name = beerParse("var __varuNamn = \"(.+)\"", htmlcode);	
		//if(name == "Finns ej")
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
