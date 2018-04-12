package Testcase;
import org.testng.annotations.Test;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.io.IOException;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ISuiteResult;
import org.testng.ITestContext;

import Keyword.Button;
import Keyword.DropDown;
import Keyword.Keyword;
import Keyword.Label;
import Keyword.Link;
import Keyword.TextBox;
import Utilities.WebDriverSelector;


public class Credential extends Keyword {
	
ISuiteResult result;
Keyword functions =new Keyword();
TextBox textbox =new TextBox();
Button button =new Button();
Link link=new Link();
DropDown dropdown=new DropDown();
Label label=new Label();
WebDriverSelector Webdriver=new WebDriverSelector();
WebDriver driver;	
   
	@BeforeSuite
	@Parameters("browserType")
	public void StartSuite(@Optional  String browserType,ITestContext context ) throws IOException 
	{
		
		driver=Webdriver.selectDriver(context.getCurrentXmlTest().getParameter("browserType"));
		System.out.println(context.getCurrentXmlTest().getParameter("browserType"));
		Webdriver.launch("itest_url");
		
	}
	
	@Test(dataProviderClass=ExcelUtil.CredTestData.class,dataProvider="Credential")
	public void VerifyLogin(Hashtable<String,String> data) 
	{	
		try {
		
			button.GoogleLogin( driver);
			link.Click("hambugMenu", driver);
			link.JSClick("roster_arrow", driver);
			link.Click("project_allocation", driver);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
			link.JSClick("preDate", driver);
			if(!("0").equalsIgnoreCase((label.getText("sltColModal",driver))))
			{
			link.JSClick("sltColModal", driver);
			
			link.Click("ModalClose", driver);
			}
			else
			{
				System.out.println("sltColModal value is Zero");
			}
			if(!("0").equalsIgnoreCase((label.getText("BrpColModal",driver))))
			{
			link.JSClick("BrpColModal", driver);
			link.Click("ModalClose", driver);
			}
			else
			{
				System.out.println("BrpColModal value is Zero");
			}
			if(!("0").equalsIgnoreCase((label.getText("RNCColMobal",driver))))
			{
			link.JSClick("RNCColMobal", driver);
			link.Click("ModalClose", driver);
			}
			else
			{
				System.out.println("RNCColMobal value is Zero");
			}
			if(!("0").equalsIgnoreCase((label.getText("METColMobal",driver))))
			{
			link.JSClick("METColMobal", driver);
			link.Click("ModalClose", driver);
			}
			else
			{
				System.out.println("METColMobal value is Zero");
			}
			if(!("0").equalsIgnoreCase((label.getText("NLAColMobal",driver))))
			{
			link.JSClick("NLAColMobal", driver);
			link.Click("ModalClose", driver);
			}
			else
			{
				System.out.println("NLAColMobal value is Zero");
			}
			if(!("0").equalsIgnoreCase((label.getText("BHBColMobal",driver))))
			{
			link.JSClick("BHBColMobal", driver);
			link.Click("ModalClose", driver);
			}
			else
			{
				System.out.println("BHBColMobal value is Zero");
			}
			link.Click("TotalColMobal", driver);
			link.Click("TotalRowMobal", driver);
			
			
			
		    } 
		catch (Exception e) 
		{
		 System.out.println(e.getMessage());
		}
	}
	@AfterSuite
	public void closeBrowser() throws IOException
	{
		Webdriver.DriverClose(driver);
	}
	
    }

 
