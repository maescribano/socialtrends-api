package com.socialtrend.model.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.socialtrend.config.PropertiesReader;
import com.socialtrend.model.Topic;

@Component
public class YoutubeTopicMapper {
	
	final static String CONTENT_URL_PREFIX = (String) PropertiesReader.getProperty("YOUTUBE_CONTENT_URL");
	
	public Topic map(JsonObject jsonYoutubeVideo){
		final Topic youtubeTopic = new Topic();
		
		//youtubeTopic.setName((String) jsonYoutubeVideo.get("name"));
		youtubeTopic.setDescription(jsonYoutubeVideo.get("snippet").getAsJsonObject().get("description").getAsString());
		youtubeTopic.setPreviewImageUrl(jsonYoutubeVideo.get("snippet").getAsJsonObject().get("thumbnails").getAsJsonObject().get("high").getAsJsonObject().get("url").getAsString());
		youtubeTopic.setShowContentUrl(CONTENT_URL_PREFIX + jsonYoutubeVideo.get("id").getAsJsonObject().get("videoId").getAsString());
		youtubeTopic.setTitle(jsonYoutubeVideo.get("snippet").getAsJsonObject().get("title").getAsString());
		
		return youtubeTopic;
	}
	
	public List<Topic> map (JsonArray jsonYoutubeVideos){
		final List<Topic> youtubeTopics = new ArrayList<Topic>();			
		
		for(final JsonElement youtubeVideo : jsonYoutubeVideos) {
		    Topic topic =  map((JsonObject)youtubeVideo);
		    youtubeTopics.add(topic);
		}
	
		return youtubeTopics;
	}
	
}
