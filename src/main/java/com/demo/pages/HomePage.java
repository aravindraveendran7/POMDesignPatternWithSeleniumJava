package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.driver.DriverManager;
import com.demo.enums.WaitStratergy;

public class HomePage extends BasePage {
	
	private final By linkWelcome=By.id("welcome");
	private final By linkLogout=By.xpath("//a[text()='Logout']");
	
	public HomePage clickWelcome() {
		userDefinedClick(linkWelcome,WaitStratergy.CLICKABLE,"welcomelink");
		return this;
	}
	
	public LoginPage logOut() {
//		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);//used instead of thread.sleep wich requires to use declaration or try catch block-uses library common lang3
//		wait.until(drver->drver.findElement(link_logout).isEnabled());//after java 8
		userDefinedClick(linkLogout,WaitStratergy.CLICKABLE,"logoutlink");
		return new LoginPage();
	}

}
