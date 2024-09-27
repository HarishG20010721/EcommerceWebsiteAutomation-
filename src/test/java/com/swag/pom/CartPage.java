package com.swag.pom;

import org.openqa.selenium.By;

import com.swag.base.CommonToAllPages;

public class CartPage extends CommonToAllPages {
	
	public CartPage()
	{
		super();
	}
	
	// Locators
	
	By cardHeader = By.xpath("//span[@class='title']");
	By checkOutButton = By.id("checkout");
	
	
	// Actions
	
	public String getCartHeaderText()
	{
		return getElement(cardHeader).getText();
	}
	
	public void clickOnCheckOutButton() 
	{
		getElement(checkOutButton).click();
	}

	
	// After Cart Page
	public CheckOutPage checkOutPage()
	{
		return new CheckOutPage();
	}
}
