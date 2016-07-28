package com.socialtrend.services;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;

import com.socialtrend.utils.HttpUtils;

public abstract class SocialHttpConnectionManager {
	
	public abstract String getBearerToken();
	public abstract HttpURLConnection buildHttpConnection(URL url, 
			String httpMethod) throws ProtocolException, IOException;
	public abstract HttpURLConnection buildHttpConnection(URL url, 
			String httpMethod, Map<String, String> customResquestParameters) 
			throws ProtocolException, IOException;
	
	public String  launchRequestAndReturnJsonResponse(String url, String method){
		HttpURLConnection connection = null;
		try {
			connection = buildHttpConnection(
					new URL(url), method);
			return HttpUtils.readResponse(connection);
		} catch (ProtocolException e) {
			e.printStackTrace();
			return "";
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return "";
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}finally{
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

}
