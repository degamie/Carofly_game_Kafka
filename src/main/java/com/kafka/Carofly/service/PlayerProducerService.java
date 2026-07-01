//WID(01/07/2026)(Sarthak Mittal(DegamieSign)(PlayerProduicerService)#1
package com.kafka.Carofly.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafka.Carofly.dto.PlayerProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import tools.jackson.databind.ObjectMapper;

import java.util.logging.Logger;

public class PlayerProducerService {
    public void setKafkaTemplate(KafkaTemplate kafkaTemplate){this.kafkaTemplate=kafkaTemplate;}//binding  Kafka Template in GameApp

    public void setlogger(Logger logger){this.logger=logger;}//binding Logger In App
    public PlayerProducerService(PlayerProducer producer){
        this.producer=producer;
    }
    public Logger logger;
    String playerIdAsString = "";
    public void setPlayerIdAsString(String playerIdAsString){this.playerIdAsString=playerIdAsString;}//binding PlayerIdAsString in GameApp
    public ObjectMapper objectMapper;
    public  final String PLAYER_TOPIC=new String();
    public KafkaTemplate kafkaTemplate;

    @Autowired
    public PlayerProducer producer;
    public Object publishMessagetoKafka(PlayerProducer playerProducer) throws RuntimeException, JsonProcessingException {
        playerIdAsString = objectMapper.writeValueAsString(playerProducer);
        kafkaTemplate.send(PLAYER_TOPIC, playerIdAsString);
        logger.info("Message Sent To Kafka" + playerIdAsString);

        return "Its Been Sent to kafka,Pls Check";
    }

    public void setPlayerProdcuerName(String playerProducerName){this.playerproducername=playerproducername;}//binding PlayerProducerName in GameApp
    public String getplayerproducerName(String playerProducerName){return playerProducerName;}//Fetching PlayerProducerName in app
    public void setPlayerProducerId(String playerId) {
        this.playerId=playerId;
    }
//    PlayerProducerService(PlayerProducer producer){this.producer=producer;}//Binding PlayerProducer in GameApp


    public String getPlayerProducerId(String playerId) {
        return playerId;
    }
}
