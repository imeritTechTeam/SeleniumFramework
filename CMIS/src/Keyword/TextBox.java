package Keyword;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Locator;
import Utilities.ORFile;
import Utilities.WebDriverSelector;

public class TextBox {
	
	static WebDriverSelector driver;
	public static void SetText(String strxpath,String strData) throws IOException, InterruptedException
	{
		
		try
		{
		By textboxLocator=Locator.getWebElement(strxpath);
		WebDriverWait wait = new WebDriverWait(WebDriverSelector.driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(textboxLocator)).sendKeys(strData);	
	
				
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
			By textboxLocator=Locator.getWebElement(strxpath);
			WebDriverWait wait = new WebDriverWait(WebDriverSelector.driver, 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(textboxLocator)).getText();
				
		}
		catch(Exception e)
		{
			  e.printStackTrace();
		}
		
	}
}
