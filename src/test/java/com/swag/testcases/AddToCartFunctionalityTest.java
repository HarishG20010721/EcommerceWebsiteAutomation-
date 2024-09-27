package com.swag.testcases;

import java.io.IOException;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.swag.basetest.CommonToAllTest;
import com.swag.pom.CartPage;
import com.swag.pom.ProductListPage;
import com.swag.resources.ScreenShot;

public class AddToCartFunctionalityTest {
	
	public ProductListPage productListPage;
	public CartPage cartPage;
	public CommonToAllTest commonToAllTest;
	
	public AddToCartFunctionalityTest() throws IOException
	{
		super();
		productListPage = new ProductListPage();
		cartPage = new CartPage();
		commonToAllTest = new CommonToAllTest();
	}
	
	
	@Test(priority = 3, description = "Add To Cart Functionality", groups = {"functionalTest"})
	public void addToCartFunctionality() throws IOException
	{	
		productListPage.addTocart(commonToAllTest.getProperties().getProperty("Product_Name"));
		productListPage.clickOnCartLink();
		ScreenShot.getScreenShot("AddToCart");
		String expectedResult = cartPage.getCartHeaderText();
		Assertions.assertThat(expectedResult).isNotNull().isNotBlank().contains(commonToAllTest.getProperties().getProperty("Cart_Header"));
		
	}
	
	

}
