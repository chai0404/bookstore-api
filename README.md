 # 📚 Bookstore API (Spring Boot)

A robust RESTful backend application built using Spring Boot for managing books and users with secure authentication.

---

## 🔧 Features

* 🔐 User Registration & Login using JWT Authentication
* 📖 Book Management (Create, Read, Update, Delete)
* 🛡️ Secured REST APIs using Spring Security
* ⚠️ Global Exception Handling for better error responses

---

## 🛠 Tech Stack

* Java
* Spring Boot
* Spring Security
* JWT (JSON Web Token)
* MySQL
* Maven

---

## 🚀 How to Run

1. Clone the repository

   ```bash
   git clone https://github.com/chai0404/bookstore-api.git
   ```

2. Configure MySQL in `application.properties`

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

3. Run the application

   ```bash
   mvn spring-boot:run
   ```

---

## 📌 API Endpoints

### 🔑 Authentication

* `POST /auth/register` → Register new user
* `POST /auth/login` → Login and get JWT token

### 📚 Books

* `GET /books` → Get all books
* `POST /books` → Add new book
* `PUT /books/{id}` → Update book
* `DELETE /books/{id}` → Delete book

---

## 📦 Future Improvements

* 📊 Add Swagger UI for API testing
* 👥 Role-based authorization (Admin/User)
* 📈 Pagination & Sorting for book list

---

## 👨‍💻 Author

**Chaitanya Janbandhu**
