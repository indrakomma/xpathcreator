package practicetestng;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeTest;

public class log4jutil {
	
	//public static final Logger log=Logger.getLogger(log4jutil.class.getName());
	
	
	@BeforeTest
	public void loadlog4j()
	{
		String logconfig=System.getProperty("user.dir")+"/src/main/java/practicetestng/log4j.properties";
         PropertyConfigurator.configure(logconfig);	
	
	}

}
