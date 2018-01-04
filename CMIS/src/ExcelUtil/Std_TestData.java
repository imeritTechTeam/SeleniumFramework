package ExcelUtil;
import java.util.HashMap;



import org.testng.annotations.DataProvider;

import Utilities.Testutilities;

public class Std_TestData {
		private String sTestcaseName ;
		private int iTestcaserow;

		@DataProvider(name="StdCreation_TestData")
		public  Object[][]  StdCreation()
		     {
			Object[][] TesttabArray=null;
			
				try
					{
						 Excelutill.setExcelFile(Testutilities.TestDataPath, "TD2");
						 sTestcaseName = this.toString();
						 sTestcaseName=Excelutill.getTestCaseName(this.toString());
						 iTestcaserow=Excelutill.getRowContains(sTestcaseName, 0);
						 TesttabArray=Excelutill.getDataArray(Testutilities.TestDataPath, "TD2", iTestcaserow);	
					     
					}
				catch(Exception e)
				{
				System.out.println("Error in Dataprovider code"+e.getMessage());
			    }
		return TesttabArray;
		
		} 
	}


