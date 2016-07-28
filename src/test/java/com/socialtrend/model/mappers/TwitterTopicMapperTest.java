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
public class TwitterTopicMapperTest {

	JsonParser jsonParser;
	JsonReader jsonReader;
	JsonObject simpleJsonObjectMock;
	
	@Autowired
	private TwitterTopicMapper twitterTopicMapper;


	@Before
	public void init() throws FileNotFoundException {
		jsonParser = new JsonParser();
		JsonReader jsonReader = new JsonReader(new FileReader("src/test/resources/MockTwitterResponse.json"));
		simpleJsonObjectMock = jsonParser.parse(jsonReader).getAsJsonObject();
	}

	@Test
	public void simpleJsonObjectMapperTest(){
		final JsonObject firstTwitterTopic = simpleJsonObjectMock.get("statuses").getAsJsonArray().get(5).getAsJsonObject();
		Topic twitterTopic = twitterTopicMapper.map(firstTwitterTopic);
		
		final String showContentUrl = "https://twitter.com/"+firstTwitterTopic.get("user").getAsJsonObject().get("screen_name").getAsString()+"/status/"+firstTwitterTopic.get("id").getAsString();
		final String peviewImageUrl = firstTwitterTopic.get("entities").getAsJsonObject().get("media") != null && 
				firstTwitterTopic.get("entities").getAsJsonObject().get("media").getAsJsonArray().get(0).getAsJsonObject().get("media_url") != null  ? 
						firstTwitterTopic.get("entities").getAsJsonObject().get("media").getAsJsonArray().get(0).getAsJsonObject().get("media_url").getAsString() : 
						"";
		
		assertTrue(firstTwitterTopic.get("text").getAsString().equals(twitterTopic.getDescription()));
		assertTrue(peviewImageUrl.equals(twitterTopic.getPreviewImageUrl()));
		assertTrue(showContentUrl.equals(twitterTopic.getShowContentUrl()));
		assertTrue(firstTwitterTopic.get("text").getAsString().equals(twitterTopic.getTitle()));

	}
	
	
	@Test
	public void JsonObjectCollectionMapperTest(){
		final JsonArray jsonTwitterTopics = simpleJsonObjectMock.get("statuses").getAsJsonArray();
		List<Topic> twitterTopics = twitterTopicMapper.map(jsonTwitterTopics);		
		
		final String showContentUrl = "https://twitter.com/"+jsonTwitterTopics.get(0).getAsJsonObject().get("user").getAsJsonObject().get("screen_name").getAsString()+"/status/"+jsonTwitterTopics.get(0).getAsJsonObject().get("id").getAsString();
		final String peviewImageUrl = jsonTwitterTopics.get(0).getAsJsonObject().get("entities").getAsJsonObject().get("media") != null && 
				jsonTwitterTopics.get(0).getAsJsonObject().get("entities").getAsJsonObject().get("media").getAsJsonArray().get(0).getAsJsonObject().get("media_url") != null  ? 
						jsonTwitterTopics.get(0).getAsJsonObject().get("entities").getAsJsonObject().get("media").getAsJsonArray().get(0).getAsJsonObject().get("media_url").getAsString() : 
						"";
		
		assertTrue((jsonTwitterTopics.get(0).getAsJsonObject().get("text").getAsString().equals(twitterTopics.get(0).getDescription())));
		assertTrue(peviewImageUrl.equals(twitterTopics.get(0).getPreviewImageUrl()));
		assertTrue(showContentUrl.equals(twitterTopics.get(0).getShowContentUrl()));
		assertTrue(jsonTwitterTopics.get(0).getAsJsonObject().get("text").getAsString().equals(twitterTopics.get(0).getTitle()));
	}

}
