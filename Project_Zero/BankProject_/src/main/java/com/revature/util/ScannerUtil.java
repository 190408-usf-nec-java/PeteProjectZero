package com.revature.util;

import java.util.Scanner;

public class ScannerUtil {
	protected static Scanner scanner = new Scanner(System.in);

	public static int getNumericChoice(int max) {
		int choice = -1;
		
		while(choice < 0 || choice > max) {
			System.out.println("Insert a whole number between "
					+ "0 and " + max + ".");
			
			if(scanner.hasNext()) {
				if(!scanner.hasNextInt()) {
					scanner.nextLine();
					continue;
				}
				choice = scanner.nextInt();
				// Next int will leave the new line character
				// after the user hit enter in the buffer
				// nextLine will clear the buffer out
				scanner.nextLine();
			}
		}
		
		return choice;
	}
	
	public static int getint() {
		return scanner.nextInt();
	}
	
	public static String getLine() {
		return scanner.nextLine();
	}
	
	public static double getNum() {
		return scanner.nextDouble();
	}
	
//Trying to set the rules for Cash Handling	
	public static double getCash(double amount) {
		double money = -1;
	while(money < 0) {
		System.out.println("Please insert the amount: " +amount);
		if(scanner.hasNext()) {
			if(!scanner.hasNextInt()) {
				scanner.nextLine();
				continue;
			}
		money = scanner.nextInt();
		scanner.nextLine();
		}
	
		}	
	return money;
	}	
}