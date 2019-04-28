package com.abof.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetPropertyValue {
	
	public static final String FILE_PATH="./src/main/resources/config.property";
	
	public static String readValue(String key){
		String propertyValue="";
		
		Properties prop=new Properties();
		try {
			prop.load(new FileInputStream(new File(FILE_PATH)));
			propertyValue = prop.getProperty(key);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return propertyValue;
		
	}

}
