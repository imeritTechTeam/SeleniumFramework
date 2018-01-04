package Testcase;
import java.util.Hashtable;
import org.testng.annotations.Test;
import Keyword.Keyword;

public class StudentCreation {
	
	@Test(priority=1,dataProviderClass=ExcelUtil.Std_TestData.class ,dataProvider="StdCreation_TestData")
	public static void NewStudent(Hashtable<String,String> data)
	{
		
		try
		{
			Keyword.LinkClick("hambugMenu","hambugMenu");
			Keyword.LinkClick("student","student");
			Keyword.LinkClick("NS_center","Center");
			Keyword.SelectListValue("center",data.get("Center"));
			Keyword.LinkClick("NS_PersonalID","Personal Identity");
			Thread.sleep(2000);
			Keyword.SelectListValue("Religion",data.get("Religion"));
			Keyword.EnterText("firstname",data.get("FirstName"));
			Keyword.EnterText("midname", data.get("midname"));
			Keyword.EnterText("lastname",data.get("lastname"));
			Keyword.DatePicker("dob", data.get("DOB"));
			Thread.sleep(2000);
			Keyword.SelectListValue("IDProof", data.get("IDProof"));
			Keyword.EnterText("IDNo", data.get("Identity No."));
			Keyword.ClickRadio("Female");
			Keyword.ClickRadio("Married");
			Keyword.ClickRadio("ST");
			Keyword.EnterText("DesibPer", data.get("Disability(%)"));
			Keyword.EnterText("ShortDescrib", data.get("Short Description"));
			Keyword.LinkClick("NS_comm", "Communication");
			Keyword.EnterText("contactNo", data.get("contactNo"));
			Keyword.EnterText("Email", data.get("Email"));
			Keyword.EnterText("pincode", data.get("Pincode"));
			Keyword.SelectListValue("pincode", "700009-Kolkata East-Parsibagan S.O");
			Keyword.EnterText("PoliceStation", data.get("PoliceStation"));
			Keyword.EnterText("AltNo", data.get("AltNo"));
			Keyword.EnterText("LandNo", data.get("LandlineNo"));
			Keyword.SelectListValue("DemoGraphic",data.get("DemoGraphic"));
			Keyword.EnterText("CurrentAdd", data.get("CurrentAddress"));
			Keyword.LinkClick("NS_edu&Occ", "Education and Occupation");
			Keyword.LinkClick("EngRead", "EngRead");
			Keyword.LinkClick("EngWrite", "EngWrite");
			Keyword.LinkClick("HindRead", "HindRead");
			Keyword.LinkClick("HindWrite", "HindWrite");
			Keyword.LinkClick("BengRead", "BengRead");
			Keyword.LinkClick("BengWrite", "BengWrite");
			Keyword.LinkClick("HindSpeak","HindSpeak");
			Keyword.SelectListValue("Livelihood", data.get("Livilhood Preference"));
			Keyword.VerifyCheckbox("occupation_status");
			Keyword.SelectListValue("Income", data.get("Select Income"));
			Keyword.SelectListValue("EmpType", data.get("Employee type"));
			Keyword.VerifyCheckbox("can_operate_compute");
			Keyword.EnterText("Skill", data.get("Computer skill"));
			Keyword.VerifyCheckbox("ready_to_relocate");
			Keyword.SelectListValue("SelPrefer", data.get("Select Preference"));
			Keyword.LinkClick("NS_Exam", "Examination Details");
			Keyword.SelectListValue("Qualification", data.get("Qualification"));
			Keyword.EnterText("12Pass", data.get("12Pass"));
			Keyword.EnterText("12University", data.get("12University"));
			Keyword.EnterText("12Year",data.get("12Year"));
			Keyword.EnterText("12Percent", data.get("12Percent"));
			Keyword.LinkClick("NS_FamIncm", "Family and Income"); 
			Keyword.EnterText("fathername", data.get("Fathername"));
			Keyword.EnterText("mothername", data.get("Mothername"));
			Keyword.SelectListValue("FatherOcc",data.get("Father Occupation"));
			Keyword.SelectListValue("MotherOcc",data.get("Mother Occupation"));
			Keyword.SelectListValue("MonFamIncome",data.get("MonFamIncome"));
			Keyword.VerifyCheckbox("bpl");
			Keyword.EnterText("bplno", data.get("BPL_No"));
			Keyword.LinkClick("NS_OthDetail", "Other Details");
			Keyword.SelectListValue("admitthrough", data.get("Admit_through"));
			Keyword.EnterText("referalid",data.get("Referal_ID"));
			Keyword.ButtonClick("SaveButton");
			Keyword.driverQuit();
		}catch(Exception e)
		
		{
			System.out.println(e.getMessage());
		}
    
	}
	/*@Test(priority=2,dataProviderClass=AlertMessageData.class ,dataProvider="AlertMessage")
	public static void AlertMessage(Hashtable<String,String> data)
	{
		try
		{
			
			Keyword.VerifyAlertMsg(data.get("Strxpath"),data.get("AlertMessageData"));
			System.out.println(data.get("AlertMessageData"));
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}*/
}
	

