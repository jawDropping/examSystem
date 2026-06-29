INSTRUCTIONS:
Build a backend REST API for a simple Exam Management System. Your application must handle basic CRUD operations and manage the relationship between users (examinees) and the exams they are assigned to take.

Core Requirements
• CRUD Operations: The application should allow creating, reading, updating, and deleting User, UserExams (reading only), and Exam records.
• Relationships: *A user can be assigned to take an exam.
When an exam is assigned to a user, the system should track the connection and record a basic completion status (e.g., PENDING, COMPLETED).

Expected Endpoints:
1. Users (/api/users)

GET /api/users — Retrieve all users.
GET /api/users/{id} — Retrieve a specific user by their ID.
POST /api/users — Create a new user record.
PATCH /api/users/{id} — Update an existing user's details.
DELETE /api/users/{id} — Delete a user record.


2. Exams & Attempts (/api/exams)

GET /api/exams — Retrieve all available exams.
GET /api/exams/{id} — Retrieve a specific exam by its ID.
POST /api/exams — Create a new exam.
PATCH /api/exams/{id} — Update exam details.
DELETE /api/exams/{id} — Delete an exam.


3. UserExams (/api/user-exams)

GET /api/user-exams
 OPTIONAL: (Bonus points) Add query params for user_id and exam_id to fetch exams taken by user or users who took exams by exam

POST /api/exams/{id}/assign — Assign this specific exam to a user.
PATCH /api/user-exams/{id}/submit — Mark a user's exam status as completed.


Entities

User: id (UUID), first_name, last_name, email
Exam: id (UUID), code, description , status
 Exam status - Active, Inactive, Cancelled

UserExams (Join Table): id, user_id, exam_id, date_taken, status
 User exam status - Completed, Pending, Cancelled
