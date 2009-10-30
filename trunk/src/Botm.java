import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


public class Botm {
	public static void main(String[] args) throws MalformedURLException{		
	
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
		try {
			database.save();
		} catch (IOException e1) {			
			e1.printStackTrace();
		}
	}
	Boolean b = true;
	System.out.println("Månadens öl:");
	Scanner scan = new Scanner(System.in);
	System.out.println(database.getRandomBeverage().toString());
	while(b){		
		System.out.println("En till? (Ja/Nej)");
		if(scan.next().equals("Ja")){			
			System.out.println("Du får ingen annan!");
		}else{
			System.out.println("Skit i det då!");
			b = false;
		}
		
	}
	
	}
}
