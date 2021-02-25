package com.att.automation.webpages;

import org.openqa.selenium.WebDriver;

public class DealsPage extends BasePage{
	
	public DealsPage(WebDriver driver) {
		super(driver);
		waitUntilVisible(repo.dealsHeaderEle, 5);
		
	}
	
	public String getTitle() {
		return driver.getTitle();
	} 

}
