package extentreport;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class basesetup {

	public static WebDriver driver;
	public EventFiringWebDriver driver1;
	public WebDriverEventListener eventlistner;
	public static ExtentReports report;
	public static ExtentTest testObj;

	public static void main(String[] args) throws IOException {
	
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(
				System.getProperty("user.dir") + "/reports/trai2.html"));
		report = new ExtentReports();
		report.attachReporter(extent);

		System.setProperty(
				"webdriver.chrome.driver",
				"C:\\Users\\indraa36\\Downloads\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("http://google.com");
		testObj = report.createTest("paytmkaro");

		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File("reports/AAAA.png");
		FileUtils.copyFile(SrcFile, DestFile);
         
		testObj.pass("url entered");
		//Thread.sleep(2000);
		testObj.addScreenCaptureFromPath("AAAA.png");
		//driver.findElement(By.xpath("(//*[@class='_1tnO'])[1]")).click();
		// log.info("clicked");
		report.flush();
		
	}


}
