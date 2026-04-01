# microservicios-futfem-referees-temp

`microservicios-futfem-referees-temp` is the temporary referee service in the Tikitakas backend. It exists to hold provisional, imported, staged, or transitional referee records separately from the main referee catalog, which helps preserve clearer domain boundaries and safer data workflows.

This repository is built with Java 21, Spring Boot, Spring Data JPA, MySQL, Springdoc OpenAPI, and Maven Wrapper. It follows the same conventions as the rest of the futfem services by inheriting common CRUD behavior from `microservicios-common`, registering in Eureka, and exposing its public API through the central gateway.

Typical local execution:

```bash
./mvnw spring-boot:run
```

Gateway route:

- `/api/futfem/refereestemp/**`

As part of `v0.1.0`, the project has been updated with Docker-compatible packaging, Jenkins pipeline support, and gateway-aware OpenAPI metadata. This ensures that Swagger remains usable from the aggregated gateway UI and that the service behaves consistently in CI and deployment environments.

Use this repository when referee information must go through an intermediate lifecycle before reaching the main referee domain model. It keeps temporary workflows isolated without forcing them into the canonical service too early.
