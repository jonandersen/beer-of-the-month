package se.beerofthemonth;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Observable;
import java.util.Observer;

import model.Database;

import util.FileDownloader;
import util.FileParser;
import android.util.Log;
import android.app.ProgressDialog;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class BeerOfTheMonth extends TabActivity implements Observer {
	private ProgressDialog progress;
	private String file = "systembolaget.xls";
	private String urlpath = "http://www.systembolaget.se/Applikationer/Knap"
		+ "par/Press/Alla+Artiklar?Format=Excel";	
	private Database db;
	private boolean download = true;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Resources res = getResources(); // Resource object to get Drawables
        TabHost tabHost = getTabHost();  // The activity TabHost
        TabHost.TabSpec spec;  // Resusable TabSpec for each tab
        Intent intent;  // Reusable Intent for each tab
        
        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent().setClass(this, Home.class);        
        // Initialize a TabSpec for each tab and add it to the TabHost
        spec = tabHost.newTabSpec("home").setIndicator("Home",
                          res.getDrawable(R.drawable.ic_tab_home)).setContent(intent);
        tabHost.addTab(spec);
        
        
        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent().setClass(this, Roll.class);        
        // Initialize a TabSpec for each tab and add it to the TabHost
        spec = tabHost.newTabSpec("roll").setIndicator("Roll",
                          res.getDrawable(R.drawable.ic_tab_roll))
                      .setContent(intent);
        tabHost.addTab(spec);
        
        
        // Do the same for the other tabs
        intent = new Intent().setClass(this, Community.class);
        spec = tabHost.newTabSpec("community").setIndicator("Community",
                          res.getDrawable(R.drawable.ic_tab_community))
                      .setContent(intent);
        tabHost.addTab(spec);
        
   
        
        tabHost.setCurrentTab(0);    
        if(download){
        	onStartUp();
        }        
    }
    
    
    public void onStartUp(){
    	progress = new ProgressDialog(this);
		progress.setCancelable(false);
		progress.setMessage("Downloading and parsing information");
		progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		progress.setProgress(0);	
		progress.show();				
		
		FileOutputStream fos = null;			
		URL url = null;
		try {
			fos = openFileOutput(file, Context.MODE_PRIVATE);
			url = new URL(urlpath);			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		FileDownloader fd = new FileDownloader(fos, url);
		fd.addObserver(this);
		
		progress.setMax(fd.getFileSize());		
		
		Thread download = new Thread(fd);
		db = new Database();
		download.start();		
    }
    
	@Override
	public void update(Observable arg0, Object arg1) {
		int bytesRead = ((Integer)arg1);
		if(bytesRead != FileDownloader.DONE){
			progress.incrementProgressBy(bytesRead);
		}else{
			FileParser fp;
			try {
				fp = new FileParser(db, new BufferedReader(new InputStreamReader(
						new FileInputStream(file), "iso-8859-1")));
				fp.parse();
			} catch (Exception e) {
				e.printStackTrace();
			}			
			progress.dismiss();
		}
		
		
	}
}