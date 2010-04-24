package reworked;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class SettingsControl extends Control{	
	private SettingsModel set;
	
	public SettingsControl(View view) {
		super(view);
		view.addSettingListener(new SettingListener());
		view.addCancelSettingListener(new CancelSettingListener());
		view.addOkSettingListener(new OkSettingListener());
		view.addBeerCheckBoxListener(new BeerCheckBoxListener());
		set = new SettingsModel();
		set.addObserver(this);
	}

	
	public void update(Observable arg0, Object arg1) {
		view.setBeerCheckBox(set.get(set.BEER));
		view.setWineCheckBox(set.get(set.WINE));
		view.setBeverageCheckBox(set.get(set.BEVERAGE));
	}
	
	
	public class SettingListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {			
			viewSettings("Closed settings tab, no changes were made",
					"Opened settings tab");
			set.dispatch();
		}
	}
	
	public class CancelSettingListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			viewSettings("Closed settings tab, no changes were made", null);
			set.dispatch();
		}	
	}
	
	public class OkSettingListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			viewSettings("Closed settings tab, changes were saved", null);
			set.save();
			
		}	
	}
	
	public class BeerCheckBoxListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			set.set(set.BEER, !set.get(set.BEER));
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
