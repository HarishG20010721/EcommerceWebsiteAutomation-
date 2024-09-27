package com.swag.pom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.swag.base.CommonToAllPages;

public class ProductListPage extends CommonToAllPages {
	
	public ProductListPage()
	{
		super();
	}
	
	// Locators 
	
	By app_logo = By.xpath("//div[@class='app_logo']");
	By product_filter = By.xpath("//select[@class='product_sort_container']");
	By product_price = By.xpath("//div[@class='inventory_item_price']");
	By product_names = By.xpath("//div[@class='inventory_item_name ']");
	By addToCartButton = By.xpath("//div[@class='pricebar']/button");
	By cartLink = By.xpath("//a[@class='shopping_cart_link']");
	
	
	// Actions 
	
	public String validateAppLogo()
	{
		return presenceOfElement(app_logo).getText();
	}
	
	public void applyFilter(String filterValue)
	{
		implicitWait();
		Select option = new Select(getElement(product_filter));
		option.selectByValue(filterValue);
	}
	
	public boolean validateProductPrice() {
		
		List<WebElement> productPrices = getElements(product_price);
		List<String> prices = new ArrayList<String>();
		
		for(WebElement productPrice : productPrices)
		{
			prices.add(getElementText(productPrice).replace("$", "").trim());
		}
		
		double productPrice1 = Double.parseDouble(prices.get(0));
		double productPrice2 = Double.parseDouble(prices.get(1));
		
		if(productPrice1<productPrice2)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public boolean addTocart(String productName)
	{
		boolean productFound = false;
		
		Map<WebElement, WebElement> productsMap = new HashMap<WebElement, WebElement>();
		
		List<WebElement> productNames = getElements(product_names);
		List<WebElement> productAddToCartButtons = getElements(addToCartButton);
		
		for(int i=0;i<productNames.size();i++)
		{
			productsMap.put(productNames.get(i), productAddToCartButtons.get(i));
		}
		
		for(Entry<WebElement, WebElement> product : productsMap.entrySet())
		{
			if(product.getKey().getText().equals(productName))
			{
				product.getValue().click();
				productFound = true;
				break;
			}
		}
		
		if(productFound)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public void clickOnCartLink()
	{
		getElement(cartLink).click();
	}
	
	// After Product List
	public CartPage cartPage()
	{
		return new CartPage();
	}
	

}
