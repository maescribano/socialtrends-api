package com.socialtrend.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Ignore;
import org.junit.Test;

public class PropertiesReaderTest {

	@Test
	@Ignore
	public void getPropertieTest(){
		Properties properties = new Properties();


		InputStream in = PropertiesReader.class.getResourceAsStream("static/src/main/resources/twitterOauth.properties");
		try {
			properties.load(in);
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
