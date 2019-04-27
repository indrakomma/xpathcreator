package excelutil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class xpathnotlinks {
	HashMap<Integer, String>radio=new HashMap<Integer, String>();

	 ArrayList<String> inputtextlist=new ArrayList<String>();
	 ArrayList<String> radiolist=new ArrayList<String>();
	 ArrayList<String> checkboxlist=new ArrayList<String>();
	 ArrayList<String> buttonlist=new ArrayList<String>();
	 ArrayList<String> containstextlist=new ArrayList<String>();
	 
	//list for forloop
	 ArrayList<String> classlocatorlist=new ArrayList<String>();
	 ArrayList<String> idlocatorlist=new ArrayList<String>();
	 ArrayList<String> contenttextlocatorlist=new ArrayList<String>();
	 List<String> finallist=new ArrayList<String>();
	  int s=1;	
     @Test
	 public void getsource() throws InterruptedException, IOException
	 {
		System.setProperty("webdriver.chrome.driver","C://Users//indraa36//Desktop//freshframework//ownframework//drivers//chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		//driver.get("http://book.theautomatedtester.co.uk/chapter1");
		driver.get("https://www.mobikwik.com/");
		Thread.sleep(5000);
		List<WebElement> links=driver.findElements(By.tagName("input"));
		System.out.println(links.size());
		for(WebElement ele:links)
		{
			String str=ele.getAttribute("text");
			
			String type=ele.getAttribute("type");
			if(type.contains("radio"))
			{   
				deletearray(finallist);
				deletearray(classlocatorlist);
				deletearray(containstextlist);
				String radiotext=ele.getAttribute("text");  
				String radioid=ele.getAttribute("id");
				String radioclass=ele.getAttribute("class"); //storing attribute values
				
		
				radiolist.add(radioid);
				classlocatorlist.add(radioclass);
				containstextlist.add(radiotext);
						
				System.out.println("Total radio button-->"+radiolist.size());
	
				forloop(radiolist);
				writecell(finallist);
	
				
         	}
			
			if(type.contains("text"))
			{  
				deletearray(finallist);
				deletearray(classlocatorlist);
				deletearray(containstextlist);
				String inputtextboxtext=ele.getAttribute("text");
				String inputtextboxid=ele.getAttribute("id");
				String inputtextidclass=ele.getAttribute("class");
				inputtextlist.add(inputtextboxid);
				classlocatorlist.add(inputtextidclass);
				containstextlist.add(inputtextboxtext);
				System.out.println("total input text box are------->"+inputtextlist.size());
				
				forloop(inputtextlist);
				writecell(finallist);
				
		   	}
	    	if(type.contains("checkbox"))
			{ 
	    		deletearray(finallist);
				deletearray(classlocatorlist);
				deletearray(containstextlist);
				String checkboxtext=ele.getAttribute("text");
				String checkboxid=ele.getAttribute("id");
				String checkboxclass=ele.getAttribute("class");
				
				checkboxlist.add(checkboxid);
				classlocatorlist.add(checkboxclass);
				containstextlist.add(checkboxtext);
				System.out.println("total checkbox---->"+checkboxlist.size());

				forloop(checkboxlist);
				writecell(finallist);
				
			
         	}
			if(type.contains("button"))
			{ 
				deletearray(finallist);
				deletearray(classlocatorlist);
				deletearray(containstextlist);
				String buttontext=ele.getAttribute("text");
				String buttonid=ele.getAttribute("id");
				String buttonclass=ele.getAttribute("class");
				
				buttonlist.add(buttonid);
				classlocatorlist.add(buttonclass);
				containstextlist.add(buttontext);
				System.out.println("total buttons---->"+buttonlist.size());

				forloop(checkboxlist);
				writecell(finallist);
				break;
			
			}			
		
	
		}
		driver.quit();
	 }
	 
	  public void forloop(List<String> arraylistname)
	  {  
		  for (int i = 0; i < arraylistname.size(); i++) {
			
			  String idlocators="//*[@id='"+arraylistname.get(i)+"']";
			  String classlocator="//*[@class='"+classlocatorlist.get(i)+"']";
			  String containstextlocator="//*[contains(text(),'"+containstextlist.get(i)+"')]";	
			  System.out.println(containstextlist.get(i)+ "and"+containstextlocator+"and"+idlocators+" and "+classlocator);
		      finallist.add(containstextlist.get(i)+ "and"+containstextlocator+"and"+idlocators+" and "+classlocator);
		  }
		  
	  }
	  
	 
	  public void writecell(List<String> writelist) throws IOException
	  {
		  String sheetlocation="C://Users//indraa36//Desktop//xpath.xlsx";
		  
		  FileInputStream fis=new FileInputStream(sheetlocation);
		  XSSFWorkbook wb=new XSSFWorkbook(fis);
		  XSSFSheet sheet=wb.getSheetAt(1);
		  int lastcell=sheet.getRow(0).getLastCellNum();
		  System.out.println(lastcell);
		  
		 
		  System.out.println(finallist.size());
			 if(sheet.getRow(0).getCell(0).getStringCellValue().equals("radiobutton"))
			  {
				  for (int i = 0; i < finallist.size(); i++) {

					  String xpathsplit=finallist.get(i);
					  String[] splitting=xpathsplit.split("and");
					  System.out.println(splitting[0]);
					  System.out.println(splitting[1]);
					  System.out.println(splitting[2]);
					  System.out.println(splitting[3]);
					  
					  sheet.createRow(i+1).createCell(0).setCellValue(splitting[0]);
					  sheet.getRow(i+1).createCell(1).setCellValue(splitting[1]);
					  sheet.getRow(i+1).createCell(2).setCellValue(splitting[2]);
					  sheet.getRow(i+1).createCell(3).setCellValue(splitting[3]);
		              
				}}
				  if(sheet.getRow(0).getCell(6).getStringCellValue().equals("checkbox"))
				  {
					  
					  for (int i = 0; i < finallist.size(); i++) {

						  String xpathsplit=finallist.get(i);
						  String[] splitting=xpathsplit.split("and");
						  System.out.println(splitting[0]);
						  System.out.println(splitting[1]);
						  System.out.println(splitting[2]);
						  System.out.println(splitting[3]);
						  
						  sheet.getRow(i+1).createCell(6).setCellValue(splitting[0]);
						  sheet.getRow(i+1).createCell(7).setCellValue(splitting[1]);
						  sheet.getRow(i+1).createCell(8).setCellValue(splitting[2]);
						  sheet.getRow(i+1).createCell(9).setCellValue(splitting[3]);
			              
					      }	  
	              }
	  
				  if(sheet.getRow(0).getCell(12).getStringCellValue().equals("text"))
				  {
					  
					  for (int i = 0; i < finallist.size(); i++) {

						  String xpathsplit=finallist.get(i);
						  String[] splitting=xpathsplit.split("and");
						  System.out.println(splitting[0]);
						  System.out.println(splitting[1]);
						  System.out.println(splitting[2]);
						  System.out.println(splitting[3]);
						  
						  sheet.getRow(i+1).createCell(12).setCellValue(splitting[0]);
						  sheet.getRow(i+1).createCell(13).setCellValue(splitting[1]);
						  sheet.getRow(i+1).createCell(14).setCellValue(splitting[2]);
						  sheet.getRow(i+1).createCell(15).setCellValue(splitting[3]);
			              
					      }	  
	              }
				  if(sheet.getRow(0).getCell(18).getStringCellValue().equals("button"))
				  {
					  
					  for (int i = 0; i < finallist.size(); i++) {

						  String xpathsplit=finallist.get(i);
						  String[] splitting=xpathsplit.split("and");
						  System.out.println(splitting[0]);
						  System.out.println(splitting[1]);
						  System.out.println(splitting[2]);
						  System.out.println(splitting[3]);
						  
						  sheet.getRow(i+1).createCell(18).setCellValue(splitting[0]);
						  sheet.getRow(i+1).createCell(19).setCellValue(splitting[1]);
						  sheet.getRow(i+1).createCell(20).setCellValue(splitting[2]);
						  sheet.getRow(i+1).createCell(21).setCellValue(splitting[3]);
			              
					      }	  
	              }

			 FileOutputStream out=new FileOutputStream(sheetlocation);
			  wb.write(out);
			  System.out.println("writed");
			  wb.close();
	
		 
		  
	  }
	 
	 
	 
	  
     public void deletearray(List<String> writelist)
     {
       
    	 writelist.size();
    	 for (int i = 0; i < writelist.size(); i++) {
    		 writelist.remove(i);
			
		}
    	 System.out.println("empty list:"+writelist.size());
    	 
    	 
    	 
     }








}
