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
			if(weekday == 5){
				answer = "Ja";
			}else{
				answer = "Nej";
			}			
			setChanged();
			notifyObservers();
		}
		
//		private void check(){		
//			ScriptEngineManager manager = new ScriptEngineManager();
//		    ScriptEngine engine = manager.getEngineByName("javascript");
//		    try {
//		      engine.put("name", "abcde");
//		      engine.eval("var output = '';for (i = 0; i <= name.length; i++) {"
//		          + "  output = name.charAt(i)+'-' + output" + "}");
//		      String name = (String) engine.get("output");
//		      System.out.println(name);
//		    } catch (ScriptException e) {
//		      System.err.println(e);
//		    }
//		}
		
		public String getAnswer(){
			return answer;
		}
		
	}
	
	
	

