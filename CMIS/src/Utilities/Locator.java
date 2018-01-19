package Utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Locator {

	static WebDriverSelector driver;
	public static WebElement getWebElement(String locator) throws FileNotFoundException, IOException
	{

		String strlocator;
		//boolean tokens = locator.contains("XPATH");
		
		WebElement webElement = null;

		try{

		if(locator.contains("XPATH")){

		strlocator = ORFile.getlocator(locator).trim();
		webElement = driver.findElement(By.xpath(strlocator));

		}else if(locator.contains("ID"))
		{
		strlocator = ORFile.getlocator(locator).trim();
		webElement = driver.findElement(By.id(strlocator));

		}else if(locator.contains("NAME")){
		strlocator = ORFile.getlocator(locator).trim();
		webElement = driver.findElement(By.name(strlocator));

		}else if(locator.contains("CSS")){
		strlocator = ORFile.getlocator(locator).trim();
		webElement = driver.findElement(By.cssSelector(strlocator));

		}else if(locator.contains("LINKTEXT")){
		strlocator = ORFile.getlocator(locator).trim();
		webElement = driver.findElement(By.linkText(strlocator));
		}

		}catch(NoSuchElementException e){

		e.printStackTrace();
		
		}

		return webElement;

		}
}
