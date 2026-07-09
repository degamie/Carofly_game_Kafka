//WID(9/07/2026)(Sarthak Mittal(DegamieSign)(PlayerProduicerService)#1.1.1.1
package com.kafka.Carofly.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafka.Carofly.dto.PlayerProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import tools.jackson.databind.ObjectMapper;

import java.util.logging.Logger;

public class PlayerProducerService {
    public  void existsByplayerTopic(String playerTopic){
        if(playerTopic.length()!=0)getPlayerTopic(playerTopic);
        else getPlayerTopic(0);
    }
    public  String playerTopic=null;
    private void  setPlayerTopic(String playerTopic) {this.playerTopic=playerTopic;}
    private   String getPlayerTopic(String playerTopic) {return playerTopic;}
    public void updateByPLAYER_TOPIC(String PLAYER_TOPIC){getPlayerTopic(PLAYER_TOPIC)+setPlayerTopic(PLAYER_TOPIC)+1;}//




    public void setPLAYER_TOPIC(String PLAYER_TOPIC){this.PLAYER_TOPIC=PLAYER_TOPIC;}//Binding PLAYERTOPIC in GameApp
    PlayerProducerService(String playerIdAsString){
        this.playerIdAsString=playerIdAsString;
    }
    public void setObjectMapper(ObjectMapper objectMapper){this.objectMapper=objectMapper;}
    public void setLogger(Logger logger){this.logger=logger;}//bidning Logger in GameApp
    public void setKafkaTemplate(KafkaTemplate kafkaTemplate){this.kafkaTemplate=kafkaTemplate;}//binding  Kafka Template in GameApp

    public void setlogger(Logger logger){this.logger=logger;}//binding Logger In App
    public PlayerProducerService(PlayerProducer producer){
        this.producer=producer;
    }
    public Logger logger;
    String playerIdAsString = "";
    public void setPlayerIdAsString(String playerIdAsString){this.playerIdAsString=playerIdAsString;}//binding PlayerIdAsString in GameApp
    public ObjectMapper objectMapper;
    public String PLAYER_TOPIC=new String();
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
    public String getplayerproducerName(String playerProducerName, PlayerProducer playerProducer){return playerProducerName;}//Fetching PlayerProducerName in app
    public void setPlayerProducerId(String playerId) {
        this.playerId=playerId;
    }
//    PlayerProducerService(PlayerProducer producer){this.producer=producer;}//Binding PlayerProducer in GameApp


    public String getPlayerProducerId(String playerId) {
        return playerId;
    }
}
