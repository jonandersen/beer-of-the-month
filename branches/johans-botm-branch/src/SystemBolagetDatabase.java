import java.awt.List;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SystemBolagetDatabase extends HashMap<Integer, String>{

	public SystemBolagetDatabase() {
		super(400, 1);
	}

	public void beerID(URL url) throws IOException {
		Scanner scan = new Scanner(url.openStream());
		String s;
		while (scan.hasNext()) {
			s = scan.nextLine();
			if (s.contains("<input type=\"checkbox\" name=\"checkbox\" value=")) {
				String cut = s.substring(95, 155);
				int k = 0;
				while(Character.isDigit(cut.charAt(k))) ++k;
				String beerName = cut.substring(k + 6);
				int l = 0;
				while(beerName.charAt(l) != '"') ++l;
				beerName = beerName.substring(0, l);
				int id = Integer.parseInt(cut.substring(0, k));
				if(id != 169803){
					put(id, beerName);
				}
			}
		}
	}

	public ArrayList<Integer> getKeyArray(){
		return new ArrayList<Integer>(keySet());
	}
}
