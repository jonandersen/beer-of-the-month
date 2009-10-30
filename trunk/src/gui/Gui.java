package gui;

import javax.swing.JFrame;

import control.BotmMenuBar;
import control.ExitListener;

public class Gui extends JFrame{
	
	public Gui(){
		super("Beverage of the month");
		setJMenuBar(new BotmMenuBar(this, null));
        addWindowListener(new ExitListener());
        pack();
        setResizable(false);
        setVisible(true);
	}
	
    public void rename(String title) {
        setTitle(title);        
    }

}
