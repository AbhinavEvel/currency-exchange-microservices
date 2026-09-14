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

🔑 Authentication & Request Flow
[ Client Request ] 
       │
       ▼  (Header: Authorization: Bearer <token>)
[ JwtAuthFilter ] 
       │
       ├─► Extract Token & Validate via JwtUtil
       ├─► Set Authentication in SecurityContext
       │
       ▼
[ Controller / Protected Endpoint ] ──► Return Response
📡 API Endpoints (Sample)
1. Authentication
POST /api/auth/login - Authenticate user credentials and receive a JWT token.

2. Currency Exchange Service
GET /currency-exchange/from/{from}/to/{to} - Fetch current exchange rate between two currencies.

3. Currency Conversion Service (Protected)
GET /currency-conversion/from/{from}/to/{to}/quantity/{quantity} - Calculate converted value (Requires JWT Header).

🧪 Testing with Postman
To access protected endpoints:

Send a request to login to generate a valid token.

In Postman, go to the Headers tab of your request and add:

Key: Authorization

Value: Bearer <YOUR_JWT_TOKEN>

<ElicitationsGroup message="README me aur kya add karna chahte ho?">
  <Elicitation label="Docker compose setup add karein?" query="Is README file me Docker support aur docker-compose configuration steps add kardo."/>
  <Elicitation label="Spring Cloud / Eureka setup add karein?" query="Agar microservices me Eureka Naming Server use ho raha hai toh uske steps README me add kardo."/>
</ElicitationsGroup>
