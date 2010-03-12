package model;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class HtmlParser {
	 public String getHtmlSource(URL url, String id) throws IOException {

         String s = null;

         // -----------------------------------------------------//
         // Step 1: Start creating a few objects we'll need.
         // -----------------------------------------------------//

         InputStream is = null;
         BufferedReader dis;
         String read;

         try {


                 is = url.openStream(); // throws an IOException
                 dis = new BufferedReader(new InputStreamReader(
                                 new BufferedInputStream(is)));

                 while ((read = dis.readLine()) != null) {
                         s += read+"\n";
                 }

         } catch (MalformedURLException mue) {

                 System.out.println("Ouch - a MalformedURLException happened.");
                 mue.printStackTrace();
                 System.exit(1);

         } catch (IOException ioe) {

                 System.out.println("Oops- an IOException happened.");
                 ioe.printStackTrace();
                 System.exit(1);

         } finally {

                 // ---------------------------------//
                 // Step 6: Close the InputStream //
                 // ---------------------------------//

                 try {
                         is.close();
                 } catch (IOException ioe) {
                         // just going to ignore this one
                 }

         } // end of 'finally' clause
         int index = s.indexOf("(nr");
         int lastIndex = index;
         for(int i = index; i < s.length() ; i ++){
        	if(s.charAt(i) == ')'){
        		lastIndex = i;
        		break;
        	}
        	
         } 
         index += 3;                 
         String newId = s.substring(index, lastIndex);
         
         
         newId = newId.replaceAll("\\t","");
         newId = newId.replaceAll("\\n","");
         if(newId.equals(id)){        	 
        	 return s;        	 
         } else{
        	 URL newURL = new URL(url.toString().replaceAll(id, newId));         	
        	 return getHtmlSource(newURL, newId);        	 
         }
         

 }

	 public boolean isInHouse(String s){		
		 return s.contains("Lagersaldo:");
	 }
	 
	 public int getStockCount(String s){		
		 int index = s.indexOf("Lagersaldo:");
		 String digits ="";
		for(int i=0; i< 40;i++){
			 if(Character.isDigit(s.charAt(index+i))){
				 digits+=s.charAt(index+i);
				 if(!Character.isDigit(s.charAt(index+i+1)))
					 return Integer.parseInt(digits);
			 }
		 }
		return -1;
	 }
	 
	 
}
