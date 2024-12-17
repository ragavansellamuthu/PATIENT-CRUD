# Patient CRUD Application

This is a Spring Boot-based application that allows you to manage patient records. It includes functionality for creating, reading, updating, and soft deleting patient data, as well as features like pagination, search, sorting, and more.

---

### **Project Description**
- **Create**: Allows creating new patient records.
- **Read**: Allows viewing patient records.
- **Update**: Allows updating existing patient records.
- **Soft Delete**: Allows soft deletion of patient records (they can be restored).
- **List All Patients**: Fetches and lists all patient records.
- **Pagination**: Allows pagination of patient records.
- **Search**: Supports searching for patients based on their name (along with pagination).
- **Sorting**: Sorts patient records along with pagination.
- **Swagger UI**: API documentation for testing the endpoints.
- **Actuator**: Health checks and server metrics.
- **Server-side Validation**: Ensures data integrity through validation.
- **Custom Annotations**: Used for custom validation.
- **Global Exception Handling**: Catches exceptions globally and sends meaningful responses.
- **JPA Auditing**: Tracks creation and modification times.
- **ModelMapper**: Maps model(DTO)s to entities and vice versa.

---

### **Prerequisites**

Before running this project, ensure that the following software is installed:

- **Java 17** or later
- **Maven** 
- **MySQL** 

Also, make sure to configure your database credentials in the `application.properties` file. Update the following fields:

- `spring.datasource.url` — Database URL with schema name
- `spring.datasource.username` — Database Username
- `spring.datasource.password` — Database Password

---

### **Technology Stack**

This project uses the following technologies:

- **Java**: 17
- **Spring Boot**: 3.4.0
- **MySQL**: 8.0.40
---

### **Swagger & Actuator Links**

```
http://localhost:8080/aria/swagger-ui
```
```
http://localhost:8080/aria/api-docs
```
```
http://localhost:8080/aria/patient/actuator/health
```
```
http://localhost:8080/aria/patient/actuator/metrics/http.server.requests
```
---

### **Automatic Schema and Sample Data Creation**

To simplify testing and setup, this project uses **CommandLineRunner** to prepopulate the database with 10 patient records during the first run.

- **Automatic Schema and Table Creation**: On initial startup, the schema and table will be created automatically.
- **Test Data**: 10 sample patient records are inserted into the database.

This allows you to quickly test functionalities such as:  
- Pagination  
- Searching  
- Sorting  

**No additional configuration is needed.** The records are created automatically, ensuring a smooth testing experience.

---

