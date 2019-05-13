package com.revature.Dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.Service.LoginService;
import com.revature.Util.ConnectionUtil;
import com.revature.bean.ErsReimbursement;

public class SubmitDao {
	//===============================================SubmitTicket=======================================
	
	public void SubmitTicket(ErsReimbursement reimburs) {
		

		try(Connection conn = ConnectionUtil.getConnection()){
		String sql = "Insert into ers_reimbursement (REIM_AMMOUNT, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_STATUS_ID, REIMB_TYPE_ID) values (?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		//ps.setInt(1, reimburs.getId());
		ps.setDouble(1, reimburs.getAmount());
		ps.setString(2, reimburs.getDescription());
		ps.setInt(3, LoginService.Currentid);
		//ps.setInt(4, reimburs.getResolver());
		ps.setInt(4, reimburs.getStatus_Id());
		ps.setInt(5, reimburs.getType_Id());
		
		System.out.println("this should be the author id: " +LoginService.Currentid);
		
		
		ps.execute();

		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	//=========================================ManagerDecision==============================================
	
	public void ManagerDecision(ErsReimbursement reimburs) {
	
	try(Connection conn = ConnectionUtil.getConnection()){
		String sql = "Update ers_reimbursement set reimb_resolver = 1, REIMB_RESOVLED = now(), REIMB_STATUS_ID = ? WHERE reim_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, reimburs.getStatus_Id());
		ps.setInt(2, reimburs.getId());
		
		ps.executeUpdate();
		
		}catch(SQLException e){
			e.printStackTrace();
			
		}
	}

}
