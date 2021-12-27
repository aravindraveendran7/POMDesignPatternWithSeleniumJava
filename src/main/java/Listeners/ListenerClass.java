package Listeners;

import org.testng.*;
import reports.ExtentLogger;
import reports.ExtentReport;
import java.io.IOException;
import java.util.Arrays;
public class ListenerClass implements ITestListener, ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        try {
            ExtentReport.initReports();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onFinish(ISuite suite) {
        try {
            ExtentReport.flushReports();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getMethodName());
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName()+" is Passed");
    }
    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName()+" is failed");
        try {
            ExtentLogger.fail(result.getMethod().getMethodName()+" is failed",true);
            ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName()+" is skipped");
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        //no special implementation as of now
    }
    @Override
    public void onStart(ITestContext context) {
        //no special implementation as of now
    }
    @Override
    public void onFinish(ITestContext context) {
        //no special implementation as of now
    }
}
