package com.kafka.Carofly.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.internals.Topic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class kafkaTopic {
    @Bean
    public NewTopic createPlayerTopic(){
        return new Topic("PlayerTransactionTopid",3,(short)1);
    }

}
