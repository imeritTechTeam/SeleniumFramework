package Keyword;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.paulhammant.ngwebdriver.NgWebDriver;

import Utilities.Locator;
import Utilities.ORFile;
import Utilities.WebDriverSelector;

public class Button {
	
	static WebDriverSelector driver;
	
	public static void Click(String strxpath) throws IOException, InterruptedException
	{
		
		try
		{
		
		WebElement button=Locator.getWebElement(strxpath);
		//WebElement button=((WebElement) driver).findElement(By.xpath(xpath));
		if(button.isDisplayed())
		{
			button.click();
		}
		}catch(Exception e)
		{
			  e.printStackTrace();
		}
		
	}// Button click function ends
}
