import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


public class Botm {
	public static void main(String[] args) throws MalformedURLException, IOException, ClassNotFoundException {		
	
	Database database;	
	try{	
		System.out.println("Opening please enter a name for the database");
		Scanner scan = new Scanner(System.in);
		FileInputStream f_in = new FileInputStream(scan.next()+".data");		
		ObjectInputStream obj_in = new ObjectInputStream (f_in);
		Object obj = obj_in.readObject();		
		database = (Database) obj;
		System.out.println("Successfully opened");
	}catch(Exception e){
		System.out.println("No database found, creating a new one");
		database = new Database(null);
		database.reScrapeAll();
		database.save();
	}		
	}
}
