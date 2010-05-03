package main;

import gui.View;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;


import control.ExitControl;
import control.FridayControl;
import control.RollControl;
import control.SettingsControl;
import control.StartUpControl;

import util.FileDownloader;
import util.FileParser;
import model.Database;
import model.FridayModel;
import model.RollModel;
import model.SettingsModel;
import model.StartUpModel;

public class Main {

	public static void main(String[] args){
		Database db = new Database();
		
		RollModel model = new RollModel();
		View view = new View();
		
		RollControl control = new RollControl(model, view);
		model.addObserver(control);
		
		FridayModel fri = new FridayModel();
		FridayControl freControl = new FridayControl(view, fri);		
		fri.addObserver(freControl);
		
		SettingsModel setM = new SettingsModel(db);
		SettingsControl set = new SettingsControl(view,model,setM);
		
		ExitControl exit = new ExitControl(view);
		
		StartUpModel sum = new StartUpModel(db);
		StartUpControl suc = new StartUpControl(view, sum);
		
		//Must be last!!
		suc.initiate();
		
	}
}
