package com.revature.userdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.revature.bean.BankUser;
import com.revature.util.ConnectionUtil;

//Creating a Dao-Data access Object to insert my User 
public class UserDao {
	
	public void saveUser(BankUser user) {
		try(Connection conn = ConnectionUtil.getConnection()){
		String sql = "INSERT INTO User_Account (firstname, lastname, username, password) VALUES" + "(?,?,?,?) Returning Account_id";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, user.getFirstname());
		ps.setString(2, user.getLastname());
		ps.setString(3, user.getUsername());
		ps.setString(4, user.getPassword());
		
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			int id = rs.getInt("account_id");
			user.setAccount_id(id);
			user = new BankUser();
		}
		}catch (SQLException e) {
		e.printStackTrace();
		}
	
	}
}
