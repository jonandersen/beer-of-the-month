package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import control.BeerFunctionality;

import server.Server;

import model.BeerOfTheMonthSaver;
import model.Beverage;
import model.Database;
import model.FileDownloader;
import model.FileParser;

import exception.BotMException;
import gui.Gui;
import gui.LoadingScreen;


public class BotM {

	public static void main(String[] args) {
		
		
		File file = new File(System.getProperty("java.io.tmpdir")
                   + "/systembolaget.xls");
		LoadingScreen ls = new LoadingScreen();
		FileDownloader fd = new FileDownloader("http://www.systembolaget.se/Applikationer/Knap"
				+ "par/Press/Alla+Artiklar?Format=Excel", file);
		Thread t = new Thread(fd);
		t.start();
		while(!fd.done()){
			ls.setValue(fd.progress());			
		}
		ls.setValue(100);
		Database db = new Database();
		FileParser fp;
		try {
			fp = new FileParser(db, new BufferedReader(new InputStreamReader(
					new FileInputStream(file), "iso-8859-1")));
			fp.parse();
		} catch (Exception e) {
			e.printStackTrace();
		}
		BeerFunctionality bf = new BeerFunctionality(db);	
		ls.dispose();
		Gui gui = new Gui(bf, db);

	}

}
