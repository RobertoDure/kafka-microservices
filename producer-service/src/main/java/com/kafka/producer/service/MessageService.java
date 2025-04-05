package com.kafka.producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class MessageService {

    private static final Logger logger = LoggerFactory.getLogger(MessageService.class);

    private static final String TOPIC = "message-topic";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public MessageService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void sendMessage(String message) {
        logger.info("Sent message: {}", message);
        kafkaTemplate.send(TOPIC, message);
    }
}