package reworked;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;

import model.Beverage;

public class RollModel extends Observable {
	private String result;
	private String bang;
	private List<Beverage> rollList;
	private List<Beverage> bangList;

	public RollModel() {
		result = "Nothing rolled";
		bang = "";
	}

	public void setRollList(List<Beverage> list) {
		this.rollList = list;
	}

	public void roll() {
		if (rollList == null || rollList.size() == 0) {
			result = "Nothing rolled";
		} else {
			Random rand = new Random();
			result = rollList.get(rand.nextInt(rollList.size())).toString();
		}
		setChanged();
		notifyObservers();
	}

	public String getResult() {
		return result;
	}

	public void setBangList(List<Beverage> bangForBuck) {
		bangList = bangForBuck;
		if (bangList == null || bangList.size() == 0){
			bang = "";
		}
	}

	public void calculateBang() {
		if (bangList == null || bangList.size() == 0) {
			bang = "";
		} else {
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
			bang = bestBang.toString();
		}
		setChanged();
		notifyObservers();
	}
	
	public String getBang(){
		return bang;
	}

}
