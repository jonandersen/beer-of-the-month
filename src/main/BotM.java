package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import parser.FileParser;
import database.Database;
import exception.BotMException;
import exception.ParserException;
import filemanager.BeerOfTheMonthSaver;
import filemanager.FileDownloader;
import beerfunctionality.BeerFunctionality;
import beverage.Beverage;

public class BotM {

	public static void main(String[] args) {
		File file = new File("systembolagetdb");
		try {
			FileDownloader.DownloadFile("http://www.systembolaget.se/Applikationer/Knap" +
					"par/Press/Alla+Artiklar?Format=Excel", file);
		} catch (BotMException e) {			
			System.out.println(e);
			e.printStackTrace();
		}
		Database db = new Database();
		FileParser fp;
		try {
			fp = new FileParser(db, new BufferedReader(new FileReader(file)));
			fp.parse();
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (ParserException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		BeerFunctionality bf = new BeerFunctionality(db);
		Beverage beer = bf.BeerOfTheMonth();
		try {
			BeerOfTheMonthSaver bs = new BeerOfTheMonthSaver(beer, "BeerOfTheMonth");
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		}

	}

}
