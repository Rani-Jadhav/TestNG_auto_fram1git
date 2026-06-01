package Utilities;

import java.io.File;

import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.helpers.Reporter;
import org.testng.ITestResult;

import Base.basetest;

public class screenshot extends basetest {

	public static void captureScreenshot() {

        try {
        	
        	Date currentdate=new Date();
        	String testName= currentdate.toString().replace("","").replace(":", "-");

            TakesScreenshot ts = (TakesScreenshot) Base.basetest.driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            //File dest = new File("C:/Users/Dell/OneDrive/Pictures/Screenshots/" + testName + ".png");
            File dest = new File("C:/Users/Dell/eclipse-workspace_TestNG_automation/TestNG_auto_framework/screenshots/" + testName + ".png");

            FileUtils.copyFile(src, dest);

            System.out.println("Screenshot saved");

        } catch (IOException e) {

            System.out.println("Failed to capture screenshot");

        }
    }
}
