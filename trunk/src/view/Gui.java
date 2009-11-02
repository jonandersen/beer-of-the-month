package view;

import java.awt.BorderLayout;
import java.net.MalformedURLException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import control.BotmMenuBar;
import control.ExitListener;
import control.RandomBeerButton;
import control.ReScrapeBeerButton;
import database.Database;

public class Gui extends JFrame{
	
	public Gui(){
		super("Beverage of the month");
		setLayout(new BorderLayout());
		Database db = new Database();
		setJMenuBar(new BotmMenuBar(this, db));
        addWindowListener(new ExitListener());
        setSize(1024, 768);
        add(new BeerList(this, db), BorderLayout.NORTH);
        InfoArea info = new InfoArea();
        add(info, BorderLayout.CENTER);
        add(new ReScrapeBeerButton(this, db, info ), BorderLayout.SOUTH);
       
        JLabel label = new JLabel();
        add(label, BorderLayout.WEST);
        add(new RandomBeerButton(this,db,label), BorderLayout.EAST);
        pack();
        setResizable(true);
        setVisible(true);
	}
	
    public void rename(String title) {
        setTitle(title);        
    }

}
