package fillo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.TestNG;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.ArrayList;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class fillo2 {

	public static String testdataPath = "C://Users//indraa36//Desktop//freshframework//testngg//Data.xlsx";

	ArrayList<String> rowdata = new ArrayList<String>();
	static ArrayList<String> classname = new ArrayList<String>();

	@BeforeTest
	public void excel() {
		Fillo fill = new Fillo();
		try {
			Connection makeconnection = fill.getConnection(testdataPath);
			String yes = "Y";
			Recordset recordset = makeconnection.executeQuery(
					"Select * from Sheet1").where("run='Y'");
			while (recordset.next()) {

				System.out.println("" + recordset.getField("rowid") + ","
						+ recordset.getField("run") + ","
						+ recordset.getField("Classname"));
				rowdata.add("" + recordset.getField("rowid") + ","
						+ recordset.getField("run") + ","
						+ recordset.getField("Classname"));

			}
			System.out.println(rowdata);
			System.out.println("total testcases to run" + rowdata.size());

			for (String e : rowdata) { // for fetching classnames
				String[] tc = e.split(",");
				System.out.println(tc[2]);
				classname.add(tc[2]);

				System.out.println(classname.size());
			}
			System.out.println(classname);// printing class name

		} catch (FilloException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(priority=1)
	public static void createtestNGXMLFile() {
		String line1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		String line2 = "<!DOCTYPE suite SYSTEM \"http://testng.org/testng-1.0.dtd\">";
		String line3 = "<suite guice-stage=\"DEVELOPMENT\" name=\"Default suite\">";
		String line4 = " <test thread-count=\"5\" verbose=\"2\" name=\"Default test\">";
		String line5 = "<classes>";
		
		String line8 = "";
		String line9 = "</classes>";
		String line10 = "</test> <!-- Test -->";
		String line11 = "</suite> <!-- listners -->";
		
		
		
	
		String classNamesFinalString = "";
		for (int i = 0; i < classname.size(); i++) {
			classNamesFinalString = classNamesFinalString
					+ "<class name=\"practicetestng." + classname.get(i)
					+ "\"/>" + "\n";
		}

		line8 = classNamesFinalString;

		String finalTextNGXMLString = line1 + "\n" + line2 + "\n" + line3
				+ "\n" + line4 + "\n" + line5 
				+ "\n" + line8 + "\n" + line9 + "\n" + line10+ "\n" + line11;
		System.out.println(finalTextNGXMLString);
		// till here u create ur own xml
		// below writing xml

		File file = null;
		FileWriter fileWriter = null;
		BufferedWriter writer = null;

		try {
			file = new File("testng.xml");
			fileWriter = new FileWriter(file);
			file.createNewFile();
			writer = new BufferedWriter(fileWriter);
			writer.write(finalTextNGXMLString);
			System.out.println("File written successfully.");
	     	} catch (Exception e) {
			e.printStackTrace();
		    } 
		  finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
	
	
	//@Test(priority=2)
	//public void testClass() {

		TestNG obj=new TestNG();
		
		List<String> suites=new ArrayList<String>();
		suites.add("testng.xml");//it will take only list
		
		obj.setTestSuites(suites);
		obj.run();
	
	}
	
	
	
}
