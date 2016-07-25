package com.socialtrend.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.beust.jcommander.Strings;
import com.socialtrend.model.Topic;
import com.socialtrend.services.TrendingInfoRetriever;
import com.socialtrend.services.impl.twitter.TwitterTrendingInfoRetriever;

public class TrendingTopicCollector {
	
	@Autowired
	private Map<String, TrendingInfoRetriever> socialRetrievers;

	@Autowired
	private TwitterTrendingInfoRetriever trendingTopicNamesRetriever;
	
	public List<Topic> getTrendingTopics(List<String> socialNets){
		//TODO
		//final List<String> trendingTopicNames = ...
		// De moment solo con un trendingTopicName, el mas trendy
	
		final List<String> trendingTopicNames = new ArrayList<>();
		trendingTopicNames.add("#cristianoronaldo");
		final List <Topic> trendingTopics = new ArrayList<>();
		
		for (String topicName : trendingTopicNames) {
			for (String socialNet : socialNets) {
				trendingTopics.addAll(socialRetrievers.get(socialNet).getTrendingTopics(topicName));
			}
		}
		
		return trendingTopics;
		
//		for (String name : trendingTopicNames) {			
//			Topic topic = new Topic();
//			trendingTopics.add(topic);
//		}
	}
	
	public String getClosestTrendingTopicName(){
		return "";
	}
	
	public String getWorldTrendingTopicName(){
		return "";
	}
	
	public String getTrendingTopicNameByPlace(String place){
		return "";
	}
//	etTrendingTopics("#WeLoveYouNiall");
//}
//
//@RequestMapping(path="/trendingtopicname/{type}")
//public String getTrendingTopicName(
//		@PathVariable(value="type") String type,
//		@RequestParam(value="place", required=false) String place){		
//	return 
//		TP_CLOSEST_REQUEST_TYPE.equalsIgnoreCase(type) ?  trendingTopicCollector.getClosestTrendingTopicName() :
//		TP_WORLD_REQUEST_TYPE.equalsIgnoreCase(type) ? trendingTopicCollector.getWorldTrendingTopicName() :
//			trendingTopicCollector.getTrendingTopicNameByPlace(place);
	
}
