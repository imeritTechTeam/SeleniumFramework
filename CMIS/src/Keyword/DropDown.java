package Keyword;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Locator;
import Utilities.WebDriverSelector;

public class DropDown 
{
	WebDriverSelector driver;
	
	public  void SelectValue(String strxpath,String strdata,WebDriver driver) throws IOException//String strxpath2
	{
		try
		{
			By SelectLocator=Locator.getWebElement(strxpath);
			WebDriverWait wait = new WebDriverWait(driver, 10);
		    Select Listvalue=new Select(wait.until(ExpectedConditions.presenceOfElementLocated(SelectLocator)));
			Listvalue.selectByVisibleText(strdata);
		}
			//input tag dropdown 
			/*else if(xpath.contains("input"))
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
			}*/
			
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
