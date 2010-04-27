package reworked;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Observable;

import util.FileDownloader;
import util.FileParser;

import model.Database;

public class StartUpModel extends Observable{
	private Database db;
	private int progress;
	
	public StartUpModel(Database db) {
		this.db = db;
		progress = 0;
	}
	
	public int getProgress(){
		return progress;
	}
	
	public void initiate(){
		File file = new File(System.getProperty("java.io.tmpdir")
                + "/systembolaget.xls");
		FileDownloader fd = new FileDownloader("http://www.systembolaget.se/Applikationer/Knap"
				+ "par/Press/Alla+Artiklar?Format=Excel", file);	
		Thread t = new Thread(fd);
		t.start();
		while(!fd.done()){
			int before = progress;
			progress = fd.progress();	
			if(before != progress){
				setChanged();
				notifyObservers();
			}
		}	
		progress = 100;
		setChanged();
		notifyObservers();
		FileParser fp;
		try {
			fp = new FileParser(db, new BufferedReader(new InputStreamReader(
					new FileInputStream(file), "iso-8859-1")));
			fp.parse();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getDatabaseSize(){
		return String.valueOf(db.getSize());
	}

}
