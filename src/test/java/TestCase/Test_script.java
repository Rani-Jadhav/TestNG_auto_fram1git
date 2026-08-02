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
		
    driver.findElement(By.xpath(loc.getProperty("login_butn"))).click();


    WebElement email = waitutiles.waitForElement(driver, By.id(loc.getProperty("email")));
   email.sendKeys(username);
    
    
    WebElement nxt = waitutiles.waitForElement(driver,By.xpath(loc.getProperty("nxt")));
    nxt.click();
    
    screenshot.captureScreenshot();
   
    
    WebElement pas = waitutiles.waitForElement(driver,By.xpath(loc.getProperty("pass")));
    pas.sendKeys(password);
   
    WebElement signin = waitutiles.waitForElement(driver,By.xpath(loc.getProperty("signin_but")));
    signin.click();
    
    
    WebElement linknxt = waitutiles.waitForElement(driver,By.xpath(loc.getProperty("link_btn")));
    linknxt.click();
    
 
    
    Thread.sleep(5000);
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
	
