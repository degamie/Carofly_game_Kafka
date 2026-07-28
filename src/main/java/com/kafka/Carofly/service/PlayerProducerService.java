//WID(28/07/2026)(Sarthak Mittal(DegamieSign)(PlayerProduicerService)(Async0
package com.kafka.Carofly.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafka.Carofly.Config.JwtUtil;
import com.kafka.Carofly.dto.PlayerProducer;
import com.kafka.Carofly.dto.PlayerProducerEnum;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.logging.Logger;

import static com.kafka.Carofly.dto.PlayerProducerEnum.PLAYERID;

@Service
@EnableKafka
@EnableAsync
@EnableCaching

public class PlayerProducerService<T> {
//    public PlayerProducerEnum playerProducerEnum;
    @Autowired
    public JwtUtil jwtUtil;

    @Autowired
    public PlayerProducer producer;
    private void setplayerProducer(PlayerProducer playerProducer) {this.producer=producer;  }
    public void sendChatMessage(PlayerProducer playerProducer) {
        String token = jwtUtil.generateToken(playerProducer.getPlayerId(PLAYERID));

        ProducerRecord<String,PlayerProducer> record=new PlayerProducer("client-chat-messages", playerProducer.getPlayerId(PLAYERID), playerProducer);
        record.headers().add(new RecordHeader("Authorization", token.getBytes(StandardCharsets.UTF_8)));
        kafkaTemplate.send(record);

    }
@Async('player-producer')
    private List<PlayerProducer> getplayerProducer(PlayerProducer playerProducer) {
        return playerProducer;
    }
    public void updateByproducer(PlayerProducer playerProducer){
        getplayerProducer(playerProducer)+setplayerProducer(playerProducer)+1;
    }


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
