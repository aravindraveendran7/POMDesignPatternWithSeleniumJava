package com.demo.Listener;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.demo.reports.ExtentLogger;
import com.demo.reports.ExtentReport;

public class ListenerClass implements ITestListener,ISuiteListener{

	public void onStart(ISuite suite) {
		try {
			ExtentReport.initReports();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void onFinish(ISuite suite) {
			try {
				ExtentReport.flushReports();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		try {
			ExtentLogger.pass(result.getMethod().getMethodName()+"is passed",true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onTestFailure(ITestResult result) {
		try {
			ExtentLogger.fail(result.getMethod().getMethodName()+"is failed",true);
			ExtentLogger.fail(result.getThrowable().toString());//to log failures in report
			ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));//to log the entire error message
		} catch (Exception e) {
			e.printStackTrace();
		}
		//attach screenshot
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
