package com.example.kafkaconversationsystemone.kafka.consumer;

import com.example.kafkaconversationsystemone.SystemOneTag;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class MessageConsumer {

    Logger logger = Logger.getAnonymousLogger();

    @KafkaListener(topics = "for-two-to-publish-on", groupId = "conversation")
    public void listen(@Payload(required = false) TransformedString message) {
        logger.info(SystemOneTag.SYSTEM_TAG + "Received message: " + message);
    }
}
