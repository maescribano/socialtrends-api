package com.socialtrend.services.youtube;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.socialtrend.config.BeansConfig;
import com.socialtrend.model.Topic;
import com.socialtrend.services.impl.youtube.YoutubeTrendingInfoRetriever;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { BeansConfig.class})
public class YoutubeTrendingInfoRetrieverTest {

	@Autowired
	YoutubeTrendingInfoRetriever youtubeTrendingInfoRetriever;
	
	@Test
	public void getTrendingTopicsTest(){
		List<Topic> result = youtubeTrendingInfoRetriever.getTrendingTopics("cristiano ronaldo");
		System.out.println(result.get(0).getName());
	}
	
}
