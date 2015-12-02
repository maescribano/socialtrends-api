package com.socialtrend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.socialtrend.services.TrendingInfoRetriever;

@RestController
@RequestMapping(path="/socialtrends")
public class SocialTrendController {
	
	final static String TP_CLOSEST_REQUEST_TYPE = "closest";
	final static String TP_WORLD_REQUEST_TYPE = "world";
	
	
	@Autowired
	TrendingInfoRetriever trendingTopicInfoRetriever;

	@RequestMapping(path="/trendingtopics")
	public String getTrendingTopics(){
		//TODO
//		final List<Topic> trendingTopics = new ArrayList<Topic>();
//		final Topic topic = new Topic();
//		topic.setName("Topic de pruebaaaaaaaaaaa!");
//		trendingTopics.add(topic);
		
		return trendingTopicInfoRetriever.getTrendingTopics("#WeLoveYouNiall");
	}

	@RequestMapping(path="/trendingtopicname/{type}")
	public String getTrendingTopicName(
			@PathVariable(value="type") String type,
			@RequestParam(value="place", required=false) String place){		
		return 
			TP_CLOSEST_REQUEST_TYPE.equalsIgnoreCase(type) ?  trendingTopicInfoRetriever.getClosestTrendingTopicName() :
			TP_WORLD_REQUEST_TYPE.equalsIgnoreCase(type) ? trendingTopicInfoRetriever.getWorldTrendingTopicName() :
			trendingTopicInfoRetriever.getTrendingTopicNameByPlace(place);
	}


}
