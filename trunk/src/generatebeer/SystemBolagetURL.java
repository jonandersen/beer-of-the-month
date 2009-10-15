package generatebeer;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SystemBolagetURL extends Observable {
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
		setChanged();
		notifyObservers(url.toString());
		Scanner scan = new Scanner(url.openStream());
		String s = scan.next();
		String beername = "";		
		while (scan.hasNext()) {
			if(s.contains("class=\"rubrikstor\">")) {
				beername = s.substring(19, s.length());
				s = scan.next();
				while (!s.contains("<")) {
					beername = beername + " " + s;
					s = scan.next();
				}
				setChanged();
				notifyObservers(beername);				
			} else if(s.contains("Land")){					
				while(!s.contains("class=\"text_tabell\">")){									
					s = scan.next();				
				}				
				Tokenizer tok = new Tokenizer(s);	
				while(tok.hasMoreTokens()){					
					String token = tok.nextToken();	
					if(token.equals(">") && tok.hasMoreTokens()){
						if(tok.peekAtNextToken().equals("<")){
							break;
						}						
						StringBuilder sb = new StringBuilder();
						token = tok.nextToken();							
						sb.append(token);		
						while(!tok.peekAtNextToken().equals("<")){
							token = tok.nextToken();								
							sb.append(token);							
						}
						String country = sb.toString();
						beername = beername + "\n" + country;
						setChanged();
						notifyObservers(country);
						break;
					}							
				}	
				
			}
			s = scan.next();
		}
		return beername;
	}
}
