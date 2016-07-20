package com.socialtrend.services.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import com.socialtrend.config.PropertiesReader;
import com.socialtrend.services.SocialHttpConnectionManager;
import com.socialtrend.utils.HttpUtils;

@Service
@Qualifier("twitterHttpConnectionManager")
public class TwitterHttpConnectionManager implements SocialHttpConnectionManager{
	
	private final static String CONSUMER_KEY = (String)PropertiesReader.getProperty("CONSUMER_KEY");
	private final static String CONSUMER_SECRET = (String)PropertiesReader.getProperty("CONSUMER_SECRET");
	private final static String ENDPOINT_URL_TOKEN = "https://api.twitter.com/oauth2/token";

	protected String bearerToken;

	
	private String getUpdatedBearerToken() {
		final String encodedCredentials = getEncodedTokenCredentials();
		HttpURLConnection connection = null;
		Map<String, String> customResquestParameters = null;

		try {
			customResquestParameters = buildGetAuthTokenRequestParameters(encodedCredentials);
			connection = buildHttpConnection(new URL(ENDPOINT_URL_TOKEN),
					"POST", customResquestParameters);
			HttpUtils.writeRequest(connection, "grant_type=client_credentials");
			String jsonResponse = HttpUtils.readResponse(connection);

			JSONObject obj = new JSONObject(jsonResponse);

			return ((connection.getResponseCode() != HttpURLConnection.HTTP_OK) || obj == null) ? 
					"": (bearerToken = (String)obj.get("access_token"));

		}
		catch (Exception e) {
			return "";
		}
		finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}
	
	private String getEncodedTokenCredentials(){
		return encodeKeys(CONSUMER_KEY, CONSUMER_SECRET);
	}
	
	private  String encodeKeys(String consumerKey, String consumerSecret) {
		try {
			String encodedConsumerKey = URLEncoder.encode(consumerKey, "UTF-8");
			String encodedConsumerSecret = URLEncoder.encode(consumerSecret, "UTF-8");

			String fullKey = encodedConsumerKey + ":" + encodedConsumerSecret;
			byte[] encodedBytes = Base64Utils.encode(fullKey.getBytes());
			return new String(encodedBytes);
		}
		catch (UnsupportedEncodingException e) {
			return new String();
		}
	}

	private Map<String, String> buildGetAuthTokenRequestParameters(String encodedCredentials){

		final Map<String, String> requestParameters = new HashMap<>();

		requestParameters.put("Host", "api.twitter.com");
		requestParameters.put("Authorization", "Basic " + encodedCredentials);
		requestParameters.put("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8"); 
		requestParameters.put("Content-Length", "29");

		return requestParameters;

	}
	
	public HttpURLConnection buildHttpConnection(URL url, 
			String httpMethod, Map<String, String> customResquestParameters) 
			throws ProtocolException, IOException{
		final HttpURLConnection connection;
	
		addBearerParameter(customResquestParameters);
		
		connection =  (HttpURLConnection) url.openConnection();           
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setUseCaches(false);
		connection.setRequestMethod(httpMethod);
		
		
		for (String propertyName : customResquestParameters.keySet()) {
			connection.setRequestProperty(propertyName, customResquestParameters.get(propertyName));
		}
		return connection;		
	}
	
	public HttpURLConnection buildHttpConnection(URL url, 
			String httpMethod) 
			throws ProtocolException, IOException{
		final HttpURLConnection connection;
		final Map<String, String> requestParameters = new HashMap<>();
		addBearerParameter(requestParameters);
		
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
	
	
	
	private void addBearerParameter(Map<String, String> requestParameters) {
		
		requestParameters.put("Host", "api.twitter.com");
		if (requestParameters.get("Authorization") == null || requestParameters.get("Authorization").isEmpty()){
			requestParameters.put("Authorization", "Bearer " + getBearerToken());
		}
	}

	public String getBearerToken(){
		return bearerToken != null ? bearerToken : getUpdatedBearerToken();
	}

	
}
