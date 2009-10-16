package gui;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;


public class BeerGUI extends Observable implements Observer {

	public BeerGUI() {
		JFrame frame = new JFrame("Beer of the Month");
		frame.setLayout(new BorderLayout());
		BeerPanel bp = new BeerPanel();
		frame.add(bp, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);	
		addObserver(bp);

	}

	
	public void update(Observable o, Object arg) {
		setChanged();
		notifyObservers(arg);		
	}

}
