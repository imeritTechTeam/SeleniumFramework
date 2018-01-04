package Testcase;
import java.util.Hashtable;
import org.testng.annotations.Test;
import Keyword.Keyword;

public class FeeCollection
{

	@Test(priority=1,dataProviderClass=ExcelUtil.Feecollect_TestData.class ,dataProvider="FeeCollection_TestData")
	public static void Fee_collection(Hashtable<String,String> data)
	{
		
		try
		{
			Keyword.LinkClick("hambugMenu","hambugMenu");
			Keyword.LinkClick("student","student");
			Keyword.LinkClick("Collect_Fee","Collect Fees");
			Keyword.EnterText("Std_id", data.get("Student_id"));
			Keyword.SelectListValue("Std_id",data.get("Std_id"));
			System.out.println(data.get("Std_id"));
			Keyword.EnterText("Fee_amt", data.get("Fee_Amount"));
			Keyword.EnterText("Fee_Rpt", data.get("Fee_Receipt"));
			Keyword.datepick("Fee_RvDate", data.get("Receive_Date"));
			Thread.sleep(2000);
			Keyword.EnterText("Fee_ReceiverID", data.get("Receiver_id"));
			Keyword.SelectItem("Fee_ReceiverID",data.get("Rece_id"));
			//Thread.sleep(2000);
			Keyword.ButtonClick("Add_Fee");
			//Keyword.driverQuit();
			
        }
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}	
		}
		}
		
