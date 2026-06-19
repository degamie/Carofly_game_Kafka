//WID(19/6/2026)(Sarthak Mittal(Player producer)#1
package com.kafka.Carofly.Controller;

import com.kafka.Carofly.dto.PlayerProducer;
import com.kafka.Carofly.service.PlayerProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerProducerController {
    @Autowired
    public PlayerProducerService playerProducerService;
    public PlayerProducerController(PlayerProducerService playerProducerService){this.playerProducerService=PlayerProducerService;}//binding PlatyerPRoducerService in App
    @GetMapping("/producer")
    public String getPlayerProducer(@RequestBody PlayerProducer playerProducer){
        return "Player Producer sends Player Retrieved Notifications in Carolfy live Game Server";
    }

}
