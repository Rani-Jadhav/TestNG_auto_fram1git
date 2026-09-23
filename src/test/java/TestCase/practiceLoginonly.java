package TestCase;

import java.sql.Driver;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class practiceLoginonly 
{
  
	@Test
	public void login() throws InterruptedException{
		
		WebDriverManager.chromedriver().setup();
		WebDriver d=new ChromeDriver();
		d.get("https://www.tutorialspoint.com/selenium/practice/browser-windows.php");
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		d.manage().window().maximize();
		
		WebDriverWait wait=new WebDriverWait(d,Duration.ofSeconds(2));
		JavascriptExecutor js=(JavascriptExecutor)d;
		
		String main=d.getWindowHandle();
		System.out.println("main handle: "+main);
        System.out.println("Window Title : " + d.getTitle());
		
		d.findElement(By.xpath("//button[text()='New Tab']")).click();
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        System.out.println("After New Tab: " + d.getWindowHandles().size());
		
		
		//d.switchTo().window(main);
		d.findElement(By.xpath("//button[text()='New Window']")).click();
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));

        System.out.println("After New Tab: " + d.getWindowHandles().size());
		//--------------------------
        
//        d.findElement(By.xpath("//button[text()='New Window Message']")).click();
//		wait.until(ExpectedConditions.numberOfWindowsToBe(4));
//
//        System.out.println("After New Tab: " + d.getWindowHandles().size());
		
		Set<String> all=d.getWindowHandles();
		System.out.println("size is: "+all.size());
		
		for (String handle : all) {

            if(!handle.equals(main))
            {
            	//d.switchTo().window(handle);

                System.out.println("----------------------------");
                System.out.println("Window Handle: " + d.getWindowHandle());
                System.out.println("Window Title : " + d.getTitle());
            }
        }
       		
		
		d.quit();
	
		
	}
	
}
