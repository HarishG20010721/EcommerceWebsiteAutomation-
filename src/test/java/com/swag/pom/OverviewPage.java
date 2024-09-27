package com.swag.pom;

import org.openqa.selenium.By;

import com.swag.base.CommonToAllPages;

public class OverviewPage extends CommonToAllPages {
	
	public OverviewPage()
	{
		super();
	}
	
	// Locators
	
	By overViewHeader = By.xpath("//span[@class='title']");
	
	
	// Actions
	
	public String getHeaderText()
	{
		return getElement(overViewHeader).getText();
	}

}
