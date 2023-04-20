# API REST TO-DO LIST

This is a REST CRUD API for a todo list application. The API uses JPA for data persistence in a relational database.

## Endpoints

The API provides the following endpoints for accessing CRUD operations:

### GET /tasks

Returns a list of all tasks.

### GET /tasks/{id}

Returns a specific task identified by its ID.

### POST /tasks

Creates a new task.

### PUT /update/{id}

Updates a specific task identified by its ID.

### DELETE /delete/{id}

Deletes a specific task identified by its ID.

## Data model

The todo list application uses a Task entity with the following attributes:

    id - unique identifier for the task.
    title - title of the task.
    description - description of the task.
    

## Repository

The TodoRepository.java file contains the repository interface that extends JpaRepository:

## Model

The Task.java file contains the Task entity class
    
## Database configuration
The application uses a database configuration file application.properties to configure the database settings. 
The file should be located in the resources folder of the project and include the following settings:

On mine, MySQL is on port 3307 because I have MariaDB running on 3306.

`spring.datasource.url=jdbc:mysql://localhost:3307/todocrud?useSSL=false
spring.datasource.username=yourusername
spring.datasource.password=youtpassword
spring.jpa.hibernate.ddl-auto=update
`

The `spring.datasource.url` setting specifies the JDBC URL of the database.
The `spring.datasource.username` and spring.datasource.password settings specify the credentials to connect to the database.
The `spring.jpa.hibernate.ddl-auto` setting specifies how Hibernate should handle database schema changes.

## Running the Application

To run the application, follow these steps:

    - Clone the repository to your local machine.
    - Open the project in your IDE of choice.
    - Configure the database settings in the application.properties file.
    - Build and run the project.

Once the application is running, you can access the API endpoints using a tool like Postman or cURL.

## View

I have also created a controller for the views, to display the list on a web site, in a table. It allows you to delete, edit and create.
