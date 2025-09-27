# Student Record Management System (CLI)

A simple **command-line Student Management System** written in Java.  
It demonstrates the use of:
- Object-Oriented Programming (OOP)
- HashMap for efficient CRUD operations
- Java Scanner for user input
- CLI-based menu-driven programs

---

## 📌 Features
- Add a student (with ID, name, marks)
- View all students
- View a student by ID
- Update student details
- Delete student record
- Exit option

---

## ⚡ Why HashMap Instead of ArrayList?
- **ArrayList** required searching through the list → **O(n)** time for update/delete/search.  
- **HashMap** allows direct access by student ID → **O(1)** average time for add/update/delete/search.  
- This makes the system more scalable for larger datasets.

---

## 🖥️ Usage
1. Clone this repository:
   ```bash
   git clone https://github.com/Sandipan495/student-record-management.git
