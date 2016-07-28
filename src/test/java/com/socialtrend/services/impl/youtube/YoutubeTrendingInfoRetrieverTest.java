package com.socialtrend.services.impl.youtube;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.socialtrend.config.BeansConfig;
import com.socialtrend.model.Topic;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { BeansConfig.class})
public class YoutubeTrendingInfoRetrieverTest {

	final static String EXAMPLE_SEARCH = "cristiano ronaldo";	
	
	@Autowired
	YoutubeTrendingInfoRetriever youtubeTrendingInfoRetriever;
	
	
	@Test
	public void getTrendingTopicsTest(){
		// Integration test
		List<Topic> result = youtubeTrendingInfoRetriever.getTrendingTopics(EXAMPLE_SEARCH);
		assertTrue(!result.isEmpty() && result.size() == 5);
	}
	
	@Test
	// Unit Test
	public void parseResponseAndBuildTopicCollectionTest() throws JsonIOException, JsonSyntaxException, FileNotFoundException{
				
		final String exampleResponse = new JsonParser()
				.parse(new JsonReader(new FileReader("src/test/resources/MockYoutubeResponse.json")))
				.getAsJsonObject()
				.toString();
		
		List<Topic> result = youtubeTrendingInfoRetriever.parseResponseAndBuildTopicCollection(exampleResponse);
		assertTrue(!result.isEmpty() && result.size() == 5);
	}
	
	@Test
	public void getWorldTrendingTopicNameTest() {
		assertTrue(null == youtubeTrendingInfoRetriever.getClosestTrendingTopicName());
	}

	@Test
	public void getClosestTrendingTopicNameTest() {
		assertTrue(null == youtubeTrendingInfoRetriever.getClosestTrendingTopicName());
	}

	@Test
	public void getTrendingTopicNameByPlaceTest() {
		assertTrue(null == youtubeTrendingInfoRetriever.getTrendingTopicNameByPlace(""));
	}

	
}
