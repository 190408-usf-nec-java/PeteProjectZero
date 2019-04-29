package com.revature.userdao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.revature.bean.Account;
import com.revature.userservice.UserService;
import com.revature.util.ConnectionUtil;

public class BankDao {

	public void saveAccount(Account userAccount) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
		String sql = "INSERT INTO User_Bank (service, Deposit, Withdraw, Balance) VALUES" + "(?,?,?,?) RETURNING AccountNum";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, userAccount.getService());
		ps.setDouble(2, userAccount.getDeposit());
		ps.setDouble(3, userAccount.getWithdraw());
		ps.setDouble(4, userAccount.getBalance());
		
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			int AccountNum = rs.getInt("AccountNum");
			userAccount.setAccountNum(AccountNum);
			userAccount = new Account();
		}
	}catch(SQLException e) {
		e.printStackTrace();
		}
	}
	
	public Account getAccountById(int currentUserId) {
		Account account = null;

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT Deposit, Withdraw, Balance, accountid, service FROM User_Bank WHERE AccountNum = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, (UserService.currentUserId));

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Double deposit = rs.getDouble("deposit");
				Double withdraw = rs.getDouble("withdraw");
				Double balance = rs.getDouble("balance");
				int accountid = rs.getInt("accountid");
				String service = rs.getString("service");
				
				account = new Account(deposit, withdraw, balance, UserService.currentUserId, accountid,service);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return account;
	
	}
}
