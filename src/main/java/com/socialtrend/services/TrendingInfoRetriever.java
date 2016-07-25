package com.socialtrend.services;

import java.util.List;

import com.socialtrend.model.Topic;

public abstract class TrendingInfoRetriever {
	
	public abstract String getWorldTrendingTopicName();
	public abstract String getClosestTrendingTopicName();
	public abstract String getTrendingTopicNameByPlace(String place);
	public abstract List<Topic> getTrendingTopics(String topicName);
	

	
}
