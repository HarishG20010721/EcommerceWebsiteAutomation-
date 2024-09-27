package com.swag.testcases;

import java.io.IOException;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.swag.basetest.CommonToAllTest;
import com.swag.pom.ProductListPage;
import com.swag.resources.ScreenShot;

public class ApplyFilterFunctionalityTest {
	
	public ProductListPage productListPage;
	public CommonToAllTest commonToAllTest;
	
	public ApplyFilterFunctionalityTest() throws IOException
	{
		super();
		if(productListPage == null)
		{
			productListPage = new ProductListPage();
			commonToAllTest = new CommonToAllTest();
		}
	}
	
	@Test(priority = 2, description = "Filter Functionality Test", groups = {"functionalTest"})
	public void filterFunctionality() throws IOException
	{
		productListPage.applyFilter(commonToAllTest.getProperties().getProperty("Filter_Options"));
		boolean expectedResult = productListPage.validateProductPrice();
		ScreenShot.getScreenShot("Filter");
		Assertions.assertThat(expectedResult).isTrue();	
		
	}
	

}
