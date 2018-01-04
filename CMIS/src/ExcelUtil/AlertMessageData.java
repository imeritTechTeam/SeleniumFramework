package ExcelUtil;
import org.testng.annotations.DataProvider;
import Utilities.Testutilities;


public class AlertMessageData
{
	private String sTestcaseName ;
	private int iTestcaserow;

	@DataProvider(name="AlertMessage")
	public  Object[][] AlertMessage()
		     {
			Object[][] TesttabArray=null;
				try
					{
						 Excelutill.setExcelFile(Testutilities.TestDataPath, "TD3");
						 sTestcaseName = this.toString();
						 System.out.println("TestCase Name:"+sTestcaseName);
						 sTestcaseName=Excelutill.getTestCaseName(this.toString());
						 iTestcaserow=Excelutill.getRowContains(sTestcaseName, 0);
						 TesttabArray=Excelutill.getDataArray(Testutilities.TestDataPath, "TD3", iTestcaserow);	
							
					}
				catch(Exception e)
				{
				System.out.println("Error in Dataprovider code"+e.getMessage());
			    }
		return TesttabArray;
		
		} 
	}


