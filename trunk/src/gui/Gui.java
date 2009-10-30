package gui;

import java.net.MalformedURLException;

import javax.swing.JFrame;

import control.BotmMenuBar;
import control.ExitListener;
import database.Database;

public class Gui extends JFrame{
	
	public Gui(){
		super("Beverage of the month");
		Database db = new Database();
		try {
			db.reScrape(db.BEER);
		} catch (MalformedURLException e) {			
			e.printStackTrace();
		}
		setJMenuBar(new BotmMenuBar(this, db));
        addWindowListener(new ExitListener());
        pack();
        setResizable(false);
        setVisible(true);
	}
	
    public void rename(String title) {
        setTitle(title);        
    }

}
