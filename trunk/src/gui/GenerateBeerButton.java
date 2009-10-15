package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class GenerateBeerButton extends JButton implements ActionListener {
	
	public GenerateBeerButton(){
		super("Generate");
		super.addActionListener(this);
	}

	
	public void actionPerformed(ActionEvent e) {
		
		
	}
}
