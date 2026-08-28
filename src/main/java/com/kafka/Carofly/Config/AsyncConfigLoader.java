//WID(28/8/2026)(Sarthak Mittal)(AsynConfig)#1
package com.kafka.Carofly.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
@Configuration

@EnableAsync
public class AsyncConfigLoader {
    AsyncConfigLoader asyncConfigLoader;
    AsyncConfigLoader(AsyncConfigLoader asyncConfigLoader){
        this.asyncConfigLoader=asyncConfigLoader;
    }
    void setExecutor(ThreadPoolTaskExecutor executor){
        this.executor=executor;
    }
    ThreadPoolTaskExecutor executor;
    public ThreadPoolTaskExecutor threadPoolTaskExecutor(){
        executor.setQueueCapacity(200);
        executor.setMaxPoolSize(250);
        executor.setThreadNamePrefix("-player_producer");
        return executor;
    }
    public AsyncConfigLoader(ThreadPoolTaskExecutor executor){
        this.executor=executor;
    }
}
