package com.revature.Service;

import java.security.NoSuchAlgorithmException;

import com.revature.Dao.LoginDao;
import com.revature.Util.HttpException;
import com.revature.bean.Credentials;
import com.revature.bean.ErsUsers;

public class LoginService {
	
	LoginDao loginDao = new LoginDao();
	
	public static int Currentid;
	public static int EmployeeRoleid;
	
	public int login(Credentials credentials) {
		
		//If the credentials lacks a password or user name will give a HttpException with status 422
		
		if(credentials.getPassword() == null || credentials.getUsername() == null) {
			System.out.println("not working");
			
			throw new HttpException(422);
		}
		
		//attempt to retrieve username/password from database and compares them
		
		ErsUsers user = loginDao.getPasswordByUsername(credentials.getUsername());
		
		System.out.println(user);
		
		//if returned user password does not match credentials password, throw HttpException with status 400
		if(!user.getERS_PASSWORD().equals(credentials.getPassword())) {				
			throw new HttpException(400);
		}
			
		//if returned user password matches credentials password, return integer value equal to the id on the returned user object
		
		Currentid = user.getERS_USERS_ID();
	
		
		
		System.out.println("the loginDao part is working :" +Currentid); 
		
		
	
		return user.getERS_USERS_ID();
		
		
	}
	
	public String getfirstname(Credentials credentials) throws NoSuchAlgorithmException {
				
		ErsUsers user = loginDao.getPasswordByUsername(credentials.getUsername());
	
	return user.getERS_FIRST_NAME();
			
	}
	
	public String getlastname(Credentials credentials) throws NoSuchAlgorithmException {
		
		ErsUsers user = loginDao.getPasswordByUsername(credentials.getUsername());
	
	return user.getERS_LAST_NAME();
			
	}
	
	public int getRole(Credentials credentials) throws NoSuchAlgorithmException {
		
		ErsUsers user = loginDao.getPasswordByUsername(credentials.getUsername());
	
	return user.getUSER_ROLE_ID();
			
	}
	

	public LoginService (LoginDao loginDao) {
		super();
		this.loginDao = loginDao;
	}
	
	public LoginService() {
		super();
		this.loginDao = new LoginDao();
	}

}
