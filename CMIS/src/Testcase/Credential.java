package Testcase;
import java.util.Hashtable;

import org.testng.ISuiteResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Keyword.Button;
import Keyword.Keyword;
import Keyword.TextBox;
import Utilities.WebDriverSelector;


public class Credential extends Keyword {
	
ISuiteResult result;
static Keyword functions =new Keyword();
	
	
	@BeforeClass
	public static void beforeclass() 
	{
		try
		{
		 WebDriverSelector.LaunchApp("itest_url","BrowserName");
		}
		catch(Exception e)
		{
			 e.printStackTrace();
		}
	}
	
	@Test(dataProviderClass=ExcelUtil.CredTestData.class,dataProvider="Credential")
	public static void VerifyLogin(Hashtable<String,String> data) 
	{	
		try {
			
			TextBox.SetText("LoginUserID",data.get("Userid"));
			TextBox.SetText("LoginPassword",data.get("Password"));
			Button.Click("LoginButton");
			
		    } 
		catch (Exception e) 
		{
		 System.out.println(e.getMessage());
		}
	}
	
    }

 
