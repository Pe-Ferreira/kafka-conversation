package com.example.kafkaconversationsystemone.kafka.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TransformedStringDeserializer implements Deserializer<TransformedString> {

    Logger logger = Logger.getAnonymousLogger();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public TransformedString deserialize(String topic, byte[] transformedStringInByteArray) {
        try {
            if (transformedStringInByteArray == null) {
                logger.log(Level.SEVERE, "Null received at deserializing");
                return null;
            }
            logger.info("Deserializing...");
            return objectMapper.readValue(transformedStringInByteArray, TransformedString.class);
        } catch (Exception e) {
            throw new SerializationException("Error deserializing transformedString");
        }
    }

    @Override
    public void close() {
    }
}
