//WID(14/8/2026)(Sarthak Mittal)(AsynConfig)
package com.kafka.Carofly.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
@Configuration

@EnableAsync
public class AsyncConfigLoader {
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
