package control;

import gui.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;


public class ExitControl extends Control {
	
	public ExitControl(View view){
		super(view);
		view.addExitListener(new ExitListener());
	}
	
	
	
	public class ExitListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
			
		}
		
	}
	
	public void update(Observable arg0, Object arg1) {
		

	}

}
