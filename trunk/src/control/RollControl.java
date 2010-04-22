package control;

import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JTextArea;
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
	private JTextArea summary;

	public RollControl(Gui gui, BeerFunctionality bf) {
		statusArea = gui.getStatusArea();
		set = gui.getSet();
		this.bf = bf;
		infoArea = gui.getInfoArea();
		okButton = gui.getOkButton();
		cancelButton = gui.getCancelButton();
		settings = gui.getSettings();
		summary = gui.getSummary();
	}

	
	
	 public void loadData(){
		 Thread thread = new Thread(new Runnable() {
		        public void run() {
		        	Queue<String> q = new LinkedList<String>();
		        	summary.setText("");
		        	statusArea.setText("");	
		        	bf.setKey(set.getStore());
					if(set.rollBeer() && !set.bFB()){			
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
								q.add("Beer of the Month: " + beer.toString() +  " In stock: "  + beer.getStockCount());
							}
							
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
								q.add("Beer of the month: " + beer);
							}
							
						}				
					}
					if(set.rollWine() && !set.bFB()){
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
								q.add("Wine of the Month: " + wine  + " In stock: " + wine.getStockCount());
							}
							
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
								q.add("Wine of the Month: " + wine);
							}
							
					}
				}
				if (set.rollBeverage() && !set.bFB()) {
					Beverage beverage = null;
					if (set.checkStock()) {
						beverage = checkStockRandom(bf.getDb().getList());
						statusArea.setText("Beverage of the Month: "
								+ beverage.toString() + "\n"
								+ statusArea.getText());
						q.add("Beverage of the Month: " + beverage + " In stock: "
								+ beverage.getStockCount());
					} else {
						beverage = bf.BeverageOfTheMonth();
						statusArea.setText("Beverage of the Month: "
								+ beverage.toString() + "\n"
								+ statusArea.getText());
						q.add("Beverage of the Month: " + beverage);
					}
				}
				if (set.bFB()) {
					Beverage beverage = null;
					ArrayList<Beverage> list;
					if (set.rollWine() && !set.rollBeer()) {
						list = (ArrayList<Beverage>) bf.getDb().getWineList();
					} else if (set.rollBeer() && !set.rollWine()) {
						list = (ArrayList<Beverage>) bf.getDb().getBeerList();
					} else {
						list = (ArrayList<Beverage>) bf.beverageList();
					}
					if (set.checkStock()) {
						beverage = checkStock(list);
					} else {
						beverage = bf.bang(list);
					}
					statusArea.setText("Bang for the Buck in stock is "
							+ beverage.toString() + " In stock: "
							+ beverage.getStockCount() + "\n"
							+ statusArea.getText());
					q.add("Most bang for the Buck: " + beverage + "In stock: " +
							+ beverage.getStockCount());
				}
				while (!q.isEmpty()) {
					summary.setText(summary.getText() + q.poll() + "\n");
				}
				infoArea.setText("Done evaluating, check above for beverage");
				okButton.setEnabled(true);
				settings.setEnabled(true);
			}
		});
		// Keep gui responsive to user input.
		thread.setPriority(Thread.NORM_PRIORITY); // 5, EDT = 6
		thread.start();
	}

	private Beverage checkStock(ArrayList<Beverage> list) {
		Beverage beverage = null;
		boolean found = false;
		while (!found) {
			beverage = bf.bang(list);
			try {
				if (!bf.checkInStock(beverage)) {
					list.remove(beverage);
					statusArea.setText("Not in stock: " + beverage.toString()
							+ "\n" + statusArea.getText());

				} else {
					found = true;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return beverage;
	}

	private Beverage checkStockRandom(ArrayList<Beverage> list) {
		Beverage beverage = null;
		boolean found = false;
		while (!found) {
			beverage = bf.randomBeverage(list);
			try {
				if (!bf.checkInStock(beverage)) {
					list.remove(beverage);
					statusArea.setText("Not in stock: " + beverage.toString()
							+ "\n" + statusArea.getText());
				} else {
					found = true;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return beverage;
	}
}
