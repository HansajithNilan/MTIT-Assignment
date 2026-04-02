### School Management System – Microservices Architecture

# Project Overview

This project implements a School Management System backend using a microservices architecture with an API Gateway.
The system is designed by decomposing the domain into independent services, each responsible for a specific business capability.
This project was developed as part of IT4020 – Modern Topics in IT

# Objectives

* Design a real-world system using microservices architecture
* Implement independent services for different domains
* Use an API Gateway to provide a single entry point
* Demonstrate Swagger API documentation
* Ensure services are accessible:
* Individually (direct access)
* Through the API Gateway

# Selected Domain


👨‍🎓 Student Service

📘 Course Service

📊 Attendance Service

👩‍🏫 Lecturer Service

# Microservices Description
1. Student Service

Handles all student-related operations:

* Create student
* Get all students
* Get student by ID
* Update student
* Delete student

2. Course Service

Manages course-related data:

* Create course
* Get all courses
* Get course by ID
* Update course
* Delete course

3. Attendance Service

Handles attendance tracking:

* Mark attendance
* View attendance records
* Get attendance by student/course
* Update attendance

4. Lecturer Service

Manages lecturer information:

* Create lecturer
* Get all lecturers
* Get lecturer by ID
* Update lecturer
* Delete lecturer

# API Gateway

The API Gateway acts as a single entry point for all client requests.

Why API Gateway?

* Avoid exposing multiple service ports
* Centralized routing
* Simplifies client communication
* Improves maintainability

# Request Flow

###### Client → API Gateway → Microservice → Response → Client


# Ports Configuration

| Service            | Port |
| ------------------ | ---- |
| API Gateway        | 8080 |
| Student Service    | 8081 |
| Course Service     | 8082 |
| Attendance Service | 8083 |
| Lecturer Service   | 8084 |

# API Access
🔹 Direct Service Access (Native)

* Student → http://localhost:8081/swagger-ui/index.html
* Course → http://localhost:8082/swagger-ui/index.html
* Attendance → http://localhost:8083/swagger-ui/index.html
* Lecturer → http://localhost:8084/swagger-ui/index.html

🔹 Access via API Gateway

* Student → http://localhost:8080/student-service/swagger-ui/index.html
* Course → http://localhost:8080/course-service/swagger-ui/index.html
* Attendance → http://localhost:8080/attendance-service/swagger-ui/index.html
* Lecturer → http://localhost:8080/lecturer-service/swagger-ui/index.html

# Technology Stack
* Language: Java
* Framework: Spring Boot
* API Gateway: Spring Cloud Gateway
* Build Tool: Maven
* API Documentation: Swagger (OpenAPI)
* IDE: IntelliJ IDEA / VS Code

# How to Run the Project

Step 1: Clone Repository

`git clone <your-repo-link>
cd school-management-microservices`

Step 2: Run Services

Run each service individually:

`cd student-service
mvn spring-boot:run`

Repeat for:

* course-service
* attendance-service
* lecturer-service
* api-gateway

Step 3: Access APIs

* Use Swagger UI
* Or use Postman

# Challenges Faced

* Maven & dependency issues
* Port conflicts
* Swagger routing via Gateway
* API path mapping

# Solutions

* Proper configuration of application.yml
* Correct route mapping in Gateway
* Testing using Swagger

# Final Outcome

* Fully working microservices system
* API Gateway routing successfully implemented
* Services accessible both individually and via gateway
* Clean project structure
* No runtime or build errors

# Conclusion

This project demonstrates a real-world microservices implementation using Spring Boot and API Gateway.

It highlights:

* Service decomposition
* Gateway-based routing
* Scalable backend architecture