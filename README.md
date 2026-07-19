# FitTrack Java Pro

Modern responsive FitTrack dashboard rebuilt with Java 17 + Spring Boot 3.5, HTML5, modern CSS, ES6 JavaScript, Chart.js, REST JSON APIs, JPA and SQL persistence.

## Run
```cmd
java -version
mvn -version
mvn clean spring-boot:run
```
Open `http://localhost:8080`.

## Mobile on same Wi-Fi
Run `ipconfig`, find the laptop Wi-Fi IPv4 address, then open `http://YOUR-LAPTOP-IP:8080` on the phone. The server binds to `0.0.0.0`.

## Internet/cloud
Do not expose port 8080 directly to the public internet. Deploy behind HTTPS/TLS on AWS and use a domain. The planned production architecture will use PostgreSQL and secure authentication/device tokens.

## Database
Local development uses file-backed H2 in PostgreSQL compatibility mode. For production, set `DATABASE_URL`, `DB_USER`, and `DB_PASSWORD` to PostgreSQL and replace Hibernate schema updates with Flyway migrations.

## Note
The UI is a new professional responsive SPA. Core daily log CRUD, dashboard, history, water logging and Health Connect ingestion endpoints are wired. Meal/workout entities and APIs are included for continued expansion.
