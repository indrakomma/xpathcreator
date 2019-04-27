package extentreport;

import java.util.ArrayList;
import java.util.List;

import org.testng.*;
import org.testng.annotations.Test;

public class ExecuteRunClass {

	
	
	
	@Test
	public void testClass() {

		TestNG obj=new TestNG();
		
		List<String> suites=new ArrayList<String>();
		suites.add("testng.xml");
		
		obj.setTestSuites(suites);
		obj.run();
		
	}

}
