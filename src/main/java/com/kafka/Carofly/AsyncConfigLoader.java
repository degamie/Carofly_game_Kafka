package com.kafka.Carofly;

import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@EnableAsync
public class AsyncConfigLoader {
    ThreadPoolTaskExecutor executor;
    public ThreadPoolTaskExecutor threadPoolTaskExecutor(){
        executor.setQueueCapacity(200);
        executor.setMaxPoolSize(250);
        executor.setThreadNamePrefix("-player_producer");
        return executor;
    }
}
