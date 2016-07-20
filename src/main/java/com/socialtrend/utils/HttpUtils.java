package com.socialtrend.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;

public class HttpUtils {
	
	public static boolean writeRequest(HttpURLConnection connection, String textBody) {
		try {
			BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
			wr.write(textBody);
			wr.flush();
			wr.close();
			return true;
		}
		catch (IOException e) { 
			return false; 
		}
	}


	public static String readResponse(HttpURLConnection connection) {
		try {
			StringBuilder str = new StringBuilder();
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			String line = "";
			while((line = br.readLine()) != null) {
				str.append(line + System.getProperty("line.separator"));
			}
			return str.toString();
		}
		catch (IOException e) { 
			return new String(); 
		}
	}
}
