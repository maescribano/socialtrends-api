package com.socialtrend.services.impl.twitter;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.socialtrend.config.Constants;
import com.socialtrend.model.Topic;
import com.socialtrend.services.SocialHttpConnectionManager;
import com.socialtrend.services.TrendingInfoRetriever;
import com.socialtrend.utils.HttpUtils;

@Service
public class TwitterTrendingInfoRetriever extends TrendingInfoRetriever{

//	private final static String ENDPOINT_AVAILABLE_TRENDING_PLACES = "https://api.twitter.com/1.1/trends/available.json";
//	private final static String ENDPOINT_TRENDING_TOPICS_BYPLACE = "https://api.twitter.com/1.1/trends/place.json";
	private final static String ENDPOINT_TRENDING_TOPICNAMES_WORLDWIDE = "https://api.twitter.com/1.1/trends/place.json?id=1";
	private final static String ENDPOINT_SEARCH_TRENDING_TOPICS = "https://api.twitter.com/1.1/search/tweets.json";


	
	@Autowired
	private SocialHttpConnectionManager twitterHttpConnectionManager;
	
	
	
	
	@Override
	public String getWorldTrendingTopicName() {
		HttpURLConnection connection = null;
		try {
			connection = twitterHttpConnectionManager.buildHttpConnection(
					new URL(ENDPOINT_TRENDING_TOPICNAMES_WORLDWIDE), Constants.GET_METHOD);
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
	public List<Topic> getTrendingTopics(String topicName) {
		HttpURLConnection connection = null;
		final List<Topic> trendingTopics = new ArrayList<>();
		try {
			
			Topic topic = new Topic();
			trendingTopics.add(topic);
			
			connection = twitterHttpConnectionManager.buildHttpConnection(
					new URL(ENDPOINT_SEARCH_TRENDING_TOPICS + "?q=" + URLEncoder.encode(topicName, "UTF-8")), 
					Constants.GET_METHOD);
			String jsonResponse = HttpUtils.readResponse(connection);
			//return jsonResponse;
			return trendingTopics;
			
		} catch (Exception e) {
			return trendingTopics;
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



