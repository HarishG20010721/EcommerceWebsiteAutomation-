package com.swag.resources;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import com.swag.driver.DriverManagerTL;

public class ScreenShot {
	
	public ScreenShot()
	{
		
	}
	
	public static void getScreenShot(String imgName) throws IOException
	{
		File srcFile =((TakesScreenshot)DriverManagerTL.getDriver()).getScreenshotAs(OutputType.FILE);
		File trgFile = new File(System.getProperty("user.dir")+"\\screenshot\\"+imgName+".png");
		FileUtils.copyFile(srcFile, trgFile);
	}

}
