package com.swag.basetest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.swag.driver.DriverManagerTL;

public class CommonToAllTest {
	
	@BeforeTest(groups = {"main"})
	public void Setup() 
	{
		DriverManagerTL.init();
	}
	
	@AfterTest(groups = {"main"})
	public void TearDown()
	{
		DriverManagerTL.down();
	}
	
	public Properties getProperties() throws IOException {
		
		FileInputStream file =  new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/TestData.properties");
		Properties properties = new Properties();
		properties.load(file);
		return properties;	
	}

}
