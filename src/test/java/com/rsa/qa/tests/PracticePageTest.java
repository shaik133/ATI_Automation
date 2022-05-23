/**
 * 
 */
package com.rsa.qa.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rsa.qa.base.BasePage;
import com.rsa.qa.pages.PracticePage;

/**
 * @author Admin
 *
 */
public class PracticePageTest extends BasePage {

	PracticePage practicePage;
	
	public PracticePageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setup()
	{
		log.info("Browser is getting launched");
		launch();
		practicePage= new PracticePage();
	}
	
	@Test(priority=1)
	public void getPageTitleTest()
	{
		log.info("Validating pageTitle");
		String Title= practicePage.getPageTitle();
		Assert.assertEquals(Title, "Practice Page");
	}
	
	@Test(priority=2)
	public void clickRadioBtnTest()
	{
		log.info("selecting Radio button");
		practicePage.clickRadioBtn();
	}
	
	@Test(priority=3)
	public void autoCompleteTabTest()
	{
		log.info("sending values in autosuggest tab and clicking desired value");
	 String text =practicePage.autoCompleteTab();
	 System.out.println(text+" is clicked");
	}
	
	@Test(priority=4)
	public void selectDDTest()
	{
		log.info("Selecting desied value from select dropdown");
		practicePage.selectDD();
	}
	
	@Test(priority=5)
	public void checkBoxTest()
	{
		log.info("select check box");
		practicePage.checkBox();
	}
	
	@Test(priority=6)
	public void getwindowSizeTest()
	{
		log.info("switching to child window");
		practicePage.getwindowSize();
	}
	
	@Test(priority=7)
	public void SwitchToNewWindowTest()
	{
		log.info("new tab is being clicked");
		String Title = practicePage.SwitchToNewWindow(prop.getProperty("newURL"));
		log.debug("new url is passed and browser is opened");
		log.info("validating new page title");
		Assert.assertEquals(Title, "Rahul Shetty Academy");
	}
	
	@Test(priority=8)
	public void switchToAlertTest()
	{
		log.info("switching to alert");
		practicePage.switchToAlert();
		log.debug("alert is accepted");
	}
	
	@Test(priority=9)
	public void elementDisplayTest()
	{
		log.debug("validating text box is visible or not");
		practicePage.elementDisplay();
		Assert.assertTrue(true);
	}
	
	@Test(priority=10)
	public void elementNotDisplayTest()
	{
		log.info("validating text box is visible or not");
		

		Assert.assertTrue(practicePage.elementNotDisplay());
	}
	
	@Test(priority=11)
	public void validateSumofTable()
	{
		log.info("calculating total sum of amount from all rows");
		int totalSum=practicePage.SumOflistTable();
		
		log.info("Total amount present on screen");
		int ExpectedSum=practicePage.TotalOfTable();
		
		Assert.assertEquals(totalSum, ExpectedSum);
		
	}
	
	@Test(priority=12)
	public void TotalPriceTest()
	{
		log.info("Vaildating the total price of the products listed");
		practicePage.TotalPrice();
	}
	
	@Test(priority=13)
	public void mouseHoverClickTest()
	{
		log.info("Mouse movement action and click on reload");
		practicePage.mouseHoverClick();
	}
	
	@Test(priority=14)
	public void iframeSwitchTest()
	{
		log.info("validating the text by switching into frame");
		practicePage.iframeSwitch();
	}
	
	@Test(priority=15)
	public void getEachLinkTest()
	{
		practicePage.getEachLink();
	}
	
	@Test(priority=16)
	public void getBrokenLinkTest() throws IOException
	{
		log.info("Vaildating the each link and finding broken link");
		practicePage.getBrokenLink();	
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
		log.info("Browser is closed");
	}
	
}
