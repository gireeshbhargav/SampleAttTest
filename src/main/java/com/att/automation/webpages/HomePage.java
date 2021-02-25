package com.att.automation.webpages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.att.automation.common.AutomationConstants;
import com.att.automation.repo.MenubarObjectsRepo;



@SuppressWarnings("all")
public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		launchURL(AutomationConstants.homepageURL, AutomationConstants.homepageTitle);
	}


	/*
	 * TO GET SIZE OF CONTAINERS PRESENT ON HOMEPAGE
	 */
	public int getHomePageContainersCount() {
		List<WebElement> list = driver.findElements(repo.container);
		return  driver.findElements(repo.container).size();	
	}

	
	/*
	 * TO GET THE LIST OF HEADBAND ELEMENTS ON HOMEPAGE DYNAMICALLY
	 */
	public String[] getHeadBandListActual() {
		String[] listOfHeadBandElements = new String[7];
		String headBandText;

		List<WebElement> list = driver.findElements(repo.container);
		int listSize =  driver.findElements(repo.headBand).size();

		if(listSize == 7) {
			for(int i=0; i< listSize; i++) {
				By headElement = By.xpath("//*[@id='HEADBAND0']/ul/li["+(i+1)+"]");
				waitUntilVisible(headElement,5);
				headBandText = driver.findElement(headElement).getText();
				listOfHeadBandElements[i] = headBandText.trim();
			}
		}else {
			System.out.println("The total number of elements: "+listSize+" on headband doesn't match");
		}
		return listOfHeadBandElements;
	}

	/*
	 * TO CLICK HEADBAND ELEMENTS ON HOMEPAGE BASED ON TEXT
	 */
	public void clickHeadBandByLocator(String textHeader) {

		switch (textHeader) {
		case "Deals":
			verifyLocatorText(repo.dealsElement,textHeader);
			waitUntilClickable(repo.dealsElement, 5);
			clickElement(repo.dealsElement);
			break;

		case "Phones & devices":
			verifyLocatorText(repo.phonesElement,textHeader);
			waitUntilClickable(repo.phonesElement, 5);
			clickElement(repo.phonesElement);
			break;

		case "Wireless":
			verifyLocatorText(repo.wirelessElement,textHeader);
			waitUntilClickable(repo.wirelessElement, 5);
			clickElement(repo.wirelessElement);
			break;

		case "Internet":
			verifyLocatorText(repo.internetElement,textHeader);
			waitUntilClickable(repo.internetElement, 5);
			clickElement(repo.internetElement);
			break;

		case "TV":
			verifyLocatorText(repo.tvElement,textHeader);
			waitUntilClickable(repo.tvElement, 5);
			clickElement(repo.tvElement);
			break;

		case "Prepaid":
			verifyLocatorText(repo.prepaidElement,textHeader);
			waitUntilClickable(repo.prepaidElement, 5);
			clickElement(repo.prepaidElement);
			break;

		case "Bundles":
			verifyLocatorText(repo.bundlesElement,textHeader);
			waitUntilClickable(repo.bundlesElement, 5);
			clickElement(repo.bundlesElement);
			break;

		default:
			break;
		}

	}

	/*
	 * TO GET LIST OF ELEMENTS PRESENT UNDER ACCOUNT DROPDOWN
	 */
	public String[] getAccountButtonDropdownList() {
		String[] dropDownList= new String[7];

		waitUntilVisible(repo.dropdwonListElements,5);
		if(isElementDisplayed(repo.dropdwonListElements)) {
			int listSize =  driver.findElements(repo.dropdwonListElements).size();

			for(int i=0;i<listSize;i++) {
				By dropdownListLoc = By.xpath("//*[@class='parsys cta section']/ul/li["+(i+1)+"]/a/span");
				String dropdownText = getText(dropdownListLoc);
				dropDownList[i]= dropdownText.trim();
			}
		}
		return	dropDownList;

	}

	
	public DealsPage clickonDeals() {
		clickHeadBandByLocator("Deals");
		return new DealsPage(driver) ;	
	}

	public PhonesPage clickOnPhones() {
		clickHeadBandByLocator("Phones & devices");
		return new PhonesPage(driver);
	}

	public WirelessPage clickOnWireless() {
		clickHeadBandByLocator("Wireless");
		return new WirelessPage(driver);
	}

	public AccountButtonPage clickAccountDropdown() {
		waitUntilVisible(repo.accountButton, 5);
		clickElement(repo.accountButton);
		waitUntilVisible(repo.dropdownElement, 5);
		return new AccountButtonPage(driver);
	}

	public String[] expectedHeadBandList() {
		String[] expectedList = {"Deals","Phones & devices","Wireless","Internet","TV","Prepaid","Bundles"};
		return expectedList;

	}

	/*
	 *  TO GET LIST OF MAIN MENU BAR ELEMENTS
	 */
	public String[] mainMenuListVerification() {
		String[] actualMenuList= new String[9];

		waitUntilClickable(MenubarObjectsRepo.menuButton, 5);
		clickElement(MenubarObjectsRepo.menuButton);
		waitUntilVisible(MenubarObjectsRepo.mainMenuElementsList, 5);
		if(isElementDisplayed(MenubarObjectsRepo.mainMenuElementsList)) {

			int listSize =  driver.findElements(MenubarObjectsRepo.mainMenuElementsList).size();

			for(int i=0;i<9;i++) {
				By mainMenuList = By.xpath("//*[@id='tab-desktop-menu']/li["+(i+1)+"]/a/span[1]");
				String dropdownText = getText(mainMenuList);
				actualMenuList[i]= dropdownText.trim();
			}
		}

		return actualMenuList;
	}



}
