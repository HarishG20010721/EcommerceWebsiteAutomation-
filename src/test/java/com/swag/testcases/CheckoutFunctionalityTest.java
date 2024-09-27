package com.swag.testcases;

import java.io.IOException;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.swag.basetest.CommonToAllTest;
import com.swag.pom.CartPage;
import com.swag.pom.CheckOutPage;
import com.swag.pom.OverviewPage;

public class CheckoutFunctionalityTest {
	
	public CartPage cartPage;
	public CheckOutPage checkOutPage;
	public OverviewPage overviewPage;
	public CommonToAllTest commonToAllTest;
	
	public CheckoutFunctionalityTest() throws IOException
	{
		super();
		cartPage = new CartPage();
		checkOutPage = new CheckOutPage();
		overviewPage = new OverviewPage();
		commonToAllTest = new CommonToAllTest();
	}
	
	@Test(priority = 4, description = "Check Out Functionality", groups = {"functionalTest"})
	public void checkOutFunctionality() throws IOException
	{
		cartPage.clickOnCheckOutButton();
		checkOutPage.enterFirstName(commonToAllTest.getProperties().getProperty("First_Name"));
		checkOutPage.enterLastName(commonToAllTest.getProperties().getProperty("Last_Name"));
		checkOutPage.enterPostalCode(commonToAllTest.getProperties().getProperty("Postal_Code"));
		checkOutPage.clickOnContinueButton();
		
		String expectedResult = overviewPage.getHeaderText();
		
		Assertions.assertThat(expectedResult).isNotNull().isNotBlank().contains(commonToAllTest.getProperties().getProperty("OverView_Header"));
	}
	
	

}
