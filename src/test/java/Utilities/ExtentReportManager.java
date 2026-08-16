package Utilities;

import java.io.ObjectInputFilter.Config;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager
{
	
	
	public static ExtentReports extent;   //ExtentReports: whole report file
                                            //ExtentTest = one test case inside report
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();  //ThreadLocal: each parallel thread gets its own test object
	
	/*
	Login Test  --> Thread 1 --> ExtentTest object 1
	Search Test --> Thread 2 --> ExtentTest object 2
	Without ThreadLocal, parallel execution can mix logs between tests.
	*/
    public static ExtentReports getReport() {

        if(extent == null) {

            ExtentSparkReporter spark =
                    new ExtentSparkReporter("test-output/ExtentReport.html");
            
            spark.config().setReportName("Automation Test Report");
            spark.config().setDocumentTitle("Regression Execution");

            extent = new ExtentReports();
            extent.attachReporter(spark);
            
            extent.setSystemInfo("Tester", "Rani");
            extent.setSystemInfo("Browser", "Chrome");
            extent.setSystemInfo("Environment", "QA");
        }

        return extent;
        
        
        
    }
    public static void info(String msg)
    {
        test.get().info(msg);
    }

    public static void pass(String msg)
    {
        test.get().pass(msg);
    }

    public static void fail(String msg)
    {
        test.get().fail(msg);
    }
    public static void skip(String msg)
    {
        test.get().skip(msg);
    }
}

