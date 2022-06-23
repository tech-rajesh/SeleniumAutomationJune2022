package retryLogicExample;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryLogic implements IRetryAnalyzer{

	
	int counter = 0;
	int retryCount = 2; 			//how many retries 
	
	
	public boolean retry(ITestResult result) {
		
		
		if(counter < retryCount) {
			
			
			counter++;
			return true;
			
		}
		
		
		
		
		
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	

}
