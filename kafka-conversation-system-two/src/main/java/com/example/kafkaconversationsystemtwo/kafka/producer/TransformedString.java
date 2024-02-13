package com.example.kafkaconversationsystemtwo.kafka.producer;

import java.io.Serializable;

public class TransformedString implements Serializable {

    private String originalString;
    private Integer charCount;

    public TransformedString(String originalString) {
        this.charCount = originalString.length();
        this.originalString = originalString;
    }

    @Override
    public String toString() {
        return "TransformedString{" +
                "originalString='" + originalString + '\'' +
                ", charCount=" + charCount +
                '}';
    }
}
