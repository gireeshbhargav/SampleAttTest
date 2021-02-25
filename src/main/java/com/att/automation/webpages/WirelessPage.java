package com.att.automation.webpages;

import org.openqa.selenium.WebDriver;
	
	public class WirelessPage extends BasePage {
	
		public WirelessPage(WebDriver driver) {
			super(driver);
			waitUntilVisible(repo.wirelessHeaderEle, 5);
		}
		
		public String getTitle() {
			return driver.getTitle();
		} 
		
		public String getHeader() {
			String header = getText(repo.wirelessHeaderEle);
			return header;
		}
}
