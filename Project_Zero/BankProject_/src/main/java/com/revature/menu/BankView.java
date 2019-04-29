package com.revature.menu;

import com.revature.util.ScannerUtil;
import com.revature.userservice.BankService;

public class BankView implements View {
	
	BankService bankService = new BankService();
	
	public View printOptions() {
		System.out.println("Bank Menu");

		System.out.println("1. Make a Deposit: ");
		System.out.println("2. Make a Withdraw: ");
		System.out.println("3. View Balance: ");
		System.out.println("4. Transfer Money: ");
		System.out.println("5. Create another count: ");
		System.out.println("0. Quiet: ");

		int selection = ScannerUtil.getNumericChoice(5);

		switch (selection) {
		case 0:return new MainMenu();
		
		case 1:BankService.Deposit();
				return this;
		
		case 2:BankService.Withdrawn();
				return this;
				
		case 3:BankService.ShowBalance();
				return this;
				
		case 4:BankService.Transfer();
				return this;
				
		case 5:BankService.Initial();
				return this;
		}
		return null;

}
}
