package TestCase;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;import java.util.DuplicateFormatFlagsException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class seleniumlogin {
	
	
public static void main(String[] arge) {
	
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.tutorialspoint.com/selenium/practice/register.php");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
	
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(0));
	
	
	
	WebElement firstname=	driver.findElement(By.id("firstname"));	
	wait.until(ExpectedConditions.elementToBeClickable(firstname)).click();
	System.out.println(firstname.isDisplayed());
	
	driver.findElement(By.className("form-control")).sendKeys("abc");
	Assert.fail("Forcefully failing the test");
	driver.findElement(By.cssSelector("#username")).sendKeys("pqr");
	
	driver.close();
	 //  driver.findElement(By.cssSelector(".username")).sendKeys("pqr");  //class
//	driver.findElement(By.cssSelector("input.username")).sendKeys("pqr");  //input tag+class name
//	driver.findElement(By.cssSelector("input#username")).sendKeys("pqr");  //input tag+id
//	
//	driver.findElement(By.xpath("//input[@class='btn btn-primary']")).sendKeys("pqr");
//	driver.findElement(By.xpath("//input[contains(@class, 'btn btn-primary')]")).sendKeys("pqr");
//	driver.findElement(By.xpath("//input[starts-with(@class, 'btn btn-primary')]")).sendKeys("pqr");
//
//	driver.findElement(By.xpath("//input[text()= 'btn btn-primary']")).sendKeys("pqr");
//	driver.findElement(By.xpath("//input[normiliz-space()= 'btn btn-primary']")).sendKeys("pqr");
//	
//
//	driver.findElement(By.xpath("//input[contains(text()= 'btn btn-primary')]")).sendKeys("pqr");
//	driver.findElement(By.xpath("//input[contains(text()= 'btn btn-primary') and (@id= 'btn btn')]")).sendKeys("pqr");
//	driver.findElement(By.xpath("//input[@class='btn btn-primary' and @id= 'btn btn']")).sendKeys("pqr");
//	
//	
	
	
    
//    List<WebElement> links = driver.findElements(By.tagName("a"));
//
//    for(WebElement link : links) {
//
//        String url = link.getAttribute("href");
//
//        if(url != null) {
//        	
//        	/*
//        	 HttpURLConnection provides methods specifically for HTTP communication, such as:
//				setRequestMethod()
//				connect()
//				getResponseCode()
//        	 */
//            HttpURLConnection connection =(HttpURLConnection) new URL(url).openConnection();
//
//            connection.setRequestMethod("HEAD");
//            connection.connect();
//
//            int responseCode = connection.getResponseCode();
//
//            if(responseCode >= 400) {
//                System.out.println("Broken Link: " + url);
//            }
//        }
//    }
//    
//    
//    System.out.println("done");
    
	
	
	
	
	
}

}
