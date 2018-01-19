package Keyword;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Utilities.WebDriverSelector;

public class DropDown 
{
	static WebDriverSelector driver;
	
	public static void SelectListValue(String strxpath,String strdata) throws IOException//String strxpath2
	{
		try
		{
			//Thread.sleep(1000);
			String xpath=Utilities.ORFile.getlocator(strxpath);
			//Select tag dropdown 
			if(xpath.contains("select"))
		    {
			WebElement Selectlist=((WebDriver) driver).findElement(By.xpath(xpath));
			Select Listvalue=new Select(Selectlist);
			Listvalue.selectByVisibleText(strdata);
			}
			//input tag dropdown 
			else if(xpath.contains("input"))
		    {
				WebElement select=((WebDriver) driver).findElement(By.xpath(xpath));
				select.click();
				Thread.sleep(1000);
				List<WebElement> options = ((WebDriver) driver).findElements(By.tagName("span"));
				
				for(WebElement opt: options )
			      {
					if(strdata.equalsIgnoreCase(opt.getText()))
				    {
				opt.click();
				    }
			      }
		    }
			//input tag dropdown if name contains single quotes 
			else
			{
				String xpath1="//input[@value=\"";
				String xpath3="\"]";
				String xpath4=xpath1+xpath+xpath3;
				WebElement select=((WebDriver) driver).findElement(By.xpath(xpath4));
				select.click();
				Thread.sleep(500);
				List<WebElement> options = ((WebDriver) driver).findElements(By.tagName("span"));
				
				for(WebElement opt: options )
			      {
					if(strdata.equalsIgnoreCase(opt.getText()))
				    {
				opt.click();
				    }
			      }
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
