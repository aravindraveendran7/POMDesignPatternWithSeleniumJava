package com.demo.reports;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManger {

	private ExtentManger() {
	}
	
	
	private static ThreadLocal<ExtentTest>extTest=new ThreadLocal<ExtentTest>();


	 static ExtentTest getExtentTest() {//access modifier is by default here which means it can be accessed only within the same pkg
		return extTest.get();
	}

	 static void setExtentTest(ExtentTest extentTestRef) {
		extTest.set(extentTestRef);
	}

	 static void unLoad() {
		extTest.remove();
	}
	
	
}
