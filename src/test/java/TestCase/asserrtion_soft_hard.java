package TestCase;

import org.openqa.selenium.By;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.basetest;
import Utilities.screenshot;
import io.github.bonigarcia.wdm.WebDriverManager;

public class asserrtion_soft_hard extends basetest{
	@Test
	public void assSoftHard() throws InterruptedException
	{
		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver=new ChromeDriver();
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		
		//hard assert
//		String expTitle="Electronics, Cars, Fashion, Collectibles & More | eBay";
//		String actTitle=driver.getTitle();
//		System.out.println("step1");
//		Assert.assertEquals(actTitle, expTitle, "successfull title");
//		System.out.println("step2");
//		
//		String extvalue="hidden";
//		String actvalue=driver.findElement(By.xpath("//input[@type='hidden']")).getAttribute("type");
//		System.out.println("value is: "+actvalue);
//		Assert.assertEquals(actvalue, extvalue, "successfull value");
//		System.out.println("step3");
		
		
		//soft assert
		SoftAssert softass=new SoftAssert();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		String expTitle="Pardon Our Interruption...";
		String actTitle=driver.getTitle();
		System.out.println("step1");
		softass.assertEquals(actTitle, expTitle, "successfull title");
		System.out.println("step2");
		
		String extvalue="hidden";
		String actvalue=driver.findElement(By.xpath("//input[@type='hidden']")).getAttribute("type");
		System.out.println("value is: "+actvalue);
		softass.assertEquals(actvalue, extvalue, "successfull value");
		System.out.println("step3");
		
		//screenshot.captureScreenshot();
		//Reporter.log("Report is failed");
		
		Thread.sleep(2000);
		
		softass.assertAll();
		Thread.sleep(10000);
		
		
		
	}

}
