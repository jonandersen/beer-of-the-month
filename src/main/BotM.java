package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import model.BeerFunctionality;
import model.BeerOfTheMonthSaver;
import model.Beverage;
import model.Database;
import model.FileDownloader;
import model.FileParser;

import exception.BotMException;
import gui.Gui;


public class BotM {

	public static void main(String[] args) {
		File file = new File(System.getProperty("java.io.tmpdir")
				+ "/systembolaget.xls");
		try {
			FileDownloader.DownloadFile(
					"http://www.systembolaget.se/Applikationer/Knap"
							+ "par/Press/Alla+Artiklar?Format=Excel", file);
		} catch (BotMException e) {
			System.out.println(e);		
		}
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
		Gui gui = new Gui(bf);
		
	}

}
