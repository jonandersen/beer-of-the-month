package reworked;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class SettingsControl extends Control{	
	private SettingsModel set;
	private RollModel rollModel;
	
	public SettingsControl(View view, RollModel rollModel, SettingsModel set) {
		super(view);
		this.rollModel = rollModel;
		this.set = set;
		view.addSettingListener(new SettingListener());
		view.addCancelSettingListener(new CancelSettingListener());
		view.addOkSettingListener(new OkSettingListener());
		view.addBeerCheckBoxListener(new BeerCheckBoxListener());		
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
			rollModel.setRollList(set.getForRoll());
			
			
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
