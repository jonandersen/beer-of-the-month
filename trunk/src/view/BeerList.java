package view;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import database.Database;

public class BeerList extends JPanel implements Observer{
	private Database db;
	private DefaultListModel listModel;
	private JList list;
	private JLabel label;

	public BeerList(Gui gui, Database db){
		this.db = db;	
        db.addObserver(this);
        
        label = new JLabel("");
        label.setPreferredSize(new Dimension(300, 15));
        add(label);
	}
	
	public void update(Observable arg0, Object arg1) {		
		if(db != null){
			label.setText((db.getRandomBeverage().toString()));
			
		}		
	}
}
