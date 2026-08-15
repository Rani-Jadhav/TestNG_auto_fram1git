package Base;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;



import io.github.bonigarcia.wdm.WebDriverManager;

public class basetest 
{
	// public static WebDriver driver; 
	 public  Properties prop=new Properties();
	 public  Properties loc=new Properties();
	 public  FileReader fr;
	 public  FileReader fr1;
	 public  String env; 
	 
	// ThreadLocal driver for parallel execution   //for te paaller execution we are using this 2 lines and updating getDriver() method everywhere instead of d
	 public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	
	 public static WebDriver getDriver()   // method to get driver anywhere in framework
	 {
	     return tlDriver.get();
	 }
	 
	 //Note when we add his ThreadLocal and carete getDriver method we need to remove all static keywork from above veriables and from setup tear down metods
	 //then the paralallel execution happens correctly.
	 
	 
	 //tlDriver.set(driver);
	 
	 //------------------------------------------------------------
	/*//if we pased parametres we need to add param tag in .xml file , then need to add @parameters annotaion and give same name there 
	 //(.xml and @paramer should be same) and need to provide pamamertes in methods now copied the method parameter to instant paramters. in blok1 
	 
	 3 ways execution from :
	 1)system.getproperly paramerts get at runtime,2)parametes from @paramerte annotaions  3)defalt paramerts
	  note: if paramerts are added in base class and not passed in .xml file error will ocuure so use @optiona for methods localmveriable it will get resolve 
	 1 Maven/Jenkins
	   -Denv=prod -Dbrowser=edge

	2. TestNG XML
	   envpara="prod"
	   browserpara="edge"

	3. Default value
	   qa / chrome
	  */
	 
	 @BeforeMethod
	 @Parameters({"envpara", "browserpara"})    
	  public  void setup( @Optional String env1, @Optional String browser1) throws IOException //pass broswer if added @parametr
, InterruptedException
	  {
		 
		 System.out.println( "START Thread = " + Thread.currentThread().getId());
		  if(getDriver() ==null)
		  {
		  ///////////////////////for env for jenins////////////////////////////////////
		  /// 
		   env = System.getProperty("env");        //System.getProperty() is used to read values passed to the Java JVM at runtime.

		   
		   if(env == null)
		   {
		       env = env1;     // from testng.xml blok1
		   }
		   
		   
          // Default Environment
          if(env == null)
          {
              env = "qa";        
          }
          System.out.println(System.getProperty("user.dir")
        		  + "\\src\\test\\resources\\configfiles\\config-" + env + ".properties");
          // Loads config-qa.properties / config-dev.properties / config-uat.properties
          fr = new FileReader(System.getProperty("user.dir")+ "\\src\\test\\resources\\configfiles\\config-"+ env + ".properties");

          fr1 = new FileReader(System.getProperty("user.dir")+ "\\src\\test\\resources\\configfiles\\locatores.properties");

          prop.load(fr);
          loc.load(fr1);
          
          System.out.println("browser key = " + prop.getProperty("browser"));
          System.out.println("All properties = " + prop);
      }
	
		  
///////////////////////for browser for jenins////////////////////////////////////
		  
		  
		  String executionMode = System.getProperty("executionMode");

		  if(executionMode == null)
		  {
		      executionMode = "headed";
		  }

		  
		  
		  String browser = System.getProperty("browser");
		  
		  System.out.println("Runtime Browser = " + System.getProperty("browser"));
		  System.out.println("Property Browser = " + prop.getProperty("browser"));
		  
		  
		  if(browser == null)
		  {
		      browser = browser1;   // from testng.xml
		  }
		  
		  //defalt 
		  if(browser == null)
		  {
		      browser = prop.getProperty("browser");
		  }
//-------------------------------------------------------------------------
		  if(browser.equalsIgnoreCase("chrome"))
		  {
			  
		      WebDriverManager.chromedriver().setup();

		      Thread.sleep(2000);
		      ChromeOptions options = new ChromeOptions();

		      if(executionMode.equalsIgnoreCase("headless"))
		      {
		          options.addArguments("--headless=new");
		      }

		     // driver = new ChromeDriver(options);
		      tlDriver.set(new ChromeDriver(options));
		  }

		  else if(browser.equalsIgnoreCase("edge"))
		  {
		      WebDriverManager.edgedriver().setup();

		      EdgeOptions options = new EdgeOptions();

		      if(executionMode.equalsIgnoreCase("headless"))
		      {
		          options.addArguments("--headless=new");
		      }

		      //driver = new EdgeDriver(options);
		      tlDriver.set(new EdgeDriver(options));
		  }

		  else if(browser.equalsIgnoreCase("firefox"))
		  {
		      WebDriverManager.firefoxdriver().setup();

		      FirefoxOptions options = new FirefoxOptions();

		      if(executionMode.equalsIgnoreCase("headless"))
		      {
		          options.addArguments("--headless");
		      }

		      //driver = new FirefoxDriver(options);
		      tlDriver.set(new FirefoxDriver(options));
		      
		  }

		  else
		  {
		      throw new RuntimeException("Invalid browser : " + browser);
		  }
		  
//		  driver.get(prop.getProperty("testURL"));
//		  driver.manage().window().maximize();
		  
		  getDriver().get(prop.getProperty("testURL"));
		  getDriver().manage().window().maximize();

		  System.out.println("Environment : " + env);
		  System.out.println("Browser : " + browser);
		  System.out.println("Execution Mode : " + executionMode);
		  System.out.println("URL : " + prop.getProperty("testURL"));
		  
		  
		  System.out.println(
				    "END Thread = " + Thread.currentThread().getId()
				);
		  Thread.sleep(2000);
	  }  
	  
	  @AfterMethod
      public  void teardown() throws InterruptedException
      {
//		  if(driver!=null)
//		  {
//			  driver.quit();
//			  driver=null;
//		  }
		  
		  if(getDriver()!=null)
		  {
			  Thread.sleep(2000);
		      getDriver().quit();
		      tlDriver.remove();
		  }
		  prop.clear();
		  loc.clear();
		 
          System.out.println("logout successfull");
	  }
}
