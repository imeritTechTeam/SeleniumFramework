package Keyword;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import Utilities.ORFile;
import Utilities.WebDriverSelector;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



	public class Keyword 
	{ 
		static WebDriverSelector driver;
		static boolean status=true;
		static Properties OR;
		String strxpath,strdata;
		//static JavascriptExecutor js=(JavascriptExecutor)driver;
		//static ITestResult result;
		
		
		
	
	public static void VerifyText(String strxpath,String strdata) throws IOException
	{
	try
		{
		String xpath=ORFile.getlocator(strxpath);
		WebElement vr_Text=((WebDriver) driver).findElement(By.xpath(xpath));
		String actualText=vr_Text.getText();
		Assert.assertEquals(actualText, strdata, "Text not match");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		}
	
	 public static void VerifyAlertMsg(String strxpath,String strdata) throws IOException, InterruptedException
	 {
		  try
		  {
		    //JavascriptExecutor js=(JavascriptExecutor)driver;
			//js.executeScript("scroll(0,500)");
			String xpath=Utilities.ORFile.getlocator(strxpath);
			WebElement d1=((WebDriver) driver).findElement(By.xpath(xpath));
			d1.click();
			System.out.println("Save button clicked");
			Thread.sleep(4000);
			WebElement erorClick=((WebDriver) driver).findElement(By.tagName("//div[4]/ul"));
			erorClick.click();
			System.out.println("Error list clicked");
			List<WebElement> error=((WebDriver) driver).findElements(By.tagName("li"));
			for(WebElement e1: error )
			{
				
				if(strdata.equalsIgnoreCase(e1.getText()))
				{
					System.out.println(xpath);
					System.out.println(e1.getText());
				    Assert.assertEquals(e1.getText(),strdata,"Error message exists");
				}
			}
	 }catch(Exception e)
	 {
		 status=false;
	 }
	 }
	 public static void driverQuit()
	 {
		 ((WebDriver) driver).quit();
	 }
	 public static void isAlertMessage()
	 {
		 ((WebDriver) driver).switchTo().alert().accept();
	 }
	}	
			




