package com.kafka.email.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class MessageListener {

    private static final Logger logger = LoggerFactory.getLogger(MessageListener.class);

    private final JavaMailSender mailSender;

    public MessageListener(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    /**
     * Listens to messages from the Kafka topic and sends an email with the message content.
     * @param message the message received from the Kafka topic
     */
    @KafkaListener(topics = "message-topic", groupId = "message-group")
    public void listen(String message) {
        logger.info("Received message: {}", message);
        sendEmail(message);

    }

    /**
     * Sends an email with the given message.
     * @param message the message to be sent in the email
     */
    private void sendEmail(String message) {
        // Send email
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("sender.email@mail.com");
        mailMessage.setTo("test.email@mail.com");
        mailMessage.setSubject("Email Message");
        mailMessage.setText(message);
        mailSender.send(mailMessage);
        logger.info("Email body message : {}", message);
    }
}