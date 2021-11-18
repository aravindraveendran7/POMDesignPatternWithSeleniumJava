package com.demo.tests;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.demo.driver.Driver;
import com.demo.driver.DriverManager;

public class HomePageTests extends BaseTest{
	
	private HomePageTests() {
		
	}
	@Test
	public void test3() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("python",Keys.ENTER);
	}

}
