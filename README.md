# 🧑‍💼 User Management REST API

A **Spring Boot RESTful API** for managing users with full CRUD functionality.  
This project implements **Hibernate ORM** via **Spring Data JPA**, follows a **layered architecture**, and is fully tested using **Postman**.

---

## ✨ Features
- ➕ **Create User** – Add new users to the system  
- 📄 **Retrieve Users** – Fetch all users or a specific user by ID  
- ✏ **Update User** – Modify existing user details  
- ❌ **Delete User** – Remove a user from the system  
- ✅ Input validation and robust exception handling  
- 🗄 **Spring Data JPA** for seamless database integration  

---

## 🛠 Tech Stack
- ☕ **Java 17**  
- 🌱 **Spring Boot 3.x**  
- 🔗 **Hibernate** with **Spring Data JPA**  
- 🐬 **MySQL** (or H2 for in-memory testing)  
- 📦 **Maven**  
- 📫 **Postman** for API testing  

---

## 📂 Project Structure
SpringBootWebS/
├── src/
│   ├── main/
│   │   ├── java/                 # Application source code (controllers, services, repositories, entities)
│   │   └── resources/            # Configuration files (application.properties, static/templates if used)
│   └── test/
│       └── java/                 # Unit and integration tests
├── gradle/                       # Gradle wrapper files
├── bin/                          # Compiled classes (generated)
├── build.gradle                   # Gradle build configuration
├── gradlew                        # Gradle wrapper (Unix)
├── gradlew.bat                    # Gradle wrapper (Windows)
├── LICENSE                        # License file
├── HELP.md                        # Help or guide file
└── settings.gradle                 # Gradle settings


---

## ▶ How to Run
1. **Clone this repository**
   ```bash
   git clone https://github.com/core-rohitkumar0607/User-Management-api.git
   cd User-Management-API
   
2. ** Configure Database **
   Update application.properties with your MySQL details:
   spring.datasource.url=jdbc:mysql://localhost:3306/userdb
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   
4. ** Build and Run **
   mvn clean install
   mvn spring-boot:run

5. ** Test End Points **
   Use Postman
   Base URL: http://localhost:8080/api/users
