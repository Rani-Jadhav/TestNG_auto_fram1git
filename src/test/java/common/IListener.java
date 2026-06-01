package common;

import javax.swing.text.Utilities;


import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import Utilities.screenshot;

public class IListener extends screenshot implements ITestListener{

	
	public void onTestStart(ITestResult result) {
		System.out.println("on every test start");
		
	}


	public void onTestSuccess(ITestResult result) {
		System.out.println("Success11");
		captureScreenshot();
		Reporter.log("logs are onTestSuccess: " +result.getName());
		Reporter.log("<a href=\"C:\\Users\\Dell\\eclipse-workspace_TestNG_automation\\TestNG_auto_framework\\screenshots\">Test Result</a>");
		
		//Reporter.log("<a href=C:/Users//Dell\\eclipse-workspace_TestNG_automation\\TestNG_auto_framework\\screenshots\>Test Result</a>");

	}

	
	public void onTestFailure(ITestResult result) {
		
		System.out.println("Failure11");
		captureScreenshot();
		Reporter.log("logs are onTestFailure: " +result.getName());
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
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
	}
	
	

}
