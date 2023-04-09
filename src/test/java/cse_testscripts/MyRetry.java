package cse_testscripts;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetry implements IRetryAnalyzer {

	public static int retryCount = 0;
	private static final int maxRetryCount = 2;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(retryCount < maxRetryCount) {
			retryCount++;
		   return true;
		}
		return false;
	}

}
