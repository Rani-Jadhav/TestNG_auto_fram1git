package TestCase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class makemytrp 
{
	@Test
	public void login() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver d=new ChromeDriver();
		d.get("//https://www.makemytrip.com/");
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		d.manage().window().maximize();
		 
		WebDriverWait wait=new WebDriverWait(d, Duration.ofSeconds(5000));
		
		
//		 WebElement cross=d.findElement(By.xpath("//span[@class='commonModal__close']"));
//		wait.until(ExpectedConditions.elementToBeClickable(cross));
//	   cross.click();
//	   Thread.sleep(1000);
	   
	   
	   //List<WebElement> all=	d.findElements(By.xpath("//*"));
	  
	   //System.out.println("size is:"+all);
	   
//	   for(WebElement one: all)
//	   {
//		   String tagname=one.getTagName();
//		   int count=0;
//		   if(tagname.equals("input"))
//		   {
//			   count++;
//			   System.out.println("input count is: "+count);
//		   }
//		  
//	   }
	  
//	   List<WebElement> tags=	d.findElements(By.tagName("input"));
//	   
//	   for(WebElement tag:tags)
//	   {
//		   String tagname=tag.getTagName();
//		   System.out.println(tagname);
//	   }
	   
	   
	   Thread.sleep(1000);
	   d.quit();
		
	}
	
	
	
}
