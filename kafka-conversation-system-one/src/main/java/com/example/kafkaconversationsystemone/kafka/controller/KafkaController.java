package com.example.kafkaconversationsystemone.kafka.controller;

import com.example.kafkaconversationsystemone.SystemOneTag;
import com.example.kafkaconversationsystemone.kafka.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private MessageProducer messageProducer;

    @GetMapping("/send")
    public String sendMessage(@RequestParam("message") String message) {
        messageProducer.sendMessage("for-one-to-publish-on", message);
        System.out.println(SystemOneTag.SYSTEM_TAG + "Message sent: " + message);
        return "Message sent: " + message;
    }
    // TODO use logger instead of sout
}
