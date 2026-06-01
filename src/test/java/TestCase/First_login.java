package TestCase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class First_login 
{

	public static void main(String[] args) throws InterruptedException, IOException 
	{
	
		WebDriverManager.chromedriver().setup();
	    WebDriver driver=new ChromeDriver();
	    driver.get("https://www.zoho.com/");
	    driver.manage().window().maximize();
	    
	    driver.findElement(By.xpath("//a[@class='zgh-login'][normalize-space()='Sign In']")).click();


	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    WebElement email = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(By.id("login_id"))
	    );

	    email.sendKeys("ranipatange4@gmail.com");
	    
	    Thread.sleep(10);
	    driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
	    Thread.sleep(10);
	    driver.findElement(By.xpath("//input[@id='password']")).sendKeys("patange12@223");
	    Thread.sleep(10);
	    driver.findElement(By.xpath("//button[@id='nextbtn']//span[contains(text(),'Sign in')]")).click();
	    
	    
	  
	   // driver.findElement(By.xpath("//span[@class='link-btn']")).click();
	    
	    WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(20));

	    WebElement linknxt = wait3.until
	    (ExpectedConditions.visibilityOfElementLocated((By.xpath("//span[@class='link-btn']"))));
	    linknxt.click();
	    Thread.sleep(5000);
		
	    
	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File src = ts.getScreenshotAs(OutputType.FILE);
	    File dest = new File("C:/Users/Dell/OneDrive/Pictures/Screenshots/test.png");
	    FileUtils.copyFile(src, dest);
	  
	    
	    
	    

	}

}
