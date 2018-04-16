package Keyword;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Locator;

public class Label {
	
	public String getText(String strxpath,WebDriver driver) throws IOException, InterruptedException
	{
		String strData = null;
		try
		{
			
			By textboxLocator=Locator.getWebElement(strxpath);
			WebDriverWait wait = new WebDriverWait(driver, 60);
			strData=wait.until(ExpectedConditions.presenceOfElementLocated(textboxLocator)).getText();
				
		}
		catch(Exception e)
		{
			System.out.println("Unable to gettext"+strxpath);
		}
		return  strData;
		
	}
	
	public String	xPathGetText(String strxpath,WebDriver driver) throws IOException, InterruptedException
	{
		String strData = null;
		try
		{
		
			WebDriverWait wait = new WebDriverWait(driver, 60);
			strData=wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(strxpath)))).getText();
				
		}
		catch(Exception e)
		{
			System.out.println("Unable to gettext "+strxpath);
		}
		return  strData;
		
	}
	
}
