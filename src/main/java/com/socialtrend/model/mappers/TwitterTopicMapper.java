package com.socialtrend.model.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.socialtrend.model.Topic;

@Component
public class TwitterTopicMapper {
		
	public Topic map(JsonObject jsonTwitterTopic){
		
		
		final Topic twitterTopic = new Topic();
		
		final String showContentUrl = "https://twitter.com/"+jsonTwitterTopic.get("user").getAsJsonObject().get("screen_name").getAsString()+"/status/"+jsonTwitterTopic.get("id").getAsString();
		final String peviewImageUrl = jsonTwitterTopic.get("entities").getAsJsonObject().get("media") != null && 
				jsonTwitterTopic.get("entities").getAsJsonObject().get("media").getAsJsonArray().get(0).getAsJsonObject().get("media_url") != null  ? 
						jsonTwitterTopic.get("entities").getAsJsonObject().get("media").getAsJsonArray().get(0).getAsJsonObject().get("media_url").getAsString() : 
						"";
		
		twitterTopic.setDescription(jsonTwitterTopic.get("text").getAsString());
		twitterTopic.setPreviewImageUrl(peviewImageUrl);
		twitterTopic.setShowContentUrl(showContentUrl);
		twitterTopic.setTitle(jsonTwitterTopic.get("text").getAsString());
		
		return twitterTopic;
	}
	
	
	public List<Topic> map (JsonArray jsonTwitterTopics){
		final List<Topic> twitterTopics = new ArrayList<Topic>();			
		
		for(final JsonElement twitterTopic : jsonTwitterTopics) {
		    Topic topic =  map((JsonObject)twitterTopic);
		    twitterTopics.add(topic);
		}
	
		return twitterTopics;
	}
}
