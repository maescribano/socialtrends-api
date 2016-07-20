package com.socialtrend.services.impl;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.socialtrend.services.SocialHttpConnectionManager;
import com.socialtrend.services.TrendingInfoRetriever;
import com.socialtrend.utils.HttpUtils;

@Service
public class TwitterTrendingInfoRetriever extends TrendingInfoRetriever{

//	private final static String ENDPOINT_AVAILABLE_TRENDING_PLACES = "https://api.twitter.com/1.1/trends/available.json";
//	private final static String ENDPOINT_TRENDING_TOPICS_BYPLACE = "https://api.twitter.com/1.1/trends/place.json";
	private final static String ENDPOINT_TRENDING_TOPICNAMES_WORLDWIDE = "https://api.twitter.com/1.1/trends/place.json?id=1";
	private final static String ENDPOINT_SEARCH_TRENDING_TOPICS = "https://api.twitter.com/1.1/search/tweets.json";
	private final static String GET_METHOD = "GET";
	//private final static String POST_METHOD = "POST";

	
	@Autowired
	@Qualifier("twitterHttpConnectionManager")
	private SocialHttpConnectionManager twitterHttpConnectionManager;
	
	
	
	
	@Override
	public String getWorldTrendingTopicName() {
		HttpURLConnection connection = null;
		try {
			connection = twitterHttpConnectionManager.buildHttpConnection(
					new URL(ENDPOINT_TRENDING_TOPICNAMES_WORLDWIDE), GET_METHOD);
			String jsonResponse = HttpUtils.readResponse(connection);
			return jsonResponse;

		} catch (Exception e) {
			return "";
		}finally{
			if (connection != null) {
				connection.disconnect();
			}
		}
	}
	@Override
	public String getClosestTrendingTopicName() {
		return "implementar llamada a world trending topic closest";
	}
	@Override
	public String getTrendingTopicNameByPlace(String place) {
		// TODO Auto-generated method stub
		return place;
	}
	//TODO : return list<Topic>
	public String getTrendingTopics(String topicName) {
		HttpURLConnection connection = null;
		try {
			
			
			connection = twitterHttpConnectionManager.buildHttpConnection(
					new URL(ENDPOINT_SEARCH_TRENDING_TOPICS + "?q=" + URLEncoder.encode(topicName, "UTF-8")), 
					GET_METHOD);
			String jsonResponse = HttpUtils.readResponse(connection);
			return jsonResponse;

		} catch (Exception e) {
			return "";
		}finally{
			if (connection != null) {
				connection.disconnect();
			}
		}
	}
	//	private String getAvailableTrendingPlaces() {
	//		HttpURLConnection connection = null;
	//		try {
	//			final String Bearer = new String(getBearerToken().getBytes());
	//			Map<String, String> requestParameters = buildAvailableTrendingPlacesParameters(Bearer);
	//			connection = buildHttpConnection(
	//					new URL(ENDPOINT_AVAILABLE_TRENDING_PLACES), GET_METHOD, requestParameters);
	//			String jsonResponse = readResponse(connection);
	//			return jsonResponse;
	//			
	//		} catch (Exception e) {
	//			return "";
	//		}finally{
	//			if (connection != null) {
	//				connection.disconnect();
	//			}
	//		}
	//	}
	
	
	
}



