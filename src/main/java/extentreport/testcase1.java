package extentreport;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import practicetestng.testngpract;

public class testcase1 extends basesetup{
	Logger log=Logger.getLogger(testcase1.class);
	@Test
	public void login() throws InterruptedException, IOException
	{
	//    Test=report.createTest("paytmkaro");
		driver.get("https://paytm.com");
		log.info("sent url");
	//	Test.pass("url entered");
		Thread.sleep(2000);
	//	Test.addScreenCaptureFromPath(basesetup.getscreenshot("AAAAA.PNG"));
		driver.findElement(By.xpath("(//*[@class='_1tnO'])[1]")).click();
		log.info("clicked");
	
		
	  
	}

}
