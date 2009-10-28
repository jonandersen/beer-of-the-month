import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class URLParser {	
	public static String parseURL(URL url) throws IOException{
		StringBuilder sb = new StringBuilder();
		Scanner scan = new Scanner(url.openStream());
		while(scan.hasNext()){
			sb.append(scan.nextLine() + "\n");			
		}
		return sb.toString();		
	}
}
