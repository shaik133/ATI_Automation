/**
 * 
 */
package com.rsa.qa.actiondriver;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.rsa.qa.base.BasePage;

import freemarker.ext.beans.BooleanModel;

/**
 * @author Shaik Jafar Sadiq
 *
 */







public class Action extends BasePage{
	
	
	
	/*--------------- autosuggestive for amazon----------*/
	
	
	public static  void aotoSuggest(List<WebElement> ele, String text)
	{
		List<WebElement> Items=ele;
		for(WebElement Item:Items)
		{
			if(Item.getText().equalsIgnoreCase(text))
			{
				Item.click();
				break;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*--------------- Get Text-------------*/
	public static String getText(WebElement ele)
	{
		String text=ele.getText();
		System.out.println(text+" is the fetched text");
		return text;
	}
	
	
	/*-------------------Get Title method------*/
	
	public static String getTitle()
	{
		String Title = null;
		try
		{
			 Title=driver.getTitle();
			 return Title;
		}
		catch(Exception e)
		{
			e.getMessage();
			return null;
		}
		
		finally
		{
			if(Title != null)
			{
				System.out.println("Title of the page is "+Title);
			}
			else
			{
				System.out.println("Something went wrong while fetching Title of the page");
			}
		}
		
	}
	/*  Take Screenshot method*/
	public static String takeScreenshot(WebDriver driver, String testName) 
	{
		String desitnation = null;
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.hh.MM.ss").format(new Date());
		try {
		TakesScreenshot takeScreeshot = (TakesScreenshot)driver;
		File src=takeScreeshot.getScreenshotAs(OutputType.FILE);
		 desitnation = System.getenv("user.dir")+"\\Screenshots\\"+testName+"_"+timestamp+".png";
		FileUtils.copyFile(src, new File(desitnation));
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return desitnation;
		
	}
	
	
	/*     Select statement    */

	public static boolean select( WebElement ele, String text)
	{
		boolean flag=false;
		try
		{
			Select options = new Select(ele);
			options.selectByVisibleText(text);
			options.getFirstSelectedOption();	
			flag=true;
			return flag;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return flag;
		}
		finally
		{
			if(flag)
			{
				System.out.println(text+" is selected");
			}
			else
			{
				System.out.println(text+" is not selected");
			}
		}
		
		
	}
	

		
		
		
/*-------------------------------click method--------------*/
		
		public static boolean click(WebElement ele)
		{
			boolean flag=false;
			try {
			ele.click();
			flag=true;
			return flag;
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
				return flag;
			}
			finally
			{
				if (flag)
				{
					System.out.println(ele+ " is clicked");
				}
				else
				{
					System.out.println(ele+ " is  failed to click");
				}
			}
			
		}
		
		
/*-------------------Element displayed method------------*/		
		public static boolean isDisplayed(WebElement ele)
		{
		boolean display =ele.isDisplayed();
		return display;
		}

		/*--------------------------Send keys----------------------*/
		public static boolean sendKeys(WebElement ele,String text)
		{
			boolean flag=false;
			try
			{
			ele.sendKeys(text);
			flag=true;
			return flag;
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
				return flag;
			}
			finally
			{
				if(flag)
				{
					System.out.println(text+" sent");
				}
				else
				{
					System.out.println(text+" is failed to send");
				}
			}
		}
		
		
/*--------------------------------Switch to frame method---------------*/
		public static boolean switchToFrame(WebElement ele)
		{
			boolean flag=false;
			try {
				
				driver.switchTo().frame(ele);
				flag=true;
				return flag;
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
				return flag;
			}
			finally
			{
				if(flag)
				{
					System.out.println(ele+" switched to frame");
				}
				else
				{
					System.out.println(ele+" is failed to switch");
				}
			}
		}

/*-----------------Switch back to default content---------------*/		
		
	public static boolean switchToDefaultContent()	
	{
		boolean flag=false;
		try
		{
			driver.switchTo().defaultContent();
			flag=true;
			return flag;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return flag;
		}
		finally
		{
			if(flag)
			{
				System.out.println("Switched back to default content");
			}
			else
			{
				System.out.println("Failed to switch back to default content");
			}
		}
		
	}
	
// Dynamic incrementing dropdowm	
	
	public static void IncrementDropdown(WebElement ele, WebElement ele1)
	{
		for (int i=1; i<=3;i++)
		{
			ele.click();
		}
		for(int j=0; j<3;j++)
		{
			ele1.click();
		}
	}
	
/*--Implicite wait-----------*/
	
	public static void ImplitWait()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

/*-------------------Auto Suggest DropDown---------*/
	
	public static void autoSuggest(List<WebElement> ele, String text1)
	{
		try {
		List<WebElement> options = ele;
		for(WebElement option:options)
		{
			
			if(option.getText().equalsIgnoreCase(text1))
			{
				option.click();
				break;
			}
			}
			
			}
		catch(StaleElementReferenceException e)
		{
			List<WebElement> options = ele;
			for(WebElement option:options)
			{
				
				if(option.getText().equalsIgnoreCase(text1))
				{
					option.click();
					break;
				}
				}
				
		}
		}
	
		
	
	
/*--------------------Dynamic dropDown-------*/
	
public static boolean dynamicDD(WebElement ele, WebElement ele1)
{
	boolean flag= false;
	try
	{
		ele.click();
		ele1.click();
		flag=true;
		return flag;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return flag;
	}
	finally
	{
		if (flag)
		{
			System.out.println("From and To cities are selected");
		}
		else
		{
			System.out.println("Failed to select cities");
		}
	}
}

/*------------------------------ Is Enabled---------------*/

public static boolean isEnabled(WebElement ele)
{
	boolean enable=ele.isEnabled();
	return enable;
	
}

//Auto Suggest

public static String autoSuggestComplete(List<WebElement> ele, String text)
{

	try {
	List<WebElement>	options = ele;
	for (WebElement option: options)
	{
		if (option.getText().equalsIgnoreCase(text))
		{
			option.click();
			break;
			
		}
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return text;
	
}

//Select statement

public static boolean select1(WebElement ele, String text)
{
	boolean flag=false;
	try {
	Select option= new Select(ele);
	option.selectByVisibleText(text);
	option.getFirstSelectedOption();
	flag=true;
	return flag;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return flag;
	}
	finally
	{
		if (flag)
		{
			System.out.println(text+" is selected");
		}
		else
		{
			System.out.println(text+" is failed to select");
		}
	}
}

/*-------------------Switch window--------*/

public static void SwitchWindow()
{
	Set<String> windows= driver.getWindowHandles();
	int size =windows.size();
	
	Iterator<String> itr= windows.iterator();
	String mainWindow= itr.next();
	
	String childWindow= itr.next();
	driver.switchTo().window(childWindow);
}

/*---------------------Switch to new Window Tab-------------*/

public static String switchNewWinndowTab(String url)
{
	driver.switchTo().newWindow(WindowType.TAB);
	Set<String> windows= driver.getWindowHandles();
Iterator<String> it=	windows.iterator();
String parentId=it.next();
String childId= it.next();
driver.switchTo().window(childId);
driver.get(url);
return childId;
	
}

/*-------------------- Switch to Alert------------*/

public static void SwitchToAlert()
{
	
  Alert al =driver.switchTo().alert();
  al.getText();
  al.dismiss();

}	

/*-------------- Calculate values from fixed table----------  */

public static int sumValues(List<WebElement> ele)
{
	List<WebElement> options=  ele;
	int sum=0;
	for (int i=0; i< options.size();i++)		
	{
		sum=sum+(Integer.parseInt(options.get(i).getText()));
	}
	System.out.println(sum+" is total amount");
	return sum;
}

/*-----------Split the value method-------*/

public static int splitText(WebElement ele)
{
	int total=Integer.parseInt(ele.getText().split(":")[1].trim());
	System.out.println(total+" is expected amount");
	return total;
}

/*---------------calculate price-------- */

public static int sumOfPrice(List<WebElement> ele)

{
List<WebElement> list = ele;
int sum=0;
for (int i=0; i<list.size();i++)
{
	sum=sum+Integer.parseInt(list.get(i).getText());
}
System.out.println(sum+" is the total price of the products");
return sum;
}



/*--------------------------- Mouse Hover-----------------*/

public static void museHover(WebDriver driver, WebElement ele)
{
	
	Actions act = new Actions(driver);
	act.moveToElement(ele).build().perform();
}

/*------------------------ JavaAcript-----------*/

public static void JsScroll()
{
	JavascriptExecutor js= (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,6000)");
}


/*--------------- get no of Links-----------------*/

public static  void getLink(WebElement ele)
{
WebElement remotedriver = ele;	
remotedriver.findElements(By.tagName("a")).size();
for(int i=0; i<remotedriver.findElements(By.tagName("a")).size();i++)
{
	String key=Keys.chord(Keys.CONTROL,Keys.ENTER);
	remotedriver.findElements(By.tagName("a")).get(i).sendKeys(key);
}
Action.ImplitWait();
}

/*----------------------------- Get the broken Link------------*/

public static void getBrokenLink(List<WebElement> ele) throws IOException
{
List<WebElement> listoflinks = ele;
SoftAssert sa = new SoftAssert();
for(WebElement link:listoflinks)
{
	String url= link.getAttribute("href");
	HttpURLConnection conn = null;
	
	try {
		 conn= (HttpURLConnection) new URL(url).openConnection();
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	conn.setRequestMethod("HEAD");
	conn.connect();
	int resCode= conn.getResponseCode();
	sa.assertTrue(resCode<400, "The Broken link is "+"'"+link.getText()+"'"+" with response code of "+resCode);
}
sa.assertAll();
}

/*-------------------------- Add to cart action-------------*/


public static void addToCart( List<WebElement> ele)
{
	String[] veggies= {"Brocolli","Carrot","Potato","Corn"};
	List<WebElement> items= ele;
	int j=0;
	for (int i=0;i<items.size();i++)
	{
		String formatedItems=items.get(i).getText().split("-")[0].trim();
		
		List Vegitems=Arrays.asList(veggies);
		
		if(Vegitems.contains(formatedItems))
		{
			driver.findElements(By.xpath("//div[@class='product-action']//button")).get(i).click();
			j++;
			
			if(j==veggies.length) 
			{
				break;
			}
	}
	
	
	}
	}



/*----------- footerlinks click--------*/

public static void clickEachLink(WebElement ele)
{
	

WebElement footer=ele;

List<WebElement> links =footer.findElements(By.tagName("a"));
for(int i=0;i<links.size();i++)
{
	String keys= Keys.chord(Keys.CONTROL,Keys.ENTER);
	links.get(i).sendKeys(keys);
}

}

/*------------------------Get the broken Link1-----------*/
public static void getbrokenLink(WebElement ele) throws MalformedURLException, IOException
{
	WebElement footer= ele;
	List<WebElement> links= footer.findElements(By.tagName("a"));
	SoftAssert sa= new SoftAssert();
	for(int i=0;i<links.size();i++)
	{
		String url=links.get(i).getAttribute("href");
		HttpURLConnection conn= (HttpURLConnection)new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int rescode=conn.getResponseCode();
		sa.assertTrue(rescode<400, "the broken link is "+"'"+links.get(i).getText()+"'"+" wih the response code of "+rescode);
	}
	sa.assertAll();
}

}