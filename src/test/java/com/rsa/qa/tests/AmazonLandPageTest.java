/**
 * 
 */
package com.rsa.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rsa.qa.base.BasePage;
import com.rsa.qa.pages.AmazonLandPage;
import com.rsa.qa.pages.SigninPage;

/**
 * @author Admin
 *
 */
public class AmazonLandPageTest extends BasePage {

	AmazonLandPage amazonLandPage;
	SigninPage signinPage;
	
	public AmazonLandPageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setup()
	{
		launch();
		amazonLandPage = new AmazonLandPage();
	}
	
	
	@Test(priority=1)
	public void getTitleTest()
	{
	String title =	amazonLandPage.getTitle();
	Assert.assertEquals(title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	}
	
	
	@Test(priority=2)
	public void clickAccListTest()
	{
		log.info("clicking on the Account & List button");
		signinPage=amazonLandPage.clickAccList();
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
