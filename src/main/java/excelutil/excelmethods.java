package excelutil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.And;

public class excelmethods {
	
	Workbook workbook;
	XSSFSheet sheet;
	XSSFSheet sheet1;
	XSSFRow row;
	XSSFCell cell;
	FileInputStream fis=null;
	FileOutputStream out= null;
	
	
	
	public void test() throws IOException
	{
		
	}
	public void createexcel(String sheetname) throws IOException
	{
		fis=new FileInputStream("C://Users//indraa36//Desktop//freshframework//indra.xlsx");
		
		
		sheetname="";
	    workbook=new XSSFWorkbook();//workbook instance
		 out=new FileOutputStream("C://Users//indraa36//Desktop//freshframework//indra.xlsx");//location
		 sheet=(XSSFSheet) workbook.createSheet(sheetname);//giving sheet name
		workbook.write(out);	
	}
	 
	public void writecell() throws IOException{//not done
		
		fis=new FileInputStream("C://Users//indraa36//Desktop//freshframework//indra.xlsx");
		
		String sheetname="indra";
	   
	    XSSFWorkbook wb=new XSSFWorkbook(fis);
	    System.out.println("ye");
		sheet1=wb.getSheetAt(0);
		
		System.out.println("ye1");
		sheet1.getRow(0).createCell(2).setCellValue("ssss");
		System.out.println("ye3");
		
		 out=new FileOutputStream("C://Users//indraa36//Desktop//freshframework//indra.xlsx");//location
		 wb.write(out);
		 wb.close();
		System.out.println("writed");
	
	}
	
	public void getallvalues() throws IOException{
		ArrayList<String> addd=new ArrayList<String>();
		List<String> add1=new ArrayList<String>();
		HashMap<String, String> data = new HashMap<String, String>();
		fis=new FileInputStream("C://Users//indraa36//Desktop//freshframework//indra.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet2=wb.getSheetAt(0);
		int totalrow=sheet2.getLastRowNum();
		System.out.println("total row is"+totalrow);
		for (int i = 0; i < totalrow; i++) {
			int lastcolvalue=sheet2.getRow(i).getLastCellNum();
			System.out.println("in"+i+" row last col value is" +lastcolvalue);
			for (int j = 0; j < lastcolvalue; j++) {
				
				String value=sheet2.getRow(i).getCell(j).toString();
				addd.add(value);
				add1.add(value);
			
				
			}
			
		}
		System.out.println(addd);
		
	}
	
	public void fulldatahash() throws IOException{
		List<String> add1=new ArrayList<String>();
		
		
		
	LinkedHashMap<Integer,LinkedHashMap<String, String>> original=new LinkedHashMap<Integer, LinkedHashMap<String, String>>();	
	HashMap<String, String> data = new HashMap<String, String>();
	LinkedHashMap<String, String> data1=new LinkedHashMap<String, String>();
	    int rownum=0;
		fis=new FileInputStream("C://Users//indraa36//Desktop//freshframework//indra.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet2=wb.getSheetAt(0);
		int totalrow=sheet2.getLastRowNum();
		System.out.println("total row is"+totalrow);
		for (int i = 0; i < totalrow; i++) {
			int lastcolvalue=sheet2.getRow(i).getLastCellNum();
			System.out.println("in "+i+" row last col index is" +lastcolvalue);
			for (int j = 0; j < lastcolvalue; j++) {
				
				String header=sheet2.getRow(0).getCell(j).toString();
		        String value=sheet2.getRow(i+1).getCell(j).toString();
		        
		        data.put(header, value);
		        data1.put(header, value);
      
			}
			//System.out.println(add1);
			System.out.println(data1);
		}
		
	}
	
	public void getclass() throws IOException
	{
		List<String> getclass=new ArrayList<String>();
		fis=new FileInputStream("C://Users//indraa36//Desktop//freshframework//indra.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet2=wb.getSheetAt(0);
		int totalrow=sheet2.getLastRowNum();
		for (int i = 0; i <= 0; i++) {
			row=sheet2.getRow(0);
			int cell=sheet2.getRow(i).getLastCellNum();
			System.out.println(cell);
			
			for (int j = 0; j < cell; j++) {
				
			 int  colnum=j;
			 if(sheet2.getRow(i).getCell(colnum).getStringCellValue().trim().equals("tcname")){
				 
				 
				 for (int k = 1; k < sheet2.getLastRowNum(); k++) {
					String classvalue=sheet2.getRow(k).getCell(colnum).getStringCellValue();
			        getclass.add(classvalue);
				 }
				 System.out.println(getclass);
				 break;
				 
				 
			 }
			 
			
			}
			
		}
		
		
	}

	
}
