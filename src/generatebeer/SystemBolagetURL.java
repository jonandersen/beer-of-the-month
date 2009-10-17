package generatebeer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;
import java.util.StringTokenizer;

import sun.net.www.URLConnection;

public class SystemBolagetURL extends Observable {
	private ArrayList<String> list;

	public SystemBolagetURL() {
		list = new ArrayList<String>();

	}

	public ArrayList<String> beerID(URL url) throws IOException {
		

		/**
		 * A complete Java program to demonstrate how to extract multiple
		 * HTML tags from a String that contains multiple lines. Multiple
		 * lines are handled with the Pattern.MULTILINE flag.
		 */
	
		
		Scanner scan = new Scanner(url.openStream());
		
		String s = "";
		
		while (scan.hasNext()) {
			s += scan.next();
		}
		 
		    //System.out.println(s);
		    
		    // the pattern we want to search for
		    Pattern p = Pattern.compile("ue=\"(\\w+)\"", Pattern.MULTILINE);
		    Matcher m = p.matcher(s);

		    // print all the matches that we find
		    while (m.find())
		    {
		    	  //System.out.println(m.group(1));
		    	list.add(m.group(1));
		      }
		    
		return list;
		//http://www.devdaily.com/blog/post/java/how-extract-multiple-html-tags-groups-multiline-string
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
			} else if(s.contains("class=\"text_tabell\">")){					
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
						while(tok.hasMoreTokens() && !tok.peekAtNextToken().equals("<")){
							token = tok.nextToken();								
							sb.append(token);							
						}
						String country = sb.toString();
						beername = beername + "\n" + country;
						//setChanged();
						//notifyObservers(country);
						break;
					}							
				}	
				
			}
			s = scan.next();
		}
		return beername;
	}
}
