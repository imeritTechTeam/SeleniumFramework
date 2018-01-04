package Testcase;
import java.util.Hashtable;
import org.testng.ISuiteResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Keyword.Keyword;

@Listeners(Utilities.TestListteners.class)
public class Credential extends Keyword {
	
ISuiteResult result;
static Keyword functions =new Keyword();
	
	
	@BeforeClass
	public static void beforeclass() 
	{
		try
		{
		 Keyword.LaunchApp("CMIS_url","Chrome");
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
			
			Keyword.EnterText("LoginUserID",data.get("Userid"));
			Keyword.EnterText("LoginPassword",data.get("Password"));
			Keyword.ButtonClick("LoginButton");
			System.out.println(driver.getPageSource().contentEquals("Tamaghna Kumar Banerje"));
		    } 
		catch (Exception e) 
		{
		 System.out.println(e.getMessage());
		}
	}
	
    }

 
