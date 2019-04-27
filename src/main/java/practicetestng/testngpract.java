package practicetestng;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

public class testngpract extends log4jutil {
	
	Logger log=Logger.getLogger(testngpract.class);
	
	@Test

	public void openurl()
	{
		log.info("print opening log msg");
		
		System.out.println("opened url");
		assertEquals("hi", "hi");
		log.info("yes");
	}
	
	public void enteringcredential()
	{
		log.info("hello log msg");
		
		assertEquals("hi", "hello");
		System.out.println("credential entered");
	}
	

	public void loggedin()
	{
		System.out.println("loggedin");
		assertEquals("hi", "hi");
	}
}
