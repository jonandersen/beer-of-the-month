package control;


import javax.swing.JMenu;
import javax.swing.JMenuBar;

import view.Gui;

import database.Database;

public class BotmMenuBar extends JMenuBar {
	
	public BotmMenuBar(Gui gui, Database db){
		JMenu file = new JMenu("File");
	    JMenu edit = new JMenu("Edit");	    
	     file.add(new SaveMenuItem(gui, db));
	     file.add(new OpenMenuItem(gui, db));
	     
	     file.add(new CloseMenuItem(gui));

	     add(file);
	     add(edit);
	}

}
