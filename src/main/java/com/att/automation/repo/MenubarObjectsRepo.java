package com.att.automation.repo;

import org.openqa.selenium.By;

public class MenubarObjectsRepo {

	public static final By mainMenuElementsList = By.xpath("//*[@id='tab-desktop-menu']/li/a");
	
	public static final By sideMenuItemsList = By.xpath("//*[@class='lg-submenu open active']/li/a[@role='menuitem']");
	
	public static final By menuButton = By.xpath("//*[@id='z1-pullMenu-open']");
	
}
