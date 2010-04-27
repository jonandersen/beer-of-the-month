package reworked;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;

import exception.BotMException;

import util.StockChecker;

import model.Beverage;

public class RollModel extends Observable {
	private String result;
	private String bang;	
	private List<Beverage> rollList;
	private List<Beverage> bangList;
	private boolean checkStock;

	public RollModel() {
		result = "";
		bang = "";
		checkStock = false;		
	}

	public void setRollList(List<Beverage> list) {
		this.rollList = list;
	}

	public String roll() throws BotMException {
		if (rollList == null || rollList.size() == 0) {
			result = "";
			return "";
		} else {
			Random rand = new Random();
			Beverage rolled = rollList.get(rand.nextInt(rollList.size()));
			if (checkStock) {
				StockChecker checker = new StockChecker();
				int i = 0;
				try {
					i = checker.checkInStock(rolled);
				} catch (IOException e) {
					throw new BotMException(
							"Systembolaget blocked you, please try again in a minute");
				}
				while (i == 0) {
					setChanged();
					notifyObservers(rolled.toString());
					rollList.remove(rolled);
					rolled = rollList.get(rand.nextInt(rollList.size()));
					try {
						i = checker.checkInStock(rolled);
					} catch (IOException e) {
						throw new BotMException(
								"Systembolaget blocked you, please try again in a minute");
					}
				}
				result = rolled.toString() + " instock : " + i;
				return result;
			} else {
				result = rolled.toString();
				return result;
			}
		}
	}
	
	public void setBangList(List<Beverage> bangForBuck) {
		bangList = bangForBuck;
		if (bangList == null || bangList.size() == 0) {
			bang = "";
		}
	}

	public String getMostBangForTheBuck() throws BotMException {
		if (bangList == null || bangList.size() == 0) {
			bang = "";
			return "";
		} else {
			Beverage bev = calculateBang();
			if(bev != null){
				bang = bev.toString();
			}
			if(checkStock){
				StockChecker checker = new StockChecker();
				int i = 0;
				try {
					i = checker.checkInStock(bev);
				} catch (IOException e) {
					throw new BotMException(
							"Systembolaget blocked you, please try again in a minute");
				}
				while (i == 0) {
					setChanged();
					notifyObservers(bev.toString());
					bangList.remove(bev);
					bev = calculateBang();
					try {
						i = checker.checkInStock(bev);
					} catch (IOException e) {
						throw new BotMException(
								"Systembolaget blocked you, please try again in a minute");
					}
				}
				if(bev != null){
					bang = bev.toString() + " instock : " + i;
				}				
			}
			return bang;
		}		
	}
	
	private Beverage calculateBang(){
		double price, volume, alcohol, currentBang = 0, tempBang;
		Beverage bestBang = null;
		for (Beverage b : bangList) {
			String s = b.getPrice().replace(",", ".");
			price = Double.parseDouble(s);
			volume = Double.parseDouble(b.getVolume());
			alcohol = Double.parseDouble(b.getAlcohol().replace("%", "")
					.replace(",", "."));
			tempBang = price / (volume * alcohol);
			if (currentBang == 0) {
				currentBang = tempBang;
			}
			if (tempBang < currentBang) {
				bestBang = b;
				currentBang = tempBang;
			}
		}
		return bestBang;
	}
	 

	public void setCheckStock(boolean b) {
		checkStock = b;
	}

	public boolean getCheckStock() {
		return checkStock;
	}

}
