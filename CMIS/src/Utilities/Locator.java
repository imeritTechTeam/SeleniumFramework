package Utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


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
        	// WebDriverSelector.ngDriver.waitForAngularRequestsToFinish();
   		    // WebDriverWait wait = new WebDriverWait(WebDriverSelector.driver, 10);
   		   //  webElement = wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorValue)));
        	 webElement = WebDriverSelector.driver.findElement(By.id(locatorValue));
        	
                    break;
        case "xpath" :
        	WebDriverSelector.ngDriver.waitForAngularRequestsToFinish();
  		     WebDriverWait wait = new WebDriverWait(WebDriverSelector.driver, 10);
  		     webElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
  		   
        	//webElement = WebDriverSelector.driver.findElement(By.xpath(locatorValue));
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
