import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BeerParser {

	public HashMap<String, Beer> beerID(String s) throws IOException {
		HashMap<String, Beer> map = new HashMap<String, Beer>();
		// the pattern we want to search for

		Pattern p = Pattern.compile("ue=\"(\\w+)\"", Pattern.MULTILINE);
		Matcher m = p.matcher(s);

		// print all the matches that we find
		while (m.find()) {
			// System.out.println(m.group(1));
			map.put(m.group(1), new Beer(m.group(1)));
		}
		return map;
	}
	
	
}
