package TestCase;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.waitutiles;

public class annotation {

	//@BeforeTest
    public void DBConnected() {
		
		System.out.println("DBConnected");
	}
    //@AfterTest
    public void DBdisconnected() {
		
		System.out.println("DBdisconnected");
	}
    
	
	//@BeforeMethod
     public void login() {
		
		System.out.println("login application");
		
	}
    // @AfterMethod
     public void logout() {
 		
 		System.out.println("logout application");
 	}
	
	
	
	//@Test (priority=1, description="smoke test case")
	public void test1() {
		
		System.out.println("test1");
	}
	@Test 
    public void test2() {
		
		System.out.println("test2");
	}
	//@Test  
    public void test3() {
		
		System.out.println("test3");
	}
	
	//@Test (expectedExceptions = ArithmeticException.class)
	public void testException1() {
	 int a = 10 / 0;
	}
	//@Test (expectedExceptions = Exception.class)
	public void testException2() {
	 int a = 10 / 0;
	}
	
	//@Test(invocationCount = 5,invocationTimeOut = 20000)  //if count is 2 and time is 2000 so 1 test case have to run 2 times within 2 sec"
	public void test()
	throws InterruptedException {
	Thread.sleep(10000);
	}
	
	
	/*skip test 4 ways 
	Using @Test(enabled=false)
	Throwing SkipException
	Through dependency failures using dependsOnMethods
	Excluding tests from testng.xml
	*/
	
	//@Test  
	public void loginTest()
	{
	    throw new SkipException("Skipping this test");
	}
	
	
	
	/*
	 test case may fail cos:
	 Network issue
Element loading slowly
Browser crash
Session timeout
Temporary API failure


Now we rerun:

testng-failed.xml

because we want to verify:

Was it a real defect?
OR
Was it a temporary issue?
	*/
}
