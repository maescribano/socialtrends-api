package com.socialtrend;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.socialtrend.model.Topic;
import com.socialtrend.services.TrendingInfoRetriever;
import com.socialtrend.services.impl.TrendingTopicCollector;

@RestController
@RequestMapping(path="/socialtrends")
public class SocialTrendController {
	
	final static String TP_CLOSEST_REQUEST_TYPE = "closest";
	final static String TP_WORLD_REQUEST_TYPE = "world";
	
	
	@Autowired
	TrendingTopicCollector trendingTopicCollector;

	//TODO: incluir param socialnets, de momento pide todas las que esten en la lista de retrievers
	@RequestMapping(path="/trendingtopic")
	public List<Topic> getTrendingTopics(){
		//TODO
//		final List<Topic> trendingTopics = new ArrayList<Topic>();
//		final Topic topic = new Topic();
//		topic.setName("Topic de pruebaaaaaaaaaaa!");
//		trendingTopics.add(topic);
		List<String> socialNets = new ArrayList<String>();
		socialNets.add("twitter");
		socialNets.add("youtube");
		return trendingTopicCollector.getTrendingTopics(socialNets);
	}

	@RequestMapping(path="/trendingtopicname/{type}")
	public String getTrendingTopicName(
			@PathVariable(value="type") String type,
			@RequestParam(value="place", required=false) String place){		
		return 
			TP_CLOSEST_REQUEST_TYPE.equalsIgnoreCase(type) ?  trendingTopicCollector.getClosestTrendingTopicName() :
			TP_WORLD_REQUEST_TYPE.equalsIgnoreCase(type) ? trendingTopicCollector.getWorldTrendingTopicName() :
				trendingTopicCollector.getTrendingTopicNameByPlace(place);
	}


}
