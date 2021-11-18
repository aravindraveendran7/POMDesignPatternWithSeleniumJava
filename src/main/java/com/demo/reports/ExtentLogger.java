package com.demo.reports;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.demo.driver.DriverManager;
import com.demo.enums.ConfigProperties;
import com.demo.utils.ReadPropertyFile;
import com.demo.utils.ScreenShotUtil;

public final class ExtentLogger {
	
	private ExtentLogger() {}

	
	public static void pass(String message) {
		ExtentManger.getExtentTest().pass( message);
	}

	public static void fail(String message) {
		ExtentManger.getExtentTest().pass( message);
	}
	
	
	public static void skip(String message) {
		ExtentManger.getExtentTest().pass( message);
	}
	
	public static void pass(String message,boolean isscreenshotrequired) throws Exception {
		if (ReadPropertyFile.get(ConfigProperties.PASSSTEPSCREENSHOT).equalsIgnoreCase("yes")&&
				isscreenshotrequired) {
			ExtentManger.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtil.getBase64Image()).build());
		}
		else {
			pass(message);
		}
	}
	
	public static void fail(String message,boolean isscreenshotrequired) throws Exception {
		if (ReadPropertyFile.get(ConfigProperties.FAILEDSTEPSCREENSHOT).equalsIgnoreCase("yes")&&
				isscreenshotrequired) {
			ExtentManger.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtil.getBase64Image()).build());
		}else {
			fail(message);
		}
	}
	
	public static void skip(String message,boolean isscreenshotrequired) throws Exception {
		if (ReadPropertyFile.get(ConfigProperties.SKIPPEDSTEPSCREENSHOT).equalsIgnoreCase("yes")&&
				isscreenshotrequired) {
			ExtentManger.getExtentTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtil.getBase64Image()).build());
		}else {
			skip(message);
		}
	}

	
}
