package ExcelUtil;

import java.util.Map;

import org.testng.annotations.DataProvider;

public class Authentication {

    @SuppressWarnings("null")
	@DataProvider(name="authentication")
	public static Object[][]  authentication()

        {
    	String sTestcaseName = null;
    	int iTestcaserow;
    	Object[][] excelData=null;
			try
			{
				 Excelutill.setExcelFile("E:\\Automation\\TestData\\TestcaseFile.xlsx", "TestData");
				 sTestcaseName = sTestcaseName.toString();
				 sTestcaseName=Excelutill.getTestCaseName(sTestcaseName.toString());
				 iTestcaserow=Excelutill.getRowContains(sTestcaseName, 0);
				 excelData=Excelutill.getDataArray("E:\\Automation\\TestData\\TestcaseFile.xlsx", "TestData", iTestcaserow);	
					
			}catch(Exception e)
			{
				System.out.println("Error in Dataprovider code"+e.getMessage());
			}
    	return excelData;
    	
    	}
}
