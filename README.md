# Kafka Microservices Demo

This project demonstrates a simple microservices architecture using Apache Kafka for message communication between services. It consists of two Spring Boot services (producer and consumer) that communicate through a Kafka message broker.

## Project Structure

```
kafka-microservices/
├── docker-compose.yml    # Docker configuration for Kafka and Zookeeper
├── producer-service/     # Service that produces messages to Kafka
├── consumer-service/     # Service that consumes messages from Kafka
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

### Consumer Service
- Application configuration: `consumer-service/src/main/resources/application.yml`
- Default port: 8081
- Consumer group: message-group

## Docker Configuration

The `docker-compose.yml` file includes:
- Zookeeper for Kafka cluster management
- Kafka broker configured for local development

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