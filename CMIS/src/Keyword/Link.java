package Keyword;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
			By LinkLocator=Locator.getWebElement(strxpath);
			WebDriverWait wait = new WebDriverWait(WebDriverSelector.driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(LinkLocator)).click();	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		}
	
	public static void isPresent(String strxpath) throws IOException, InterruptedException
	{
		try
		{ 
			By LinkLocator=Locator.getWebElement(strxpath);
			WebDriverWait wait = new WebDriverWait(WebDriverSelector.driver, 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(LinkLocator));	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		}
	public static void isEnable(String strxpath) throws IOException, InterruptedException
	{
		try
		{ 
			By LinkLocator=Locator.getWebElement(strxpath);
			WebDriverWait wait = new WebDriverWait(WebDriverSelector.driver, 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(LinkLocator)).isEnabled();	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		}
}
