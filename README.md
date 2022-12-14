<h1 align="center"> Social Network Project </h1>

<p align="center">
This is a mini social media project that I created to learn more about the Spring and React frameworks. It is a simple social media site that allows users to create accounts and make posts. It is a work in progress and I plan to add more features in the future.
</p>

<h2 align="center"> Technologies </h2>
<p align="center">
<img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white" alt="Spring">
<img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white" alt="PostgreSQL">
<img src="https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white" alt="Hibernate">
<img src="https://img.shields.io/badge/Docker-2CA5E0?style=for-the-badge&logo=docker&logoColor=white" alt="Docker">
</p>

<h2 align="center"> About </h2>

<p align="center">
This repo contains the backend code of the project made with Spring. <br>
The frontend code can be found <a href="https://github.com/fhilipecrash/social-network-frontend">here</a>.
</p>

## Features

- [x] Create accounts
- [ ] User posts

## Getting Started

### Prerequisites
- Docker
- Docker Compose
- Java 17
- Maven

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/fhilipecrash/mini-social-media-backend
   ```
2. Run the project
   ```sh
    docker-compose up -d # Run the postgres container
    ./mvnw clean install # Build the project 
    ./mvnw spring-boot:run # Run the spring application
    ```
   
## Usage

Checkout the Swagger documentation at http://localhost:8080/api/swagger-ui/index.html
