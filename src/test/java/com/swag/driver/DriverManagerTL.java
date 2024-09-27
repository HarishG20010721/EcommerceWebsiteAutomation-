package com.swag.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManagerTL {
	
	private static final ThreadLocal<WebDriver> THREAD_LOCAL = new ThreadLocal<WebDriver>();
	
	public static void setDriver(WebDriver driver) 
	{
		THREAD_LOCAL.set(driver);
	}
	
	public static WebDriver getDriver()
	{
		return THREAD_LOCAL.get();
	}
	
	public static void unLoad()
	{
		THREAD_LOCAL.remove();
	}
	
	public static void down()
	{
		if(Objects.nonNull(getDriver()))
		{
			getDriver().quit();
			unLoad();
		}
	}
	
	public static void init()
	{
		if(Objects.isNull(getDriver()))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--guest");
			options.addArguments("--remote-allow-origins=*");
			WebDriver driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			setDriver(driver);
			
		}
	}

}
