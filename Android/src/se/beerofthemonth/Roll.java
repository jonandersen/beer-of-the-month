package se.beerofthemonth;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Roll extends Activity {
	private Button roll;
	private EditText info;
	private int i;
	
	  public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.roll);  
	        info = (EditText) findViewById(R.id.Info);
	        roll = (Button) findViewById(R.id.Roll);
	        i = 0;
	        roll.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	               info.setText(Integer.toString(i++));
	            }
	        });
	        
	        
	        
	       
	    }
	  
	 
}
