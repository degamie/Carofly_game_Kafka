//WID(30/05/2026)(Sarthak Mittal(DegamieSign)(ProducerCls)
package com.kafka.Carofly.dto;

//import com.networknt.schema.format.TimeFormat;
import java.time.LocalTime;

import org.springframework.kafka.core.KafkaTemplate;


public class PlayerProducer {
    public void setPlayerId(String playerId){this.playerId=playerId;}//binding PlayerId in GameApp
    public void setplayerSpeedaccuracy(Integer playerspeedaccuracy){this.playerspeedaccuracy=playerspeedaccuracy;}
    public KafkaTemplate<String,String> kafkaTemplate=null;
    public String getPlayerId(String playerId){return playerId;}//Fetching PlayerID in GameApp
    PlayerProducer(String playerId,String playername,int score,LocalTime playermodifieddate,Integer plaayerspeedaccuracy){
        this.playerId=playerId;
        this.plaayerspeedaccuracy=plaayerspeedaccuracy;
        this.playername=playername;
        this.score=score;
        this.playermodifieddate=playermodifieddate;

    }
    public String playerId;
    public String playername;
    public  int score;
    public LocalTime playermodifieddate;
    public  Integer plaayerspeedaccuracy;


}

