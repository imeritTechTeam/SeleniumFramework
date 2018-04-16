package Testcase;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ISuiteResult;
import org.testng.ITestContext;

import Keyword.Button;
import Keyword.DatePicker;
import Keyword.DropDown;
import Keyword.Keyword;
import Keyword.Label;
import Keyword.Link;
import Keyword.TextBox;
import Utilities.ExtentManager;
import Utilities.WebDriverSelector;


public class Credential extends Keyword {
	
ISuiteResult result;
Keyword functions =new Keyword();
TextBox textbox =new TextBox();
Button button =new Button();
DatePicker datepicker=new DatePicker();
Link link=new Link();
DropDown dropdown=new DropDown();
Label label=new Label();
WebDriverSelector Webdriver=new WebDriverSelector();
WebDriver driver;	
ExtentReports reports;
ExtentTest test;
double peopleShift;

	@BeforeClass
	@Parameters("browserType")
	public void StartSuite(@Optional  String browserType,ITestContext context ) throws IOException 
	{
		reports = ExtentManager.GetExtent("ReportName");
		driver=Webdriver.selectDriver(context.getCurrentXmlTest().getParameter("browserType"));
		System.out.println(context.getCurrentXmlTest().getParameter("browserType"));
		Webdriver.launch("itest_url");
		
	}
	
	@Test(dataProviderClass=ExcelUtil.CredTestData.class,dataProvider="Credential")
	public void VerifyLogin(Hashtable<String,String> data) 
	{	
		double totalPeopleShift=0;
		try {
			test = reports.createTest("Credential Test Case: ");
			button.GoogleLogin( driver);
			link.Click("hambugMenu", driver);
		//	datepicker.datepick("datePicker","dates" ,driver);
			link.JSClick("roster_arrow", driver);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			link.JSClick("roster_arrow", driver);
			link.Click("project_allocation", driver);
			test.info("Reported loaded");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			link.JSClick("preDate", driver);
		    List<WebElement> rows =driver.findElements(By.xpath(".//*[@id='roster-projects-tabular']/tbody/tr"));
			int row=rows.size();
			
			List<WebElement> cols =driver.findElements(By.xpath(".//*[@id='roster-projects-tabular']/tbody/tr[1]/td"));
			int col=cols.size();
			System.out.println("Number of Rows"+row);
			System.out.println("Number of columns"+col);
		    //Modal click loop starts
			for(int i=1;i<=row-1;i++)
		    {
		    	
		    	System.out.println("value of i"+i);
				for(int j=2;j<=col-1;j++)
			    {
					
					//*[@id='roster-projects-tabular']/tbody/tr[1]/td[2]//../label[1]
		    		//String xpath=".//*[@id='roster-projects-tabular']/tbody/tr["+i+"]/td["+j+"]//../label[1]";
					String xpath=".//*[@id='roster-projects-tabular']/tbody/tr["+i+"]/td[2]//../label[1]";
		    		test.info(label.xPathGetText(xpath,driver));
		    		System.out.println(xpath);
		    		if(!("0").equalsIgnoreCase((label.xPathGetText(xpath,driver))))
					{
		    			Thread.sleep(3000);
						link.XpathClick(xpath, driver);
						Thread.sleep(3000);
		    			List<WebElement> innerRows =driver.findElements(By.xpath(".//div[@id='daily-manshift-headcount-modal']//../tr"));
		    			int inRow=innerRows.size();
		    			
		    			System.out.println("value of inner Row"+inRow);
					//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					for(int k=1;k<inRow;k++)
				    {
						Thread.sleep(3000);
				    	System.out.println("value of k"+k);
				    	String innerXpath=".//div[@id='daily-manshift-headcount-modal']//../tr["+k+"]/td[4]";
				    	Thread.sleep(3000);
				    	String ShiftCount=(label.xPathGetText(innerXpath,driver));
				    	//String aa=ShiftCount.toString();
				    	double Peopleshift=Double.parseDouble(ShiftCount);
				    	
				    	totalPeopleShift=totalPeopleShift+Peopleshift;
				    	System.out.println("innerXpath"+innerXpath);
				    	System.out.println("Peopleshift"+totalPeopleShift);
				    }
					String labelTotPeopleShift=label.getText("peopleShift",driver);
					String Totalpeople=labelTotPeopleShift.split("(")[0];
					String rosterpeople=labelTotPeopleShift.split("(")[1];
					System.out.println("Totalpeople"+Totalpeople);
					double doblabelTotShift=Double.parseDouble(Totalpeople);
				//	double labelPeopleShift=Double.parseDouble(labelTotPeopleShift);
					
					//System.out.println("labelPeopleShift"+labelPeopleShift);
				if(totalPeopleShift==doblabelTotShift)
					{
						test.info("totalPeopleShift");
						test.pass("People shift match");
					}
					{
						test.fail("People shift mismatch");
					}
					test.info(label.getText(xpath,driver));
					link.Click("ModalClose", driver);
					}
					else
					{
						System.out.println("List value is Zero");
						test.info(label.getText(xpath,driver));
					}
			    }
		    
		    }
		    label.getText("TotalColMobal", driver);
			System.out.println(label.getText("TotalColMobal", driver));
			test.info(label.getText("TotalColMobal", driver));
			label.getText("TotalRowMobal", driver);
			System.out.println(label.getText("TotalRowMobal", driver));
			test.info(label.getText("TotalColMobal", driver));
		    }
		
		catch (Exception e) 
		{
		 System.out.println("Unable to execute");
		}
	}
	
	@AfterClass
	public void afterClass() throws IOException
	{
		reports.flush();
	}
	@AfterSuite
	public void closeBrowser() throws IOException
	{
		Webdriver.DriverClose(driver);
	}
	
    }

 
