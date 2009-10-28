import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class BotM {

	public static void main(String[] args) throws IOException {
		String ur = "";
		SystemBolagetDatabase db = new SystemBolagetDatabase();
		for (int k = 1; k <= 13; k++) {
			URL url = new URL(
					"http://www.systembolaget.se/Applikationer/Sok/ResultatLista.htm?NRMODE=Publish"
							+ "ed&NRNODEGUID=%7bDCD7DFFB-CD43-4B8B-BD46-C35D089B8739%7d&NRORIGINALURL=%2fApplikationer%2fSok%2fResultatLista.htm%3fSok"
							+ "%3dAv%26SokKriteria%3dOl%3a0%3a0%3a%3a0%3a0%3a0%3a30%3a0%3a0%3a%3a%3a%3a%3a0%3a0%3a0%3a0%3a0%3a0%3a%3a%3a%3a%3a%3a%3a%3a%3a%3a%3a%3"
							+ "a%3a%3a0%3a100%3a0%3a%3aTrue%3a%3a%3a%26Butik%3d0%26SidNr%3d1%26SortKol%3dnamn%26Asc%3d1%26SokOrdinarieSort%3dTrue%26SokVarugrupp%3"
							+ "dOl%26SokStrangar%3d%25u00d6L%3aAlla%2bl%25u00e4nder%3aAlla%2bstorlekar%3a%3a%3aBeska%3aFyllighet%3aS%25u00f6tma%3a&NRCACHEHINT=Guest&"
							+ "SokVarugrupp=Ol&SokKriteria=Ol%3a0%3a0%3a%3a0%3a0%3a0%3a30%3a0%3a0%3a%3a%3a%3a%3a0%3a0%3a0%3a0%3a0%3a0%3a%3a%3a%3a%3a%3a%3a%3a%3a%3a%3"
							+ "a%3a%3a%3a0%3a100%3a0%3a%3aTrue%3a%3a%3a&SokOrdinarieSort"
							+ "=True&Sok=Av&SokStrangar=%u00d6L%3aAlla+l%u00e4nder%3aAlla+storlekar%3a%3a%3aBeska%3aFyllighet%3aS%u00f6tma%3a&Asc=1&Butik=0&SortKol=namn&sidNr="
							+ k);
			db.beerID(url);
		}
		Random random = new Random();
		ArrayList<Integer> idArray = db.getKeyArray();
		int beer = idArray.get(random.nextInt(idArray.size()));
		ur = "http://www.systembolaget.se/SokDrycker/Produkt?VaruNr=" + 169803
				+ "&Butik=0&SokStra"
				+ "gar=%u00d6L%3aAlla+l%u00e4nder%3aAlla+storlekar%3a%3a%3aBe"
				+ "ska%3aFyllighet%3aS%u00f6tma%3a";	
		System.out.println(ur);
		System.out.println(db.get(beer));
	}
}