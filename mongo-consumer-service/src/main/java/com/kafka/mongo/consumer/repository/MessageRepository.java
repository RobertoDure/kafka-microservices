package com.kafka.mongo.consumer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kafka.mongo.consumer.model.Message;

@Repository
public interface MessageRepository extends MongoRepository<Message, String> {
}