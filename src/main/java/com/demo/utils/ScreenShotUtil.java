package com.demo.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.demo.driver.DriverManager;

public final class ScreenShotUtil {
	
	private ScreenShotUtil() {
		
	}
	
	public static String getBase64Image() {
		return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}

}
