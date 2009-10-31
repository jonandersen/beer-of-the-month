package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.Gui;

import database.Database;

public abstract class BotmButton extends JButton{
	protected Gui gui;
	protected Database db; 
	public BotmButton(Gui gui, Database db, String name ){
		super(name);
		this.gui = gui;
		this.db = db;		
	}
	
	
	
}
