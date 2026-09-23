package TestCase;

import org.testng.annotations.Test;

public class sample {

		@Test(priority =1,groups = "Regression")
		public void sanity3() throws InterruptedException 
		{
			
			System.out.println("sample Regression sanity3 test1 completed");
		       
	    }
		
		@Test( priority =1,groups = "Regression")
		public void sanity4() throws InterruptedException 
		{
			
			System.out.println("sample Regression sanity4 test2 completed");
		       
	    }
	

}
