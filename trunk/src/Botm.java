import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import database.Database;


public class Botm {
	public static void main(String[] args){
	Database database = null;
	System.out.println("Saving please enter a name for the database");
	Scanner scan = new Scanner(System.in);
	try{	
		File file = new File(scan.next() + ".sdb");
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
		Object obj = in.readObject();
		if(obj instanceof Database)
			System.out.println("yes I am!");
			database = (Database) in.readObject();
		System.out.println("Successfully opened");		
	}catch(FileNotFoundException e){
		System.out.println("No database found, creating a new one");
		database = new Database();
		try {
			database.reScrapeAll();
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
	}catch(Exception e){
		e.printStackTrace();
		System.exit(1);
	}
	System.out.println("See");
	scan.next();
	System.out.println(database);
	scan.next();
	
	System.out.println("Saving please enter a name for the database:");
	try {
		File outputFile = new File(scan.next() + ".sdb");
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(outputFile));
		out.writeObject(database);
	} catch (FileNotFoundException e) {
		System.err.println("Target is not writable, bad permissions or folder?");
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	Boolean b = true;
	System.out.println("M�nadens �l:");
	System.out.println(database.getRandomBeverage().toString());
	while(b){		
		System.out.println("En till? (Ja/Nej)");
		if(scan.next().equals("Ja")){			
			System.out.println("Du f�r ingen annan!");
		}else{
			System.out.println("Skit i det d�!");
			b = false;
		}
		
	}
	
	}
}
