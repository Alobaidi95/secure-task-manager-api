* Task Manager API
A RESTful Task Manager backend application built with Spring Boot that allows users to register, authenticate using JWT, and manage their personal tasks securely.
This project demonstrates backend development best practices, including authentication, authorization, layered architecture, and REST API design.

* Features
User Registration & Login
JWT-based Authentication & Authorization
Secure password hashing using BCrypt
Create, Read, Update, Delete (CRUD) tasks
User-specific task access (users can only access their own tasks)
Input validation
Clean layered architecture (Controller, Service, Repository)
MySQL database integration

* Tech Stack
Java 23
Spring Boot
Spring Security
JWT (JSON Web Tokens) 
Spring Data JPA
MySQL
Maven
Lombok

* Project Structure
src/main/java/com/osamah/taskmanager
│
├── config        # Security and application configuration
├── controller    # REST controllers (Auth, Tasks)
├── dto           # Request/Response DTOs
├── model         # JPA entities
├── repository    # Data access layer
├── security      # JWT utilities and filters
├── service       # Business logic
└── TaskManagerApplication.java

* Authentication Flow (JWT)
User registers or logs in
Server returns a JWT token
Client sends the token in the header for protected routes
Authorization: Bearer <JWT_TOKEN>

* API Endpoints
Authentication
Method	Endpoint	Description
POST	/api/auth/register	Register a new user
POST	/api/auth/login	Login and receive JWT
Tasks (Protected)
Method	Endpoint	Description
GET	/api/tasks	Get all user tasks
POST	/api/tasks	Create a new task
PUT	/api/tasks/{id}	Update a task
DELETE	/api/tasks/{id}	Delete a task

⚙️ Setup & Run Locally
1️⃣ Clone the repository
git clone https://github.com/YOUR_USERNAME/taskmanager.git
cd taskmanager

2️⃣ Configure the database
Create a file:
src/main/resources/application.properties
Use the example file:
application.properties.example
Update it with your database credentials.

3️⃣ Run the application
mvn spring-boot:run
Server will start at:
http://localhost:8080

* Testing the API
You can test endpoints using:
Postman
Insomnia
curl
Make sure to include the JWT token for protected routes.

* Notes
.DS_Store files are ignored using .gitignore
Sensitive configuration files are excluded from the repository
Example configuration file is provided for easy setup


👨‍💻 Author
Osamah Alobaidi
Backend / Java Developer
📍 United States

⭐️ If you like this project
Feel free to star the repository and use it as a reference!
