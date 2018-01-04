package Utilities;

import java.io.File;
import java.util.Locale;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;


public class TestListteners implements ITestListener 
{
	ExtentReports report=new ExtentReports(System.getProperty("user.dir") +"\\TestReport\\Report.html");
			//new ExtentReports("E:\\workspace\\CMIS\\src\\TestReport\\Report.html",false,DisplayOrder.NEWEST_FIRST, NetworkMode.OFFLINE, Locale.ENGLISH);
	ExtentTest test;
	
    @Override
	public void onTestStart(ITestResult result)
	{
    	
	   //report.loadConfig(new File("E:\\workspace\\CMIS\\src\\TestReport\\extent-config.xml"));
    	report.loadConfig(new File(System.getProperty("user.dir") +"\\extent-config.xml"));
    	//test=report.startTest(result.getMethod().getMethodName(),"CMIS Project");
		test.log(LogStatus.INFO,"Starting Testing"+result.getMethod().getMethodName());
		report.endTest(test);
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		
		test.log(LogStatus.PASS, result.getName()+"Passed");
		report.endTest(test);
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		
		test.log(LogStatus.FAIL, result.getName()+"Failed");
		report.endTest(test);
	}
	
		

	@Override
	public void onTestSkipped(ITestResult result)
	{
		
		test.log(LogStatus.SKIP, result.getName()+"Skipped");
		report.endTest(test);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		//test.log(LogStatus.INFO,context.getName());
		report.endTest(test);
		
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		test.log(LogStatus.INFO,context.getName());
		report.endTest(test);
		report.flush();
		
	}

	
}
