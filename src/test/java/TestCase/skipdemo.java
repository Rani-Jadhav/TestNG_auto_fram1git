package TestCase;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class skipdemo {
	
	boolean b=false;
	
//	@Test (enabled = false)
//	public void skip1() {
//		
//		System.out.println("skipped1 TC it will not exexute at all");
//	}
//	
//	@Test (enabled = true)
//    public void skip2() {
//		
//		System.out.println("skipped2 TC exception");
//		
//	}
//	
//	@Test
//	public void skip3() {
//		
//		System.out.println("skipped3 TC  forcfull with exception");
//		throw new SkipException("skipped skip3");
//	}
	
	

	
	@Test
	public void skip4() 
	{
	
	System.out.println("skipped4 TC with cndition");
	
	if(b==true)
	{
		System.out.println("conditins true so executed skipped4");
	}
	else
	{
		System.out.println("conditins false so executed skipped4");
		throw new SkipException("conditins false so executed and skipped skipped4");
	}
	}
	
	@Test  (dependsOnMethods = "skip4")
	public void skip5dependsonSkip4() {
		
		System.out.println("skipped5 TC  forcfull with exception");
	
	}
	
	
}


