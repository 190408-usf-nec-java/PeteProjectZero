package com.revature.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.Util.ConnectionUtil;
import com.revature.Util.HttpException;
import com.revature.bean.ErsUsers;

public class LoginDao {
	
	
	public ErsUsers getPasswordByUsername(String username) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * from ers_users where ers_username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int ERS_USERS_ID = rs.getInt("ERS_USERS_ID");
				String ERS_PASSWORD = rs.getString("ERS_PASSWORD");
				String ERS_FIRST_NAME = rs.getString("user_FIRST_NAME");
				String ERS_LAST_NAME = rs.getString("user_LAST_NAME");
				String USER_EMAIL = rs.getString("USER_EMAIL");
				int USER_ROLE_ID = rs.getInt("USER_ROLE_ID");
								
				return new ErsUsers(ERS_USERS_ID, username, ERS_PASSWORD, ERS_FIRST_NAME, ERS_LAST_NAME, USER_EMAIL, USER_ROLE_ID);
				

			}else {
			throw new HttpException(400);
		}
			
		} catch(SQLException e) {
			e.printStackTrace();
			throw new HttpException(500);
		}
	}
}

