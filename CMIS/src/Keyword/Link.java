package Keyword;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Locator;
import Utilities.ORFile;
import Utilities.WebDriverSelector;

public class Link {
	
	static WebDriverSelector driver;
	public static void Click(String strxpath) throws IOException, InterruptedException
	{
		try
		{ 
			WebElement Link=Locator.getWebElement(strxpath);
			

			
			Link.click();
					
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		}
}
