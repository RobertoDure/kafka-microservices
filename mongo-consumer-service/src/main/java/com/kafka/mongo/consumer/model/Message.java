package com.kafka.mongo.consumer.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "messages")
public class Message {
    
    @Id
    private String id;
    private String content;
    private LocalDateTime timestamp;
    
    public Message(String content) {
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }
}