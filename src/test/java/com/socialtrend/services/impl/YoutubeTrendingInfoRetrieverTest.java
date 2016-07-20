package com.socialtrend.services.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.socialtrend.config.BeansConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { BeansConfig.class})
public class YoutubeTrendingInfoRetrieverTest {

	@Autowired
	YoutubeTrendingInfoRetriever youtubeTrendingInfoRetriever;
	
	@Test
	public void getTrendingTopicsTest(){
		String result = youtubeTrendingInfoRetriever.getTrendingTopics("cristiano ronaldo");
		String parada = "";
	}
	
}
