package reworked;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import util.FileDownloader;
import util.FileParser;
import model.Database;

public class Main {

	public static void main(String[] args){
		Database db = new Database();
		File file = new File(System.getProperty("java.io.tmpdir")
                + "/systembolaget.xls");
		FileDownloader fd = new FileDownloader("http://www.systembolaget.se/Applikationer/Knap"
				+ "par/Press/Alla+Artiklar?Format=Excel", file);	
		Thread t = new Thread(fd);
		t.start();
		while(!fd.done()){
					
		}		
		FileParser fp;
		try {
			fp = new FileParser(db, new BufferedReader(new InputStreamReader(
					new FileInputStream(file), "iso-8859-1")));
			fp.parse();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RollModel model = new RollModel();
		View view = new View();
		
		RollControl control = new RollControl(model, view);
		model.addObserver(control);
		
		FridayModel fri = new FridayModel();
		FridayControl freControl = new FridayControl(view, fri);		
		fri.addObserver(freControl);
		
		SettingsModel setM = new SettingsModel(db);
		SettingsControl set = new SettingsControl(view,model,setM);
		
	}
}
