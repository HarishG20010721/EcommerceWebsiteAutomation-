package com.swag.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.swag.driver.DriverManagerTL;

public class CommonToAllPages {
	
	public CommonToAllPages()
	{
		
	}
	
	public void implicitWait() {
		DriverManagerTL.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void clickElemet(By elementLocator)
	{
		DriverManagerTL.getDriver().findElement(elementLocator).click();
	}
	
	public WebElement presenceOfElement(By elementLocator)
	{
		return new WebDriverWait(DriverManagerTL.getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(elementLocator));
	}
	
	public WebElement visibilityOfElement(By elementLocator)
	{
		return new WebDriverWait(DriverManagerTL.getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
	}
	
	public void enterInput(By elementLocator, String inputValue)
	{
		DriverManagerTL.getDriver().findElement(elementLocator).sendKeys(inputValue);
	}
	
	public WebElement getElement(By elementLocator) 
	{
		return DriverManagerTL.getDriver().findElement(elementLocator);
	}
	
	public List<WebElement> getElements(By elementLocator)
	{
		return DriverManagerTL.getDriver().findElements(elementLocator);
	}
	
	public String getElementTextByLocator(By elementLocator)
	{
		return DriverManagerTL.getDriver().findElement(elementLocator).getText();
	}
	
	public String getElementText(WebElement webElement)
	{
		return webElement.getText();
	}
	
	public void waitForElementToBeVisible(WebElement webElement, String Url) 
	{	
		WebDriverWait wait = new WebDriverWait(DriverManagerTL.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(webElement));
		wait.until(ExpectedConditions.urlContains(Url));
	}
	
	// JavaScript executer
	
	public void JseClickOnElement(By elementlocator)
	{
		JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverManagerTL.getDriver();
		jsExecutor.executeScript("arguments[0].click();", getElement(elementlocator));
	}
	
	
	public Properties getProperties() throws IOException {
		
		FileInputStream file =  new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/TestData.properties");
		Properties properties = new Properties();
		properties.load(file);
		return properties;	
	}

}
