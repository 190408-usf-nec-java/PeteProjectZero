package com.revature.userservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

//Package design to create the user in BankUser


import java.util.Scanner;
import java.util.Set;

import com.revature.bean.BankUser;
import com.revature.menu.BankView;
import com.revature.userdao.UserDao;
import com.revature.util.ConnectionUtil;
import com.revature.util.ScannerUtil;


public class UserService {
	
	UserDao userDao = new UserDao();
	public static int currentUserId = 0;

	
	//userDao = new userDao (firstname,lastname,username,password);
	
	public void setDao(UserDao userDao) {
		this.userDao = userDao;
	}
	/**
	 * Handles creation workflow for User bean
	 */
	public BankService createUser() {
		//
		System.out.println("Enter users first name: ");
		String firstname = ScannerUtil.getLine();
		
		System.out.println("Enter users last name: ");
		String lastname = ScannerUtil.getLine();
		
		System.out.println("Enter a username: ");
		String username = ScannerUtil.getLine();
		
		System.out.println("Enter a password: ");
		String password = ScannerUtil.getLine();
		
		//Validate all the data
		
		BankUser user = new BankUser(firstname, lastname, 0, username, password);
		
		//then creates a user and allocates it in the DAO

		
		userDao.saveUser(user);
		System.out.println(user);
		
		return new BankService();
		
	}
	
	public BankView getUserUsername() {
		Scanner scanner = new Scanner(System.in);
		Set<String> usernameSet = new HashSet<>();
		Set<String> passwordSet = new HashSet<>();
		Set<Integer> AccountidSet = new HashSet<>();
		
		Boolean userExists = false;
		Boolean passwordExists = false;
		
		try(Connection connection = ConnectionUtil.getConnection()){
			String sql = "select username, password, account_id from user_account;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				usernameSet.add(rs.getString(1));
				passwordSet.add(rs.getString(2));
				AccountidSet.add(rs.getInt(3));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		while(!userExists && !passwordExists) {
		
		System.out.println("Enter Username:");
				String UsernameEntry = scanner.nextLine();

		System.out.println("Enter password:");
				String passwordEntry = scanner.nextLine();

		System.out.println("Enter account id:");
				int id = (int) ScannerUtil.getNum();

		
		if((usernameSet.contains(UsernameEntry)&&(passwordSet.contains(passwordEntry)))) {
			System.out.println("Login Successful!!");
			
			currentUserId += id;
					
			userExists = true;
			passwordExists = true;
			
			return new BankView();
		}
		else {
			System.out.println("Username or Password was incorrect.  Please try again.");
			//to clear the string buffer for user input
			System.out.println("Press enter to continue.");
			scanner.nextLine();
		}
	}
		return null;
		
	}
}
