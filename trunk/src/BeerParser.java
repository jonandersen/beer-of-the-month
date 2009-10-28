import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BeerParser {

	public ArrayList<Beer> beerID(String s) throws IOException {
		ArrayList<Beer> list = new ArrayList<Beer>();
		// the pattern we want to search for

		Pattern p = Pattern.compile("ue=\"(\\w+)\"", Pattern.MULTILINE);
		Matcher m = p.matcher(s);

		// print all the matches that we find
		while (m.find()) {
			// System.out.println(m.group(1));
			list.add(new Beer(m.group(1)));
		}
		return list;
	}
	
	
}
