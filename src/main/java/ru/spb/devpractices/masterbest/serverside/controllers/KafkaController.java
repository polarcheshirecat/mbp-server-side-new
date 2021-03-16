package ru.spb.devpractices.masterbest.serverside.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.spb.devpractices.masterbest.serverside.dto.KafkaTelegramMessageDTO;

@RestController
public class KafkaController {

    @Value(value = "${kafka.topic}")
    private String kafkaTopic;

    @Autowired
    private KafkaTemplate<String, KafkaTelegramMessageDTO> kafkaTemplate;

    @PostMapping (value = "test")
    public void sendMessage(@RequestBody KafkaTelegramMessageDTO dto) {
        System.out.println(dto);
        kafkaTemplate.send(kafkaTopic, dto);
    }
}
