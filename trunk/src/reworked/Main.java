package reworked;

public class Main {

	public static void main(String[] args){
		RollModel model = new RollModel();
		View view = new View();
		
		RollControl control = new RollControl(model, view);
		model.addObserver(control);
		
		FridayModel fri = new FridayModel();
		FridayControl freControl = new FridayControl(view, fri);		
		fri.addObserver(freControl);
		
		SettingsControl set = new SettingsControl(view);
		
	}
}
