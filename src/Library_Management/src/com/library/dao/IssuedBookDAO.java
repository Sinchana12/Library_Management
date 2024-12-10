package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.library.util.DBConnection;

public class IssuedBookDAO {
	private static Connection connection;
	private Statement statement;
	private ResultSet resultSet; 

	public IssuedBookDAO(){
		connection=DBConnection.getConnection();
	}
	public void issueBook(int book_id,int user_id) {
		String updateBookQuery="Update `Books` SET `availability`=`availability`-1 WHERE `book_id`=? and `availability` > 0";
		String insertIssueQuery="Insert into `IssuedBooks` (`book_id`,`user_id`,`issue_date`,`return_date`) values(?,?,?,?)";

		try {
			PreparedStatement bookStatement=connection.prepareStatement(updateBookQuery);
			PreparedStatement issueStatement=connection.prepareStatement(insertIssueQuery);

			bookStatement.setInt(1, book_id);
			int rowsAffected=bookStatement.executeUpdate();


			if(rowsAffected > 0) {
				issueStatement.setInt(1,book_id );
				issueStatement.setInt(2, user_id);
				issueStatement.setDate(3, new java.sql.Date(System.currentTimeMillis()));
				issueStatement.setDate(4, java.sql.Date.valueOf(java.time.LocalDate.now()));
				issueStatement.executeUpdate();
				System.out.println("Book issued successfully.");
			}else {
				System.out.println("Book not available.");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


	public void returnBook(int book_id,int user_id) {
		String updateBookQuery="Update `Books` SET `availability`=`availability`+1 WHERE `book_id`=?";
		String deleteIssueQuery="Delete from `IssuedBooks` WHERE `book_id`=? and`user_id`=?";

		try {
			PreparedStatement bookStatement=connection.prepareStatement(updateBookQuery);
			PreparedStatement deleteStatement=connection.prepareStatement(deleteIssueQuery);
			bookStatement.setInt(1, book_id);
			int rowsAffected=bookStatement.executeUpdate();

			if(rowsAffected > 0) {
				deleteStatement.setInt(1, book_id);
				deleteStatement.setInt(2, user_id);
				deleteStatement.executeUpdate();
				System.out.println("Book returned successfully.");
			}else {
				System.out.println("No record of this book being issued to this user.");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> viewIssuedBooks() {
		List<String> issuedList=new ArrayList<>();
		String query="Select b.title,u.name,i.issue_date,i.return_date "
				+ "FROM issuedBooks i "
				+ "JOIN Books b ON b.book_id=i.book_id "
				+ "JOIN Users u ON u.user_id=i.user_id ";

		try {
			connection=DBConnection.getConnection();
			statement=connection.createStatement();
			resultSet=statement.executeQuery(query);
			issuedList.add(String.format("%-30s %-20s %-15s %-15s", 
					"Book Title", "User Name", "Issue Date", "Return Date"));
			issuedList.add("---------------------------------------------------------------------------------");

			// Add each issued book record to the list
			while (resultSet.next()) {
				String title = resultSet.getString("title");
				String userName = resultSet.getString("name");
				Date issueDate = resultSet.getDate("issue_date");
				Date returnDate = resultSet.getDate("return_date");

				String record = String.format("%-30s %-20s %-15s %-15s", 
						title, userName, issueDate, returnDate);
				issuedList.add(record);
			} 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return issuedList;
	}
}
