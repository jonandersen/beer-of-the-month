package reworked;

import java.util.Calendar;
import java.util.Observable;


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
		
		public String getAnswer(){
			return answer;
		}
		
	}
	
	
	

