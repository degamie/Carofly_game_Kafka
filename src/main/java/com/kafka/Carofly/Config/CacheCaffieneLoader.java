package com.kafka.Carofly.Config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheCaffieneLoader {
    CacheCaffieneLoader cacheCaffieneLoader;
    public  CacheCaffieneLoader(CacheCaffieneLoader cacheCaffieneLoader){
        this.cacheCaffieneLoader=cacheCaffieneLoader;
    }
    @Bean
    public CacheManager cacheManager(){
        CaffeineCacheManager cacheManager=new CacheManager();
        cacheManager.setCacheNames("players","gameStatus","Options");
    }
}
