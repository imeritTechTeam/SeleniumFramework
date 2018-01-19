package Keyword;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.WebElement;
import Utilities.Locator;

import Utilities.WebDriverSelector;

public class Checkbox {
	
	static WebDriverSelector driver;
	public static void click(String strxpath) throws FileNotFoundException, IOException
	{
		try
		{
		WebElement checkBox=Locator.getWebElement(strxpath);
		checkBox.click();		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		}
}
