package generatebeer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
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

	public ArrayList<String> beerID(String s) throws IOException {

		/**
		 * A complete Java program to demonstrate how to extract multiple HTML
		 * tags from a String that contains multiple lines. Multiple lines are
		 * handled with the Pattern.MULTILINE flag.
		 */

		// the pattern we want to search for
		Pattern p = Pattern.compile("ue=\"(\\w+)\"", Pattern.MULTILINE);
		Matcher m = p.matcher(s);

		// print all the matches that we find
		while (m.find()) {
			// System.out.println(m.group(1));
			list.add(m.group(1));
		}

		return list;
		// http://www.devdaily.com/blog/post/java/how-extract-multiple-html-tags-groups-multiline-string
	}

	public String getHtmlSource(URL url) throws IOException {

		String s = null;

		// -----------------------------------------------------//
		// Step 1: Start creating a few objects we'll need.
		// -----------------------------------------------------//

		InputStream is = null;
		BufferedReader dis;
		String read;

		try {

			// ------------------------------------------------------------//
			// Step 2: Create the URL. //
			// ------------------------------------------------------------//
			// Note: Put your real URL here, or better yet, read it as a //
			// command-line arg, or read it from a file. //
			// ------------------------------------------------------------//

			// ----------------------------------------------//
			// Step 3: Open an input stream from the url. //
			// ----------------------------------------------//

			is = url.openStream(); // throws an IOException

			// -------------------------------------------------------------//
			// Step 4: //
			// -------------------------------------------------------------//
			// Convert the InputStream to a buffered DataInputStream. //
			// Buffering the stream makes the reading faster; the //
			// readLine() method of the DataInputStream makes the reading //
			// easier. //
			// -------------------------------------------------------------//
			dis = new BufferedReader(new InputStreamReader(
					new BufferedInputStream(is)));

			// ------------------------------------------------------------//
			// Step 5: //
			// ------------------------------------------------------------//
			// Now just read each record of the input stream, and print //
			// it out. Note that it's assumed that this problem is run //
			// from a command-line, not from an application or applet. //
			// ------------------------------------------------------------//

			while ((read = dis.readLine()) != null) {
				s += read;
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

	public String getBeer(URL url) throws IOException {
		setChanged();
		notifyObservers(url.toString());
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
				setChanged();
				notifyObservers(beername);
			} else if (s.contains("class=\"text_tabell\">")) {
				Tokenizer tok = new Tokenizer(s);
				while (tok.hasMoreTokens()) {
					String token = tok.nextToken();
					if (token.equals(">") && tok.hasMoreTokens()) {
						if (tok.peekAtNextToken().equals("<")) {
							break;
						}
						StringBuilder sb = new StringBuilder();
						token = tok.nextToken();
						sb.append(token);
						while (tok.hasMoreTokens()
								&& !tok.peekAtNextToken().equals("<")) {
							token = tok.nextToken();
							sb.append(token);
						}
						String country = sb.toString();
						beername = beername + "\n" + country;
						// setChanged();
						// notifyObservers(country);
						break;
					}
				}

			}
			s = scan.next();
		}
		return beername;
	}
}
