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
//				//FileReader fr=new FileReader("C:\\Users\\Dell\\eclipse-workspace_TestNG_automation\\TestNG_auto_framework\\src\\test\\resources\\configfiles\\config.properties");
//			      FileReader fr=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
//			      FileReader fr1=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\locatores.properties");
//
//			  prop.load(fr);
//			  loc.load(fr1);
//		  }
//		  Thread.sleep(5000);
		  
		  ///////////////////////for env for jenins////////////////////////////////////
		  String env = System.getProperty("env");

          // Default Environment
          if(env == null)
          {
              env = "qa";
          }

          // Loads config-qa.properties / config-dev.properties / config-uat.properties
          fr = new FileReader(System.getProperty("user.dir")+ "\\src\\test\\resources\\configfiles\\config-"+ env + ".properties");

          fr1 = new FileReader(System.getProperty("user.dir")+ "\\src\\test\\resources\\configfiles\\locatores.properties");

          prop.load(fr);
          loc.load(fr1);
          
        
      }
	
		  
///////////////////////for browser for jenins////////////////////////////////////
		  
//		  if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
//		  //if(browser.equalsIgnoreCase("chrome")) //its for @parameter annotation
//		  {
//			  WebDriverManager.chromedriver().setup();
//			  driver=new ChromeDriver();
//			  driver.get(prop.getProperty("testURL"));
//			    driver.manage().window().maximize();
//		  }
//		  else 
//			  if(prop.getProperty("browser").equalsIgnoreCase("edge"))  //if(browser.equalsIgnoreCase("edge")) //its for @parameter annotation
//		  {
//			  WebDriverManager.edgedriver().setup();
//			  driver=new EdgeDriver();
//			  driver.get(prop.getProperty("testURL"));
//			    driver.manage().window().maximize();
//		  }
		// new code added for jenkis execution  
		  String browser = System.getProperty("browser");  //here we passing browser from anywhere like @paramerte or jenins so browser value is chrome 

		  if(browser == null)                               //it will get exute when we are not passing value form anywhre and exection started and there no browser passed so it takes default 
		  {
		      browser = prop.getProperty("browser");
		  }

		  if(browser.equalsIgnoreCase("chrome"))
		  {
		      WebDriverManager.chromedriver().setup();
		      driver = new ChromeDriver();
		      driver.get(prop.getProperty("testURL"));
		      driver.manage().window().maximize();
		  }
		  else if(browser.equalsIgnoreCase("edge"))
		  {
		      WebDriverManager.edgedriver().setup();
		      driver = new EdgeDriver();
		      driver.get(prop.getProperty("testURL"));
		      driver.manage().window().maximize();
		  }
		  else if(browser.equalsIgnoreCase("firefox"))
		  {
		      WebDriverManager.firefoxdriver().setup();
		      driver = new FirefoxDriver();
		      driver.get(prop.getProperty("testURL"));
		      driver.manage().window().maximize();
		  }
		  else
		  {
		      throw new RuntimeException("Invalid browser : " + browser);
		  }
		  
	  }
	 
      //Thread.sleep(5000);
		  
	  
	  @AfterMethod
      public static void teardown()
      {
		  if(driver!=null)
		  {
			  
			  
			  driver.quit();
			  driver=null;
			  
			  
		  }
		  prop.clear();
		  loc.clear();
		 
          System.out.println("logout successfull");
	  }
}
