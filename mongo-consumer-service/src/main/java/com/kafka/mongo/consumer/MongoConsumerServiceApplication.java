package com.kafka.mongo.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoConsumerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoConsumerServiceApplication.class, args);
    }
}