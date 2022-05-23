/**
 * 
 */
package com.rsa.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.rsa.qa.utils.ExtentReport;

/**
 * @author Admin
 *
 */
public class BasePage {

	public static	Properties prop;
	public static WebDriver driver;
	public static Logger log;
	
	@BeforeSuite
	public void launchReports() throws IOException
	{
		ExtentReport.reportSetup();
	}
	
	@BeforeClass
	public void setupLog4j()
	{
		log= Logger.getLogger(getClass());
		PropertyConfigurator.configure("log4j.properties");
	}
	
	public BasePage()
	{
		try {
		 prop = new Properties();
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\rsa\\qa\\configuration\\config.properties");
		prop.load(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void launch()
	{
		String browser = prop.getProperty("browser");
		if (browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\com\\rsa\\qa\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else
		{
			System.out.println("firfox Browser");
		}
		
		driver.get(prop.getProperty("practiceURL"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	@AfterSuite
	public void flushReport()
	{
		ExtentReport.flushReport();
	}
	
}
