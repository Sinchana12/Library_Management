package com.library.service;

import java.util.List;
import java.util.Scanner;

import com.library.dao.BookDAO;
import com.library.model.Book;

public class BookService {
	public BookDAO bookDAO=new BookDAO();
	Scanner scanner=new Scanner(System.in);

	public void displayAllBooks() {
		List<Book> books = bookDAO.getAllBooks();
		if(books.isEmpty()) {
			System.out.println("No books found");
		}else {
			books.forEach(System.out::println);
		}
	}

	public void addNewBook() {

		System.out.println("Enter Book Title:");
		String title=scanner.nextLine().trim();
		if(title.isEmpty()) {
			System.out.println("Error: Title cannot be empty.");
			return;
		}

		System.out.println("Enter Author:");
		String author=scanner.nextLine().trim();
		if(author.isEmpty()) {
			System.out.println("Error: Author cannot be empty.");
			return;
		}

		System.out.println("Enter Genre:");
		String genre=scanner.nextLine().trim();
		if(genre.isEmpty()) {
			System.out.println("Error: Genre cannot be empty.");
			return;
		}

		System.out.println("Enter Availability (number of copies):");
		int availability=scanner.nextInt();
		if(availability < 0) {
			System.out.println("Error: Availability cannot be negative.");
			return;
		}
		Book book=new Book(0,title,author,genre,availability);
		bookDAO.addBooks(book);
	}

	public 	void updateBookDetails() {

		System.out.println("Enter Book ID to update:");
		int bookId = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		
		System.out.println("Enter Book Title:");
		String title = scanner.nextLine().trim();
		if(title.isEmpty()) {
			System.out.println("Error: Title cannot be empty.");
			return;
		}

		System.out.println("Enter Author:");
		String author = scanner.nextLine().trim();
		if(author.isEmpty() && author != null) {
			System.out.println("Error: Author cannot be empty.");
			return;
		}

		System.out.println("Enter Genre:");
		String genre = scanner.nextLine().trim();
		if(genre.isEmpty()) {
			System.out.println("Error: Genre cannot be empty.");
			return;
		}

		System.out.println("Enter availability (number of copies):");
		int availability = scanner.nextInt();
		if(availability < 0) {
			System.out.println("Error: Availability cannot be negative.");
			return;
		}

		Book book = new Book(bookId, title, author, genre,availability);
		bookDAO.updateBooks(book);
	}

	public void deleteBook() {
		System.out.println("Enter Book ID to delete:");
		int bookId = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		bookDAO.deleteBooks(bookId);
	}
}
