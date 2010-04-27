package reworked;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import exception.BotMException;

public class RollControl extends Control{
	private RollModel model;
	
	public RollControl(RollModel model, View view){
		super(view);
		this.model = model;
		view.addRollListener(new RollListener());		
		view.addRollSettingListener(new RollSettingListener());
		
	}
	
	public void update(Observable arg0, Object arg1) {	
		if(arg1 != null){			
			view.setRecentHistory("Not in stock: " + (String) arg1);
		}else{
			if(model.getResult().length() == 0){
				view.setSummary(model.getBang());
			}else{
				view.setSummary(model.getResult() + "\n" + model.getBang());
			}			
		}			
	}
	
	
	
	public class RollSettingListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			
		}
	}
	
	public class RollListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Thread thread = new Thread(new Runnable(){
				public void run(){	
					view.setSummary("");
					view.setRecentHistory("Rolled");
					if(model.getCheckStock()){
						view.setStatus("Evaluating important beer decisions");
						view.setButtonsEnabled(false);
					}
					try {
						model.roll();
						model.getMostBangForTheBuck();
					} catch (BotMException e1) {				
						view.setStatus(e1.toString());
					}
					if(model.getCheckStock()){
						view.setStatus("Evaluating important beer decisions");
						view.setStatus("Done");
						view.setButtonsEnabled(true);
					}					
				}
			});	
			// Keep gui responsive to user input.
			thread.setPriority(Thread.NORM_PRIORITY); // 5, EDT = 6
			thread.start();
		}
	}
	
	public class BotmListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}
	}
}
