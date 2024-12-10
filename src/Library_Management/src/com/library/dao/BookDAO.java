package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.library.model.Book;
import com.library.util.DBConnection;

public class BookDAO {

	private static Connection connection;
	private PreparedStatement prepareStatement;

	static {
		connection=DBConnection.getConnection();
	}

	public List<Book> getAllBooks(){
		List<Book> books=new ArrayList<>();
		String query="Select * from Books";
		try {
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery(query);

			System.out.printf("%-10s %-30s %-25s %-20s %-15s\n",
					"Book ID","Title","Author","Genre","Availability");
			System.out.println("--------------------------------------------------------------------------------------------------------");
			while(resultSet.next()) {
				Book book=new Book();
				book.setBookId(resultSet.getInt("book_id"));
				book.setTitle(resultSet.getString("title"));
				book.setAuthor(resultSet.getString("author"));
				book.setGenre(resultSet.getString("genre"));
				book.setAvailability(resultSet.getInt("availability"));
				books.add(book);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return books;
	}

	public void addBooks(Book b) {
		String query="Insert into `Books`(`title`,`author`,`genre`,`availability`) values(?,?,?,?)";
		try {
			prepareStatement=connection.prepareStatement(query);
			prepareStatement.setString(1, b.getTitle());
			prepareStatement.setString(2, b.getAuthor());
			prepareStatement.setString(3, b.getGenre());
			prepareStatement.setInt(4, b.getAvailability());

			prepareStatement.executeUpdate();
			System.out.println("Book added successfully.");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}