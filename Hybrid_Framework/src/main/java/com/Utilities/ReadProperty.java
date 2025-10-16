package com.Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperty {
	
	public static String readConfiqdata(String key) throws Exception {
		
		String path ="C:\\Users\\shrut\\eclipse-workspace\\Hybrid_Framework\\src\\main\\resources\\confiq.properties";
		
		System.out.println(path);
		FileInputStream file = new FileInputStream(path);
		
		Properties pro = new Properties();
		 pro.load(file);
		 
		 return pro.getProperty(key);
	
	
	}
}
