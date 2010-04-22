package control;

import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import model.Beverage;
import gui.Gui;
import gui.Settings;

public class RollControl {
	private JTextPane statusArea;
	private Settings set;
	private BeerFunctionality bf;
	private JTextField infoArea;
	private JButton okButton;
	private JButton cancelButton;
	private JButton settings;
	
	public RollControl(Gui gui, BeerFunctionality bf){
		statusArea = gui.getStatusArea();
		set = gui.getSet();
		this.bf = bf;
		infoArea = gui.getInfoArea();
		okButton = gui.getOkButton();
		cancelButton = gui.getCancelButton();
		settings = gui.getSettings();
	}
	
	
	 public void loadData(){
		 Thread thread = new Thread(new Runnable() {
		        public void run() {
		        	Queue<String> q = new LinkedList<String>();
		        	statusArea.setText("");			
					if(set.rollBeer()){			
						if(set.checkStock()){
							Beverage beer = null;
							if(set.getPriceLessOrEqualsThen() <= 0 && set.getVolume()[0] <=0 && set.getVolume()[1] <=0 && set.getAlco()[0]<=0 && set.getAlco()[1]<=0){
								beer = checkStockRandom(bf.getDb().getBeerList());
							}else{
								beer = checkStockRandom(bf.getDb().getBeerList(set.getPriceLessOrEqualsThen(), set.getVolume(), set.getAlco()));									
							}
							if(beer==null){
								statusArea.setText("Beer of the Month: "+ "Couldn't find one =("  + "\n"+ statusArea.getText());
							}else{
								statusArea.setText("Beer of the Month: "+ beer.toString() + " In stock:" + beer.getStockCount() + "\n" + statusArea.getText());
							}
							q.add("Beer of the month: " + beer.toString());
						}else{
							Beverage beer;
							if(set.getPriceLessOrEqualsThen() <= 0 && set.getVolume()[0] <=0 && set.getVolume()[1] <=0 && set.getAlco()[0]<=0 && set.getAlco()[1]<=0){
								 beer = bf.BeerOfTheMonth();
							}else{
								 beer = bf.BeerOfTheMonth(set.getPriceLessOrEqualsThen(),set.getVolume(), set.getAlco());
							}
							
							if(beer==null){
								statusArea.setText("Beer of the Month: "+ "Couldn't find one =(" + "\n" + statusArea.getText());
							}else{
								statusArea.setText("Beer of the Month: "+ beer.toString() +  "\n" + statusArea.getText());
							}
							q.add("Beer of the month: " + beer + beer.getStockCount());
						}				
					}
					if(set.rollWine()){
						if(set.checkStock()){
							Beverage wine = null;
							if(set.getPriceLessOrEqualsThen() <= 0 && set.getVolume()[0] <=0 && set.getVolume()[1] <=0 && set.getAlco()[0]<=0 && set.getAlco()[1]<=0){
								wine = checkStockRandom(bf.getDb().getWineList());									
							}else{
								wine = checkStockRandom(bf.getDb().getWineList(set.getPriceLessOrEqualsThen(), set.getVolume(), set.getAlco()));
							}
							if(wine==null){
								statusArea.setText("Wine of the Month: " + "Couldn't find one =("  +  "\n" + statusArea.getText());
							}else{
								statusArea.setText("Wine of the Month: " + wine.toString() + " In stock:" + wine.getStockCount() + "\n" + statusArea.getText());
							}
							q.add("Wine of the month: " + wine);
						}else{
							Beverage wine = null;
							if(set.getPriceLessOrEqualsThen() <= 0 && set.getVolume()[0] <=0 && set.getVolume()[1] <=0 && set.getAlco()[0]<=0 && set.getAlco()[1]<=0){
								wine = bf.WineOfTheMonth();
							}else{
								wine = bf.WineOfTheMonth(set.getPriceLessOrEqualsThen(),set.getVolume(), set.getAlco());
							}
							if(wine==null){
								statusArea.setText("Wine of the Month: " + "Couldn't find one =(" +  "\n" + statusArea.getText());
							}else{
								statusArea.setText("Wine of the Month: " + wine.toString() +"\n" +  statusArea.getText());
							}
							q.add("Wine of the month: " + wine + wine.getStockCount());
						}
					}
					if(set.rollBeverage()){
						Beverage beverage = null;
						if(set.checkStock()){							 
							beverage = checkStockRandom(bf.getDb().getList());
							statusArea.setText("Beverage of the Month: " + beverage.toString() + "\n" + statusArea.getText());
						}else{
							beverage = bf.BeverageOfTheMonth();
							statusArea.setText("Beverage of the Month: " + beverage.toString()  + "\n"+ statusArea.getText());
						}
						q.add("Beverage of the month: " + beverage + beverage.getStockCount());
					}
					if(set.bFB()){						
						Beverage beverage = null;
						if(set.checkStock()){							
							ArrayList<Beverage> list = (ArrayList<Beverage>) bf.beverageList();
							beverage = checkStock(list);
						}else{							
							beverage = bf.bangForTheBuck();							
						}
						statusArea.setText("Bang for the Buck in stock is " +
								beverage.toString() + " In stock:" + beverage.getStockCount()+  "\n" +statusArea.getText());
						q.add("Most bang for the buck: " + beverage + beverage.getStockCount());
					}					
					while(!q.isEmpty()){
						statusArea.setText(q.poll() + "\n" + statusArea.getText() );
					}
					statusArea.setText("Summary: \n" + statusArea.getText());
					
					infoArea.setText("Done evaluating, check above for beverage");
					okButton.setEnabled(true);
					settings.setEnabled(true);	
		        }});
		    	// Keep gui responsive to user input.
		    thread.setPriority(Thread.NORM_PRIORITY);  // 5, EDT = 6
		    thread.start();    
	 }	 
	
	 
	 private Beverage checkStock(ArrayList<Beverage> list){
		 Beverage beverage = null;
		 boolean found = false;
		 while (!found){
				beverage = bf.bang(list);
				try {
					if(!bf.checkInStock(beverage)){
							list.remove(beverage);		
							statusArea.setText("Not in stock: " + 
									 beverage.toString() +  "\n" + statusArea.getText());
							
					}else{
						found = true;
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
		}
		return beverage;
	 }	 
	 
	 private Beverage checkStockRandom(ArrayList<Beverage> list){
		 Beverage beverage = null;
		 boolean found = false;
		 while (!found){
				beverage = bf.randomBeverage(list);
				try {
					if(!bf.checkInStock(beverage)){
							list.remove(beverage);		
							statusArea.setText("Not in stock: " 
									+ beverage.toString()
									 + "\n" + statusArea.getText());							
					}else{
						found = true;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}	
		}
		return beverage;
	 }	 
}
