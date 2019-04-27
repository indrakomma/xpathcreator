package xmlsuiteutil;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import practicetestng.tc1;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class xmlcreation {
	String testdataPath = "C://Users//indraa36//Desktop//freshframework//testngg//Data.xlsx";

	ArrayList<String> rowdata = new ArrayList<String>();
	ArrayList<String> classname = new ArrayList<String>();
	
	
//	@Test
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
	 
	 @Test
	 public void createxml(){
		 
		
		 XmlSuite xmlsuite=new XmlSuite();
		 xmlsuite.setName("mysuite");
		 xmlsuite.addListener("practicetestng.listener");
		 
		XmlTest xmltest=new XmlTest();
		xmltest.setName("mytest");
		xmltest.setThreadCount(2);
		
		XmlClass xmlclass=new XmlClass(tc1.class);
		
		List<XmlClass> list=new ArrayList<XmlClass>();
		list.add(xmlclass);
		xmltest.setXmlClasses(list);
		
		 TestNG ng=new TestNG();
		 List<XmlSuite> suitelist=new ArrayList<XmlSuite>();
		 suitelist.add(xmlsuite);
		 ng.setXmlSuites(suitelist);
		 ng.run();
		 
		
		 
	 }



}
