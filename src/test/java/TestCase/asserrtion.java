package TestCase;

import java.awt.Window;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class asserrtion {

	
	
	@Test
	public void assert1() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://www.ebay.com/");
		
		String expeTitle="Pardon Our Interruption...";
		String actualTitle=d.getTitle();
		System.out.println("actual title is: "+actualTitle);

		Assert.assertEquals(actualTitle, expeTitle);
		System.out.println("asertion successfull");
		
		d.close();
	}
}
