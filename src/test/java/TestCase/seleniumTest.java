package TestCase;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class seleniumTest {


	
public static void main(String[] args) 
{
	
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
	  //driver.get("https://www.amazon.in/");
	  driver.get("//https://in.search.yahoo.com/");
	  driver.manage().window().maximize();
		 
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1000));
	  JavascriptExecutor js=(JavascriptExecutor) driver;
	 
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
//	   WebElement search=  driver.findElement(By.id("twotabsearchtextbox"));
//	   
//
//	    wait.until(ExpectedConditions.elementToBeClickable(search)).sendKeys("join amazon prime watch " +Keys.ENTER);
//		
//	    WebElement product = driver.findElement(By.cssSelector("div[data-asin='B0B3RRWSF6']"));
//	    product.isDisplayed();
//
//	 // Step B: find Add to Cart INSIDE that container only
//	 WebElement addToCart = product.findElement(By.cssSelector("span.a-button-text"));
//	 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCart);
//
//	 addToCart.click();
//	    
//	  driver.close();
//	  
//	  
//	  
//	  
//	  
////	  List <WebElement> l1=driver.findElements(By.tagName("a"));
////	  System.out.println("total links:" +l1.size());
////	  
////	  
////	  
////	  for(WebElement l2:l1)
////	  {
////		  String url=l2.getAttribute("href");
////		  System.out.println(url);
////	  }
	

	
}
}
