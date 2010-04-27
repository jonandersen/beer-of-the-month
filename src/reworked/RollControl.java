package reworked;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class RollControl extends Control{
	private RollModel model;
	
	public RollControl(RollModel model, View view){
		super(view);
		this.model = model;
		view.addRollListener(new RollListener());
		view.addExitListener(new ExitListener());
		view.addRollSettingListener(new RollSettingListener());
		
	}

	
	
	
	
	public void update(Observable arg0, Object arg1) {		
		view.setSummary(model.getResult() + "\n" + model.getBang());	
	}
	
	
	
	public class RollSettingListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			
		}
	}
	
	public class RollListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			model.roll();
			model.calculateBang();
		}
	}
	
	public class BotmListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	public class ExitListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
			
		}
		
	}
}
