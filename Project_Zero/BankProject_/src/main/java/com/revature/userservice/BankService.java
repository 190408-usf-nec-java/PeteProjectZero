package com.revature.userservice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.revature.bean.Account;
import com.revature.menu.BankView;
import com.revature.menu.MainMenu;
import com.revature.menu.View;
import com.revature.userdao.BankDao;
import com.revature.util.ConnectionUtil;
import com.revature.util.ScannerUtil;

public class BankService {
	
	static BankDao bankDao = new BankDao();
	
	static double balance;
	static double previous_Transaction;
	
	public void setDao(BankDao bankDao) {
		this.bankDao = bankDao;	
	}
	
	/**
	 * Handles creation workflow for BankUser bean
	 * @return 
	 * @return 
	 */
	
	public static View Initial() {
		
		System.out.println("Please enter amount: ");
		double deposit = ScannerUtil.getNum();
		double balance = deposit;
		
		if(deposit>0){
		
		Account userAccount = new Account(deposit,0,balance,0,0,"Check");
		
		bankDao.saveAccount(userAccount);
		
		}else {
			System.out.println("Please enter a valid amount");
		}
		return new MainMenu();
	}
	
	public static View CreateAccount() {
		
		System.out.println("Please provide the Account Name: ");
		String Service = ScannerUtil.getLine();
		
		System.out.println("Please enter an amount: ");
		double deposit = ScannerUtil.getNum();
		
		if(deposit > 0) {
		
		double balance = deposit;
		
		Account userAccount = new Account(deposit,0,balance,0,0,Service);
		
		bankDao.saveAccount(userAccount);

		
		}else {
			System.out.println("Please enter a valid amount");
		}
		return new BankView();
	}
	
	
	public static View ShowBalance() {
				
		Account account = bankDao.getAccountById(UserService.currentUserId);
		
		System.out.println(account.getBalance());
		
return new BankView();	
}

	
	public static View Deposit() {
		
		System.out.println("Please enter Deposited amount:");
		Double amount = ScannerUtil.getNum();
		
		if(amount > 0)
		System.out.println("Please enter which AccountNum to deposit into:");
		int AccountId = ScannerUtil.getint();
		{
			try(Connection connection = ConnectionUtil.getConnection()){
				String sql = "UPDATE user_bank SET balance = balance + ? where accountnum = ?;";
				PreparedStatement ps = connection.prepareStatement(sql);
				
				ps.setDouble(1, amount);
				//ps.setDouble(2, amount);
				ps.setInt(2, AccountId);	
				ps.executeUpdate();
		}
				catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return new BankView();
}
	
	public static View Withdrawn() 
	{
		System.out.println("Please enter withdraw amount:");
		Double amount = ScannerUtil.getNum();
		
		if(amount > 0) 
		System.out.println("Please enter which AccountNum want to withdraw from:");
		int AccountId = ScannerUtil.getint();
			
			if(amount > 0) 
			{
				try(Connection connection = ConnectionUtil.getConnection()){
					String sql = "UPDATE user_bank SET balance = balance - ? where accountnum = ?;";
					PreparedStatement ps = connection.prepareStatement(sql);
					
					ps.setDouble(1, amount);
					//ps.setDouble(2, amount);
					ps.setInt(2, AccountId);	
					ps.executeUpdate();
			}
					catch(SQLException e) {
					e.printStackTrace();
				}
			}
			return new BankView();
	}
	
	
	public static View Transfer() {
		
		System.out.println("Please give the account Id to transfer too:");
		int accountid = ScannerUtil.getint();
		
		System.out.println("How much is going to be transferred: ");
		double amount = ScannerUtil.getNum();
				
		try(Connection connection = ConnectionUtil.getConnection()){
			String sql = "select user_bank.Balance from user_account join user_bank on user_account.Account_id = user_bank.Accountid where account_id = ?;";
			PreparedStatement ps = connection.prepareStatement(sql);
						
			ps.setDouble(1, accountid);	
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String sql1 = "UPDATE user_bank SET balance = balance + ? where accountnum = ?;";
			PreparedStatement ps1 = connection.prepareStatement(sql1);
			
			ps1.setDouble(1, amount);
			ps1.setDouble(2, UserService.currentUserId);
			ps1.executeUpdate();
			
			String sql2 = "UPDATE user_bank SET balance = balance - ? where accountnum = ?;";
			PreparedStatement ps2 = connection.prepareStatement(sql2);
			
			ps2.setDouble(1, amount);
			ps2.setDouble(2, accountid);
			ps2.executeUpdate();
			
			System.out.println("Transfer was successful");
			}
			}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
}

