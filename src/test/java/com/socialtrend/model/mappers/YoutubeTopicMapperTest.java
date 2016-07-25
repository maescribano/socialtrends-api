package com.socialtrend.model.mappers;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.socialtrend.config.BeansConfig;
import com.socialtrend.model.Topic;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { BeansConfig.class})
public class YoutubeTopicMapperTest {

	JsonParser jsonParser;
	JsonObject simpleJsonObjectMock;
	//String simpleJsonObjectString =  "{ \"kind\": \"youtube#searchResult\", \"etag\": \"5g01s4-wS2b4VpScndqCYc5Y-8k/K8ATkIHkF3n9v4iarB5kRk6rTfs\", \"id\": { \"kind\": \"youtube#video\", \"videoId\": \"6NpKoF8Uj1k\" }, \"snippet\": { \"publishedAt\": \"2016-07-25T01:27:00.000Z\", \"channelId\": \"UCooTLkxcpnTNx6vfOovfBFA\", \"title\": \"Cristiano Ronaldo's home island to name airport after him\", \"description\": \"Madeira International Airport will soon be known as Cristiano Ronaldo Airport. SUBSCRIBE to get the latest FOX Soccer content: ...\", \"thumbnails\": { \"default\": { \"url\": \"https://i.ytimg.com/vi/6NpKoF8Uj1k/default.jpg\", \"width\": 120, \"height\": 90 }, \"medium\": { \"url\": \"https://i.ytimg.com/vi/6NpKoF8Uj1k/mqdefault.jpg\", \"width\": 320, \"height\": 180 }, \"high\": { \"url\": \"https://i.ytimg.com/vi/6NpKoF8Uj1k/hqdefault.jpg\", \"width\": 480, \"height\": 360 } }, \"channelTitle\": \"FOX Soccer\", \"liveBroadcastContent\": \"none\" } }";

	String youtubeJsonResponseSample = "{ \"kind\": \"youtube#searchListResponse\", \"etag\": \"5g01s4-wS2b4VpScndqCYc5Y-8k/ICjZlAm9tUqu1mpFVfqmNUA9GIY\", \"nextPageToken\": \"CAUQAA\", \"regionCode\": \"ES\", \"pageInfo\": { \"totalResults\": 1000000, \"resultsPerPage\": 5 }, \"items\": [ { \"kind\": \"youtube#searchResult\", \"etag\": \"5g01s4-wS2b4VpScndqCYc5Y-8k/YXJr8OO0HNv1kXb22oUHVzA2Goo\", \"id\": { \"kind\": \"youtube#video\", \"videoId\": \"HcAnLRI-QDM\" }, \"snippet\": { \"publishedAt\": \"2016-07-22T18:15:27.000Z\", \"channelId\": \"UC5TonuMJPPPd5FWD1EcIK1A\", \"title\": \"Los Porteros Más Tontos en la Historia del Fútbol\", \"description\": \"Algunos errores de porteros imperdonables :D COMPARTE Y DALE LIKE :) SÍGUEME EN ...\", \"thumbnails\": { \"default\": { \"url\": \"https://i.ytimg.com/vi/HcAnLRI-QDM/default.jpg\", \"width\": 120, \"height\": 90 }, \"medium\": { \"url\": \"https://i.ytimg.com/vi/HcAnLRI-QDM/mqdefault.jpg\", \"width\": 320, \"height\": 180 }, \"high\": { \"url\": \"https://i.ytimg.com/vi/HcAnLRI-QDM/hqdefault.jpg\", \"width\": 480, \"height\": 360 } }, \"channelTitle\": \"Eddy Fútbol\", \"liveBroadcastContent\": \"none\" } }, { \"kind\": \"youtube#searchResult\", \"etag\": \"5g01s4-wS2b4VpScndqCYc5Y-8k/dDR2XX2ZrFjBwUrfjNz7ulA4sx8\", \"id\": { \"kind\": \"youtube#video\", \"videoId\": \"Iz0-BBvAFrs\" }, \"snippet\": { \"publishedAt\": \"2016-07-22T00:45:39.000Z\", \"channelId\": \"UC5TonuMJPPPd5FWD1EcIK1A\", \"title\": \"Los Peores Penales Fallados por Estrellas del Fútbol\", \"description\": \"Algunos de los peores penales peor cobrados en la historia! COMPARTE Y DALE LIKE ;) SÍGUEME EN ...\", \"thumbnails\": { \"default\": { \"url\": \"https://i.ytimg.com/vi/Iz0-BBvAFrs/default.jpg\", \"width\": 120, \"height\": 90 }, \"medium\": { \"url\": \"https://i.ytimg.com/vi/Iz0-BBvAFrs/mqdefault.jpg\", \"width\": 320, \"height\": 180 }, \"high\": { \"url\": \"https://i.ytimg.com/vi/Iz0-BBvAFrs/hqdefault.jpg\", \"width\": 480, \"height\": 360 } }, \"channelTitle\": \"Eddy Fútbol\", \"liveBroadcastContent\": \"none\" } }, { \"kind\": \"youtube#searchResult\", \"etag\": \"5g01s4-wS2b4VpScndqCYc5Y-8k/o_zaGGUqOYuBT9ya7Iw8JdN-AFM\", \"id\": { \"kind\": \"youtube#video\", \"videoId\": \"9hYwlS8DC6Y\" }, \"snippet\": { \"publishedAt\": \"2016-07-21T01:33:26.000Z\", \"channelId\": \"UC5TonuMJPPPd5FWD1EcIK1A\", \"title\": \"Las Mejores Simulaciones de Falta en el Fútbol\", \"description\": \"Unas de las simulaciones más exageradas en el futbol xD COMPARTE Y DALE LIKE :) SIGUEME EN ...\", \"thumbnails\": { \"default\": { \"url\": \"https://i.ytimg.com/vi/9hYwlS8DC6Y/default.jpg\", \"width\": 120, \"height\": 90 }, \"medium\": { \"url\": \"https://i.ytimg.com/vi/9hYwlS8DC6Y/mqdefault.jpg\", \"width\": 320, \"height\": 180 }, \"high\": { \"url\": \"https://i.ytimg.com/vi/9hYwlS8DC6Y/hqdefault.jpg\", \"width\": 480, \"height\": 360 } }, \"channelTitle\": \"Eddy Fútbol\", \"liveBroadcastContent\": \"none\" } }, { \"kind\": \"youtube#searchResult\", \"etag\": \"5g01s4-wS2b4VpScndqCYc5Y-8k/lIuEW2cZTXSP2_YPLSEQOxUPqIY\", \"id\": { \"kind\": \"youtube#video\", \"videoId\": \"52I2399rX70\" }, \"snippet\": { \"publishedAt\": \"2016-07-25T13:11:43.000Z\", \"channelId\": \"UCml8twxnMIpjswMer1JoYPA\", \"title\": \"Botas de Fútbol de Messi (16+ PUREAGILITY & X PURECHAO) - GuidoFTO vlogs\", \"description\": \"Probando las nuevas botas de Fútbol de messi 16+ PUREAGILITY & X PURECHAOS! Partidos & Golazos de Futbol al ángulo! por la noche intentamos ir al ...\", \"thumbnails\": { \"default\": { \"url\": \"https://i.ytimg.com/vi/52I2399rX70/default.jpg\", \"width\": 120, \"height\": 90 }, \"medium\": { \"url\": \"https://i.ytimg.com/vi/52I2399rX70/mqdefault.jpg\", \"width\": 320, \"height\": 180 }, \"high\": { \"url\": \"https://i.ytimg.com/vi/52I2399rX70/hqdefault.jpg\", \"width\": 480, \"height\": 360 } }, \"channelTitle\": \"GuidoFTO\", \"liveBroadcastContent\": \"none\" } }, { \"kind\": \"youtube#searchResult\", \"etag\": \"5g01s4-wS2b4VpScndqCYc5Y-8k/C4rmH8OxJNLJh5_axnph3jXpOxc\", \"id\": { \"kind\": \"youtube#video\", \"videoId\": \"WC3VK_7xK9w\" }, \"snippet\": { \"publishedAt\": \"2016-04-27T00:18:12.000Z\", \"channelId\": \"UCVtSqTs5yyNySSVP5S5869w\", \"title\": \"Las Mejores Jugadas Del Fútbol 2016\", \"description\": \"Parte 2: https://www.youtube.com/watch?v=ZBfVNR53hH4 Los mejores lujos, regates, jugadas de fantasía del fútbol de este año! Best Football Skills 2016 ...\", \"thumbnails\": { \"default\": { \"url\": \"https://i.ytimg.com/vi/WC3VK_7xK9w/default.jpg\", \"width\": 120, \"height\": 90 }, \"medium\": { \"url\": \"https://i.ytimg.com/vi/WC3VK_7xK9w/mqdefault.jpg\", \"width\": 320, \"height\": 180 }, \"high\": { \"url\": \"https://i.ytimg.com/vi/WC3VK_7xK9w/hqdefault.jpg\", \"width\": 480, \"height\": 360 } }, \"channelTitle\": \"Yo Amo El Fútbol\", \"liveBroadcastContent\": \"none\" } } ] }";
	@Autowired
	private YoutubeTopicMapper youtubeTopicMapper;


	@Before
	public void init() {
		jsonParser = new JsonParser();
		simpleJsonObjectMock = jsonParser.parse(youtubeJsonResponseSample).getAsJsonObject();
	}

	@Test
	public void simpleJsonObjectMapperTest(){
		final JsonObject firstYoutubeVideo = simpleJsonObjectMock.get("items").getAsJsonArray().get(0).getAsJsonObject();
		Topic youtubeTopic = youtubeTopicMapper.map(firstYoutubeVideo);

		assertTrue(firstYoutubeVideo.get("snippet").getAsJsonObject().get("description").getAsString().equals(youtubeTopic.getDescription()));
		assertTrue(firstYoutubeVideo.get("snippet").getAsJsonObject().get("title").getAsString().equals(youtubeTopic.getTitle()));
		assertTrue(firstYoutubeVideo.get("snippet").getAsJsonObject().get("thumbnails").getAsJsonObject().get("high").getAsJsonObject().get("url").getAsString().equals(youtubeTopic.getPreviewImageUrl()));
		assertTrue(("https://www.youtube.com/watch?v="+firstYoutubeVideo.get("id").getAsJsonObject().get("videoId").getAsString()).equals(youtubeTopic.getShowContentUrl()));

	}
	
	
	@Test
	public void JsonObjectCollectionMapperTest(){
		final JsonArray youtubeVideos = simpleJsonObjectMock.get("items").getAsJsonArray();
		List<Topic> youtubeTopics = youtubeTopicMapper.map(youtubeVideos);
		
		
		assertTrue(youtubeVideos.get(0).getAsJsonObject().get("snippet").getAsJsonObject().get("description").getAsString().equals(youtubeTopics.get(0).getDescription()));
		assertTrue(youtubeVideos.get(0).getAsJsonObject().get("snippet").getAsJsonObject().get("title").getAsString().equals(youtubeTopics.get(0).getTitle()));
		assertTrue(youtubeVideos.get(0).getAsJsonObject().get("snippet").getAsJsonObject().get("thumbnails").getAsJsonObject().get("high").getAsJsonObject().get("url").getAsString().equals(youtubeTopics.get(0).getPreviewImageUrl()));
		assertTrue(("https://www.youtube.com/watch?v="+youtubeVideos.get(0).getAsJsonObject().get("id").getAsJsonObject().get("videoId").getAsString()).equals(youtubeTopics.get(0).getShowContentUrl()));

	}
	
	
	

}
