import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.MalformedURLException;
import java.net.URL;


public class Botm {
	public static void main(String[] args) throws MalformedURLException, IOException, ClassNotFoundException {		
	Database database;
	
	try{
		// Read from disk using FileInputStream
		FileInputStream f_in = new 
			FileInputStream("db.data");

		// Read object using ObjectInputStream
		ObjectInputStream obj_in = 
			new ObjectInputStream (f_in);

		// Read an object
		Object obj = obj_in.readObject();
		
		database = (Database) obj;
	}catch(Exception e){
		database = new Database(null);
		database.reScrapeAll();
	}
	
	database.save();
	
	}
}
