# Kafka Microservices Demo

This project demonstrates a simple microservices architecture using Apache Kafka for message communication between services. It consists of three Spring Boot services that communicate through a Kafka message broker.
The producer service sends messages to a Kafka topic, while two consumer services consume those messages. One consumer service saves the message to a MongoDB database, and the other sends an email using the message consumed.
The project is designed to be run locally using Docker for Kafka and Zookeeper, and it uses Maven for dependency management and building the project.

## Project Structure

```
kafka-microservices/
├── docker-compose.yml    # Docker configuration for Kafka and Zookeeper
├── producer-service/     # Service that produces messages to Kafka
├── mongo-consumer-service/     # Service that consumes messages from Kafka and saves this message in MongoDB
├── email-consumer-service/     # Service that consumes messages from Kafka and sends an email using the message consumed
└── pom.xml              # Parent POM file
```

## Technologies Used

- Java 23
- Spring Boot 3.2.2
- Spring Kafka
- Docker
- Apache Kafka
- Apache Zookeeper
- Maven
- MongoDB
- Spring Data MongoDB
- Spring Boot Starter Mail
- Spring Boot Starter Web
- Java Mail Sender

## Prerequisites

- Java 23 or later
- Docker and Docker Compose
- Maven

## Getting Started

### 1. Start Kafka Infrastructure

First, start the Kafka broker and Zookeeper using Docker Compose:

```bash
  docker-compose up -d
```

This will start:
- Zookeeper on port 2181
- Kafka broker on port 9092

### 2. Build the Project

Build all services using Maven:

```bash
  mvn clean install
```

### 3. Start the Services

Start both services in separate terminals:

```bash
   # Start Producer Service (runs on port 8080)
   cd producer-service
   mvn spring-boot:run

   # Start Consumer Service (runs on port 8081)
   cd consumer-service
   mvn spring-boot:run
```

## Using the Services

### Producer Service (Port 8080)

Send a message to Kafka using the REST API:

```bash
curl -X POST http://localhost:8080/api/messages -H "Content-Type: text/plain" -d "Hello, Kafka!"
```

### Consumer Service (Port 8081)

The consumer service automatically listens for messages on the "message-topic" topic and logs them to the console.

## Configuration

### Producer Service
- Application configuration: `producer-service/src/main/resources/application.yml`
- Default port: 8080
- Kafka topic: message-topic

### Email Consumer Service
- Application configuration: `mongo-consumer-service/src/main/resources/application.yml`
- Default port: 8081
- Consumer group: message-group

### Mongo DB Consumer Service
- Application configuration: `email-consumer-service/src/main/resources/application.yml`
- Default port: 8082
- Consumer group: mongo-message-group

## Docker Configuration

The `docker-compose.yml` file includes:
- Zookeeper for Kafka cluster management
- Kafka broker configured for local development
- MongoDB for data persistence
- fake-smtp-server for email simulation

## Development

The project uses a multi-module Maven structure:
- Parent POM manages common dependencies and properties
- Each service is a separate Spring Boot application
- Services are configured to work with a local Kafka broker

## Stopping the Services

1. Stop the Spring Boot applications (Ctrl+C in their respective terminals)
2. Stop the Kafka infrastructure:
```bash
   docker-compose down
```

## Contributing

Feel free to submit issues and enhancement requests.