package Keyword;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		
		By buttonLocator=Locator.getWebElement(strxpath);
		WebDriverWait wait = new WebDriverWait(WebDriverSelector.driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(buttonLocator)).click();
		
		}catch(Exception e)
		{
			  e.printStackTrace();
		}
		
	}
	
	public static void isPresent(String strxpath) throws IOException, InterruptedException
	{
		
		try
		{
		
		By buttonLocator=Locator.getWebElement(strxpath);
		WebDriverWait wait = new WebDriverWait(WebDriverSelector.driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(buttonLocator));
		
		}catch(Exception e)
		{
			  e.printStackTrace();
		}
		
	}
	public static void isEnable(String strxpath) throws IOException, InterruptedException
	{
		
		try
		{
		
		By buttonLocator=Locator.getWebElement(strxpath);
		WebDriverWait wait = new WebDriverWait(WebDriverSelector.driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(buttonLocator)).isEnabled();
		
		}catch(Exception e)
		{
			  e.printStackTrace();
		}
		
		
		
	}
}
