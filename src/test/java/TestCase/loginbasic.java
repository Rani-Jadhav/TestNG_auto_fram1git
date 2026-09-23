package TestCase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginbasic {
 
	@Test
	public void login() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver d=new ChromeDriver();
		d.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");//https://www.makemytrip.com/
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		d.manage().window().maximize();
		
		d.findElement(By.id("name")).sendKeys("RAni");
		
	List<WebElement> all=d.findElements(By.tagName("button"));
	
	for(WebElement one:all)
	{
		if(one.getText().equals("Elements"))
		{
		System.out.println(one.getText());
		one.click();
		System.out.println("click is done");
		}
		if(one.getText().equals("Forms"))
		{
			System.out.println("tagname is got: "+one.getTagName());
		}
	}
	
	d.quit();
		
	}
	
	
}
