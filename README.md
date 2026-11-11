# Gym Management API

A simple gym member CRUD REST API built with Java 25, Spring Boot, Spring Data JPA, and an in-memory H2 database.

## Run

Install Java 25 and Maven, then run:

```shell
mvn spring-boot:run
```

The API starts at `http://localhost:8080`. Data is stored in memory and is cleared when the application stops.

## Endpoints

| Method | Path | Description |
|---|---|---|
| `POST` | `/api/members` | Create a gym member |
| `GET` | `/api/members` | List all gym members |
| `GET` | `/api/members/{id}` | Get one gym member |
| `PUT` | `/api/members/{id}` | Replace a gym member's details |
| `DELETE` | `/api/members/{id}` | Delete a gym member |

Create/update requests require `name`, `email`, `phone`, and `membershipType`. The email must be valid and all fields must be non-blank.

Example:

```json
{
  "name": "Asha Khan",
  "email": "asha@example.com",
  "phone": "555-0100",
  "membershipType": "Monthly"
}
```
