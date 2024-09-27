package com.swag.pom;

import java.io.IOException;

import org.openqa.selenium.By;

import com.swag.base.CommonToAllPages;
import com.swag.driver.DriverManagerTL;

public class LoginPage extends CommonToAllPages{
	
	public LoginPage()
	{
		super();
	}
	
	// Locators
	By user_name = By.id("user-name");
	By password = By.id("password");
	By login_button = By.id("login-button");
	By error = By.xpath("//h3[@data-test='error']");
	
	
	// Actions
	
	public void openUrl() throws IOException 
	{
		DriverManagerTL.getDriver().get(getProperties().getProperty("Url"));
	}
	
	public void enterUserName(String user_name) 
	{
		enterInput(this.user_name, user_name);
	}
	
	public void enterpassword(String password)
	{
		enterInput(this.password, password);
	}
	
	public void clickOnLoginButton() {
		clickElemet(login_button);
	}
	
	public String getError()
	{
		return getElementTextByLocator(error);
	}
	
	public String getLoginText()
	{
		return getElement(login_button).getAttribute("value");
	}
	
	// After Login Page
	public ProductListPage afterLogin()
	{
		return new ProductListPage();
	}
}
