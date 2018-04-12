package ExcelUtil;
import org.testng.annotations.DataProvider;
import Utilities.Testutilities;

public class CredTestData
{
private String sTestcaseName ;
private int iTestcaserow;

	@DataProvider(name="Credential")
	public  Object[][] Credential()
	     {
		Object[][] TesttabArray=null;
			try
				{
					 Excelutill.setExcelFile("C:\\Users\\123456\\git\\SeleniumFramework\\CMIS\\iMPP_TestData.xlsx", "TD1");
					 sTestcaseName = this.toString();
					 sTestcaseName=Excelutill.getTestCaseName(this.toString());
					 iTestcaserow=Excelutill.getRowContains(sTestcaseName, 0);
					 TesttabArray=Excelutill.getDataArray("C:\\Users\\123456\\git\\SeleniumFramework\\CMIS\\iMPP_TestData.xlsx", "TD1", iTestcaserow);	
						
				}
			catch(Exception e)
			{
			System.out.println("Error in Dataprovider code"+e.getMessage());
		    }
	return TesttabArray;
	
	} 
}
