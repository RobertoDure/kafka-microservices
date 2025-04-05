package com.kafka.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class MessageListener {
    
    private static final Logger logger = LoggerFactory.getLogger(MessageListener.class);
    
    @KafkaListener(topics = "message-topic", groupId = "message-group")
    public void listen(String message) {
        logger.info("Received message: {}", message);
        // Add your message processing logic here
    }
}