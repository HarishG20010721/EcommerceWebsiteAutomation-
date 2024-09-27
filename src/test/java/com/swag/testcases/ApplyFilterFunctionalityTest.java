package com.swag.testcases;

import java.io.IOException;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.swag.basetest.CommonToAllTest;
import com.swag.pom.ProductListPage;

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
	public void filterFunctionality()
	{
		try {
			productListPage.applyFilter(commonToAllTest.getProperties().getProperty("Filter_Options"));
			boolean expectedResult = productListPage.validateProductPrice();
			Assertions.assertThat(expectedResult).isTrue();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	

}
