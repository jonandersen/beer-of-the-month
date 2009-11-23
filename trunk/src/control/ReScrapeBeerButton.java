package control;

import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.MalformedURLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

import view.Gui;
import view.InfoArea;

import database.Database;

public class ReScrapeBeerButton extends BotmButton implements ActionListener,
		PropertyChangeListener {
	private InfoArea info;
	private JProgressBar progressBar;	
	private JFrame frame;

	public ReScrapeBeerButton(Gui gui, Database db, InfoArea info) {
		super(gui, db, "Rescrape Beer");
		addActionListener(this);
		this.info = info;
		progressBar = new JProgressBar(0, 100);
		progressBar.setValue(0);
		progressBar.setStringPainted(true);

	}

	public void actionPerformed(ActionEvent arg0) {
		try {
			frame = new JFrame();
			frame.add(progressBar);
			frame.setResizable(true);
			frame.setVisible(true);
			frame.pack();
			frame.toFront();			
			this.setEnabled(false);
			db.addPropertyChangeListener(this);
			setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			db.reScrape(db.BEER);
			info.setText("Working");			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}



	public void propertyChange(PropertyChangeEvent evt) {
		if (!db.done()) {			
			int progress = db.status();
			progressBar.setValue(progress);			
		}else{
			Toolkit.getDefaultToolkit().beep();
			this.setEnabled(true);
			setCursor(null); // turn off the wait cursor
			progressBar.setValue(progressBar.getMinimum());
		}
	}
}
