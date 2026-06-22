//WID(22/6/2026)(Sarthak Mittal(DegamieSign)#1
package com.kafka.Carofly.service;

import com.kafka.Carofly.dto.PlayerProducer;
import org.springframework.beans.factory.annotation.Autowired;

public class PlayerProducerService {
    @Autowired
    public PlayerProducer producer;
    public void setPlayerProducerId(String playerId) {
        this.playerId=playerId;
    }
    PlayerProducerService(PlayerProducer producer){this.producer=producer;}//Binding PlayerProducer in GameApp


    public String getPlayerProducerId(String playerId) {
        return playerId;
    }
}
