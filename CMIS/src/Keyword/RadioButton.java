package Keyword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.WebDriverSelector;

public class RadioButton {
	static WebDriverSelector driver;
	 public static void ClickRadio(String strdata)
	 {
			
		 try
		 {
			 String xpath1="//label[@for='";
			 String xpath=xpath1+strdata+"']";
			 WebElement OradioButton=((WebDriver) driver).findElement(By.xpath(xpath));
			 if(OradioButton.isEnabled())
			 {
				 OradioButton.click();
			 }
		 }catch(Exception e) 
		 {
			 e.printStackTrace();
		 }
	 }
}
