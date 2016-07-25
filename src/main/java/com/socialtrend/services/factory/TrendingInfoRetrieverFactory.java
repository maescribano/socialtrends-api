package com.socialtrend.services.factory;

import com.socialtrend.services.TrendingInfoRetriever;
import com.socialtrend.services.impl.twitter.TwitterTrendingInfoRetriever;
 
public class TrendingInfoRetrieverFactory {
	
	private final static String TWITTER_TRENDINGINFO_RETRIEVER_TYPE = "twitter";
	
	
	public static TrendingInfoRetriever geInstance(String type){
		switch (type) {
		case TWITTER_TRENDINGINFO_RETRIEVER_TYPE:
			return new TwitterTrendingInfoRetriever();
		default:
			return new TwitterTrendingInfoRetriever();
		}
	}
	
	public static TrendingInfoRetriever getInstance(){
		//Por Ahora siempre usamos twiiter como referencia para obtener
		//el nombre de los trendingtopics actuales.

		
		return new TwitterTrendingInfoRetriever();
	}

}
