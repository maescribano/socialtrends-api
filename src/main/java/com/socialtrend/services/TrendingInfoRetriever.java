package com.socialtrend.services;

import java.util.List;

import com.socialtrend.model.Topic;

public abstract class TrendingInfoRetriever {
	
	public abstract String getWorldTrendingTopicName();
	public abstract String getClosestTrendingTopicName();
	public abstract String getTrendingTopicNameByPlace(String place);
	public abstract List<Topic> getTrendingTopics(String topicName);
	
	//TODO: Este metodo launchRequestAndReturnResponse deberia ser responsabilidad del SocialHttpConnectionManager. Cambiar.
//	public String  launchRequestAndReturnJsonResponse(String url, String method, SocialHttpConnectionManager connector){
//		HttpURLConnection connection = null;
//		try {
//			connection = connector.buildHttpConnection(
//					new URL(url), method);
//			return HttpUtils.readResponse(connection);
//		} catch (ProtocolException e) {
//			e.printStackTrace();
//			return "";
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//			return "";
//		} catch (IOException e) {
//			e.printStackTrace();
//			return "";
//		}finally{
//			if (connection != null) {
//				connection.disconnect();
//			}
//		}
//	}
}
