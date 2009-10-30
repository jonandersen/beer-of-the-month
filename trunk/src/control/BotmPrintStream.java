package control;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import database.Database;


public class BotmPrintStream  {
	private String fileName;
	
	
	public BotmPrintStream(String fileName)  {
		this.fileName = fileName;		
	}
	
	 public void save(Database db) {	
			FileOutputStream f_out;
			try {
				f_out = new FileOutputStream(fileName);
				ObjectOutputStream obj_out = new ObjectOutputStream (f_out);		
				obj_out.writeObject ( db );	
			} catch (FileNotFoundException e) {				
				e.printStackTrace();
			} catch (IOException e) {				
				e.printStackTrace();
			}	
			System.out.println("Successfully saved");
	    }

}
