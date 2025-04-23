# Boat API

Une API REST construite avec **Spring Boot 3.4**, **Java 21**, et **Spring Security**, permettant la gestion de bateaux, leurs catégories et les utilisateurs associés. L’authentification est basée sur **JWT**.

---

## Stack technique

- **Java 21**
- **Spring Boot 3.4**
- **Spring Security**
- **Spring Data JPA (Hibernate)**
- **H2**
- **Maven**
- **JUnit 5 / Mockito**

---

## Démarrage rapide

### 1. Prérequis

- Java 21
- Maven 3.9+
- H2

### 2. Configuration

#### Installation du projet

1. Clone du projet depuis Github

```
git clone https://github.com/ombinte1280/boat-api.git
```

2. Installation des packages

```
mvn install
```

#### Profils disponibles

- `dev` : avec base de données H2

#### `application-dev.yml` (extrait)

```yaml
spring:
  application:
    name: boat-api
server:
  port: 8081
```

#### Run du projet

```
mvn spring-boot:run -Dspring.profiles.active=dev
```