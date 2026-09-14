# 💱 Currency Exchange & Conversion Microservices System

A robust, scalable backend microservices system built using **Java 17**, **Spring Boot 3**, and **Spring Security with JWT Authentication**. This system handles currency rates management and currency conversion logic independently through decoupled microservices.

---

## 🏗️ Architecture Overview

The system consists of two primary microservices:

1. **Currency Exchange Service**: Manages and stores exchange rates for various currency pairs (e.g., USD to INR, EUR to USD).
2. **Currency Conversion Service**: Calculates converted amounts by communicating with the Exchange Service and handles secure access via **JWT (JSON Web Token)** authentication.

---

## ✨ Key Features

- **JWT Authentication & Authorization**: Custom `JwtAuthFilter` and `JwtUtil` for stateless security.
- **Microservices Communication**: Decoupled service architecture.
- **Spring Security 6 Integration**: Context-aware request authentication with `SecurityContextHolder`.
- **Database Persistence**: Spring Data JPA with relational database support (H2/PostgreSQL/MySQL).
- **Clean Architecture**: Clear separation of concerns (Security, Controllers, Services, Entities).

---

## 🛠️ Tech Stack & Dependencies

| Technology | Purpose |
| :--- | :--- |
| **Java 17+** | Primary Programming Language |
| **Spring Boot 3** | Core Application Framework |
| **Spring Security** | Application Security & Interceptors |
| **JJWT (`io.jsonwebtoken`)** | Parsing & Validating JWT Tokens |
| **Spring Data JPA** | Database Management & ORM |
| **Maven** | Dependency & Build Management |

---

## 🚀 Getting Started

### Prerequisites
- **JDK 17** or higher installed.
- **Maven 3.8+** installed.
- An API platform like **Postman** or **cURL** for testing endpoints.

### ⚙️ Application Configuration

Ensure your `application.properties` or `application.yml` file contains the JWT secret key:

```properties
# jwt settings
jwt.secret=YourSuperSecretKeyHereWhichIsAtLeast256BitsLongForHMACSHA!
