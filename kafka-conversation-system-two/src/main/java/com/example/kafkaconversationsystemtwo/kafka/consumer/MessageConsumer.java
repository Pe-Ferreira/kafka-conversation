package com.example.kafkaconversationsystemtwo.kafka.consumer;

import com.example.kafkaconversationsystemtwo.SystemTwoTag;
import com.example.kafkaconversationsystemtwo.kafka.producer.MessageProducer;
import com.example.kafkaconversationsystemtwo.kafka.producer.TransformedString;
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

        TransformedString transformedMessage = new TransformedString(message);

        messageProducer.sendMessage("for-two-to-publish-on", transformedMessage);
    }
}
