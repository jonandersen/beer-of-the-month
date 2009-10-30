package beverage;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public abstract class Beverage implements Serializable{
	private static final long serialVersionUID = 33337594920058035L;


	
	protected String beerParse(String pattern, String site){
        Pattern p = Pattern.compile(pattern, Pattern.MULTILINE);
        Matcher m = p.matcher(site);        
        while (m.find()) {                
                return m.group(1);
        }
        return "Finns ej";
	}
}
