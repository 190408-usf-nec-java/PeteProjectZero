package com.revature.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.Service.LoginService;
import com.revature.Util.ConnectionUtil;
import com.revature.Util.HttpException;
import com.revature.bean.ErsReimbursement;
import com.revature.bean.ErsUsers;

public class RequestDao {
	
	//=====================================================ViewEmployeeTicketsById====================================

	
	public ArrayList ViewEmployeeTicketsById(int currentId){
		//makes a List with an empty object of ErsReimbursment bean
		ArrayList<ErsReimbursement> reimbList = new ArrayList<>();
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * from Ers_reimbursement where reimb_author = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, currentId);
			
			System.out.println("my current id at Request Dao for View Employee Ticke: " +currentId);
			
			ResultSet rs = ps.executeQuery();
			
			
			//loops through resultset and add it to LIST
			while(rs.next()) {
				int id = rs.getInt("reim_id");
				double amount = rs.getDouble("reim_ammount");
				String Description = rs.getString("reimb_description");
				int Resolver = rs.getInt("reimb_resolver");
				int Status_Id = rs.getInt("reimb_status_id");
				int Type_Id = rs.getInt("reimb_type_id");
				
				
				//Adds the result set Reimbursment into the empty Reimbursement in List
				reimbList.add(new ErsReimbursement (id, amount, Description, currentId, Resolver, Status_Id, Type_Id));
			
				
			}
			
	
		}catch(SQLException e) {
			e.printStackTrace();
			throw new HttpException(500);
		}
		return reimbList;
	}
	
	//=====================================================ViewUserByUserId====================================
	
	public ArrayList ViewUserByUserId(int currentId) {
		
		ArrayList<ErsUsers> UserList = new ArrayList<>();
		
		try(Connection conn = ConnectionUtil.getConnection()){
		String sql = "SELECT * from ers_users where ers_users_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, currentId);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			String ERS_USERNAME = rs.getString("ERS_USERNAME");
			String ERS_PASSWORD = rs.getString("ERS_PASSWORD");
			String ERS_FIRST_NAME = rs.getString("user_FIRST_NAME");
			String ERS_LAST_NAME = rs.getString("user_LAST_NAME");
			String USER_EMAIL = rs.getString("USER_EMAIL");
			int USER_ROLE_ID = rs.getInt("USER_ROLE_ID");
							
			UserList.add(new ErsUsers(currentId, ERS_USERNAME, ERS_PASSWORD, ERS_FIRST_NAME, ERS_LAST_NAME, USER_EMAIL, USER_ROLE_ID));
			

		}else {
		throw new HttpException(400);
	}
		
	} catch(SQLException e) {
		e.printStackTrace();
		throw new HttpException(500);
	}
		return UserList;
}
	
	//=====================================================ViewAllTicket for the manager by employee id====================================

	
	public ArrayList ViewAllEmployeeTicketByEmployeeid(int authorid){
		//makes a List with an empty object of ErsReimbursment bean
		ArrayList<ErsReimbursement> EmployeereimbList = new ArrayList<>();
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * from Ers_reimbursement where REIMB_AUTHOR != ? AND reimb_status_id = 0";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			System.out.println("This is authorId at RequestDao all:" +authorid);
			
			ps.setInt(1, 1);
			
			ResultSet rs = ps.executeQuery();
			
			
			//loops through resultset and add it to LIST
			while(rs.next()) {
				int id = rs.getInt("reim_id");
				double amount = rs.getDouble("reim_ammount");
				String Description = rs.getString("reimb_description");
				int author_id = rs.getInt("reimb_author");
				int resolver_id = rs.getInt("reimb_resolver");
				int Status_Id = rs.getInt("reimb_status_id");
				int Type_Id = rs.getInt("reimb_type_id");
				
				
				//Adds the result set Reimbursment into the empty Reimbursement in List
				EmployeereimbList.add(new ErsReimbursement (id, amount, Description, author_id, resolver_id, Status_Id, Type_Id));
			
				
			}
			
	
		}catch(SQLException e) {
			e.printStackTrace();
			throw new HttpException(500);
		}
		return EmployeereimbList;
	}

}
