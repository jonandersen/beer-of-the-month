package util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import se.beerofthemonth.BeerOfTheMonth;

import android.app.ProgressDialog;
import android.content.Context;

import exception.BotMException;

public class FileDownloader extends Thread {	
	private ProgressDialog progress;
	private String urlpath;
	private String file;
	private BeerOfTheMonth beerOfTheMonth;
	
	public FileDownloader(String urlpath, String file, ProgressDialog progress, BeerOfTheMonth beerOfTheMonth){		
		this.progress = progress;
		this.urlpath = urlpath;
		this.file = file;
		this.beerOfTheMonth = beerOfTheMonth;
	}
	public void DownloadFile() throws BotMException {
		try {
			URL url = new URL(urlpath);
			URLConnection conn = url.openConnection();
			double total = conn.getContentLength();
			progress.setMax((int) total);
			BufferedInputStream bis = new BufferedInputStream(new URL(urlpath).openStream());			
			FileOutputStream fos = beerOfTheMonth.openFileOutput(file, Context.MODE_PRIVATE);				
			BufferedOutputStream  bos = new BufferedOutputStream(fos, 1024);			
			byte[] buf = new byte[4 * 1024];
			int bytesRead;			
			while ((bytesRead = bis.read(buf)) != -1) {
				bos.write(buf, 0, bytesRead);							
				progress.incrementProgressBy(bytesRead);		
			}			
			bos.close();
			bis.close();
			//TODO Fix these
		} catch (MalformedURLException e) {			
			throw new BotMException("The url is wrong");
		} catch (IOException e) {			
			throw new BotMException("I/O problem");
		} 
	}
	
	public void run() {
		try {			
			DownloadFile();			
		} catch (BotMException e) {			
			System.err.println("An error occured: " + e.getMessage());
			System.exit(-1);
		}		
	}

}
