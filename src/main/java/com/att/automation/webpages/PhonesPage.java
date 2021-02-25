package com.att.automation.webpages;

import org.openqa.selenium.WebDriver;

public class PhonesPage extends BasePage{
		
		public PhonesPage(WebDriver driver) {
			super(driver);
			waitUntilVisible(repo.phonesHeaderEle, 5);
		}
		
		public String getTitle() {
			return driver.getTitle();
		} 
		
		public String getHeader() {
			String header = getText(repo.phonesHeaderEle);
			return header;
		}
		
}
