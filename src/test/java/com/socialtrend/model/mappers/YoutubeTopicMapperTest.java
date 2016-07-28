package com.socialtrend.model.mappers;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileReader;
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
import com.google.gson.stream.JsonReader;
import com.socialtrend.config.BeansConfig;
import com.socialtrend.model.Topic;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { BeansConfig.class})
public class YoutubeTopicMapperTest {

	JsonParser jsonParser;
	JsonReader jsonReader;
	JsonObject simpleJsonObjectMock;
	

	@Autowired
	private YoutubeTopicMapper youtubeTopicMapper;


	@Before
	public void init() throws FileNotFoundException {
		jsonParser = new JsonParser();
		jsonReader = new JsonReader(new FileReader("src/test/resources/MockYoutubeResponse.json"));
		simpleJsonObjectMock = jsonParser.parse(jsonReader).getAsJsonObject();
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
