package model;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class HtmlParser {
	 public String getHtmlSource(URL url) throws IOException {

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

         return s;

 }

	 public boolean isInHouse(String s){		
		 return s.contains("Lagersaldo:");
	 }
	 
	 
}
