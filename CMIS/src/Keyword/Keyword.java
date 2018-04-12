package Keyword;

import java.io.IOException;

import java.util.Properties;
import java.util.Set;

import Utilities.Locator;
import Utilities.ORFile;
import Utilities.WebDriverSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



	public class Keyword 
	{ 
		WebDriverSelector driver=new WebDriverSelector();
		static Properties OR;
		String strxpath,strdata;
		
		
		
	
	
	public void VerifyText(String strxpath,String strdata,WebDriver driver) throws IOException
	{
	try
		{
		By LinkLocator=Locator.getWebElement(strxpath);
		WebDriverWait wait = new WebDriverWait(driver, 70);
		String actualText=wait.until(ExpectedConditions.elementToBeClickable(LinkLocator)).getText();	
		Assert.assertEquals(actualText, strdata, "Text not match");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		}
	
	
	
	
	}	
			




