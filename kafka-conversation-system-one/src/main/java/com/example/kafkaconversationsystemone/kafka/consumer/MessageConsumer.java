package com.example.kafkaconversationsystemone.kafka.consumer;

import com.example.kafkaconversationsystemone.SystemOneTag;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @KafkaListener(topics = "for-two-to-publish-on", groupId = "conversation")
    public void listen(String message) {
        System.out.println(SystemOneTag.SYSTEM_TAG + "Received message: " + message);
    }
}
