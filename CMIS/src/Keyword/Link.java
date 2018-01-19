package Keyword;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.ORFile;
import Utilities.WebDriverSelector;

public class Link {
	
	static WebDriverSelector driver;
	public static void Click(String strxpath,String strdata) throws IOException, InterruptedException
	{
		try
		{
		String xpath=ORFile.getlocator(strxpath);
		
		if(xpath==null)
		{
			WebElement Link =((WebDriver) driver).findElement(By.linkText(strdata));
			Thread.sleep(1000);
			Link.click();
					
		}
		else
		{
			WebElement Link=((WebDriver) driver).findElement(By.xpath(xpath));
			Thread.sleep(1000);
			Link.click();
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		}
}
