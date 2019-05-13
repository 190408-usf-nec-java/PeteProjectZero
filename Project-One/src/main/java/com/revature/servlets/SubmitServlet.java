package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Dao.SubmitDao;
import com.revature.Service.LoginService;
import com.revature.bean.ErsReimbursement;

public class SubmitServlet extends DefaultServlet{
	
	
	SubmitDao submitDao = new SubmitDao();

	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.addHeader("Access-Control-Allow-Headers", "content-type");
		response.addHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.addHeader("Access-Control-Allow-Methods", "POST, PUT");
		super.service(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException{
		
		ObjectMapper om = new ObjectMapper();
		ErsReimbursement reimburs = om.readValue(request.getInputStream(), ErsReimbursement.class);
		
		System.out.println("the SubmitServlet current id :" +LoginService.Currentid); 
		submitDao.SubmitTicket(reimburs);
		
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException{
		
		ObjectMapper om = new ObjectMapper();
		ErsReimbursement reimburs = om.readValue(request.getInputStream(), ErsReimbursement.class);
		
		submitDao.ManagerDecision(reimburs);
	}
}

