package control;
import gui.View;

import java.util.Observer;



public abstract class Control implements Observer{	
	protected View view;
	
	public Control(View view){		
		this.view = view;
		
	}
	
	
}
