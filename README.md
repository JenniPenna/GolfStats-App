# GolfStats-App

A free, simple web app for tracking and analysing your own golf rounds.
Built as a personal project because most existing golf stats apps are
paid or hard to use.

> Status: work in progress

## Features

Planned:
- [ ] Log rounds hole by hole (strokes, putts, fairway hit, GIR, penalties)
- [ ] Course management (par, stroke index, length)
- [ ] Statistics: scoring average, GIR %, fairway %, putts per round
- [ ] Charts and trends over time
- [ ] User accounts and authentication
- [ ] Mobile-friendly UI for use on the course

## Tech stack

- **Backend:** Java 21, Spring Boot, Spring Data JPA, Flyway
- **Database:** PostgreSQL
- **Frontend:** React, TypeScript, Vite
- **Tooling:** Docker, GitHub Actions

## Getting started

### Prerequisites
- JDK 21
- Docker
- Node.js (for the frontend, once added)

### Run locally

1. Start the database:

docker compose up -d

2. Start the backend:

cd backend
./mvnw spring-boot:run

3. The API runs at http://localhost:8080

## Project structure

golf-stats/
├── backend/ Spring Boot REST API
├── frontend/ React + TypeScript app (coming soon)
└── docker-compose.yml Local PostgreSQL


## Roadmap

1. Backend: rounds and courses API
2. Statistics endpoints
3. Frontend UI
4. Authentication
5. Deployment