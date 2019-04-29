package com.revature.menu;

import com.revature.userservice.BankService;
import com.revature.userservice.UserService;
import com.revature.util.ScannerUtil;


public class MainMenu implements View{
	
	public MainMenu() {
		
	}
	
	UserService userService = new UserService();

	
	@Override
	public View printOptions() {
		System.out.println("1.Login:");
		System.out.println("2.Create User");
		System.out.println("0. Quit");
	
		int selection = ScannerUtil.getNumericChoice(4);
		
		switch(selection) {		
		case 1:this.userService.getUserUsername(); 
			return new BankView();
		case 2: this.userService.createUser();
			return BankService.Initial();
			
		default: return null;
		}
}
}

