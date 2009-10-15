package gui;


import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SpringLayout;


public class BeerPanel extends JPanel implements Observer{
	private JTextField[] textField;
	private int current;
	private JProgressBar progressBar;
	public BeerPanel(){
		super();
		current = 0;
		setLayout(new SpringLayout());		
	     String[] labels = {"Webadress: ", "Namn: ", "Land: ", "Distrikt: ", "Färg: ",
                 "Doft: ", "Smak: " , "Användning: " };			
        int numPairs = labels.length;
        textField = new JTextField[numPairs];
        for (int i = 0; i < numPairs; i++) {
                textField[i] = new JTextField(15);
        }  
        for (int i = 0; i < numPairs; i++) {
                JLabel l = new JLabel(labels[i], JLabel.TRAILING);
                add(l);
                l.setLabelFor(textField[i]);
                add(textField[i]);
        }
        add(new GenerateBeerButton());	
        
        progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);
        add(progressBar);
        
		SpringUtilities.makeCompactGrid(this, 9, 2, 6, 6, 6, 6);		
	}
	
	public void update(Observable arg0, Object arg1) {		
		textField[current].setText((String)arg1);
		current ++;
		progressBar.setIndeterminate(false);
		progressBar.setString(null);
	}
}
