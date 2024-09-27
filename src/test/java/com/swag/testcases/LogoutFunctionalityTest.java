package com.swag.testcases;

import java.io.IOException;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.swag.basetest.CommonToAllTest;
import com.swag.pom.LoginPage;
import com.swag.pom.MenuBar;
import com.swag.resources.ScreenShot;

public class LogoutFunctionalityTest{
	

	public MenuBar menuBar;
	public LoginPage loginPage;
	public CommonToAllTest commonToAllTest;
	
	public LogoutFunctionalityTest() throws IOException
	{
		super();
		menuBar = new MenuBar();
		loginPage = new LoginPage();
		commonToAllTest =  new CommonToAllTest();
	
	}
	
	
	@Test(priority = 5, description = "Logout Functionality", groups = {"functionalTest"})
	public void LogoutFunctionality() throws IOException
	{
		menuBar.clickOnMenuButton();
		menuBar.clickOnLogoutButton();
		ScreenShot.getScreenShot("Logout");
		String expectedResult = loginPage.getLoginText();
		
		Assertions.assertThat(expectedResult).isNotNull().isNotBlank().contains(commonToAllTest.getProperties().getProperty("Logout_Result"));
	}

}
