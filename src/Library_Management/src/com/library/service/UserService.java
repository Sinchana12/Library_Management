package com.library.service;

import java.util.List;
import java.util.Scanner;

import com.library.dao.UserDAO;
import com.library.model.User;

public class UserService {
	Scanner scanner = new Scanner(System.in);
	UserDAO userDao=new UserDAO();
	User user;
	public void displayAllUsers() {
		List<User> users=userDao.getAllUsers();
		if(users.isEmpty()) {
			System.out.println("No users found.");
		} else {
			System.out.printf("%-10s %-20s %-30s %-15s%n", "User ID", "Name", "Email", "Phone");
			System.out.println("-------------------------------------------------------------------");
			for(User user : users) {
				System.out.printf("%-10d %-20s %-30s %-15s%n",
						user.getUser_id(), user.getName(), user.getEmail(), user.getPhone_number());
			}
		}
	}

	public void addNewUser() {
		System.out.println("Enter user name:");
		String name = scanner.nextLine().trim();
		if(name.isEmpty()) {
			System.out.println("Error: Name cannot be empty.");
			return;
		}

		System.out.println("Enter user email:");
		String email = scanner.nextLine().trim();
		if(email.isEmpty()) {
			System.out.println("Error: Email cannot be empty.");
			return;
		}

		System.out.println("Enter user phone:");
		String phone = scanner.nextLine().trim();
		if(phone.isEmpty()) {
			System.out.println("Error: Phone Number cannot be empty.");
			return;
		}

		user=new User(0,name,email,phone);
		userDao.addUser(user);
	}

	public void updateUserDetails() {
		System.out.println("Enter User ID to update:");
		int userId = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		System.out.println("Enter new name:");
		String name = scanner.nextLine().trim();
		if(name.isEmpty()) {
			System.out.println("Error: Name cannot be empty.");
			return;
		}

		System.out.println("Enter new email:");
		String email = scanner.nextLine().trim();
		if(email.isEmpty()) {
			System.out.println("Error: Email cannot be empty.");
			return;
		}

		System.out.println("Enter new phone:");
		String phone = scanner.nextLine().trim();
		if(phone.isEmpty()) {
			System.out.println("Error: Phone Number cannot be empty.");
			return;
		}

		User user = new User(userId, name, email, phone);
		userDao.updateUser(user);
	}

	public void deleteUser() {
		System.out.println("Enter User ID to delete:");
		int userId = scanner.nextInt();
		userDao.deleteUser(userId);
	}
}
