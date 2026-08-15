package TestCase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.basetest;
import Utilities.readXLSdata;
import Utilities.screenshot;
import Utilities.waitutiles;

public class Test_script extends basetest
{
	@Test (dataProviderClass = readXLSdata.class, dataProvider="testdata")
	public  void Login(String username, String password) throws InterruptedException, IOException 
	{
		Thread.sleep(5000);		
		getDriver().findElement(By.xpath(loc.getProperty("login_butn"))).click();
		


    WebElement email = waitutiles.waitForElement(getDriver(), By.id(loc.getProperty("email")));
   email.sendKeys(username);
   
   Thread.sleep(5000);
    WebElement nxt = waitutiles.waitForElement(getDriver(),By.xpath(loc.getProperty("nxt")));
    nxt.click();
    System.out.println("Current URL = " + getDriver().getCurrentUrl());
    System.out.println("Page title = " + getDriver().getTitle());
    System.out.println(
    	    getDriver().getPageSource()
    	        .contains("password"));
    screenshot.captureScreenshot();
    Thread.sleep(2000);
    
    WebElement pas = waitutiles.waitForElement(getDriver(),By.xpath(loc.getProperty("pass")));
    pas.sendKeys(password);
   
    WebElement signin = waitutiles.waitForElement(getDriver(),By.xpath(loc.getProperty("signin_but")));
    signin.click();
    
    Thread.sleep(5000);

//    System.out.println("After Login URL = " + getDriver().getCurrentUrl());
//    System.out.println("After Login Title = " + getDriver().getTitle());
//    WebElement linknxt = waitutiles.waitForElement(getDriver(),By.xpath(loc.getProperty("link_btn")));
//    linknxt.click();
   
	}
	
	
//	@DataProvider (name="testdata")
//	public Object[][] tdata()
//	{
//		return new Object[][] {
//			{"ranipatange423@gmail.com", "patang2@223"},
//			{"ranipatan@gmail.com", "patange2212@223"},
//			{"ranipatange4@gmail.com", "patange12@223"}
//		};
//	}
				
}
	
