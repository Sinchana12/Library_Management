package com.library.service;

import java.util.List;
import java.util.Scanner;

import com.library.dao.BookDAO;
import com.library.model.Book;

public class BookService {
	public BookDAO bookDAO=new BookDAO();
	public void displayAllBooks() {
		List<Book> books = bookDAO.getAllBooks();
		if(books.isEmpty()) {
			System.out.println("No books found");
		}else {
			books.forEach(System.out::println);
		}
	}

	public void addNewBook() {
		Scanner scanner=new Scanner(System.in);

		System.out.println("Enter Book Title:");
		String title=scanner.nextLine();
		System.out.println("Enter Author:");
		String author=scanner.nextLine();
		System.out.println("Enter Genre:");
		String genre=scanner.nextLine();
		System.out.println("Enter Availability (number of copies):");
		int availability=scanner.nextInt();

		Book book=new Book(0,title,author,genre,availability);
		bookDAO.addBooks(book);
	}
}