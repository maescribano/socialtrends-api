package com.socialtrend.services.impl;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialtrend.config.Constants;
import com.socialtrend.config.PropertiesReader;
import com.socialtrend.services.SocialHttpConnectionManager;
import com.socialtrend.services.TrendingInfoRetriever;
import com.socialtrend.utils.HttpUtils;

@Service
public class YoutubeTrendingInfoRetriever extends TrendingInfoRetriever {
	
	private final static String YOUTUBE_ENDPOINT_SEARCH_TRENDING_TOPICS = (String)PropertiesReader.getProperty("YOUTUBE_ENDPOINT_URL_TOKEN");
	
	@Autowired
	private SocialHttpConnectionManager youtubeHttpConnectionManager;
	
	@Override
	public String getWorldTrendingTopicName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getClosestTrendingTopicName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTrendingTopicNameByPlace(String place) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTrendingTopics(String topicName) {
		HttpURLConnection connection = null;
		try {
			connection = youtubeHttpConnectionManager.buildHttpConnection(
					new URL(YOUTUBE_ENDPOINT_SEARCH_TRENDING_TOPICS + "&part=snippet&q=" + URLEncoder.encode(topicName, "UTF-8")), 
					Constants.GET_METHOD);
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

}
