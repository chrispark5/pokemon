# Pokémon Backend API

This is the backend for the Pokémon Web App, built with Spring Boot. It provides a REST API for fetching Pokémon data, interacting with type strengths and weaknesses, and managing Pokémon-related information.

Features

    •	Get All Pokémon: Fetches a list of all Pokémon.
    •	Get Pokémon by ID: Fetches detailed information about a specific Pokémon.
    •	Type Strength & Weakness: Returns type strengths and weaknesses for Pokémon battle mechanics.
    •	Search Pokémon: Allows searching for Pokémon by name or type.

# Tech Stack Overview:

• Backend Framework: Spring Boot
• Database: PostgreSQL
• ORM: Hibernate (via Spring Data JPA)
• Build Tool: Maven
• Java Version: Java 17
• Frontend Interaction: CORS enabled for GraphQL (to allow communication with the frontend at http://localhost:3000)

```javascript
//1. Clone the repo
git clone {repo_url}
//2. Navigate to project directory
cd pokemon
//3. Install dependencies
./mvnw clean install
//4.Run Spring Boot Application
./mvnw spring-boot:run

or install and run using make.sh file
./make.sh

//5. Set Postgres DB properties in application.properties file
spring.application.name=your-app-name
spring.datasource.url=jdbc:postgresql://your-database-host:5432/your-database-name
spring.datasource.username=your-database-username
spring.datasource.password=your-database-password

//6. Check server is running
The server should be running at http://localhost:8080.
```
