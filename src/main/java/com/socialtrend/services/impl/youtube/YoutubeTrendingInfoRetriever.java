package com.socialtrend.services.impl.youtube;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.socialtrend.config.Constants;
import com.socialtrend.config.PropertiesReader;
import com.socialtrend.model.Topic;
import com.socialtrend.model.mappers.YoutubeTopicMapper;
import com.socialtrend.services.SocialHttpConnectionManager;
import com.socialtrend.services.TrendingInfoRetriever;

//TODO: Utilizar el cliente java para apis de google. https://github.com/google/google-api-java-client/commits/dev

@Service
public class YoutubeTrendingInfoRetriever extends TrendingInfoRetriever {

	private final static String YOUTUBE_ENDPOINT_SEARCH_TRENDING_TOPICS = (String)PropertiesReader.getProperty("YOUTUBE_ENDPOINT_URL_TOKEN");

	@Autowired
	private SocialHttpConnectionManager youtubeHttpConnectionManager;

	@Autowired
	private YoutubeTopicMapper youtubeTopicMapper;

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
		String requestUrl;
		try {
			requestUrl = YOUTUBE_ENDPOINT_SEARCH_TRENDING_TOPICS + "&part=snippet&type=video&q=" + URLEncoder.encode(topicName, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			requestUrl = "";
			e.printStackTrace();
		}
		//TODO: Este metodo launchRequestAndReturnResponse deberia ser responsabilidad del SocialHttpConnectionManager. Cambiar.
		final String jsonResponse = launchRequestAndReturnResponse(requestUrl, Constants.GET_METHOD, youtubeHttpConnectionManager);
		return parseResponseAndBuildTopicCollection(jsonResponse);
	}



	protected List<Topic> parseResponseAndBuildTopicCollection(String jsonResponse) {

		final JsonArray youtubeVideos = ((JsonObject) new JsonParser().parse(jsonResponse)).get("items").getAsJsonArray();
		return youtubeTopicMapper.map(youtubeVideos);

	}

}
