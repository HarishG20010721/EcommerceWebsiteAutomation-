package com.swag.pom;

import org.openqa.selenium.By;

import com.swag.base.CommonToAllPages;

public class CheckOutPage extends CommonToAllPages {
	
	public CheckOutPage()
	{
		super();
	}
	
	// Locators
	
	By first_name = By.id("first-name");
	By last_name = By.id("last-name");
	By postal_code = By.id("postal-code");
	By continue_button = By.id("continue");
	
	
	// Actions
	
	public void enterFirstName(String first_name) 
	{
		getElement(this.first_name).sendKeys(first_name);
	}
	
	public void enterLastName(String last_name)
	{
		getElement(this.last_name).sendKeys(last_name);
	}
	
	public void enterPostalCode(String postal_code)
	{
		getElement(this.postal_code).sendKeys(postal_code);
	}
	
	public void clickOnContinueButton()
	{
		getElement(continue_button).click();
	}
	
	
	// After Check Out Page

}
