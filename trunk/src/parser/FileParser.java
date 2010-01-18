package parser;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.StringTokenizer;

public class FileParser {
	private BufferedReader bread;
	
	public FileParser(File file) {
		FileReader fread = null;
		try {
			fread = new FileReader(file);
			bread = new BufferedReader(fread);
		} catch(Exception e) {
			System.exit(5);
		}
	}

	public HashMap<Enum, String> parse(){
		HashMap<Enum, String> info = new HashMap<Enum, String>();
		StringTokenizer tokenizer; 
		try {
			while(bread.ready()){
				tokenizer = new StringTokenizer(bread.readLine(), "\t");
				while(tokenizer.hasMoreTokens()){
					if(!tokenizer.nextToken().matches(""));
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
