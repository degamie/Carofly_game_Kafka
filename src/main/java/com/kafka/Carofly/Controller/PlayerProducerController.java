//WID(09/07/2026)(Sarthak Mittal(Player producerController)
package com.kafka.Carofly.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafka.Carofly.dto.PlayerProducer;
import com.kafka.Carofly.service.PlayerProducerService;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.logging.Logger;
@Controller
@RequestMapping("/player_producer")
@RestController
public class PlayerProducerController {
//    public void setObjectMapper(ObjectMapper objectMapper){t}
    public void setLogger(Logger logger){this.logger=logger;}//binding Logger in GameApp
    public void setObjectMapper(ObjectMapper objectMapper){this.objectMapper=objectMapper;}//binding ObjectMapper
    public ObjectMapper objectMapper;

    public  final String PLAYER_TOPIC=new String();
    public KafkaTemplate kafkaTemplate;
    String playerIdAsString = "";
     public Logger logger;
    @Autowired
    public PlayerProducerService playerProducerService;
    @GetMapping("/producerName")
    public List<PlayerProducer>getPlayerName(@RequestParam String PlayerName,@RequestBody PlayerProducer playerProducer){
        return playerProducerService.getplayerproducerName(PlayerName,playerProducer);
    }
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
