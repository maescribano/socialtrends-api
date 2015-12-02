package com.socialtrend.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
	
	static Properties properties = new Properties();
	
	static{
		//properties.load(MyClass.class.getResourceAsStream("/config.properties"));

		InputStream in = PropertiesReader.class.getResourceAsStream("/twitterOauth.properties");
		try {
			properties.load(in);
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Object getProperty(String name){
		return properties.get(name);	
	}
	
}
