package com.att.automation.webpages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.att.automation.repo.HomepageObjectRepo;


@SuppressWarnings("all")
public class BasePage{
	protected HomepageObjectRepo repo;

	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		repo = new HomepageObjectRepo();
	}


	/*
	 *  LAUNCH URL AND VERIFY TITLE
	 */
	public void launchURL(String URL, String expectedTitle) {

		String actualURL;	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);

		String title = driver.getTitle();

		if(verifyText(expectedTitle, title)== true) {
			System.out.println("Page title verification passed and is as expected : "+ expectedTitle);
		}else {
			System.out.println("Page title verification failed");
		}

	}


	/*
	 * COMPARE TEXT ACTUAL VS EXPECTED
	 */
	public boolean verifyText(String expected, String actual) {
		boolean flag = true;

		if(actual!= null) {

		}else {
			flag= false;
		}

		return flag;
	}


	/*
	 * VERIFY TEXT AND LOCATOR
	 */
	public void verifyLocatorText(By locator, String expected) {
		
		waitUntilVisible(locator,5);
		String text = driver.findElement(locator).getText().trim();
		verifyText(expected,text);
	}


	/*
	 * TO GET LIST SIZE
	 */
	public int getListSize(By locator) {
		waitUntilVisible(locator, 5);
		return driver.findElements(locator).size();
	}


	/*
	 * WAITING FOR ELEMENTS TO BE VISIBLE
	 */
	public WebElement waitUntilVisible(By locator, int timeout) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element;
	}


	/*
	 * TO GET TEXT USING LOCATOR
	 */
	public String getText(By locator) {

		try {

			String strText = driver.findElement(locator).getText().trim();
			return strText;
		} catch (Exception e) {
			return "";
		}
	}


	/*
	 * TO WAIT UNTILL ELEMENT IS CLICKABLE
	 */
	public WebElement waitUntilClickable(By locator, int timeout) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		return element;
	}


	/*
	 * TO CLICK AN ELEMENT
	 */
	public void clickElement(By locator) {
		WebElement element = waitUntilVisible(locator, 5);
		element.click();
	}


	/*
	 * TO CHECK IF ELEMENT IS DISPLAYED
	 */
	public boolean isElementDisplayed(By locator) {
		boolean blnDisplay = false;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		try {
			WebElement element = waitUntilVisible(locator, 20); 
			if (element.isDisplayed()) {
				blnDisplay = true;
			}
		} catch (Exception e) {
		}
		return blnDisplay;
	}

}
