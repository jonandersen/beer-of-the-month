package reworked;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class FridayControl extends Control{
	private FridayModel fri;
	
	public FridayControl(View view, FridayModel fre){
		super(view);
		this.fri = fre;
		view.addRefreshListener(new RefreshListener());
	}
	
	public void update(Observable o, Object arg) {
		view.setFriday(fri.getAnswer());
		view.setRecentHistory("Checked if it was friday");
	}
	
	public class RefreshListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			fri.reCheck();
		}
	}
	
	

}
