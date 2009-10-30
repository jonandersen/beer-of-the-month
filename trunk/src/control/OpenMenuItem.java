package control;

import java.awt.FileDialog;

import database.Database;

import gui.Gui;

public class OpenMenuItem extends FileMenuItem  {

	protected OpenMenuItem(Gui gui, Database db) {
		super(gui, "Open", db);
		action = FileDialog.LOAD;
		
	}

	
	public void action(String fullName) {
		BotmBufferedReader reader = new BotmBufferedReader(fullName, db);
		reader.open(db);
		db.toString();
	}

}
