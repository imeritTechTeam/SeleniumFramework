package Testcase;
import org.testng.annotations.Test;

import Keyword.Link;

public class iMMPP_Project
{

	@Test//(priority=1,dataProviderClass=ExcelUtil.Project_TestData.class ,dataProvider="Project_TestData")
	public static void iMMPP_Projects()
	{
		
		try
		{
			//Link.Click("hambugMenu");
			//Link.Click("Project_arrow");
			//Link.Click("viewProject");
			Link.Click("projectName");
					
        }
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}	
		}
		}
		
