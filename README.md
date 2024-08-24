# User-Mgt-Service
This project provides a user management service built with Spring Boot. It includes endpoints for creating, reading, updating, and deleting user information, with built-in exception handling to manage and respond to errors gracefully.
#Features
- User CRUD Operations: Create, retrieve, update, and delete user information.
- Exception Handling: Custom handling of UserNotFoundException and other errors.
- Test Coverage: Includes unit and integration tests to ensure reliable functionality and error handling.
#Endpoints
Create User
POST /Users - Creates a new user.
Get User
GET /Users/{userID} - Retrieves user details by ID.
GET /Users - Gets all users
Update User
PUT /Users - Updates user information based on the provided user ID.
Delete User
DELETE /Users/{userID} - Deletes a user by ID.
Error Handling
404 Not Found: Returned when a requested user does not exist.
500 Internal Server Error: Returned for unexpected errors during operations.
