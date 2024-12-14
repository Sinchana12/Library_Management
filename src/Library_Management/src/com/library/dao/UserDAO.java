package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.library.model.User;
import com.library.util.DBConnection;

public class UserDAO {
	private Connection connection;
	private PreparedStatement prepareStatement;
	private Statement statement;
	private ResultSet resultSet;
	private User user;
	List<User> userList=new ArrayList<>();

	public UserDAO() {
		try {
			connection=DBConnection.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void addUser(User user) {
		String query="Insert into `users`(`user_id`,`name`,`email`,`phone_number`) values(?,?,?,?)";
		try {
			prepareStatement=connection.prepareStatement(query);
			prepareStatement.setInt(1, user.getUser_id());
			prepareStatement.setString(2, user.getName());
			prepareStatement.setString(3, user.getEmail());
			prepareStatement.setString(4, user.getPhone_number());
			prepareStatement.executeUpdate();
			System.out.println("User added successfully.");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public List<User> getAllUsers() {
		String query="Select * from `users`";
		userList.clear();
		try {
			statement=connection.createStatement();
			resultSet=statement.executeQuery(query);
			while(resultSet.next()) {
				user=new User(resultSet.getInt("user_id"),
				resultSet.getString("name"),
				resultSet.getString("email"),
				resultSet.getString("phone_number"));
				
				userList.add(user);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	public void getUserById(int user_id) {
		String query="Select * from `users` where `user_id`=?";
		try {
			prepareStatement=connection.prepareStatement(query);
			prepareStatement.setInt(1, user_id);
			 
			resultSet=prepareStatement.executeQuery();
			if(resultSet.next()) {
				user=new User(resultSet.getInt("user_id"),
						resultSet.getString("name"),
						resultSet.getString("email"),
						resultSet.getString("phone_number"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateUser(User user) {
		String query="Update `users` set `name`=?,`email`=?,`phone_number`=? where `user_id`=?";
		try {
			prepareStatement=connection.prepareStatement(query);
			prepareStatement.setString(1, user.getName());
			prepareStatement.setString(2, user.getEmail());
			prepareStatement.setString(3, user.getPhone_number());
			prepareStatement.setInt(4, user.getUser_id());
			
			prepareStatement.executeUpdate();
			System.out.println("User updated successfully.");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser(int user_id) {
		String query="Delete from `users` where `user_id`=?";
		try {
			prepareStatement=connection.prepareStatement(query);
			prepareStatement.setInt(1, user_id);
			prepareStatement.executeUpdate();
			 System.out.println("User deleted successfully.");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
