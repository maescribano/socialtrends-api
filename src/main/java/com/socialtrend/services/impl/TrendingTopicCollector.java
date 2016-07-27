package com.socialtrend.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialtrend.config.Constants;
import com.socialtrend.model.Topic;
import com.socialtrend.services.TrendingInfoRetriever;
import com.socialtrend.services.impl.twitter.TwitterTrendingInfoRetriever;

@Service
public class TrendingTopicCollector {
	
	@Autowired
	private Map<String, TrendingInfoRetriever> socialRetrievers;

	@Autowired
	private TwitterTrendingInfoRetriever trendingTopicNamesRetriever;
	
	public List<Topic> getTrendingTopics(List<String> socialNets, String type, String place){
		//TODO
		//final List<String> trendingTopicNames = ...
		// De moment solo con un trendingTopicName, el mas trendy
		
		final List<String> trendingTopicNames = new ArrayList<>();		
		final String currentTrendingTopicOnTwitter = getCurrentTrendingTopicDependsOnTypeAndPlace(type, place);

		trendingTopicNames.add(currentTrendingTopicOnTwitter);
		return getTrendingTopicsOnSocialNets(socialNets, trendingTopicNames);
		
	}

	protected List<Topic> getTrendingTopicsOnSocialNets(List<String> socialNets, final List<String> trendingTopicNames) {
		final List <Topic> trendingTopics = new ArrayList<>();
		for (String topicName : trendingTopicNames) {
			for (String socialNet : socialNets) {
				final String retriverName = socialNet.concat(Constants.TRENDING_INFO_RETRIEVER_SUFIX_ID);
				trendingTopics.addAll(socialRetrievers.get(retriverName).getTrendingTopics(topicName));
			}
		}
		return trendingTopics;
	}

	protected String getCurrentTrendingTopicDependsOnTypeAndPlace(String type, String place) {
		return Constants.TP_CLOSEST_REQUEST_TYPE.equalsIgnoreCase(type) ?  trendingTopicNamesRetriever.getClosestTrendingTopicName() :
			Constants.TP_WORLD_REQUEST_TYPE.equalsIgnoreCase(type) ? trendingTopicNamesRetriever.getWorldTrendingTopicName() :
			StringUtils.isNotEmpty(place) ? trendingTopicNamesRetriever.getTrendingTopicNameByPlace(place) :
			trendingTopicNamesRetriever.getWorldTrendingTopicName();
	}
	
	public String getClosestTrendingTopicName(){
		return trendingTopicNamesRetriever.getClosestTrendingTopicName();
	}
	
	public String getWorldTrendingTopicName(){
		return trendingTopicNamesRetriever.getWorldTrendingTopicName();
	}
	
	public String getTrendingTopicNameByPlace(String place){
		return trendingTopicNamesRetriever.getTrendingTopicNameByPlace(place);
	}

}
