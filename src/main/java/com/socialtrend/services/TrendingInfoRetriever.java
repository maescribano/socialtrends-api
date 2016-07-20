package com.socialtrend.services;

public abstract class TrendingInfoRetriever {
	
	public abstract String getWorldTrendingTopicName();
	public abstract String getClosestTrendingTopicName();
	public abstract String getTrendingTopicNameByPlace(String place);
	public abstract String getTrendingTopics(String topicName);
	

	
}
