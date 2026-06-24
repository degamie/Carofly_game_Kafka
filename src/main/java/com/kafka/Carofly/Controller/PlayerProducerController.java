//WID(24/6/2026)(Sarthak Mittal(Player producer)#1.1.1.1
package com.kafka.Carofly.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafka.Carofly.dto.PlayerProducer;
import com.kafka.Carofly.service.PlayerProducerService;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.ObjectMapper;

import java.util.logging.Logger;
@RequestMapping("/player_producer")
@RestController
public class PlayerProducerController {
    public ObjectMapper objectMapper;
    public  final String PLAYER_TOPIC=new String();
    public KafkaTemplate kafkaTemplate;
    String playerIdAsString = "";
     public Logger logger;
    @Autowired
    public PlayerProducerService playerProducerService;
    @PostMapping("/publish/msg")
    public void publishMessagetoKafka(@RequestBody PlayerProducer playerProducer) throws RuntimeException, JsonProcessingException {
        System.out.println(playerProducerService.publishMessagetoKafka(playerProducer));
    }
    public PlayerProducerController(PlayerProducerService playerProducerService){this.playerProducerService=PlayerProducerService;}//binding PlatyerPRoducerService in App


    @GetMapping("producerId")
    public String getPlayerProducerId(@RequestBody PlayerProducer playerProducer, @RequestParam String playerId){
        return playerProducerService.getPlayerProducerId(playerId);
    }
    @GetMapping("/producer")
    public String getPlayerProducer(@RequestBody PlayerProducer playerProducer){
        return "Player Producer sends Player Retrieved Notifications in Carolfy live Game Server";
    }

}
