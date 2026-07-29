# Garage

Garage is a hands-on Java and Spring Boot playground for exploring microservices, caching, messaging, observability, and API gateway concepts. The project is intentionally experimental and focused on learning rather than production-ready architecture.

## Project structure

- shorturl: URL-shortening service with PostgreSQL persistence, Redis/Ehcache caching, Kafka integration, and OpenTelemetry-based observability.
- consumer: Kafka consumer service that listens for events produced by the shorturl service.
- gateway: Spring Cloud Gateway module for routing traffic to backend services.

## Tech stack

- Java 25
- Spring Boot 4.x
- Spring Cloud Gateway
- PostgreSQL
- Redis
- Apache Kafka
- OpenTelemetry / OTLP
- Docker Compose

## Prerequisites

- JDK 25
- Maven or the provided Maven wrapper scripts
- Docker Desktop with Compose support

## Getting started

1. Start the supporting services for Redis and observability:

   ```bash
   docker compose -f shorturl/compose.yaml up -d
   ```

2. Run the services from the repository root:

   ```bash
   ./shorturl/mvnw spring-boot:run
   ./consumer/mvnw spring-boot:run
   ./gateway/mvnw spring-boot:run
   ```

3. Access the services:

   - shorturl: https://localhost:8443
   - consumer: http://localhost:8082
   - gateway: http://localhost:8080

> The shorturl service uses a local TLS keystore, so your browser may show a certificate warning. This is expected for local development.

## Notes

- The repository includes multiple learning-focused milestones around short URL functionality, caching, Redis, Docker-based monitoring, and GraalVM experiments.
- Some modules are still being expanded and may require additional configuration depending on your local environment.
