package reworked;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class FridayControl extends Control{
	private FridayModel fri;
	
	public FridayControl(View view, FridayModel fre){
		super(view);
		this.fri = fre;
		view.addUpdateListener(new UpdateListener());
	}
	
	public void update(Observable o, Object arg) {
		view.setFriday(fri.getAnswer());
	}
	
	public class UpdateListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			fri.reCheck();
		}
	}
	
	

}
