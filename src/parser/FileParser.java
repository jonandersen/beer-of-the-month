package parser;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.StringTokenizer;

import beverage.ArticleInfo;
import beverage.Beverage;

public class FileParser {
	private BufferedReader breader;

	public FileParser(File file) {
		FileReader freader = null;
		try {
			freader = new FileReader(file);
			breader = new BufferedReader(freader);
		} catch (Exception e) {
			System.exit(5);
		}
	}
	
	public Beverage parseLine(String line) {
		EnumMap<ArticleInfo ,String> info =
			new EnumMap<ArticleInfo, String>(ArticleInfo.class);
			String[] infoArray = line.split("\t");
			for(ArticleInfo ainfo : ArticleInfo.values()){
				info.put(ainfo, infoArray[ainfo.ordinal()]);
			}
		return new Beverage(info);
	}
}

//String token;
//tokenizer = new StringTokenizer(breader.readLine(), "\t");
//if(tokenizer.hasMoreTokens() && !(token = tokenizer.nextToken()).matches("\\d+")){
//	continue;
//}
//do{
//	info.
//}while(tokenizer.hasMoreTokens());
