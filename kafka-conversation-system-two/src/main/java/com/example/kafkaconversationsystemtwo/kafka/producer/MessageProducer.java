package com.example.kafkaconversationsystemtwo.kafka.producer;

import com.example.kafkaconversationsystemtwo.SystemTwoTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class MessageProducer {

    Logger logger = Logger.getAnonymousLogger();
    @Autowired
    private KafkaTemplate<String, TransformedString> kafkaTemplate;

    public void sendMessage(String topic, TransformedString message) {
        kafkaTemplate.send(topic, message);
        logger.info(SystemTwoTag.SYSTEM_TAG + "Message sent: " + message);
    }
}
