# springboot-cicd-demo

## ✅ Assignment Implementation

This project implements a Spring Boot REST API and a CI/CD pipeline as part of the given assignment.

---

## 🔹 REST API

### Endpoint

```
GET /health/details
```

### Sample Response

```json
{
  "appName": "springboot-cicd-demo",
  "buildVersion": "1.0.0",
  "customValue": "from-config-file",
  "timestamp": "2026-04-29T10:15:30Z"
}
```

### Field Details

| Field        | Description         | Source                                 |
| ------------ | ------------------- | -------------------------------------- |
| appName      | Application name    | `application.yaml (app.name)`          |
| buildVersion | Build version       | Environment variable (`BUILD_VERSION`) |
| customValue  | Custom config value | `application.yaml (app.custom-value)`  |
| timestamp    | Current timestamp   | Generated at runtime                   |

---

## ⚙️ Configuration

### application.yaml

```yaml
app:
  name: springboot-cicd-demo
  description: Health check service
  custom-value: from-config-file
```

### Environment Variable

Set BUILD_VERSION before running:

```bash
export BUILD_VERSION=1.0.0
```

---

## ▶️ Running the Application

```bash
cd demo
mvn spring-boot:run
```

Application runs at:

```
http://localhost:8080/health/details
```

---

## 🧪 Running Tests

```bash
mvn test
```

---

## 🔄 CI/CD Pipeline

### Jenkins Pipeline Covers

* Build the application (`mvn clean compile`)
* Run unit tests (`mvn test`)
* Package the application (`mvn package`)
* Inject `BUILD_VERSION` environment variable
* Archive generated JAR artifact

---

## 🔐 Security & Deployment (Approach)

### Security Scanning

* Can integrate tools like:

  * Veracode
  * OWASP Dependency Check
* These can be added as pipeline stages before packaging

### Deployment Strategy

* AWS:

  * Deploy via ECS/EKS using Docker image
* On-Prem / Kubernetes:

  * Use `kubectl` or Helm charts for deployment

---

## 🛠️ Tech Stack

* Java 17
* Spring Boot
* Maven
* Jenkins

---

## 💡 Design Choices

* Used `@ConfigurationProperties` for structured configuration
* Used environment variable with fallback:

  ```java
  @Value("${BUILD_VERSION:unknown}")
  ```
* Followed clean architecture:

  * Controller → Service → DTO

---

## 📁 Project Structure

```
springboot-cicd-demo/
├── demo/              # Spring Boot application
├── Jenkinsfile        # CI/CD pipeline
```

---

## 📄 License

MIT License
