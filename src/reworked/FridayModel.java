package reworked;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Observable;
import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import exception.BotMException;

import util.FileDownloader;


public class FridayModel extends Observable{
		private String answer;
		private Calendar calendar;
		private int weekday;
		
		public FridayModel(){
			reCheck();
		}
		
		public void reCheck(){
			calendar = Calendar.getInstance();
			weekday = calendar.get(Calendar.DAY_OF_WEEK);
			if(weekday == 6){
				answer = "Ja";
			}else{
				answer = "Nej";
			}			
			setChanged();
			notifyObservers();
		}
		
		public String getAnswer(){
			return answer;
		}
		
	}
	
	
	

