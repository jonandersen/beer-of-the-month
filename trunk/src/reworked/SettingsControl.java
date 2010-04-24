package reworked;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class SettingsControl extends Control{

	public SettingsControl(View view) {
		super(view);
		view.addSettingListener(new SettingListener());
		view.addCancelSettingListener(new CancelSettingListener());
		view.addOkSettingListener(new OkSettingListener());
	}

	
	public void update(Observable arg0, Object arg1) {
		
		
	}
	
	
	public class SettingListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {			
			viewSettings("Closed settings tab, no changes were made",
					"Opened settings tab");
			
			
		}
	}
	
	public class CancelSettingListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			viewSettings("Closed settings tab, no changes were made", null);
		}	
	}
	
	public class OkSettingListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			viewSettings("Closed settings tab, changes were saved", null);
		}	
	}
	
	private void viewSettings(String close, String open){
		if(view.settingsIsVisible()){
			view.setRecentHistory(close);
		}else{
			view.setRecentHistory(open);
		}
		view.setShowSetting(!view.settingsIsVisible());
	}

}
