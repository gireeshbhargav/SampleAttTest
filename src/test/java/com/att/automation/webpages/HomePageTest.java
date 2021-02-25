package com.att.automation.webpages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.att.automation.common.AutomationConstants;
import com.att.automation.configuration.Suitesetup;


public class HomePageTest extends Suitesetup {

	/*
	 * TO VERIFY THE NUMBER OF CONTAINERS PRESENT ON HOMEPAGE TO CHECK FOR PAGELOAD
	 */
	@Test (priority = 0)
	public void containersCountAndHeaderVerification() {

		HomePage hmo = new HomePage(driver);
		int containersCount = hmo.getHomePageContainersCount();
		assertEquals(containersCount, 7);

	}


	/*
	 * TO VERIFY DEALS OPTION IS CLICKABLE ON HOMEPAGEAND VERIFY ITS TITLE
	 */
	@Test(priority =1)
	public void dealsVerification() {

		HomePage hmo = new HomePage(driver);
		DealsPage dp= hmo.clickonDeals();
		assertTrue(dp.getTitle().equalsIgnoreCase(AutomationConstants.dealsTitle));

	}


	/*
	 * TO VERIFY PHONES OPTION IS CLICKABLE ON HOMEPAGEAND VERIFY ITS TITLE & HEADER
	 */
	@Test(priority=2)
	public void phonesAndDevicesVerification() {

		HomePage hmo = new HomePage(driver);
		PhonesPage pg = hmo.clickOnPhones();
		assertTrue(pg.getTitle().equalsIgnoreCase(AutomationConstants.phonesPageTitle));
		assertTrue(pg.getHeader().equalsIgnoreCase(AutomationConstants.phonesPageHeader));

	}


	/*
	 * TO VERIFY WIRELESS OPTION IS CLICKABLE ON HOMEPAGEAND VERIFY ITS TITLE & HEADER
	 */
	@Test(priority=3)
	public void wirelesssVerification() {

		HomePage hmo = new HomePage(driver);
		WirelessPage wp = hmo.clickOnWireless();
		assertTrue(wp.getTitle().equalsIgnoreCase(AutomationConstants.wirelessPageTitle));
		assertTrue(wp.getHeader().equalsIgnoreCase(AutomationConstants.wirelessPageHeader));
	}



	/*
	 * TO CLICK AND VERIFY IF ACCOUNT DROPDOWN LIST IS AS EXPECTED ON HOMEPAGE
	 */ 
	@Test(priority=4)
	public void accountButtonVerification() {

		HomePage hmo = new HomePage(driver);
		AccountButtonPage ap = hmo.clickAccountDropdown();
		assertEquals( hmo.getAccountButtonDropdownList(), ap.expectedDropdownList());
	}


	/*
	 * TO VERIFY IF THE LIST OF HEADBAND ELEMENTS DISPLAYED ON HOMEPAGE ARE AS EXPECTED
	 */
	@Test(priority=5)
	public void headBandElementsVerification() {

		HomePage hmo = new HomePage(driver);
		assertEquals(hmo.getHeadBandListActual(), hmo.expectedHeadBandList());
	}



	@Test(priority=6)
	public void mainMenuBarListVerification() {

		HomePage hmo = new HomePage(driver);
		assertEquals(hmo.mainMenuListVerification(), AutomationConstants.expectedMainMenuList);
	}
}

