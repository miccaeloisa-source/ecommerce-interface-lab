# ecommerce-interface-lab

**SUBMITTED BY:** MICCA ELOISA G. PELITO & RICHARD S. ARNESTO (BSIT - 2A)

## API Endpoints Information

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| GET | `/api/v1/products` | Returns all products |
| GET | `/api/v1/products/{id}` | Returns a single product |
| POST | `/api/v1/products` | Adds a new product |
| DELETE | `/api/v1/products/{id}` | Deletes a product |

# M.R Collection Ecommerce System

## Project Description
An ecommerce makeup collection system built using Spring Boot, MySQL, HTML, CSS, and JavaScript.

## Features
- Product management
- REST API
- MySQL database integration
- Frontend product display
- Fetch API integration

## Technologies Used
- Java
- Spring Boot
- MySQL
- HTML
- CSS
- JavaScript

## API Endpoints

### GET Products
GET /api/v1/products

### ADD Product
POST /api/v1/products

## Database
MySQL database with products table.

## Screenshots
<img width="659" height="511" alt="Screenshot 2026-05-15 131735" src="https://github.com/user-attachments/assets/7a87e2e2-fdcf-46c6-94ff-0733140b96aa" />
<img width="1120" height="627" alt="Screenshot 2026-05-15 131810" src="https://github.com/user-attachments/assets/69990d0c-d2d4-45c2-90a7-7038854a6aaa" />
<img width="1128" height="632" alt="Screenshot 2026-05-15 131828" src="https://github.com/user-attachments/assets/84b1af8b-e43b-4db7-a86d-749e88a20345" />
<img width="1310" height="625" alt="Screenshot 2026-05-15 131853" src="https://github.com/user-attachments/assets/2644c78f-c603-49de-86bc-f93fca5c01d1" />
<img width="1323" height="664" alt="Screenshot 2026-05-15 131923" src="https://github.com/user-attachments/assets/08b08067-36d1-43d7-b6f5-9c59f6dd978c" />

# Ecommerce API Security Lab

## Features Implemented

- Spring Security
- Authentication
- Authorization
- Role-Based Access Control (RBAC)
- Bean Validation
- Global Exception Handling

## Public Endpoints

GET /api/v1/products

POST /api/v1/auth/register

## Protected Endpoints

POST /orders

## Admin Endpoints

DELETE /api/v1/admin/products/{id}

## Authentication

Uses HTTP Basic Authentication.

### Admin Account

username: admin  
password: admin123

### User Account

username: user  
password: user123

## Validation

Implemented using:

- @NotBlank
- @Size
- @Valid

## Exception Handling

Implemented using:

- @ControllerAdvice
- MethodArgumentNotValidException
<img width="1123" height="559" alt="image" src="https://github.com/user-attachments/assets/d8567b0d-aa50-4040-9a16-d23a987c74f0" />
<img width="1109" height="551" alt="image" src="https://github.com/user-attachments/assets/58d37e2d-9fd1-4265-af83-37e89bdd606d" />
<img width="1114" height="545" alt="image" src="https://github.com/user-attachments/assets/cfdfe1f2-828a-405b-a5e5-aab06531aad5" />
<img width="1102" height="554" alt="image" src="https://github.com/user-attachments/assets/9757a13c-ae73-4a81-9eb9-29e17f359cb3" />

