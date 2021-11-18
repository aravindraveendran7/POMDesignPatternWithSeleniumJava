package com.demo.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.demo.constants.FrameworkConstants;

public final class ExtentReport {


	private  ExtentReport() {
	}
	private static ExtentReports extent;
	
	public static void initReports() throws Exception {
		if(Objects.isNull(extent)) {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReport());
		extent.attachReporter(spark);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setReportName("Run Results");
		}
	}
	
	public static void flushReports() throws IOException {
		if(Objects.nonNull(extent)) {
		extent.flush(); 
		try {
			Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReport()).toURI());
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	}
	
	public static void createTest(String username) {
		ExtentManger.setExtentTest(extent.createTest(username));
	}
}
