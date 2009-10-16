package generatebeer;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class BeerBuilder {

	
	public BeerBuilder(){
		
	}
	
	public String buildBeer(String contain, URL url) throws IOException{
		Scanner scan = new Scanner(url.openStream());
		String s = scan.next();
		String beername = "";
		while(!s.contains(contain)){									
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
			}							
		}
		return beername ;
	}
}
