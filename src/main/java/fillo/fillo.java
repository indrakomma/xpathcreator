package fillo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class fillo {

	public static String testdataPath = "C://Users//indraa36//Desktop//freshframework//testngg//Data.xlsx";

	
	@AfterTest
	public void afterValidation(){
		
		//to get value from the particular value  
		HashMap<String, String> val = datasheet_data.get(""+4);
		
		System.out.println(""+val.get("rowid"));
		
		
	}
	
	LinkedHashMap<String, HashMap<String, String>> datasheet_data = new LinkedHashMap<String, HashMap<String, String>>();
	//LinkedHashMap<String, ArrayList<String>> datasheet_data_lhm_al = new LinkedHashMap<String, ArrayList<String>>();
	
	@Test
	public void excel() {
		Fillo fill = new Fillo();
		try {
			Connection makeconnection = fill.getConnection(testdataPath);
			String yes = "Y";
			Recordset recordset = makeconnection
					.executeQuery("Select * from Sheet1");
			
			int rowNum = 0;
			
			
			while (recordset.next()) {

				LinkedHashMap<String, String> rowdata = new LinkedHashMap<String, String>();
				
			//	ArrayList<String> values = new ArrayList<String>();
				
				System.out.println(""+recordset.getField("rowid"));
			//	values.add(recordset.getField("rowid"));
				
				rowdata.put("rowid", recordset.getField("rowid"));
			//	values.add(recordset.getField("rowid"));
				
				rowdata.put("Classname", recordset.getField("Classname"));
			//	values.add(recordset.getField("Classname"));
				
				rowdata.put("run", recordset.getField("run"));
			//	values.add(recordset.getField("run"));
				
				rowdata.put("url", recordset.getField("url"));
			//	values.add(recordset.getField("url"));
				
				rowdata.put("Comments", recordset.getField("Comments"));
			//	values.add(recordset.getField("Comments"));
				
				datasheet_data.put(""+rowNum, rowdata);
				
			//	datasheet_data_lhm_al.put(""+rowNum, values);
				
				
				rowNum += 1;

			}
			
			System.out.println("datasheet_data: "+datasheet_data);
			//System.out.println("datasheet_data_lhm_al: "+datasheet_data_lhm_al);
			
			


		} catch (FilloException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
