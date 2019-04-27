package practicetestng;

import org.testng.annotations.Test;

public class trycatch {
	
	public static void main(String[] args) throws myownexception
	{
    	try {
			int i=0,k=4,j=2;
            i=k/j;
		   if(i<5)
		   {
			   throw new myownexception("eeor");
		   }
		
		
		} catch (myownexception e) {
			
			System.out.println(e);
		}
		
		
	}
	}
class myownexception extends Exception

{
	public myownexception(String msg)
	{
		super(msg);
	}
	
	}




