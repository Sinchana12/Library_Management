package com.library.main;

import java.util.Scanner;

import com.library.service.BookService;
import com.library.service.IssuedBooksService;
import com.library.service.UserService;

public class LibrarySystem {
	private static Scanner scanner = new Scanner(System.in);
	private static BookService bookService = new BookService();
	private static IssuedBooksService issuedBooksService = new IssuedBooksService();
	private static UserService userService=new UserService();

	public static void main(String[] args) {
		while(true) {
			System.out.println("\n📚 Welcome to Library Management System");
			System.out.println("1. Manage Books");
			System.out.println("2. Manage Users");
			System.out.println("3. Manage Issued Books");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");

			int choice=scanner.nextInt();
			scanner.nextLine();
			switch(choice) {
			
			case 1:
				manageBooks();
				break;

			case 2:
				manageUsers();
				break;

			case 3:
				manageIssuedBooks();
				break;

			case 4:
				System.out.println("Thank you for using the Library Management System. Goodbye! 👋");
				System.exit(0);
				break;

			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	public static void manageBooks() {

		while(true) {
			System.out.println("\n📘 Book Management");
			System.out.println("1. View All Books");
			System.out.println("2. Add a Book");
			System.out.println("3. Update Book Details");
			System.out.println("4. Delete a Book");
			System.out.println("5. Go Back");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				bookService.displayAllBooks();
				break;
			case 2:
				bookService.addNewBook();
				break;
			case 3:
				bookService.updateBookDetails();
				break;
			case 4:
				bookService.deleteBook();
				break;
			case 5:
				return;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	public static void manageUsers() {
		while(true) {
			System.out.println("\n👤 User Management");
			System.out.println("1. View All Users");
			System.out.println("2. Add a User");
			System.out.println("3. Update User Details");
			System.out.println("4. Delete a User");
			System.out.println("5. Go Back");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				userService.displayAllUsers();
				break;
			case 2:
				userService.addNewUser();
				break;
			case 3:
				userService.updateUserDetails();
				break;
			case 4:
				userService.deleteUser();
				break;
			case 5:
				return;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	// Manage issued books menu
	private static void manageIssuedBooks() {
		while (true) {
			System.out.println("\n📖 Issued Book Management");
			System.out.println("1. View All Issued Books");
			System.out.println("2. Issue a Book");
			System.out.println("3. Return a Book");
			System.out.println("4. Go Back");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				issuedBooksService.viewIssuedBooks();
				break;
			case 2:
				issuedBooksService.issueBook();
				break;
			case 3:
				issuedBooksService.returnBook();
				break;
			case 4:
				return;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}
}
