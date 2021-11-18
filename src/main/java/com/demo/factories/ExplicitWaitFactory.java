package com.demo.factories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.constants.FrameworkConstants;
import com.demo.driver.DriverManager;
import com.demo.enums.WaitStratergy;

public class ExplicitWaitFactory {

	public static WebElement performExplicitWait(WaitStratergy waitstratergy,By by) {
		WebElement element = null;
		if (waitstratergy==WaitStratergy.PRESENCE) {
			element=new WebDriverWait(DriverManager.getDriver(),FrameworkConstants.getExplicitWait()).until(ExpectedConditions.presenceOfElementLocated(by));
		}else if (waitstratergy==WaitStratergy.CLICKABLE) {
			element=new WebDriverWait(DriverManager.getDriver(),FrameworkConstants.getExplicitWait()).until(ExpectedConditions.elementToBeClickable(by));
		}
		return element;
	}

}
