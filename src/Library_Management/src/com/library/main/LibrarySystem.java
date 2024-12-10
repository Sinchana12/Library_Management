package com.library.main;

import java.util.Scanner;

import com.library.service.BookService;
import com.library.service.IssuedBooksService;

public class LibrarySystem {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		BookService bookService = new BookService();
		IssuedBooksService issuedBooksService = new IssuedBooksService();
		int choice;
		do {
			System.out.println("\nLibrary Management System");
			System.out.println("1.View All Books");
			System.out.println("2.Add a New Book");
			
			System.out.println("3.Issue a Book");
			System.out.println("4.Return a Book");
			System.out.println("5.View Issued Books");
			System.out.println("6.Exit");
			System.out.println("Enter your choice:");
			choice=scanner.nextInt();

			switch(choice) {
			case 1:
				bookService.displayAllBooks();
				break;
				
			case 2:
				bookService.addNewBook();
				break;
				
			case 3:
				issuedBooksService.issueBook();
				break;
			case 4:
				issuedBooksService.returnBook();
				break;
			case 5:
				issuedBooksService.viewIssuedBooks();
				break;
			case 6:
				System.out.println("Exiting... Goodbye!");
				break;
			default:
				System.out.println("Invalid choice! Please try again.");
			}
		}while(choice != 6);
		scanner.close();
	}
}