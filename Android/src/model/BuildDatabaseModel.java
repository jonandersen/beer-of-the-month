package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

import exception.BotMException;

import util.FileDownloader;
import util.FileParser;

import android.app.ProgressDialog;

public class BuildDatabaseModel extends Thread implements Observer{
	private ProgressDialog progress;
	private String file = "systembolaget.xls";
	private String urlpath = "http://www.systembolaget.se/Applikationer/Knap"
		+ "par/Press/Alla+Artiklar?Format=Excel";	
	private Database db;
	private FileDownloader fd = null;
	
	public BuildDatabaseModel(Database db, ProgressDialog progress, FileOutputStream fos){
		this.db = db;
		this.progress = progress;
		try {
			fd = new FileDownloader(fos, new URL(urlpath));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fd.addObserver(this);
	}
	
	public void run(){
		progress.setMax(fd.getFileSize());
		try {
			fd.DownloadFile();
		} catch (BotMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	public void update(Observable observable, Object data) {
		progress.incrementProgressBy(fd.getReadBytes());
		
		
	}
	
	

}
