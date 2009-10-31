package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import view.Gui;
import database.Database;

public class RandomBeerButton extends BotmButton implements ActionListener{
	private JLabel label;
	public RandomBeerButton(Gui gui, Database db, JLabel label) {
		super(gui, db, "Random Beer");
		addActionListener(this);
		this.label = label;
		
	}

	
	public void actionPerformed(ActionEvent arg0) {
		label.setText(db.getRandomBeverage().toString());
		
	}

}
