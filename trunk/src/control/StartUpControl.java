package control;

import gui.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;


import model.Database;
import model.StartUpModel;

public class StartUpControl extends Control{	
	private StartUpModel model;
	
	public StartUpControl(View view, StartUpModel model) {
		super(view);			
		this.model = model;
		model.addObserver(this);
		
	}

	public void initiate(){
		view.setEnabled(false);
		view.setRecentHistory("Downloading and building database");
		view.setStatus("Downloading database, please wait");
		model.initiate();
		view.setEnabled(true);
		view.setSummary("Database downloaded and created successfully \n" +
				"Database contains " + model.getDatabaseSize() + " beverages");
		view.setStatus("Done");
		view.setRecentHistory("Database built");
		
	}
	
	public void update(Observable arg0, Object arg1) {
		view.setProgress(model.getProgress());
		
	}	
}
