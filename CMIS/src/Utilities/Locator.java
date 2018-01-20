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
		WebElement webElement = null;
		strlocator = ORFile.getlocator(locator).trim();
		String locatorType = strlocator.split(":")[0];
        String locatorValue = strlocator.split(":")[1];
        try{
        switch (locatorType.toLowerCase()){
        case "id" : webElement = driver.findElement(By.xpath(strlocator));;
                    break;
        case "xpath" : webElement = driver.findElement(By.xpath(strlocator));;
                    break; 
        case "name" : webElement = driver.findElement(By.xpath(strlocator));;
                    break;
        case "css" : webElement = driver.findElement(By.xpath(strlocator));;
                    break;
        case "linktext" : webElement = driver.findElement(By.xpath(strlocator));;
                    break;
		
        }
        }
        catch(NoSuchElementException e){

		e.printStackTrace();
		
		}

		return webElement;

		}
}
