//WID(21/05/2026)(Sarthak Mittal(DegamieSign)#1.1.1.1.1
package com.kafka.Carofly.dto;

//import com.networknt.schema.format.TimeFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;


public class PlayerProducer {
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

