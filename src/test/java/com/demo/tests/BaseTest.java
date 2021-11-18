package com.demo.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.demo.driver.Driver;
import com.demo.reports.ExtentReport;

public class BaseTest {

	
	protected BaseTest() {
		//if its kept to private this cannot be access at the child level
	}

	@BeforeMethod
	protected void setUp() throws Exception {
		Driver.initDriver();
	}


	@AfterMethod
	protected void tearDown() {
		Driver.quitDriver();
	}
}
