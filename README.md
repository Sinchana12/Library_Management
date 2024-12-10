# 📚 Library Management System  

A simple and efficient **Library Management System** built using **Java**, **JDBC**, and **MySQL**. This project helps manage books, users, and book-issuing records seamlessly.  

## ✨ Features  
- 📖 Manage book inventory (Add, View, Update, Delete).  
- 👥 Manage user information.  
- 🔄 Issue and return books.  
- 📅 View issued books with details like issue date and return date.  
- 🖥️ Formatted table outputs for easy readability.  

## 🛠️ Technologies Used  
- **Java** (Core concepts, JDBC)  
- **MySQL** (Database management)  
- **Eclipse/IntelliJ IDEA** (Development IDE)  

## 📂 Project Structure  
src/
├── com.library.main # Main entry point
├── com.library.dao # Data Access Objects
├── com.library.model # Entity classes
├── com.library.service # Business logic
└── com.library.util # Utility classes (e.g., DB connection)

## 🚀 How to Run  
1. Clone the repository.  
2. Import the project into your favorite IDE.  
3. Configure the **MySQL database** in the `DBConnection` class.  
4. Run the `LibrarySystem` class to start the application.  

## 📊 Database Design  
- **Books**: Stores book details (title, author, genre, availability).  
- **Users**: Stores user information (name, contact details).  
- **IssuedBooks**: Tracks issued and returned books.  

## 🤝 Contributing  
Feel free to fork the project and submit pull requests. Your contributions are welcome!  

## 📜 License  
This project is open-source under the MIT License.  

Happy coding! 😊  
