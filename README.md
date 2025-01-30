## 📚 Library Management System
A Spring Boot-based REST API for managing books and users in a library.

## 🚀 Project Overview
The Library Management System is a backend service that allows users to manage books, register accounts, and borrow or return books. Built using Spring Boot, Spring Security, and JPA (Hibernate), this system ensures efficient management of a digital library.

## 🛠 Technoligies
Java 17
Spring Boot 3
Spring Security
Spring Data JPA (Hibernate)
MySQL
HikariCP (for database connection pooling)
Postman (for API testing)

## 🎯 Features
✔ User Registration & Authentication (JWT-based authentication) 
✔ Book Management (Add, Update, Delete books)
✔ Search Books (by title and author)
✔ Rent & Return Books

# ⚙️ Setup & Installation
## 1️⃣ Clone the Repository
git clone https://github.com/pmouchtar/LibraryManagementApplication.git
cd library-management
## 2️⃣ Configure the Database
##Edit the src/main/resources/application.properties file and set up your MySQL database:
spring.datasource.url=jdbc:mysql://localhost:3306/library_management
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
## 3️⃣ Build & Run the Application
mvn spring-boot:run

## The API will be available at:
http://localhost:8080/api

# API Endpoints & Testing
## 📌 User Endpoints
Method	Endpoint	              Description
POST	  /api/users/register   	Register a new user
GET   	/api/users/{username} 	Get user details
## 📌 Book Endpoints
Method	Endpoint	              Description
GET   	/api/books/	            Get all books
POST	  /api/books/           	Add a new book
PUT   	/api/books/{id}	        Update book details
DELETE	/api/books/{id}	        Delete a book
POST  	/api/books/rent/{id}	  Rent a book
POST	  /api/books/return/{id}	Return a book

## Example tests in Postman
### Add a Book:
Method: POST
URL: http://localhost:8080/api/books/
Body (JSON):
json

{
  "title": "Spring Boot in Action",
  "author": "Craig Walls",
  "description": "Comprehensive guide to Spring Boot",
  "isRented": false
}
### Get All Books:
Method: GET
URL: http://localhost:8080/api/books/
