//WID(1/8/2026)(Sarthak Mittal(DegameiSign)
package com.kafka.Carofly.Config;

import org.jspecify.annotations.Nullable;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;
import java.util.List;

@Configuration
@EnableCaching
public class CacheCaffieneLoader implements CacheManager{
    CacheCaffieneLoader cacheCaffieneLoader;
    public  CacheCaffieneLoader(CacheCaffieneLoader cacheCaffieneLoader){
        this.cacheCaffieneLoader=cacheCaffieneLoader;
    }
    @Bean
    public CacheManager cacheManager(){
        CaffeineCacheManager cacheManager=new CacheManager();
        cacheManager.setCacheNames("players","gameStatus","Options")(
                .maximumSize(10)
                .build());
    }

    @Override
    public @Nullable Cache getCache(String name) {
        return null;
    }

    @Override
    public Collection<String> getCacheNames() {
        return List.of();
    }

    @Override
    public void resetCaches() {
        CacheManager.super.resetCaches();
    }
}
