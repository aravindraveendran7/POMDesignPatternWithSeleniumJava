package com.demo.pages;

import org.openqa.selenium.By;

import com.demo.driver.DriverManager;
import com.demo.enums.WaitStratergy;
import com.demo.factories.ExplicitWaitFactory;
import com.demo.reports.ExtentLogger;

public class BasePage {

	protected void userDefinedClick(By by,WaitStratergy waitstratergy,String elementName) {
		
		ExplicitWaitFactory.performExplicitWait(waitstratergy, by).click();
		try {
			ExtentLogger.pass(elementName+" is clicked",true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void userDefinedEnterValue(By by,String value,WaitStratergy waitstratergy,String elementname) {
		ExplicitWaitFactory.performExplicitWait(waitstratergy, by).sendKeys(value);
		try {
			ExtentLogger.pass(value+" is entered successfully in "+elementname,true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}

}
