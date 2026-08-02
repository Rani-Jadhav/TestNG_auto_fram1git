package TestCase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.waitutiles;

public class annotation {

	@BeforeTest
    public void DBConnected() {
		
		System.out.println("DBConnected");
	}
    @AfterTest
    public void DBdisconnected() {
		
		System.out.println("DBdisconnected");
	}
    
	
	@BeforeMethod
     public void login() {
		
		System.out.println("login application");
		
	}
     @AfterMethod
     public void logout() {
 		
 		System.out.println("logout application");
 	}
	
	
	
	@Test (priority=1, description="smoke test case")
	public void test1() {
		
		System.out.println("test1");
	}
	@Test (priority=2)
    public void test2() {
		
		System.out.println("test2");
	}
	@Test (priority=3)
    public void test3() {
		
		System.out.println("test3");
	}
	
	
	
	
	
}
