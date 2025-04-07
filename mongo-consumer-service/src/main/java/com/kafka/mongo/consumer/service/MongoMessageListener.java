package com.kafka.mongo.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.mongo.consumer.model.Message;
import com.kafka.mongo.consumer.repository.MessageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MongoMessageListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(MongoMessageListener.class);
    
    private final MessageRepository messageRepository;
    
    @KafkaListener(topics = "message-topic", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(String message) {
        LOGGER.info("Received message: {}", message);
        Message messageEntity = new Message(message);
        messageRepository.save(messageEntity);
        LOGGER.info("Message saved to MongoDB: {}", messageEntity);
    }
}