package com.socialtrend.services.impl.twitter;

import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.socialtrend.config.Constants;
import com.socialtrend.model.Topic;
import com.socialtrend.model.mappers.TwitterTopicMapper;
import com.socialtrend.services.SocialHttpConnectionManager;
import com.socialtrend.services.TrendingInfoRetriever;
import com.socialtrend.utils.HttpUtils;

@Service
public class TwitterTrendingInfoRetriever extends TrendingInfoRetriever{

	@Autowired
	private SocialHttpConnectionManager twitterHttpConnectionManager;

	@Autowired
	private TwitterTopicMapper TwitterTopicMapper;



	//TODO: Por ahora devuelve el mas trendy, pero podemos meterle granularidad facilmente y que devuelva los n mas trendy.
	@Override
	public String getWorldTrendingTopicName() {
		HttpURLConnection connection = null;
		try {
			connection = twitterHttpConnectionManager.buildHttpConnection(
					new URL(Constants.ENDPOINT_TRENDING_TOPICNAMES_WORLDWIDE), Constants.GET_METHOD);
			String jsonResponse = HttpUtils.readResponse(connection);

			return new JsonParser().parse(jsonResponse).getAsJsonArray().get(0)
					.getAsJsonObject().get("trends").getAsJsonArray()
					.get(0).getAsJsonObject().get("name").getAsString();

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
		String requestUrl;
		try {
			requestUrl = Constants.ENDPOINT_SEARCH_TRENDING_TOPICS + "?q=" + URLEncoder.encode(topicName, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			requestUrl = "";
			e.printStackTrace();
		}
		//TODO: Este metodo launchRequestAndReturnResponse deberia ser responsabilidad del SocialHttpConnectionManager. Cambiar.
		final String jsonResponse = twitterHttpConnectionManager.launchRequestAndReturnJsonResponse(requestUrl, Constants.GET_METHOD);

		return parseResponseAndBuildTopicCollection(jsonResponse);
	}

	protected List<Topic> parseResponseAndBuildTopicCollection(String jsonResponse) {
		final JsonArray twitterTopics = ((JsonObject) new JsonParser().parse(jsonResponse)).getAsJsonObject().get("statuses").getAsJsonArray();
		return TwitterTopicMapper.map(twitterTopics);

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



