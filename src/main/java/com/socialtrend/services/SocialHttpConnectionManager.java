package com.socialtrend.services;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;

public interface SocialHttpConnectionManager {
	
	public abstract String getBearerToken();
	public abstract HttpURLConnection buildHttpConnection(URL url, 
			String httpMethod) throws ProtocolException, IOException;
	public abstract HttpURLConnection buildHttpConnection(URL url, 
			String httpMethod, Map<String, String> customResquestParameters) 
			throws ProtocolException, IOException;

}
