package parser;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.StringTokenizer;

import database.Database;

import exception.ParserException;

import beverage.ArticleInfo;
import beverage.Beverage;

public class FileParser {
	private BufferedReader breader;

	public FileParser(Database db, Reader reader) {
//		FileReader freader = null;
//		try {
//			freader = new FileReader(file);
//			breader = new BufferedReader(freader);
//		} catch (Exception e) {
//			System.exit(5);
//		}
	}
	
	protected Beverage parseLine(String line) throws ParserException {
		EnumMap<ArticleInfo, String> info =
			new EnumMap<ArticleInfo, String>(ArticleInfo.class);
			String[] infoArray = line.split("\t");
			for(ArticleInfo ainfo : ArticleInfo.values()){
				try{
					info.put(ainfo, infoArray[ainfo.ordinal()]);
				}
				catch(ArrayIndexOutOfBoundsException e){
					throw new exception.ParserException("Malformed Input Error");
				}
			}
		return new Beverage(info);
	}
}