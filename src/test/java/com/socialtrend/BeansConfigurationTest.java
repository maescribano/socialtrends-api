package com.socialtrend;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.socialtrend.services.impl.YoutubeTrendingInfoRetriever;

@Configuration
public class BeansConfigurationTest {

	@Bean
    public YoutubeTrendingInfoRetriever youtubeTrendingInfoRetriever()
    {
		 return Mockito.mock(YoutubeTrendingInfoRetriever.class);
    }
	
}
