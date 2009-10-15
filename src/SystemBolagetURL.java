import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class SystemBolagetURL {
	private ArrayList<String> list;

	public SystemBolagetURL() {
		list = new ArrayList<String>();

	}

	public ArrayList<String> beerID(URL url) throws IOException {
		Scanner scan = new Scanner(url.openStream());
		String s = "";
		s = scan.next();
		while (scan.hasNext()) {
			if (s.contains("value=")) {
				boolean b = true;
				s = s.substring(7, s.length() - 1);
				for (int i = 0; i < s.length(); i++) {
					if (!Character.isDigit(s.charAt(i)) || s.length() < 6) {
						b = false;
					}
				}
				if (b) {
					if(!s.contains(" ")){
						list.add(s);
					}					
				}
			}
			s = scan.next();
		}
		return list;
	}

	public String getBeer(URL url) throws IOException {
		Scanner scan = new Scanner(url.openStream());
		String s = scan.next();
		String beername = "";		
		while (scan.hasNext()) {
			if (s.contains("class=\"rubrikstor\">")) {
				beername = s.substring(19, s.length());
				s = scan.next();
				while (!s.contains("<")) {
					beername = beername + " " + s;
					s = scan.next();
				}
				return beername;
			}
			s = scan.next();

		}
		return null;
	}
}
