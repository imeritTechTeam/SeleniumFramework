package ExcelUtil;
import java.util.HashMap;



import org.testng.annotations.DataProvider;

import Utilities.Testutilities;

public class Feecollect_TestData {
		private String sTestcaseName ;
		private int iTestcaserow;

		@DataProvider(name="FeeCollection_TestData")
		public  Object[][]  FeeCollection()
		     {
			Object[][] TesttabArray=null;
			
				try
					{
						 Excelutill.setExcelFile(Testutilities.TestDataPath, "TD4");
						 sTestcaseName = this.toString();
						 sTestcaseName=Excelutill.getTestCaseName(this.toString());
						 iTestcaserow=Excelutill.getRowContains(sTestcaseName, 0);
						 TesttabArray=Excelutill.getDataArray(Testutilities.TestDataPath, "TD4", iTestcaserow);	
					     
					}
				catch(Exception e)
				{
				System.out.println("Error in Dataprovider code"+e.getMessage());
			    }
		return TesttabArray;
		
		} 
	}


