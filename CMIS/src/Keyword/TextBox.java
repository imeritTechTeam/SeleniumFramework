package Keyword;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utilities.Locator;
import Utilities.ORFile;
import Utilities.WebDriverSelector;

public class TextBox {
	
	static WebDriverSelector driver;
	public static void SetText(String strxpath,String strData) throws IOException, InterruptedException
	{
		
		try
		{
		WebElement textbox=Locator.getWebElement(strxpath);
		textbox.sendKeys(strData);
				
		}
		catch(Exception e)
		{
			  e.printStackTrace();
		}
		
	}
	public static void getText(String strxpath,String strData) throws IOException, InterruptedException
	{
		try
		{
		WebElement textbox=Locator.getWebElement(strxpath);
		textbox.getText();
				
		}
		catch(Exception e)
		{
			  e.printStackTrace();
		}
		
	}
}
