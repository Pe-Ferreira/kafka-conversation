package com.example.kafkaconversationsystemtwo.kafka.consumer;

import com.example.kafkaconversationsystemtwo.SystemTwoTag;
import com.example.kafkaconversationsystemtwo.kafka.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class MessageConsumer {

    Logger logger = Logger.getAnonymousLogger();
    @Autowired
    MessageProducer messageProducer;

    @KafkaListener(topics = "for-one-to-publish-on", groupId = "conversation")
    public void listen(String message) {
        logger.info(SystemTwoTag.SYSTEM_TAG + "Received message: " + message);
        logger.info(SystemTwoTag.SYSTEM_TAG + "Transforming message ...");

        String transformedMessage = message + "TRANSFORMED BY system-two";

        messageProducer.sendMessage("for-two-to-publish-on", transformedMessage);
        logger.info(SystemTwoTag.SYSTEM_TAG + "Message sent: " + transformedMessage);
    }
}
