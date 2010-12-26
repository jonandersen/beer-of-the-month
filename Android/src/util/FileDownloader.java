package util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Observable;

import se.beerofthemonth.BeerOfTheMonth;

import android.app.ProgressDialog;
import android.content.Context;

import exception.BotMException;

public class FileDownloader extends Observable{	
	private URL url;
	private FileOutputStream fos;
	private int read;
	
	public FileDownloader( FileOutputStream fos, URL url){			
		this.fos = fos;
		this.url = url;		
	}
	
	public int getFileSize(){		
		URLConnection conn = null;
		try {
			conn = url.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double fileSize = conn.getContentLength();		
		return (int)fileSize;
	}
	public void DownloadFile() throws BotMException {
		try {				
			BufferedInputStream bis = new BufferedInputStream(url.openStream());							
			BufferedOutputStream  bos = new BufferedOutputStream(fos, 1024);			
			byte[] buf = new byte[4 * 1024];
			int bytesRead;			
			while ((bytesRead = bis.read(buf)) != -1) {
				bos.write(buf, 0, bytesRead);
				read = bytesRead;
				setChanged();
				notifyObservers();					
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
	
	public int getReadBytes(){
		return read;
	}
}
