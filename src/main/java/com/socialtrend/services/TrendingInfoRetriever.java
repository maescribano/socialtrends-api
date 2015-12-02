package com.socialtrend.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;


public abstract class TrendingInfoRetriever {
	
	public abstract String getBearerToken();	
	public abstract String getWorldTrendingTopicName();
	public abstract String getClosestTrendingTopicName();
	public abstract String getTrendingTopicNameByPlace(String place);
	public abstract String getTrendingTopics(String topicName);
	
	public HttpURLConnection buildHttpConnection(URL url, 
			String httpMethod, 
			Map<String, String> requestParameters) 
			throws ProtocolException, IOException{
		HttpURLConnection connection = null;

		connection =  (HttpURLConnection) url.openConnection();           
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setUseCaches(false);
		connection.setRequestMethod(httpMethod);
		
		for (String propertyName : requestParameters.keySet()) {
			connection.setRequestProperty(propertyName, requestParameters.get(propertyName));
		}
		return connection;		
	}
	
	public boolean writeRequest(HttpURLConnection connection, String textBody) {
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


	public String readResponse(HttpURLConnection connection) {
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
