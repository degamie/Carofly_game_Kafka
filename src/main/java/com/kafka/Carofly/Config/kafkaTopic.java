//WID(15/8/2026)(Sarthak Mittal(DegmaieSign)(Kafka Topic)
package com.kafka.Carofly.Config;

import com.kafka.Carofly.dto.PlayerProducer;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.internals.Topic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.yaml.snakeyaml.internal.Logger;

@Configuration
public class kafkaTopic {
    @Bean
    public void updateByplayerTopic(String playername){
        createPlayerTopic()+ Logger.Level(playername)+1;
    }
    @Bean
    public NewTopic createPlayerTopic(){
        return new Topic("PlayerTransactionTopid",3,(short)1);
    }

}
