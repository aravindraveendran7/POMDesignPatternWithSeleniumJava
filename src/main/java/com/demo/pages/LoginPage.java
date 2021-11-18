package com.demo.pages;

import org.openqa.selenium.By;

import com.demo.driver.DriverManager;
import com.demo.enums.WaitStratergy;
import com.demo.reports.ExtentLogger;
import com.demo.reports.ExtentManger;
import com.demo.reports.ExtentReport;

public final class LoginPage extends BasePage {


	private final By textboxUsername=By.id("txtUsername");
	private final By textboxPassword=By.xpath("//input[@id='txtPassword' and @type='password']");
	private final By buttonLogin=By.id("btnLogin");

	public LoginPage enterUsername(String username) {
		userDefinedEnterValue(textboxUsername,username,WaitStratergy.PRESENCE,"username field");
		return this;
	}

	public LoginPage enterPassword(String password) {
		userDefinedEnterValue(textboxPassword,password,WaitStratergy.PRESENCE,"password field");
		return this;
	}

	public HomePage clickLogin() {
		userDefinedClick(buttonLogin,WaitStratergy.CLICKABLE,"login button");
		return new HomePage();
	}
	
	public String getLoginPageTitle() {
		return getPageTitle();
	}
	
	
}
