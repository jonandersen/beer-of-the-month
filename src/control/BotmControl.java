package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import model.BotmModel;

import control.ExitControl.ExitListener;

import gui.View;

public class BotmControl extends Control {
	private BotmModel botm;
	public BotmControl(View view,BotmModel botm) {
		super(view);	
		this.botm = botm;
		view.addBotmListener(new BotmListener());
		
	}

	
	public void update(Observable o, Object arg) {
				
	}
	
	public class BotmListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			view.setShowBotm(!view.botmIsVisible());
			String beers = "";
			for(String beer : botm.getAllBeers()){
				beers += beer + "\n";
			}
			view.setBotmText(beers);
			
		}
		
	}

}
