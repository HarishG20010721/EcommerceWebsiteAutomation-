package com.swag.pom;

import org.openqa.selenium.By;

import com.swag.base.CommonToAllPages;

public class MenuBar extends CommonToAllPages {
	
	public MenuBar()
	{
		super();
	}
	
	// Locators
	
	By burger_menu_button = By.xpath("//div[@class='bm-burger-button']/button");
	By logout_link =By.id("logout_sidebar_link");
	
	
	// Actions 
	
	public void clickOnMenuButton()
	{
		getElement(burger_menu_button).click();
	}
	
	public void clickOnLogoutButton() {
//		presenceOfElement(logout_link);
		JseClickOnElement(logout_link);
	}

	public LoginPage afterLogout()
	{
		return new LoginPage(); 
	}

}
