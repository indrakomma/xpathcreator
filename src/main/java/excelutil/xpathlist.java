package excelutil;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.dom4j.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.gherkin.model.And;

public class xpathlist {
 
	
	
	 
	 ArrayList<String> contenttextlist=new ArrayList<String>();
	 ArrayList<String> idlist=new ArrayList<String>();
	 ArrayList<String> classnamelist=new ArrayList<String>();
	 @Test
	 public void getsource() throws InterruptedException
	 {
		System.setProperty("webdriver.chrome.driver","C://Users//indraa36//Desktop//freshframework//ownframework//drivers//chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.tsrtconline.org.in/");
		Thread.sleep(1000);
		List<WebElement> links=driver.findElements(By.tagName("li"));
		System.out.println(links.size());
		for(WebElement ele:links)
		{
			String str=ele.getAttribute("href");
			String ids=ele.getAttribute("id");
			String classnam=ele.getAttribute("class");
			//System.out.println(str);
			String text=ele.getText();
			System.out.println(text);
			System.out.println(ids);
			ArrayList<String> id=new ArrayList<String>();
			contenttextlist.add(text);
			idlist.add(ids);
			classnamelist.add(classnam);
		
		}
		driver.quit();
		
         System.out.println(contenttextlist.size());	 
         for (int i = 1; i < contenttextlist.size(); i++) {
        	 
        	 String xpath="//*[contains(text(),'"+contenttextlist.get(i)+"')]";		
		     String idxpath="//*[@id='"+idlist.get(i)+"']";
		     String classname="//*[@class='"+classnamelist.get(i)+"']";
		     System.out.println(xpath +"and "+idxpath +"and "+classname);
         }
        
 	 }

	
}
