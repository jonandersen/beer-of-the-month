package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;

public class BotmModel extends Observable{
	ArrayList<String> list;
	public BotmModel(){
		list = new ArrayList<String>();
		list.add("November 2010 (Sailor)");
		list.add("September 2010 (Twisted Thistle IPA)");
		list.add("June 2010 (KellerBier)");
		
	}
	
	public ArrayList<String> getAllBeers(){
		return list;
	}
	
	public String getCurrentBeer(){
		return "Sailor";
	}
	
	

}
