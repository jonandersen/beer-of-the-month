package control;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.util.Scanner;

import database.Database;

public class BotmBufferedReader{
	private String fileName;
	private Database db;
	public BotmBufferedReader(String fileName, Database db)  {
		this.fileName = fileName;
		this.db = db;
		
	}
	
	 public void open(Database db){
		 	Object obj = null;
			try {
				FileInputStream f_in = new FileInputStream(fileName);		
				ObjectInputStream obj_in = new ObjectInputStream (f_in);				
				obj = obj_in.readObject();
			} catch (IOException e) {				
				e.printStackTrace();
			} catch (ClassNotFoundException e) {				
				e.printStackTrace();
			}			
			db.replaceDatabase((Database) obj);			
	 }

}
