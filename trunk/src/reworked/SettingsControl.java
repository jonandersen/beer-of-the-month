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
		view.addWineCheckBoxListener(new WineCheckBoxListener());
		view.addBangForBuckCheckBoxListener(new BangForBuckCheckBoxListener());	
		view.addCheckStockCheckBoxListener(new CheckStockCheckBoxListener());
		view.addBeverageCheckBoxListener(new BeverageCheckBoxListener());
		set.addObserver(this);
	}

	
	public void update(Observable arg0, Object arg1) {
		view.setBeerCheckBox(set.get(set.BEER));
		view.setWineCheckBox(set.get(set.WINE));
		view.setBeverageCheckBox(set.get(set.BEVERAGE));
		view.setCheckStocCheckBox(set.get(set.STOCK));
		view.setBangForBuckCheckBox(set.get(set.BFB));
	}
	
	
	public class SettingListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {			
			viewSettings("Closed settings tab, no changes were made");
			set.dispatch();
		}
	}
	
	public class CancelSettingListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			viewSettings("Closed settings tab, no changes were made");
			set.dispatch();
		}	
	}
	
	public class OkSettingListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			viewSettings("Closed settings tab, changes were saved");
			set.save();
			rollModel.setCheckStock(set.get(set.STOCK));
			if(set.get(set.BFB)){
				rollModel.setBangList(set.getBangForBuck());
				rollModel.setRollList(null);
			}else{
				rollModel.setRollList(set.getForRoll());
				rollModel.setBangList(null);
			}	
		}	
	}
	
	public class BeerCheckBoxListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			set.set(set.BEER, !set.get(set.BEER));
		}	
	}
	
	public class CheckStockCheckBoxListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			set.set(set.STOCK, !set.get(set.STOCK));			
		}	
	}
	
	public class BangForBuckCheckBoxListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			set.set(set.BFB, !set.get(set.BFB));			
		}	
	}
	
	public class WineCheckBoxListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			set.set(set.WINE, !set.get(set.WINE));		
		}	
	}
	
	public class BeverageCheckBoxListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			set.set(set.BEVERAGE, !set.get(set.BEVERAGE));		
		}	
	}
	
	private void viewSettings(String close){
		if(view.settingsIsVisible()){
			view.setRecentHistory(close);
		}
		view.setShowSetting(!view.settingsIsVisible());
	}

}
