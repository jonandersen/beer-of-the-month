import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Beverage {
	
	public Beverage(){
		
	}
	
	protected String beerParse(String pattern, String site){
        Pattern p = Pattern.compile(pattern, Pattern.MULTILINE);
        Matcher m = p.matcher(site);        
        while (m.find()) {                
                return m.group(1);
        }
        return "Finns ej";
	}
}
