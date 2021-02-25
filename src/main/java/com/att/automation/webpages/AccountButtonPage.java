package com.att.automation.webpages;

import org.openqa.selenium.WebDriver;

public class AccountButtonPage extends BasePage {

	public AccountButtonPage(WebDriver driver) {
		super(driver);
		waitUntilVisible(repo.accountButton, 5);
	}
	
	public String[] expectedDropdownList() {
		String[] dropdownListExpected= new String[7];
		
		dropdownListExpected[0] = ("Sign in");
		dropdownListExpected[1] = ("Account overview");
		dropdownListExpected[2] = ("View & pay bill");
		dropdownListExpected[3] = ("Manage profile");
		dropdownListExpected[4] = ("Move my service");
		dropdownListExpected[5] = ("Check order status");
		dropdownListExpected[6] = ("Pay without signing in");
		return dropdownListExpected;
	}
	
}
