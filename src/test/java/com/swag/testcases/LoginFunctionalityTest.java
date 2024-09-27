package com.swag.testcases;

import java.io.IOException;
import java.util.Properties;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.swag.pom.LoginPage;
import com.swag.pom.ProductListPage;
import com.swag.resources.ScreenShot;


public class LoginFunctionalityTest{
	
	Properties properties;
	LoginPage loginPage;
	ProductListPage productListPage;
	
	public LoginFunctionalityTest() throws IOException
	{
		if(loginPage == null) {
			loginPage = new LoginPage();
			properties = loginPage.getProperties();
		}
	}
	
	@Test(priority = 1, description = "Swag Lab Positive Scenario", groups = {"functionalTest","loginPositiveScenario"})
	public void loginPositiveScenario() throws IOException
	{	
		loginPage.openUrl();
		loginPage.enterUserName(properties.getProperty("Username"));
		loginPage.enterpassword(properties.getProperty("Password"));
		ScreenShot.getScreenShot("loginPositiveScenario");
		loginPage.clickOnLoginButton();
		
		productListPage = loginPage.afterLogin();
		String expectedResult = productListPage.validateAppLogo();
		
		Assertions.assertThat(expectedResult).isNotNull().isNotBlank().contains(properties.getProperty("Expected_Result"));
		
	}
	
	@Test(priority = 2, description = "Swag Lab Negative Scenario", groups = {"loginNegativeScenario"})
	public void loginNegativeScenario() throws IOException
	{
		loginPage.openUrl();
		loginPage.enterUserName(properties.getProperty("Username"));
		loginPage.enterpassword(properties.getProperty("Invalid_Password"));
		loginPage.clickOnLoginButton();
		ScreenShot.getScreenShot("loginNegativeScenario");
		
		String error = loginPage.getError();
		
		Assertions.assertThat(error).isNotNull().isNotBlank().contains(properties.getProperty("Error_Result"));
	}
}
