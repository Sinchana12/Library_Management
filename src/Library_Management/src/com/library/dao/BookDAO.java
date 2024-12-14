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
	private ResultSet resultSet;

	static {
		try {
		connection=DBConnection.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public List<Book> getAllBooks(){
		List<Book> books=new ArrayList<>();
		String query="Select * from `Books`";
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

			int rowsAffected=prepareStatement.executeUpdate(); 
			if (rowsAffected > 0) {
                System.out.println("Book added successfully.");
            } else {
                System.out.println("Failed to add book. Please try again.");
            }
		}catch(Exception e) {
			e.printStackTrace();
		} 
	}
	
	public void updateBooks(Book b) {
		String query="Update `Books` set `title`=?, `author`=?,`genre`=?,`availability`=? where `book_id`=?";
		try {
			prepareStatement=connection.prepareStatement(query);
			prepareStatement.setString(1, b.getTitle());
			prepareStatement.setString(2, b.getAuthor());
			prepareStatement.setString(3, b.getGenre());
			prepareStatement.setInt(4,b.getAvailability());
			prepareStatement.setInt(5, b.getBookId());

			int rowsAffected=prepareStatement.executeUpdate();
			if (rowsAffected > 0) {
                System.out.println("Book details updated successfully.");
            } else {
                System.out.println("Failed to update book. Please check the Book ID and try again.");
            }
		}catch(Exception e) {
			e.printStackTrace();
		} 
	}

	public void deleteBooks(int bookId) {
		String query="Delete from `Books` where `book_id`=?";
		try {
			prepareStatement=connection.prepareStatement(query);
			prepareStatement.setInt(1, bookId);
			int rowsAffected=prepareStatement.executeUpdate();
			if (rowsAffected > 0) {
                System.out.println("Book deleted successfully.");
            } else {
                System.out.println("Failed to delete book. Please check the Book ID and try again.");
            }
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean doesBookExist(int bookId) {
		String query="Select count(*) from `books` where `book_id`=?";
		try {
			prepareStatement=connection.prepareStatement(query);
			prepareStatement.setInt(1, bookId);
			resultSet=prepareStatement.executeQuery();
			if(resultSet.next()) {
				int count=resultSet.getInt(1);
				return count > 0;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
