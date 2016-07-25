package com.socialtrend.services.impl.youtube;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.socialtrend.services.SocialHttpConnectionManager;

@Service
public class YoutubeHttpConnectionManager implements SocialHttpConnectionManager {

	protected String bearerToken;
	
	@Override
	public String getBearerToken() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpURLConnection buildHttpConnection(URL url, String httpMethod) throws ProtocolException, IOException {
		final HttpURLConnection connection;
		final Map<String, String> requestParameters = new HashMap<>();
		
		
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

	@Override
	public HttpURLConnection buildHttpConnection(URL url, String httpMethod,
			Map<String, String> customResquestParameters) throws ProtocolException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
