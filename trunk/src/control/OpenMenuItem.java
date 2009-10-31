package control;

import java.awt.FileDialog;

import view.Gui;

import database.Database;


public class OpenMenuItem extends FileMenuItem  {

	protected OpenMenuItem(Gui gui, Database db) {
		super(gui, "Open", db);
		action = FileDialog.LOAD;
		
	}

	
	public void action(String fullName) {
		BotmBufferedReader reader = new BotmBufferedReader(fullName, db);
		reader.open(db);
		System.out.println(db.toString());
	}

}
