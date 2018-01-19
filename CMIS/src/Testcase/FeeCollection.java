package Testcase;
import java.util.Hashtable;

import org.testng.annotations.Test;

import Keyword.Button;
import Keyword.DatePicker;
import Keyword.DropDown;
import Keyword.Keyword;
import Keyword.Link;
import Keyword.TextBox;

public class FeeCollection
{

	@Test(priority=1,dataProviderClass=ExcelUtil.Feecollect_TestData.class ,dataProvider="FeeCollection_TestData")
	public static void Fee_collection(Hashtable<String,String> data)
	{
		
		try
		{
			Link.Click("hambugMenu","hambugMenu");
			Link.Click("student","student");
			Link.Click("Collect_Fee","Collect Fees");
			TextBox.SetText("Std_id", data.get("Student_id"));
			DropDown.SelectListValue("Std_id",data.get("Std_id"));
			System.out.println(data.get("Std_id"));
			TextBox.SetText("Fee_amt", data.get("Fee_Amount"));
			TextBox.SetText("Fee_Rpt", data.get("Fee_Receipt"));
			DatePicker.datepick("Fee_RvDate", data.get("Receive_Date"));
			Thread.sleep(2000);
			TextBox.SetText("Fee_ReceiverID", data.get("Receiver_id"));
			//DropDown.SelectItem("Fee_ReceiverID",data.get("Rece_id"));
			//Thread.sleep(2000);
			Button.Click("Add_Fee");
			//Keyword.driverQuit();
			
        }
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}	
		}
		}
		
