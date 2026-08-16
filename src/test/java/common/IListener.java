package common;

import javax.swing.text.Utilities;


import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Utilities.ExtentReportManager;
import Utilities.screenshot;

public class IListener extends screenshot implements ITestListener{

  
	 ExtentReports extent = ExtentReportManager.getReport();
        
	public void onTestStart(ITestResult result) {
		
		ExtentTest extentTest =extent.createTest(result.getMethod().getMethodName());

		ExtentReportManager.test.set(extentTest);
		System.out.println("on every test start");
	}


	public void onTestSuccess(ITestResult result) {
		System.out.println("Success11");
		captureScreenshot();
		Reporter.log("logs are onTestSuccess: " +result.getName());
		Reporter.log("<a href=\"C:\\Users\\Dell\\eclipse-workspace_TestNG_automation\\TestNG_auto_framework\\screenshots\">Test Result</a>");
		
		ExtentReportManager.pass("whole test is Passed");  //extent report
		log.info("Login started");  //log4j

	}

	
	public void onTestFailure(ITestResult result) {
		
		System.out.println("Failure11");
		captureScreenshot();
		Reporter.log("logs are onTestFailure: " +result.getName());
		
		ExtentReportManager.fail(result.getThrowable().getMessage());  //extent report
		log.error("Element not found");  //log4j
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		ExtentReportManager.skip("Test Skipped");             //extent report
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		extent.flush();
	}
	
	

}
