package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import gui.Gui;

public class CloseMenuItem extends JMenuItem implements ActionListener {
	private Gui gui;
	protected CloseMenuItem(Gui gui) {
		super("Close");
		this.gui = gui;
		addActionListener(this);
		
	}

	
	 public void actionPerformed(ActionEvent event) {
	        //guiList.remove(gui);
	        gui.dispose();
	        System.exit(0);
//	        if (guiList.isEmpty()) {
//	            System.exit(0);
//	        } else {
//	            guiList.last().toFront();
//	        }
	    }

	


}
