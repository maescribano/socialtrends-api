package com.socialtrend.services.factory;

import com.socialtrend.services.TrendingInfoRetriever;
import com.socialtrend.services.impl.TwitterTrendingInfoRetriever;

public class TrendingTopicNameRetrieverFactory {
	
	public static TrendingInfoRetriever getInstance(){
		//Por Ahora siempre usamos twiiter como referencia para obtener
		//el nombre de los trendingtopics actuales.
		
		return new TwitterTrendingInfoRetriever();
	}

}
