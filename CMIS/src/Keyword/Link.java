package Keyword;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utilities.Locator;
import Utilities.ORFile;
import Utilities.WebDriverSelector;

public class Link {
	
	WebDriverSelector driver;
	
	public void Click(String strxpath,WebDriver driver) throws IOException, InterruptedException
	{
		try
		{ 
			By LinkLocator=Locator.getWebElement(strxpath);
			WebDriverWait wait = new WebDriverWait(driver, 70);
			wait.until(ExpectedConditions.elementToBeClickable(LinkLocator)).click();	
		}
		catch(Exception e)
		{
			System.out.println("Unable to click on link"+strxpath);
		}

		}
	public void JSClick(String strxpath,WebDriver driver) throws IOException, InterruptedException
	{
		try
		{ 
			By LinkLocator=Locator.getWebElement(strxpath);
			WebElement elementToClick = driver.findElement(LinkLocator);
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", elementToClick);			 
			elementToClick.click();
		}
		catch(Exception e)
		{
			System.out.println("Unable to click on link "+strxpath);
		}

		}
	public void XpathClick(String strxpath,WebDriver driver) throws IOException, InterruptedException
	{
		try
		{ 
			WebElement elementToClick = driver.findElement(By.xpath(strxpath));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", elementToClick);			 
			elementToClick.click();
		}
		catch(Exception e)
		{
			System.out.println("Unable to click on link"+strxpath);
		}

		}
	
	public void isPresent(String strxpath,WebDriver driver) throws IOException, InterruptedException
	{
		try
		{ 
			By LinkLocator=Locator.getWebElement(strxpath);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(LinkLocator));	
		}
		catch(Exception e)
		{
			System.out.println("Link is not present "+strxpath);
		}

		}
	public void isEnable(String strxpath,WebDriver driver) throws IOException, InterruptedException
	{
		try
		{ 
			By LinkLocator=Locator.getWebElement(strxpath);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(LinkLocator)).isEnabled();	
		}
		catch(Exception e)
		{
			System.out.println("Link is not enabled");
		}

		}
}
