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
		protected static WebDriver driver;
		static boolean status=true;
		static Properties OR;
		String strxpath,strdata;
		//static JavascriptExecutor js=(JavascriptExecutor)driver;
		//static ITestResult result;
		
		
		
	public static void LaunchApp(String strxpath,String browser) throws IOException
	{ 
		String url=ORFile.getlocator(strxpath);
		
		try
		{
			// if Browser is IE
			if(browser.equalsIgnoreCase("IE"))
			{
				System.setProperty("webdriver.ie.driver", "E:\\IEDriverServer_x64_2.53.1\\IEDriverServer.exe");
				driver=new InternetExplorerDriver();	
				driver.get(url);
				driver.manage().window().maximize();
			}
			// if Browser is Firefox
			else if(browser.equalsIgnoreCase("Firefox"))
			{
			System.setProperty("webdriver.gecko.driver","E:\\Driver\\geckodriver.exe");
			driver=new FirefoxDriver();	
			driver.get(url);
			driver.manage().window().maximize();
			}
			// if Browser is Chrome
			else
			{
				System.setProperty("webdriver.chrome.driver","E:\\chromedriver\\chromedriver.exe");
				driver=new ChromeDriver();	
				driver.get(url);	
				driver.manage().window().maximize();
			}
			
		}
		catch(Exception e)
		{
			status=false;
		}
		
	}

	// Button click function starts
	
	public static boolean ButtonClick(String strxpath) throws IOException, InterruptedException
	{
		
		try
		{
		String xpath=ORFile.getlocator(strxpath);
		Thread.sleep(500);
		WebElement button=driver.findElement(By.xpath(xpath));
		if(button.isDisplayed())
		{
			button.click();
		}
		}catch(Exception e)
		{
			status=false;
		}
		return status;
	}// Button click function ends
	//EnterText click function starts
	public static void EnterText(String strxpath,String strData) throws IOException, InterruptedException
	{
		try
		{
		String xpath=ORFile.getlocator(strxpath);
		Thread.sleep(500);
		WebElement textbox=driver.findElement(By.xpath(xpath));
		Thread.sleep(500);
		textbox.sendKeys(strData);
				
		}
		catch(Exception e)
		{
			status=false;
		}
		
	}
	//Funtion for CheckBox
	public static void VerifyCheckbox(String strxpath) throws FileNotFoundException, IOException
	{
		try
		{
		String xpath2=ORFile.getlocator(strxpath);
		List<WebElement> checkboxs=driver.findElements(By.tagName("label"));
		
		for(WebElement checkbox:checkboxs )
		{
			String xpath1="//input[@id=";
			String xpath3="]/following-sibling::span[@class='lever']";
			String xpath=xpath1+xpath2+xpath3;
			WebElement ele=driver.findElement(By.xpath(xpath));
			if(!(checkbox.isSelected()))
				{
				
				ele.click();
				break;
				}	
		}
		}
		catch(Exception e)
		{
			status=false;
		}
		
		
		}
   //Function for Link click 
	public static void LinkClick(String strxpath,String strdata) throws IOException, InterruptedException
	{
		try
		{
		String xpath=ORFile.getlocator(strxpath);
		
		if(xpath==null)
		{
			WebElement Link =driver.findElement(By.linkText(strdata));
			Thread.sleep(1000);
			Link.click();
					
		}
		else
		{
			WebElement Link=driver.findElement(By.xpath(xpath));
			Thread.sleep(1000);
			Link.click();
		}
		
		}
		catch(Exception e)
		{
			status=false;
		}

		}
		
	
	public static void VerifyText(String strxpath,String strdata) throws IOException
	{
	try
		{
		String xpath=ORFile.getlocator(strxpath);
		WebElement vr_Text=driver.findElement(By.xpath(xpath));
		String actualText=vr_Text.getText();
		Assert.assertEquals(actualText, strdata, "Text not match");
		
		}
		catch(Exception e)
		{
			status=false;
		}
		
		
		
		}
		
	public static void SelectListValue(String strxpath,String strdata) throws IOException//String strxpath2
	{
		try
		{
			//Thread.sleep(1000);
			String xpath=Utilities.ORFile.getlocator(strxpath);
			//Select tag dropdown 
			if(xpath.contains("select"))
		    {
			WebElement Selectlist=driver.findElement(By.xpath(xpath));
			Select Listvalue=new Select(Selectlist);
			Listvalue.selectByVisibleText(strdata);
			}
			//input tag dropdown 
			else if(xpath.contains("input"))
		    {
				WebElement select=driver.findElement(By.xpath(xpath));
				select.click();
				Thread.sleep(1000);
				List<WebElement> options = driver.findElements(By.tagName("span"));
				
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
				WebElement select=driver.findElement(By.xpath(xpath4));
				select.click();
				Thread.sleep(500);
				List<WebElement> options = driver.findElements(By.tagName("span"));
				
				for(WebElement opt: options )
			      {
					if(strdata.equalsIgnoreCase(opt.getText()))
				    {
				opt.click();
				    }
			      }
			}
			
		}
		catch(Exception e)
		{
			status=false;
		}
	}
    //Function for Data picker
	public static void DatePicker(String strxpath,String strdata) throws ParseException 
	{
		
		try
		{
			String TstXpath=Utilities.ORFile.getlocator(strxpath);
			String YearXpath="//select[@class='picker__select--year browser-default']";
			String MonXpath="//select[@class='picker__select--month browser-default']";
			SimpleDateFormat FormatDate=new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat f1=new SimpleDateFormat("dd");
			SimpleDateFormat f2=new SimpleDateFormat("MMMM");
			SimpleDateFormat f3=new SimpleDateFormat("yyyy");
			
			//Date tdate=new Date();
			//Calendar cur_cal=Calendar.getInstance();
			//cur_cal.setTime(tdate);
			Date g_date=FormatDate.parse(strdata);
		    //Calendar g_cal=Calendar.getInstance();
			//g_cal.setTime(g_date);
			
			String g_Date=f1.format(g_date);
			String g_Month=f2.format(g_date);
			String g_Year=f3.format(g_date);
			
			System.out.println("g_Date"+g_Date);
			System.out.println("g_Month"+g_Month);
			System.out.println("g_Year"+g_Year);
			
			WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute 
			WebElement dt=driver.findElement(By.xpath(TstXpath));
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TstXpath)));
			Point pt=dt.getLocation();
			System.out.println(pt);
			//Click on Date field
			int X=pt.getX();
			int Y=pt.getY();
			System.out.println("    X"+X+"    Y"+Y);
			Actions ac = new Actions(driver);
			ac.moveToElement(dt,X,Y).click(dt).perform();
			//dt.click();
			//Select Year
			//New script add 
			WebElement sel_year=driver.findElement(By.xpath(YearXpath));
			Select Yearval=new Select(sel_year);
			Yearval.selectByVisibleText(g_Year);
					
			//Select month
			WebElement sel_mon=driver.findElement(By.xpath(MonXpath));
			Select Monthval=new Select(sel_mon);
			Monthval.selectByVisibleText(g_Month);
						
			//select Date
			String sel_date="//div[contains(text(),'"+g_Date+"')]";
			System.out.println(sel_date);
			WebElement date=driver.findElement(By.xpath(sel_date));
			date.click();
			driver.findElement(By.xpath("//button[contains(text(),'Close')]")).click();
						
		}
			
		catch(Exception e)
		{
			status=false;
		} 
	}
	//Datapick function ends(When Month Year are not drop down 
	public static void datepick(String strxpath,String strdata) throws InterruptedException, ParseException, FileNotFoundException, IOException
	{
	
	int Cal_mon=0;
	String TstXpath=ORFile.getlocator(strxpath);
	SimpleDateFormat FormatDate=new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat f1=new SimpleDateFormat("dd");
	SimpleDateFormat f2=new SimpleDateFormat("MM");
	SimpleDateFormat f3=new SimpleDateFormat("yyyy");
	SimpleDateFormat f4=new SimpleDateFormat("MMMM");
	//String dt="6/2/2017";
	//dr.get("http://jqueryui.com/datepicker/");
	//driver.switchTo().frame(0);
	Thread.sleep(4000);
	WebElement txtbx=driver.findElement(By.xpath(TstXpath));
	txtbx.click();
	
	Date tdate=new Date();
	Calendar cur_cal=Calendar.getInstance();
	cur_cal.setTime(tdate);
	Date g_date=FormatDate.parse(strdata);
    Calendar g_cal=Calendar.getInstance();
	g_cal.setTime(g_date);
		
	//Change Given date in dd/mm/yyyy	
	String g_Date=f1.format(g_date);
	int g_Month=Integer.parseInt(f2.format(g_date));
	int g_Year=Integer.parseInt(f3.format(g_date));
	int cur_mon=Integer.parseInt(f2.format(tdate));
	
	String Cur_month=f4.format(tdate);
	System.out.println("Given Date"+g_Date);
	System.out.println("Given Month"+g_Month);
	System.out.println("Given Year"+g_Year);
	
	//Dynamic Xpath creation 
	String xpath1="//div[contains(text(),";
	String xpath2="'"+Cur_month+"')]";
	String xpath=xpath1+xpath2;
	WebElement dt_month=driver.findElement(By.xpath(xpath));
	WebElement dt_Year=driver.findElement(By.xpath("//div[@class='picker__year']"));
	
	//Calculate Date difference to count number of Hits
	
	int Next_diffYear = g_cal.get(Calendar.YEAR) - cur_cal.get(Calendar.YEAR);
	int Next_diffMonth = Next_diffYear * 12 + g_cal.get(Calendar.MONTH) - cur_cal.get(Calendar.MONTH);
	System.out.println("Next Total month"+Next_diffMonth);
	
	int Prev_diffYear=cur_cal.get(Calendar.YEAR)-g_cal.get(Calendar.YEAR);
	int Prev_diffMonth = Prev_diffYear * 12 + cur_cal.get(Calendar.MONTH) - g_cal.get(Calendar.MONTH);
	System.out.println("Previous Total month"+Prev_diffMonth);
	
	//Count Calendar month
	if(dt_month.isDisplayed())
	{
	Cal_mon=cur_mon;
	}
	int Cal_Year=Integer.parseInt(dt_Year.getText());
	
	String d_xpath1="//div[contains(text(),'";
	String d_xpath=d_xpath1+g_Date+"')]";
	
	System.out.println("Calendar month"+Cal_mon);
	System.out.println("Calendar year"+Cal_Year);
	
	//If Given month & Calendar month and Given year & Calendar year are same
	if((g_Year==Cal_Year)&&(g_Month==Cal_mon))
	{
		System.out.println("If part");
		driver.findElement(By.xpath("//tr")).click();
		//driver.findElement(By.xpath("//tr")).click();
		WebElement dates=driver.findElement(By.xpath(d_xpath));
		dates.click();
		/*for(WebElement dateval: dates)
		{
			System.out.println(dateval.getText());
			String date1=dateval.getText();
			String date=get_Date(date1);
			System.out.println(date);
			if(g_Date.equals(date))
			{
				dateval.click();
				break;
			}
		
		}*/
	}
	//If Given month is greater than Calendar month and Given year is greater than Calendar year are same
		else if(((g_Year>Cal_Year)&&(g_Month>Cal_mon))||((g_Year>Cal_Year)&&(g_Month<Cal_mon))||(g_Year==Cal_Year)&&(g_Month>Cal_mon))
				{
			         System.out.println("else if part");
				Thread.sleep(2000);
			 for(int i=1;i<=Next_diffMonth;i++)
			          {
				        System.out.println("Value of I:"+i);
				        
				        WebElement dt_next=driver.findElement(By.xpath("//div[@title='Next month']"));
					    dt_next.click();
			          }  
			 driver.findElement(By.xpath("//tr")).click();
	        //List<WebElement> dates=driver.findElements(By.tagName("a"));
			WebElement dates=driver.findElement(By.xpath(d_xpath));
			dates.click();
		   /* for(WebElement dateval: dates)
			  {
		    	System.out.println(dateval.getText());
				String date1=dateval.getText();
				String date=get_Date(date1);
		    	
		    	if(g_Date.equals(date))
				{
					System.out.println("Match Date is "+date);
					dateval.click();
					break;
				}
			
			  }*/
			
		 }
	//If Given month is less than Calendar month and Given year is less than Calendar year are same
		else if((g_Year<Cal_Year)||(g_Month<Cal_mon))
		{
			System.out.println("else part");
			for(int i=1;i<=Prev_diffMonth;i++)
			    {
				 System.out.println("Else Value of I:"+i);
				 WebElement dt_next=driver.findElement(By.xpath("//div[@title='Previous month']"));
		         dt_next.click();	
		        }
			driver.findElement(By.xpath("//tr")).click();
			WebElement dates=driver.findElement(By.xpath(d_xpath));
			dates.click();
			
			/*for(WebElement dateval: dates)
			{
				String date1=dateval.getText();
				String date=get_Date(date1);
				if(g_Date.equals(date))
				//if(g_Date.equals(date1.getText()))
				{
					System.out.println(dateval.getText());
					dateval.click();
					break;
				}	
	        } */ 		
		}
			
	driver.findElement(By.xpath("//button[contains(text(),'Close')]")).click();	
		}	//Datapick function ends(When Month Year are not drop down 
	
	public static String get_Date(String date)
	
	{
	   if(!date.equalsIgnoreCase("Prev")&&!date.equalsIgnoreCase("Next"))
	   {
		if(Integer.parseInt(date)<10)
		{
			date="0"+date;
			
		}
	   }		
		return date;
	}
	 public static void SelectItem(String strxpath ,String strdata)
	 {
		 try
		 {
		 //String xpath1="//span[contains(text(),'";
	     String xpath2=Utilities.ORFile.getlocator(strxpath);
		 //Actions ac =new Actions(driver);
		 //String xpath=xpath1+strdata+"')]";
		 System.out.println("Selectitem"+xpath2);
		 WebElement Txtbox=driver.findElement(By.xpath(xpath2));
		 Txtbox.click();
		 List<WebElement> Mainitem=driver.findElements(By.xpath("//div[6]/ul"));
		 for(WebElement mn:Mainitem)
		 {
			 System.out.println(mn.getText());
		// ac.moveToElement(Mainitem).click();
		 System.out.println("main Selected");
		 //WebElement Listitem=driver.findElement(By.xpath(xpath));
		 if(strdata.equals(mn.getText()))
		 {
			 mn.click();
		 System.out.println("Value Selected");
		 }
		 }
		 }
		 catch(NoSuchElementException e) 
		 {
			 System.out.println(e.getMessage());
		 } catch (Exception e)
		 {
			 System.out.println(e.getMessage());
		 }
		
	 }
	//Funtion for Radio button
	 public static void ClickRadio(String strdata)
	 {
		 try
		 {
			 String xpath1="//label[@for='";
			 String xpath=xpath1+strdata+"']";
			 WebElement OradioButton=driver.findElement(By.xpath(xpath));
			 if(OradioButton.isEnabled())
			 {
				 OradioButton.click();
			 }
		 }catch(Exception e) 
		 {
			 status=false;
		 }
	 }
  //Verify error message
	 public static void VerifyAlertMsg(String strxpath,String strdata) throws IOException, InterruptedException
	 {
		  try
		  {
		    //JavascriptExecutor js=(JavascriptExecutor)driver;
			//js.executeScript("scroll(0,500)");
			String xpath=Utilities.ORFile.getlocator(strxpath);
			WebElement d1=driver.findElement(By.xpath(xpath));
			d1.click();
			System.out.println("Save button clicked");
			Thread.sleep(4000);
			WebElement erorClick=driver.findElement(By.tagName("//div[4]/ul"));
			erorClick.click();
			System.out.println("Error list clicked");
			List<WebElement> error=driver.findElements(By.tagName("li"));
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
		 driver.quit();
	 }
	 public static void isAlertMessage()
	 {
		 driver.switchTo().alert().accept();
	 }
	}	
			




