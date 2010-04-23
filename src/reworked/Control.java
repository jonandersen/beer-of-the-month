package reworked;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class Control implements Observer{
	private Model model;
	private View view;
	
	public Control(Model model, View view){
		this.model = model;
		this.view = view;
		view.addRollListener(new RollListener());
		view.addExitListener(new ExitListener());
	}

	
	
	
	
	public void update(Observable arg0, Object arg1) {
		view.setTotal(String.valueOf(model.getTotal()));		
	}
	
	public class SettingListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			
		}
	}
	
	public class RollListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			model.setTotal(model.getTotal() + 1);
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
