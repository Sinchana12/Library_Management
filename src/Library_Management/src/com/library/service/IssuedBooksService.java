package com.library.service;

import java.util.List;
import java.util.Scanner;

import com.library.dao.IssuedBookDAO;

public class IssuedBooksService {
	public IssuedBookDAO issuedBookDAO= new IssuedBookDAO();
	Scanner scanner=new Scanner(System.in);

	public void issueBook() {
		System.out.println("Enter the Book ID:");
		int book_id=scanner.nextInt();
		System.out.println("Enter the User ID:");
		int user_id=scanner.nextInt();
		issuedBookDAO.issueBook(book_id, user_id);
	}

	public void returnBook() {
		System.out.println("Enter the Book ID:");
		int book_id=scanner.nextInt();
		System.out.println("Enter the User ID:");
		int user_id=scanner.nextInt();
		issuedBookDAO.returnBook(book_id, user_id);
	}

	public void viewIssuedBooks() {
		List<String> issuedBooks=issuedBookDAO.viewIssuedBooks();
		if(issuedBooks.isEmpty()) {
			System.out.println("No books are currently issued.");
		}else {
			System.out.println("Issued book list:");
			System.out.println();
			for(String book: issuedBooks)
				System.out.println(book);
		}
	}
}