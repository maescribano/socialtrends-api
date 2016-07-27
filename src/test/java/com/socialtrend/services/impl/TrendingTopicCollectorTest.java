package com.socialtrend.services.impl;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
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
public class TrendingTopicCollectorTest {

	
	@Autowired
	TrendingTopicCollector trendingTopicCollector;
	
	@Test
	public void getTrendingTopicsTest(){
		
		final List<Topic> topics = trendingTopicCollector.getTrendingTopics(Arrays.asList("twitter","youtube"), "", "");
		assertTrue(topics.size() > 0);
	}
	
	
}
