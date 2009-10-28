import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class Botm {
	public static void main(String[] args) throws MalformedURLException, IOException {		
	SystemBolagetDatabase database = new SystemBolagetDatabase();
	database.reScrapeBeer();
	}
}
