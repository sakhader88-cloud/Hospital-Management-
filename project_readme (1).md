# 🏥 Hospital Management System

A robust, enterprise-grade RESTful Web Application built with **Spring Boot 3** and **Java 17**. Designed to streamline hospital administrative workflows, including patient lifecycle management, DTO transformations, and unified API response handling.

---

## 📋 Table of Contents
- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [Architecture & Design Patterns](#-architecture--design-patterns)
- [Project Structure](#-project-structure)
- [Getting Started](#-getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation & Setup](#installation--setup)
- [API Documentation & Endpoints](#-api-documentation--endpoints)
- [Database Schema](#-database-schema)
- [License](#-license)

---

## ✨ Features

- **Patient Lifecycle Management**: Complete CRUD operations for handling patient registrations, diagnoses, and medical histories.
- **DTO Abstraction Layer**: Keeps domain entities protected by using dedicated Request (`patientRequest`) and Response (`patientResponse`) objects.
- **Unified API Response Standard**: All endpoints return a standardized `APIResponse<T>` wrapper, ensuring consistent frontend integration for both success and error responses.
- **Data Mapping**: Custom mapping logic (`patientMapperImpl`) for fast, overhead-free transformations between DTOs and database entities.
- **Doctor Registration DTOs**: Extensible request payloads for future doctor and department module integrations.

---

## 🛠️ Tech Stack

- **Framework**: Spring Boot 3.x
- **Language**: Java 17 / 21
- **Persistence**: Spring Data JPA / Hibernate
- **Database**: H2 (In-Memory for Dev) / MySQL / PostgreSQL (Production)
- **Build Tool**: Apache Maven
- **Architecture**: Layered REST Architecture (Controller -> Service -> Repository -> Entity)

---

## 🏗️ Architecture & Design Patterns

The project follows clean architecture principles to separate concerns:

```
                  ┌──────────────────────┐
                  │      HTTP Request    │
                  └──────────┬───────────┘
                             │
                             ▼
                  ┌──────────────────────┐
                  │      Controller      │
                  └──────────┬───────────┘
                             │
            ┌────────────────┴────────────────┐
            ▼                                 ▼
┌──────────────────────┐          ┌──────────────────────┐
│  patientRequest DTO │          │ patientResponse DTO │
└──────────┬───────────┘          └──────────▲───────────┘
           │                                 │
           └────────────────┐ ┌──────────────┘
                            ▼ │
                  ┌──────────────────────┐
                  │    patientMapper     │
                  └──────────┬───────────┘
                             │
                             ▼
                  ┌──────────────────────┐
                  │    Patient Entity    │
                  └──────────┬───────────┘
                             │
                             ▼
                  ┌──────────────────────┐
                  │  patientrepositry    │
                  └──────────────────────┘
```

---

## 📁 Project Structure

```
Hospital-Management-System-main/
│
├── APIResponse.java            # Standardized generic JSON response wrapper
├── Patient.java                # Core JPA Entity mapping to 'patients' table
│
├── doctor_request.java         # DTO payload for doctor registration requests
├── patientRequest.java         # DTO payload for incoming patient creation/updates
├── patientResponse.java        # DTO payload for outgoing patient responses
│
├── patientMapper.java          # Interface defining DTO-to-Entity conversion contracts
├── patientMapperImpl.java      # Spring Component implementing mapping logic
├── patientrepositry.java       # Spring Data JPA Repository interface for Patient entity
│
└── README.md                   # Comprehensive repository documentation
```

---

## 🚀 Getting Started

### Prerequisites

Make sure you have the following installed on your machine:
* **JDK 17** or higher
* **Apache Maven 3.8+**
* **Git**
* An IDE such as **IntelliJ IDEA**, **Eclipse**, or **VS Code**

### Installation & Setup

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/Hospital-Management-System.git
   cd Hospital-Management-System
   ```

2. **Configure Database Settings** (`src/main/resources/application.properties`):
   ```properties
   spring.application.name=hospital-management-system
   
   # H2 In-Memory Database (Default)
   spring.datasource.url=jdbc:h2:mem:hospitaldb
   spring.datasource.driverClassName=org.h2.Driver
   spring.datasource.username=sa
   spring.datasource.password=
   spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
   spring.h2.console.enabled=true
   ```

3. **Build the Application**:
   ```bash
   mvn clean install
   ```

4. **Run the Application**:
   ```bash
   mvn spring-boot:run
   ```

The server will start at `http://localhost:8080`.

---

## 📡 API Documentation & Endpoints

### Standard API Response Format

All responses follow this JSON structure:

```json
{
  "status": "SUCCESS",
  "message": "Patient created successfully",
  "data": {
    "id": 1,
    "name": "John Doe",
    "age": 34,
    "gender": "Male",
    "disease": "Flu",
    "contactNumber": "+1234567890"
  }
}
```

### Endpoints Overview

| Method | Endpoint | Description | Payload Sample |
| :--- | :--- | :--- | :--- |
| **GET** | `/api/patients` | Retrieve all patients | N/A |
| **GET** | `/api/patients/{id}` | Get patient details by ID | N/A |
| **POST** | `/api/patients` | Register a new patient | `patientRequest` |
| **PUT** | `/api/patients/{id}` | Update existing patient | `patientRequest` |
| **DELETE** | `/api/patients/{id}` | Delete a patient record | N/A |

#### Sample Request Payload (`POST /api/patients`)

```json
{
  "name": "Jane Smith",
  "age": 28,
  "gender": "Female",
  "disease": "Migraine",
  "contactNumber": "+91 9876543210"
}
```

---

## 🗄️ Database Schema

```sql
CREATE TABLE patients (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    gender VARCHAR(50),
    disease VARCHAR(255),
    contact_number VARCHAR(20)
);
```

---

## 🤝 Contributing

Contributions are welcome! Please feel free to open an Issue or submit a Pull Request.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/NewFeature`)
3. Commit your Changes (`git commit -m 'Add NewFeature'`)
4. Push to the Branch (`git push origin feature/NewFeature`)
5. Open a Pull Request

---

## 📄 License

This project is open-source and available under the [MIT License](LICENSE).