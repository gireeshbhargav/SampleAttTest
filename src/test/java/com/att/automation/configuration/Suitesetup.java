package com.att.automation.configuration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Suitesetup {
	
	protected WebDriver driver;
	
	public void init(WebDriver driver) {
		this.driver = driver;
		
	}
	

	@BeforeTest
	public void launch() {
			
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
	}
	
	@AfterTest
	public void quit() {
		driver.close();
	}
}
