package practicetestng;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.openqa.selenium.remote.NewSessionPayload;
import org.testng.annotations.Test;

public class database {
@Test
   public void testdb() throws ClassNotFoundException, SQLException
   {
	   Class.forName("com.mysql.jdbc.Driver");
	   
	   System.out.println("driver loaded");
	   
	   
	 Connection con=DriverManager.getConnection("jdbc:mysql://DESKTOP-0KO5QLA:5816/indra","AzureAD\\indraa36","");
	  System.out.println("connected to my db"); 
 
   
   //5816
   }
}
