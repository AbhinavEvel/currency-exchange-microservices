# Currency Exchange Microservices

A Spring Boot based Microservices application for handling currency exchange
and currency conversion using independent services and service discovery.

## 🚀 Overview

This project demonstrates how a currency exchange application can be
designed using a Microservices Architecture.

Instead of building the complete application as a single monolithic service,
the system is divided into multiple independent services. Each service is
responsible for a specific business capability and can be developed,
deployed, and maintained independently.
## Technologies Used

- Java
- Spring Boot
- Spring Cloud
- Spring Data JPA
- REST APIs
- Netflix Eureka
- Maven
- Git & GitHub
The project currently consists of:

- Exchange Service
- Conversion Service
- User Service
- Eureka Server

---

## 🏗️ Architecture

```text
                    ┌─────────────────────┐
                    │       Client        │
                    └──────────┬──────────┘
                               │
                               ▼
                 ┌─────────────────────────┐
                 │   Conversion Service    │
                 │       (Client)          │
                 └──────────┬──────────────┘
                            │
                            │ Service-to-Service Call
                            ▼
                 ┌─────────────────────────┐
                 │    Exchange Service     │
                 │  Exchange Rate Logic    │
                 └─────────────────────────┘

                            ▲
                            │
                     Service Discovery
                            │
                 ┌─────────────────────────┐
                 │      Eureka Server      │
                 │   Service Registry      │
                 └─────────────────────────┘

                 ┌─────────────────────────┐
                 │      User Service       │
                 │    User Management      │
                 └─────────────────────────┘
