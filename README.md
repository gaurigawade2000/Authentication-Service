# Authentication-Service
This is project provide Authentication Service means User Login and Register Authentication using Spring Security and JWT

🛠️ Technologies Used
Technology	Purpose
Spring Boot	Backend framework
Spring Security	Authentication & Security
JWT (JSON Web Token)	Token-based Authentication
MySQL	Database
JPA/Hibernate	ORM
BCrypt Password Encoder	Hashing Passwords
Postman	API Testing

🔐 Authentication Flow

1️⃣ User Registration (Sign-Up)

User sends name, email, and password

Password is encrypted using BCrypt

User saved in database

2️⃣ User Login (Sign-In)

System checks if user exists in DB & matches password

If valid → JWT Token Generated

Token is returned to user (Postman Response)

3️⃣ Access Protected APIs

User must send JWT token in Authorization Header

🔁 API Endpoints (Example)
Method	Endpoint	Description
POST	/auth/register	Register new user
POST	/auth/login	Login & get JWT token
GET	/auth/welcome	Access with JWT token
