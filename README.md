# Practice Project

A basic **Spring Boot (Java 21)** REST API project built to practice core Spring Boot concepts — building endpoints, managing environment-specific configuration with profiles, and documenting APIs with **Swagger/OpenAPI**.

## Table of Contents

- [Overview](#overview)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Configuration Profiles](#configuration-profiles)
- [API Endpoints](#api-endpoints)
- [Swagger / API Documentation](#swagger--api-documentation)
- [Building the Project](#building-the-project)
- [Running Tests](#running-tests)
- [Troubleshooting](#troubleshooting)

## Overview

This project is a minimal but complete Spring Boot web service. It exposes a few simple REST endpoints under `/api`, and demonstrates good practice around:

- Separating configuration by environment (`dev` vs `prod`) using Spring Profiles
- Auto-generating interactive API documentation via Springdoc OpenAPI (Swagger UI)
- Using the Maven Wrapper so the project can be built without a locally installed Maven

It's intended as a learning/reference project rather than a production application.

## Tech Stack

| Component | Details |
|-----------|---------|
| Language | Java 21 |
| Framework | Spring Boot 3.3.4 |
| Web | `spring-boot-starter-web` |
| API Docs | `springdoc-openapi-starter-webmvc-ui` (v2.6.0) |
| Build Tool | Maven (via Maven Wrapper — no local Maven install required) |
| Testing | JUnit 5, `spring-boot-starter-test` |

## Project Structure

```
practice-project/
├── src/
│   ├── main/
│   │   ├── java/com/example/demo/
│   │   │   ├── DemoApplication.java     # Spring Boot entry point (@SpringBootApplication)
│   │   │   └── HelloController.java     # REST controller with all API endpoints
│   │   └── resources/
│   │       ├── application.properties        # Base/default configuration (port, app name)
│   │       ├── application-dev.properties     # Dev profile — Swagger enabled, port 8081
│   │       └── application-prod.properties    # Prod profile — Swagger disabled
│   └── test/
│       └── java/com/example/demo/
│           └── DemoApplicationTests.java  # Basic context-load test
├── pom.xml               # Maven project config and dependencies
├── mvnw / mvnw.cmd        # Maven Wrapper scripts (Linux/Mac and Windows)
└── README.md
```

## Prerequisites

- **Java 21 JDK** installed and on your `PATH`
- No need to install Maven separately — the project ships with the Maven Wrapper (`mvnw`)
- (Optional) `curl` or a tool like Postman to test the endpoints

## Getting Started

1. Run the application (uses default configuration from `application.properties`):

   ```bash
   ./mvnw spring-boot:run
   ```

   On Windows, use `mvnw.cmd` instead of `./mvnw`.

2. The app will start on **port 8080** by default. You should see Spring Boot's startup logs ending with something like `Started DemoApplication in X seconds`.

3. Verify it's running:

   ```bash
   curl http://localhost:8080/api/hello
   ```

## Configuration Profiles

The project defines three property files:

| File | Purpose | Port | Swagger |
|------|---------|------|---------|
| `application.properties` | Default/base config | 8080 | Not explicitly set |
| `application-dev.properties` | Development profile | 8081 | Enabled |
| `application-prod.properties` | Production profile | Inherits default | Disabled |

To run with a specific profile:

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

or for production:

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=prod
```

When the `dev` profile is active, the app runs on port **8081** and Swagger UI is enabled. When `prod` is active, Swagger is disabled for security reasons (API docs shouldn't typically be public in production).

## API Endpoints

All endpoints are defined in `HelloController.java`.

| Method | Endpoint | Description | Example Response |
|--------|----------|--------------|-------------------|
| GET | `/api/hello` | Returns a static welcome/hello message | `"Hello! This project is ready for you to add Swagger."` |
| GET | `/api/greet/{name}` | Greets the caller using the given path variable | `"Hello, Prince!"` |
| GET | `/api/bye` | Returns a static goodbye message | `"Goodbye!"` |

### Example requests

```bash
curl http://localhost:8080/api/hello
curl http://localhost:8080/api/greet/Prince
curl http://localhost:8080/api/bye
```

## Swagger / API Documentation

This project uses **Springdoc OpenAPI** to auto-generate interactive API documentation directly from the controller code — no manual documentation writing required.

Once the app is running (with Swagger enabled), open:

```
http://localhost:8080/swagger-ui/index.html
```

(or `http://localhost:8081/swagger-ui/index.html` if running under the `dev` profile)

From here you can view all available endpoints, see their expected inputs/outputs, and even send test requests directly from the browser.

The raw OpenAPI JSON spec is available at:

```
http://localhost:8080/v3/api-docs
```

> **Note:** Swagger is controlled via the `springdoc.api-docs.enabled` and `springdoc.swagger-ui.enabled` properties, which are set differently per profile (see `application-dev.properties` and `application-prod.properties`).

## Building the Project

To compile and package the application into a runnable JAR:

```bash
./mvnw clean package
```

This will:
1. Clean any previous build output
2. Compile the source code
3. Run tests
4. Package everything into a JAR file under `target/`

Once built, you can run the JAR directly:

```bash
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

To skip tests during the build (faster, not recommended for regular use):

```bash
./mvnw clean package -DskipTests
```

## Running Tests

The project includes a basic Spring context-load test to ensure the application starts correctly:

```bash
./mvnw test
```

## Troubleshooting

| Issue | Possible Cause | Fix |
|-------|-----------------|-----|
| `./mvnw: Permission denied` | Wrapper script isn't executable | Run `chmod +x mvnw` |
| Port `8080` already in use | Another process is using the port | Stop that process, or change `server.port` in `application.properties` |
| Swagger UI shows 404 | Swagger disabled for the active profile | Run with `-Dspring-boot.run.profiles=dev`, or enable it manually in properties |
| Build fails on Java version | Wrong JDK version installed | Ensure Java 21 is installed and set as your active JDK |
