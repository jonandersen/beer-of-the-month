package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

import javax.swing.JButton;

import view.Gui;
import view.InfoArea;

import database.Database;

public class ReScrapeBeerButton extends BotmButton implements ActionListener {	
	private InfoArea info;
	
	public ReScrapeBeerButton(Gui gui, Database db, InfoArea info){
		super(gui,db,"Rescrape Beer");
		addActionListener(this);
		this.info = info;
	}

	
	public void actionPerformed(ActionEvent arg0) {
		try {
			db.reScrape(db.BEER);
			info.setText("Working");
		} catch (MalformedURLException e) {			
			e.printStackTrace();
		}
		
		
	}
}
