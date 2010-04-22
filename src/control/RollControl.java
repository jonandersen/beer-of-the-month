package control;

import java.io.IOException;
import java.util.ArrayList;

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
		        	statusArea.setText("");			
					if(set.rollBeer()){			
						if(set.checkStock()){
							Beverage beer = null;
							try {
								if(set.getPriceLessOrEqualsThen() <= 0 && set.getVolume()[0] <=0 && set.getVolume()[1] <=0 && set.getAlco()[0]<=0 && set.getAlco()[1]<=0){
									beer = bf.BeerOfTheMonthInStock();
								}else{
									beer = bf.BeerOfTheMonthInStock(set.getPriceLessOrEqualsThen(),set.getVolume(), set.getAlco());
								}
							} catch (IOException e1) {					
								e1.printStackTrace();
								System.exit(0);
							}
							if(beer==null){
								statusArea.setText(statusArea.getText() + "Beer of the Month: "+ "Couldn't find one =(" + "\n");
							}else{
								statusArea.setText(statusArea.getText() + "Beer of the Month: "+ beer.toString() + " In stock:" + beer.getStockCount() + "\n");
							}
						}else{
							Beverage beer;
							if(set.getPriceLessOrEqualsThen() <= 0 && set.getVolume()[0] <=0 && set.getVolume()[1] <=0 && set.getAlco()[0]<=0 && set.getAlco()[1]<=0){
								 beer = bf.BeerOfTheMonth();
							}else{
								 beer = bf.BeerOfTheMonth(set.getPriceLessOrEqualsThen(),set.getVolume(), set.getAlco());
							}
							
							if(beer==null){
								statusArea.setText(statusArea.getText() + "Beer of the Month: "+ "Couldn't find one =(" + "\n");
							}else{
								statusArea.setText(statusArea.getText() + "Beer of the Month: "+ beer.toString() + "\n");
							}
							
						}				
					}
					if(set.rollWine()){
						if(set.checkStock()){
							Beverage wine = null;
							try {
								if(set.getPriceLessOrEqualsThen() <= 0 && set.getVolume()[0] <=0 && set.getVolume()[1] <=0 && set.getAlco()[0]<=0 && set.getAlco()[1]<=0){
									wine = bf.WineOfTheMonthInStock();
								}else{
									wine = bf.WineOfTheMonthInStock(set.getPriceLessOrEqualsThen(),set.getVolume(), set.getAlco());
								}
								 
							} catch (IOException e1) {					
								e1.printStackTrace();
								System.exit(0);
							}
							if(wine==null){
								statusArea.setText(statusArea.getText() + "Wine of the Month: " + "Couldn't find one =(" + "\n");
							}else{
								statusArea.setText(statusArea.getText() + "Wine of the Month: " + wine.toString() + " In stock:" + wine.getStockCount() + "\n");
							}
						}else{
							Beverage wine = null;
							if(set.getPriceLessOrEqualsThen() <= 0 && set.getVolume()[0] <=0 && set.getVolume()[1] <=0 && set.getAlco()[0]<=0 && set.getAlco()[1]<=0){
								wine = bf.WineOfTheMonth();
							}else{
								wine = bf.WineOfTheMonth(set.getPriceLessOrEqualsThen(),set.getVolume(), set.getAlco());
							}
							if(wine==null){
								statusArea.setText(statusArea.getText() + "Wine of the Month: " + "Couldn't find one =(" + "\n");
							}else{
								statusArea.setText(statusArea.getText() + "Wine of the Month: " + wine.toString() + "\n");
							}
								
							}
					}
					if(set.rollBeverage()){
						if(set.checkStock()){
							Beverage beverage = null;
							try {
								beverage = bf.BeverageOfTheMonthInStock();
							} catch (IOException e1) {					
								e1.printStackTrace();
								System.exit(0);
							}
							statusArea.setText(statusArea.getText() + "Beverage of the Month: " + beverage.toString() + "\n");
						}else{
							Beverage beverage = bf.BeverageOfTheMonth();
							statusArea.setText(statusArea.getText() + "Beverage of the Month: " + beverage.toString() + "\n");
						}
					}
					if(set.bFB()){						
						Beverage beverage = null;
						if(set.checkStock()){							
							ArrayList<Beverage> list = (ArrayList<Beverage>) bf.beverageList();
							beverage = checkStock(list);
						}else{							
							beverage = bf.bangForTheBuck();							
						}
						statusArea.setText(statusArea.getText() + "Bang for the Buck in stock is " + beverage.toString() + " In stock:" + beverage.getStockCount()+"\n");
					}
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
							statusArea.setText(statusArea.getText() + beverage.toString() + " wasn't in stock, the search continues..." + "\n");
							
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
	
	
}
