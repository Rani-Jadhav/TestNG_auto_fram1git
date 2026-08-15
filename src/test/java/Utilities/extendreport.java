package Utilities;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extendreport {
	
	
	static ExtentReports extent;

    public static ExtentReports getReport() {

        if(extent == null) {

            ExtentSparkReporter spark =new ExtentSparkReporter("test-output/ExtentReport.html");

            spark.config().setDocumentTitle("Automation Report");
            spark.config().setReportName("Regression Suite");

            extent = new ExtentReports();

            extent.attachReporter(spark);

//            extent.setSystemInfo("Tester", "Rani");
//            extent.setSystemInfo("OS", "Windows");
//            extent.setSystemInfo("Browser", "Chrome");
        }

        return extent;
	}
}
