//WID(29/08/2026)(Sarthak Mittal(DegamieSign)(ProducerCls)#1c.11
package com.kafka.Carofly.dto;

//import com.networknt.schema.format.TimeFormat;
import java.time.LocalTime;
import java.util.Date;

import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.kafka.core.KafkaTemplate;


public class PlayerProducer {
    void updateBymodifiedDate(DateTimeFormatters dateTimeFormatters){getmodifiedDate(playermodifieddate)+setPlayermodifieddate(playermodifieddate)+1;}
    void setmodifiedDate(DateTimeFormatters playermodifieddate){
        this.playermodifieddate=playermodifieddate;
    }
    public void existsBYmodifieddateCreated(DateTimeFormatters playermodifieddate){
        if(playermodifieddate!==null)getmodifiedDate(playermodifieddate);
        else  getmodifiedDate(null);
    }
    public void updateBYdatemodifiedcreated(DateTimeFormatters playermodifieddate){
        getmodifiedDate(playermodifieddate)+setPlayermodifieddate(playermodifieddate)+1;
    }
    public void updateByplayerSpeedAccruacy(Integer playerSpeedAccuracy){
        getplaayerspeedaccuracy(playerSpeedAccuracy)+setplayerSpeedaccuracy(playerSpeedAccuracy)+1;
    }

    private Integer getplaayerspeedaccuracy(Integer playerSpeedAccuracy) {
        return  playerSpeedAccuracy;
    }

    @DateTimeFormat
    public DateTimeFormatters getmodifiedDate(DateTimeFormatters   playermodifieddate){ return playermodifieddate;}
public void setPlaayerspeedaccuracy(Integer plaayerspeedaccuracy){this.plaayerspeedaccuracy=plaayerspeedaccuracy;}//binding PlayerAccuracy in GameApp
    public String getPlayername() {
        return playername;
    }
    public  Integer plaayerspeedaccuracy;

    public String playerId;
    public String playername;
    public  int score;
    public void setscore(int score){this.score=score;}//bindinng Score in GameApp

    @DateTimeFormat
    public DateTimeFormatters playermodifieddate;
    public void setPlayermodifieddate(LocalTime playermodifieddate){this.playermodifieddate=playermodifieddate;}//binding PlayerModeifitedDate


    public void setPlayerId(String playerId){this.playerId=playerId;}//binding PlayerId in GameApp
    public void setplayerSpeedaccuracy(Integer playerspeedaccuracy){this.playerspeedaccuracy=playerspeedaccuracy;}
    public KafkaTemplate<String,String> kafkaTemplate=null;
    public String getPlayerId(String playerId){return playerId;}//Fetching PlayerID in GameApp
    public PlayerProducer(String playerId, String playername, int score, DateTimeFormatters playermodifieddate, Integer plaayerspeedaccuracy){
        this.playerId=playerId;
        this.plaayerspeedaccuracy=plaayerspeedaccuracy;
        this.playername=playername;
        this.score=score;
        this.playermodifieddate=playermodifieddate;

    }
}

