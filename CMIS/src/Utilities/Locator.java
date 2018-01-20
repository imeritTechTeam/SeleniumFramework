package Utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Locator {

	
	public static WebElement getWebElement(String locator) throws FileNotFoundException, IOException
	{

		String strlocator;
		WebElement webElement = null;
		strlocator = ORFile.getlocator(locator).trim();
		String locatorType = strlocator.split(":")[0];
        String locatorValue = strlocator.split(":")[1];
        System.out.println(locatorType);
        System.out.println(locatorValue);
        
        try{
        switch (locatorType){
        case "id" :
        	webElement = WebDriverSelector.driver.findElement(By.id(locatorValue));
                    break;
        case "xpath" :
        	webElement = WebDriverSelector.driver.findElement(By.xpath(locatorValue));
                    break; 
        case "name" : 
        	webElement = WebDriverSelector.driver.findElement(By.name(locatorValue));
                    break;
        case "css" : 
        	webElement = WebDriverSelector.driver.findElement(By.cssSelector(locatorValue));
                    break;
        case "linktext" : 
        	webElement = WebDriverSelector.driver.findElement(By.linkText(locatorValue));
                    break;
		
        }
        }
        catch(NoSuchElementException e){

		e.printStackTrace();
		
		}

		return webElement;

		}
}
