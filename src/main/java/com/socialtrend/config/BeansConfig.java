package com.socialtrend.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.socialtrend.services.TrendingInfoRetriever;

@Configuration
@ComponentScan("com.socialtrend.*")
public class BeansConfig {
	
	@Autowired
	private TrendingInfoRetriever twitterTrendingInfoRetriever;
	
	@Autowired
	private TrendingInfoRetriever youtubeTrendingInfoRetriever;


	@Bean
	public Map<String, TrendingInfoRetriever> socialRetrievers() {
		final Map<String, TrendingInfoRetriever> retrievers = new HashMap<String, TrendingInfoRetriever>();
		retrievers.put(Constants.TWITTER_RETRIEVER_ID, twitterTrendingInfoRetriever);
		retrievers.put(Constants.YOUTUBE_RETRIEVER_ID, youtubeTrendingInfoRetriever);
		return retrievers;
	}
}
