package com.revature.launcher;

import com.revature.menu.MainMenu;
import com.revature.menu.View;


public class Launcher {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		View view = new MainMenu();
		
		while(view != null) {
			view = view.printOptions();
		}
		System.out.println("The end");		
	}
}
