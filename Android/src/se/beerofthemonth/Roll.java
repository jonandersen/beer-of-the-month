package se.beerofthemonth;

import model.Roller;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Roll extends Activity {
	private Button roll;
	private EditText info;
	private Roller roller;
	private Dialog dialog;
	private ProgressDialog progress;
	private Roll rolls;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.roll);
		rolls = this;

		roller = new Roller();
		info = (EditText) findViewById(R.id.Info);
		roll = (Button) findViewById(R.id.Roll);
		roll.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				progress = new ProgressDialog(rolls);
				progress.setCancelable(true);
				progress.setMessage("Evaluating important beer decisions");
				progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
				progress.setProgress(0);

				// File size?
				int fileSize = 2000;

				progress.setMax(fileSize);
				
				progress.show();

				Thread background = new Thread(new Runnable() {
					public void run() {
						try {							
							while (progress.getProgress() < progress.getMax()) {							
								Thread.sleep(50);
								progress.incrementProgressBy(100);
							}
						} catch (java.lang.InterruptedException e) {
							// if something fails do something smart
						}
						progress.dismiss();					
					}
				});

				// start the background thread
				background.start();

			}		
		});

	}

	// //set up dialog
	// dialog = new Dialog(this);
	// dialog.setContentView(R.layout.progress);
	// dialog.setTitle("This is my custom dialog box");
	// dialog.setCancelable(true);
	//
	//
	// Button button = (Button) dialog.findViewById(R.id.Cancel);
	// button.setOnClickListener(new OnClickListener() {
	// public void onClick(View v) {
	// progress.show();
	// }
	// });

}
