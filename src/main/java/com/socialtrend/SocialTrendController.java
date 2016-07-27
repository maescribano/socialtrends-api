package com.socialtrend;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.socialtrend.config.Constants;
import com.socialtrend.model.Topic;
import com.socialtrend.services.impl.TrendingTopicCollector;

@RestController
@RequestMapping(path="/socialtrends")
public class SocialTrendController {	
	
	@Autowired
	TrendingTopicCollector trendingTopicCollector;

	//TODO: incluir param socialnets, de momento pide todas las que esten en la lista de retrievers
	//TODO: incluir otro endpoint /topic para buscar topics por nombre no necesariamente los mas trendy.
	@RequestMapping(path="/trendingtopic")
	public List<Topic> getTrendingTopics(
			@RequestParam(value="socialnets", required=true) String socialnets,
			@RequestParam(value="type", required=false) String type,
			@RequestParam(value="place", required=false) String place
			){
		final List<String> socialNets = Arrays.asList(socialnets.split(","));
		return trendingTopicCollector.getTrendingTopics(socialNets, type, place);
	}

	@RequestMapping(path="/trendingtopicname")
	public String getTrendingTopicName(
			@RequestParam(value="type", required=false) String type,
			@RequestParam(value="place", required=false) String place){
		//TODO: El closest depende de la ubicación del servidor del api? comprobar!
		return 
			Constants.TP_CLOSEST_REQUEST_TYPE.equalsIgnoreCase(type) ?  trendingTopicCollector.getClosestTrendingTopicName() :
			Constants.TP_WORLD_REQUEST_TYPE.equalsIgnoreCase(type) ? trendingTopicCollector.getWorldTrendingTopicName() :
				trendingTopicCollector.getTrendingTopicNameByPlace(place);
	}


}
