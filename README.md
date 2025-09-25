# Developer Allocator

This project is an **API** built with **Java and Spring**, designed to manage the relationship between **Developers** and **Projects**.  
The API was implemented following best practices in architecture, documentation, and version control.

## Entity Relationship
- One **Developer** can be linked to only **one Project**.  
- One **Project** can contain **multiple Developers**.  
- Relationship: **One-To-Many** (Project → Developers).

## Technologies Used
-  **Java & Spring** – robust and scalable development  
-  **Swagger** – clear and interactive API documentation  
-  **H2 Database** – fast and efficient testing  
-  **Migration** – database versioning  
-  **Git & GitHub** – source code version control  
-  **Layered Architecture** – responsibility separation and organized code  

## Project Structure
- `controller/` → API layer  
- `service/` → Business logic  
- `repository/` → Data access and persistence  
- `model/` → Entity definitions  

## Documentation
1. Clone this repository:
   ```bash
   git clone https://github.com/PedroConsoni/Developer-Allocator.git
   cd Developer-Allocator
   ```
2. Run the application with Maven
      ```
      ./mvnw spring-boot:run
      ```
3. Open your browser and go to:
   ```
   http://localhost:8080/swagger-ui/index.html#/
   ```

