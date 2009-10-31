package control;

import java.awt.FileDialog;

import view.Gui;

import database.Database;


public class SaveMenuItem extends FileMenuItem {
	
	protected SaveMenuItem(Gui gui, Database db) {
		super(gui, "Save", db);
		action = FileDialog.SAVE;
	}

	
	public void action(String fullName) {
		BotmPrintStream print = new BotmPrintStream(fullName);
		print.save(db);		
	}
}
