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
	private BufferedReader reader;
	private Database db;

	public FileParser(Database db, BufferedReader reader) {
		this.reader = reader;
		this.db = db;
	}

	protected Beverage parseLine(String line) throws ParserException {
		EnumMap<ArticleInfo, String> info = new EnumMap<ArticleInfo, String>(
				ArticleInfo.class);
		String[] infoArray = line.split("\t");
		for (ArticleInfo ainfo : ArticleInfo.values()) {
			try {
				info.put(ainfo, infoArray[ainfo.ordinal()]);
			} catch (ArrayIndexOutOfBoundsException e) {
				throw new exception.ParserException("Malformed Input Error");
			}
		}
		return new Beverage(info);
	}

	public void parse() throws IOException, ParserException {
		String line;
		while (reader.ready()) {
			line = reader.readLine();
			if(!Character.isDigit(line.charAt(0)))
				continue;
			db.add(parseLine(line));
		}
	}
}