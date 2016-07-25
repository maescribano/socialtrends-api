package com.socialtrend.services.impl.youtube;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialtrend.config.Constants;
import com.socialtrend.config.PropertiesReader;
import com.socialtrend.model.Topic;
import com.socialtrend.services.SocialHttpConnectionManager;
import com.socialtrend.services.TrendingInfoRetriever;
import com.socialtrend.utils.HttpUtils;

//TODO: Utilizar el cliente java para apis de google. https://github.com/google/google-api-java-client/commits/dev

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
	public List<Topic> getTrendingTopics(String topicName) {
		HttpURLConnection connection = null;
		final List<Topic> trendingTopics = new ArrayList<>();
		try {
			
			Topic topic = new Topic();
			
			connection = youtubeHttpConnectionManager.buildHttpConnection(
					new URL(YOUTUBE_ENDPOINT_SEARCH_TRENDING_TOPICS + "&part=snippet&type=video&q=" + URLEncoder.encode(topicName, "UTF-8")), 
					Constants.GET_METHOD);
			String jsonResponse = HttpUtils.readResponse(connection);
			topic.setName(jsonResponse);
			trendingTopics.add(topic);
			return trendingTopics;
			//return jsonResponse;
			

		} catch (Exception e) {
			return trendingTopics;
		}finally{
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

}
