package Base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class basetest 
{
	 public static WebDriver driver; 
	 public static Properties prop=new Properties();
	 public static Properties loc=new Properties();
	 public static FileReader fr;
	 public static FileReader fr1;
	 
	//paramert
	 @BeforeMethod
	  public static void setup() throws IOException //pass broswer if added @parametr
, InterruptedException
	  {
		  if(driver==null)
		  {
				//FileReader fr=new FileReader("C:\\Users\\Dell\\eclipse-workspace_TestNG_automation\\TestNG_auto_framework\\src\\test\\resources\\configfiles\\config.properties");
			      FileReader fr=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
			      FileReader fr1=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\locatores.properties");

			  prop.load(fr);
			  loc.load(fr1);
		  }
		  Thread.sleep(5000);
		  if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
		  //if(browser.equalsIgnoreCase("chrome")) //its for @parameter annotation
		  {
			  WebDriverManager.chromedriver().setup();
			  driver=new ChromeDriver();
			  driver.get(prop.getProperty("testURL"));
			    driver.manage().window().maximize();
		  }
		  else 
			  if(prop.getProperty("browser").equalsIgnoreCase("edge"))  //if(browser.equalsIgnoreCase("edge")) //its for @parameter annotation
		  {
			  WebDriverManager.edgedriver().setup();
			  driver=new EdgeDriver();
			  driver.get(prop.getProperty("testURL"));
			    driver.manage().window().maximize();
		  }
		  
		  
	  }
	  @AfterMethod
      public static void teardown()
      {
		  if(driver!=null)
		  {
			  driver.quit();
			  driver=null;
		  }
		 
          System.out.println("logout successfull");
	  }
}
