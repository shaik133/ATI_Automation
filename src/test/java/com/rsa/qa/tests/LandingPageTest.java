/**
 * 
 */
package com.rsa.qa.tests;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rsa.qa.base.BasePage;
import com.rsa.qa.pages.LandingPage;

/**
 * @author Admin
 *
 */
public class LandingPageTest extends BasePage{

	LandingPage landingPage;
	
	public LandingPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		launch();
		landingPage= new LandingPage();
	}
	
	@Test(priority=1)
	public void getTitleTest()
	{
		log.info("Validating Page Title");
		String title=landingPage.getTitle();
		Assert.assertEquals(title, "QAClickJet - Flight Booking for Domestic and International, Cheap Air Tickets");
		log.info("Page title is displayed as expected");
	}
	@Test(priority=2)
	public void ClickCheckBoxTest()
	{
		log.info("checking the Family and Friends check box");
		landingPage.checkBox();
		log.debug("checkbox is checked");
	}
	@Test(priority=3)
	public void selectDropdownTest()
	{
		log.info("Slecting the dropdown list");
		landingPage.select();
		log.info("dropdown selected");
	}
	
	@Test(priority=4)
	public void passengerDDClickTest()
	{
		log.info("Slecting no of adults and no of children");
		landingPage.passengerDDClick();
	}
	
	@Test(priority=5)
	public void AutoSuggestDDTest()
	{
		log.info("Entering the values in Autosuggest dropdown");
		landingPage.AutoSuggestDD(prop.getProperty("AutosuggestSendkeys"),prop.getProperty("AutosugestEntry"));
		log.info("Value is seleced");
		
	}
	
	@Test(priority=6)
	public void SelectCitiesTest()
	{
		landingPage.SelectCities();
	}
	
	@Test(priority=7)
	public void SelectDeprtDateTest()
	{
		log.info("Selecting departure date");
		landingPage.SelectDeprtDate();
		log.info("Departure date is selected");
		
		Assert.assertTrue(landingPage.returnDateBox());
		
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
	
}
