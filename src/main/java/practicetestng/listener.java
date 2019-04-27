package practicetestng;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class listener implements ITestListener{

	public void onTestStart(ITestResult result) {
		System.out.println("tc started "+result.getMethod());
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("sucessfully passed");
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("tc failed"+result.FAILURE);
		
	}

	public void onTestSkipped(ITestResult result) {
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	
	
	
	
	
	
}
