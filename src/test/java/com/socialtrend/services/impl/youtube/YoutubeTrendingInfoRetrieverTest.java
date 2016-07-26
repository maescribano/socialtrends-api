package com.socialtrend.services.impl.youtube;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.socialtrend.config.BeansConfig;
import com.socialtrend.model.Topic;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { BeansConfig.class})
public class YoutubeTrendingInfoRetrieverTest {

	final static String EXAMPLE_SEARCH = "cristiano ronaldo";
	final static String EXAMPLE_RESPONSE = "{ \"kind\": \"youtube#searchListResponse\", \"etag\": \"5g01s4-wS2b4VpScndqCYc5Y-8k/ZF9gVPNc6EaX4IDiPSW-td40z9M\", \"nextPageToken\": \"CAUQAA\", \"regionCode\": \"ES\", \"pageInfo\": { \"totalResults\": 1000000, \"resultsPerPage\": 5 }, \"items\": [ { \"kind\": \"youtube#searchResult\", \"etag\": \"5g01s4-wS2b4VpScndqCYc5Y-8k/2Va8P9G_efS2Xl1wnbgB11y45CA\", \"id\": { \"kind\": \"youtube#video\", \"videoId\": \"LmCqUwoxLqE\" }, \"snippet\": { \"publishedAt\": \"2016-07-25T22:30:38.000Z\", \"channelId\": \"UCooTLkxcpnTNx6vfOovfBFA\", \"title\": \"Cristiano Ronaldo and Conor McGregor get in the ring together\", \"description\": \"Ronaldo stopped by McGregor's gym in Vegas while he was in town for J-Lo's birthday. SUBSCRIBE to get the latest FOX Soccer content: ...\", \"thumbnails\": { \"default\": { \"url\": \"https://i.ytimg.com/vi/LmCqUwoxLqE/default.jpg\", \"width\": 120, \"height\": 90 }, \"medium\": { \"url\": \"https://i.ytimg.com/vi/LmCqUwoxLqE/mqdefault.jpg\", \"width\": 320, \"height\": 180 }, \"high\": { \"url\": \"https://i.ytimg.com/vi/LmCqUwoxLqE/hqdefault.jpg\", \"width\": 480, \"height\": 360 } }, \"channelTitle\": \"FOX Soccer\", \"liveBroadcastContent\": \"none\" } }, { \"kind\": \"youtube#searchResult\", \"etag\": \"5g01s4-wS2b4VpScndqCYc5Y-8k/zZ7h9hFKxp0OnA4eOzt-VqaUxtA\", \"id\": { \"kind\": \"youtube#video\", \"videoId\": \"bgs0UIncY3s\" }, \"snippet\": { \"publishedAt\": \"2016-07-26T13:41:25.000Z\", \"channelId\": \"UCzH1-LbnOPwgzMxo3NcUtng\", \"title\": \"Cristiano Ronaldo | Crazy Skills and Goals ● 2016 HD\", \"description\": \"Cristiano Ronaldo | Crazy Skills and Goals ○ 2016 HD Cristiano Ronaldo | Crazy Skills and Goals ○ 2016 HD ...\", \"thumbnails\": { \"default\": { \"url\": \"https://i.ytimg.com/vi/bgs0UIncY3s/default.jpg\", \"width\": 120, \"height\": 90 }, \"medium\": { \"url\": \"https://i.ytimg.com/vi/bgs0UIncY3s/mqdefault.jpg\", \"width\": 320, \"height\": 180 }, \"high\": { \"url\": \"https://i.ytimg.com/vi/bgs0UIncY3s/hqdefault.jpg\", \"width\": 480, \"height\": 360 } }, \"channelTitle\": \"KINGDOM OF FOOTBALL\", \"liveBroadcastContent\": \"none\" } }, { \"kind\": \"youtube#searchResult\", \"etag\": \"5g01s4-wS2b4VpScndqCYc5Y-8k/S3gZyDLJ7wdC8l1wwboH5wG4ZcA\", \"id\": { \"kind\": \"youtube#video\", \"videoId\": \"tJ_wnoUfFIs\" }, \"snippet\": { \"publishedAt\": \"2016-07-26T09:58:15.000Z\", \"channelId\": \"UClvgyQvIplPQU8N73vPlFUA\", \"title\": \"Cristiano Ronaldo - Top 10 Goals, Real Madrid & Portugal ● 2016 HD\", \"description\": \"Hit LIKE & SUBSCRIBE! Title: Cristiano Ronaldo - Top 10 Goals, Real Madrid & Portugal ○ 2016 HD Cristiano Ronaldo had some amazing goals with Real ...\", \"thumbnails\": { \"default\": { \"url\": \"https://i.ytimg.com/vi/tJ_wnoUfFIs/default.jpg\", \"width\": 120, \"height\": 90 }, \"medium\": { \"url\": \"https://i.ytimg.com/vi/tJ_wnoUfFIs/mqdefault.jpg\", \"width\": 320, \"height\": 180 }, \"high\": { \"url\": \"https://i.ytimg.com/vi/tJ_wnoUfFIs/hqdefault.jpg\", \"width\": 480, \"height\": 360 } }, \"channelTitle\": \"AshStudio7\", \"liveBroadcastContent\": \"none\" } }, { \"kind\": \"youtube#searchResult\", \"etag\": \"5g01s4-wS2b4VpScndqCYc5Y-8k/dZ2MZXhEuIFAcDS90n_Ak3jgLmc\", \"id\": { \"kind\": \"youtube#video\", \"videoId\": \"oRb5Kzc8v6U\" }, \"snippet\": { \"publishedAt\": \"2016-07-25T19:52:50.000Z\", \"channelId\": \"UCDQcZMuzY948G2SllT0GDvw\", \"title\": \"Cristiano Ronaldo visits Conor McGregor\", \"description\": \"Portuguese football star Cristiano Ronaldo visited Conor McGregor at the UFC Gym in Las Vegas while McGregor was training for his UFC 202 bout on August ...\", \"thumbnails\": { \"default\": { \"url\": \"https://i.ytimg.com/vi/oRb5Kzc8v6U/default.jpg\", \"width\": 120, \"height\": 90 }, \"medium\": { \"url\": \"https://i.ytimg.com/vi/oRb5Kzc8v6U/mqdefault.jpg\", \"width\": 320, \"height\": 180 }, \"high\": { \"url\": \"https://i.ytimg.com/vi/oRb5Kzc8v6U/hqdefault.jpg\", \"width\": 480, \"height\": 360 } }, \"channelTitle\": \"mmadigest\", \"liveBroadcastContent\": \"none\" } }, { \"kind\": \"youtube#searchResult\", \"etag\": \"5g01s4-wS2b4VpScndqCYc5Y-8k/wPjJhoqfXsDi4QrVSNrCpGbQLKc\", \"id\": { \"kind\": \"youtube#video\", \"videoId\": \"e7aEI2IA3PQ\" }, \"snippet\": { \"publishedAt\": \"2016-07-25T18:50:01.000Z\", \"channelId\": \"UCE3yf1AcIlXdps2EYbq3lzw\", \"title\": \"Cristiano Ronaldo Shirtless Showdown with Conor McGregor, Danced Next to Kim Kardashian\", \"description\": \"Two titans of sport ... not one single chest hair. Cristiano Ronaldo and Conor McGregor came face-to-face in Vegas this weekend ... and immediately took their ...\", \"thumbnails\": { \"default\": { \"url\": \"https://i.ytimg.com/vi/e7aEI2IA3PQ/default.jpg\", \"width\": 120, \"height\": 90 }, \"medium\": { \"url\": \"https://i.ytimg.com/vi/e7aEI2IA3PQ/mqdefault.jpg\", \"width\": 320, \"height\": 180 }, \"high\": { \"url\": \"https://i.ytimg.com/vi/e7aEI2IA3PQ/hqdefault.jpg\", \"width\": 480, \"height\": 360 } }, \"channelTitle\": \"TMZSports\", \"liveBroadcastContent\": \"none\" } } ] }";
	
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
	public void parseResponseAndBuildTopicCollectionTest(){
		List<Topic> result = youtubeTrendingInfoRetriever.parseResponseAndBuildTopicCollection(EXAMPLE_RESPONSE);
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
