package com.demo.driver;

import java.io.IOException;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.demo.constants.FrameworkConstants;
import com.demo.enums.ConfigProperties;
import com.demo.utils.ReadPropertyFile;

public final class Driver {
	private Driver() {
		
	}
	public static void initDriver() throws Exception {
		if(Objects.isNull(DriverManager.getDriver())) {//to tackle the challenge of users invoking initDriver methods again in the test method
			System.setProperty("webdriver.chrome.driver",FrameworkConstants.getChromeDriverPath());
			DriverManager.setDriver(new ChromeDriver());
			DriverManager.getDriver().get(ReadPropertyFile.get(ConfigProperties.URL));	
		}
	}
	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unLoad();
		}
	}
}
