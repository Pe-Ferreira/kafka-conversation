package com.example.kafkaconversationsystemtwo.kafka.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TransformedStringSerializer implements Serializer<TransformedString> {

    Logger logger = Logger.getAnonymousLogger();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public byte[] serialize(String topic, TransformedString transformedString) {
        try {
            if (transformedString == null) {
                logger.log(Level.SEVERE, "null received at serializing");
                return null;
            }
            logger.info("Serializing...");
            return objectMapper.writeValueAsBytes(transformedString);
        } catch (Exception e) {
            throw new SerializationException("Error serializing transformedString to byte[]");
        }
    }

    @Override
    public byte[] serialize(String topic, Headers headers, TransformedString data) {
        return null;
    }

    @Override
    public void close() {
    }
}
