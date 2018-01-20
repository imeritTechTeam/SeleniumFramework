package ExcelUtil;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

		
	public class Excelutill 
		{
				
		//private static final Object[][] tabArray = null;
		public static XSSFWorkbook wb;
		public static XSSFSheet ws;
		public static  XSSFRow Srow;
		public static XSSFCell cell;
		public static int totalRow;
		public static int totalCol;
		static Hashtable<String,String> table; 
			public static void setExcelFile(String path,String Sheetname) throws IOException
			{
							    
				    try
				    {
				    FileInputStream Scriptfis = new FileInputStream(path);
				    wb=new XSSFWorkbook(Scriptfis);
				    ws = wb.getSheet(Sheetname);
					}
				    catch(Exception e)
				    {
				    	System.out.println("Excel not found"+e.getMessage());
				    }
			}
			
			public static Object[][] getDataArray(String FilePath,String SheetName,int iTestcaserow)
			{
				Object[][] data=null;
			   try
			   {
				
				FileInputStream Scriptfis = new FileInputStream(FilePath);
			    wb=new XSSFWorkbook(Scriptfis);
			    ws = wb.getSheet(SheetName);
			    //int StartRow=1;
			    int StartCol=0;   
			    int ci=0,cj=0;
			    
			    Srow=ws.getRow(0);
			    
			    int totalRow=ws.getLastRowNum();
			    int totalCol=Srow.getLastCellNum();
			    
			   data=new Object[totalRow][1];
			  
			    

		        for(int i=1; i<=totalRow;i++)
		        {           
		            table = new Hashtable<String,String>();
		   
		                for(int j=0 ; j<totalCol; j++)
		                {
		                try {
		                    table.put(getCellData(0, j), getCellData(i, j));
		                } catch (Exception e) 
		                {
		                  e.printStackTrace();
		                }
		                }
		   
		                data[i-1][0] = table;
		                
		        }
			}catch (Exception e)
			    {
			     System.out.println("Could not read the Excel sheet"+e.getMessage());
			     e.printStackTrace();
                }
			
			return data;
			  
		}
			
			
		

		public static String getCellData(int RowNum, int ColNum) throws Exception{

		   try{

			  cell = ws.getRow(RowNum).getCell(ColNum);

			  String CellData = cell.getStringCellValue();

			  return CellData;

			  }catch (Exception e){

				return"";

				}

			}

		public static String getTestCaseName(String sTestCase)throws Exception{

			String value = sTestCase;

			try{

				int posi = value.indexOf("@");

				value = value.substring(0, posi);

				posi = value.lastIndexOf(".");	

				value = value.substring(posi + 1);

				return value;

					}catch (Exception e){

				throw (e);

						}

			}

		public static int getRowContains(String sTestCaseName, int colNum) throws Exception{

			int i;

			try {

				int rowCount = Excelutill.getRowUsed();

				for ( i=0 ; i<rowCount; i++){

					if  (Excelutill.getCellData(i,colNum).equalsIgnoreCase(sTestCaseName))
					{

						break;

					}

				}

				return i;

					}catch (Exception e){

				throw(e);

				}

			}

		public static int getRowUsed() throws Exception {

				try{

					int RowCount = ws.getLastRowNum();

					return RowCount;

				}catch (Exception e){

					System.out.println("Unable to read");

					throw (e);

				}
      
			}
		
}