/**
 * 
 */
package com.rsa.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rsa.qa.base.BasePage;
import com.rsa.qa.pages.LoginHomePage;
import com.rsa.qa.pages.LoginPage;

/**
 * @author Admin
 *
 */
public class LoginHomePageTest extends BasePage {

	LoginHomePage loginHomePage;
	LoginPage loginPage;
	
	public LoginHomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		launch();
		log.info("browser is launched");
		loginHomePage= new LoginHomePage();
	}
	
	@Test(priority=1)
	public void getTitleTest()
	{
		log.info("validating pageTitle");
		String title=loginHomePage.getTitle();
		Assert.assertEquals(title, "Home | Rahul Shetty Academy");
	}
	
	@Test(priority=2)
	public void getLogoTest()
	{
		log.info("validating page logo");
	Assert.assertTrue(loginHomePage.getLogo());
	}
	
	@Test(priority=3)
	public void clickLoginBtnTest()
	{
		log.info("clicking on the login button");
		loginPage=loginHomePage.clickLoginBtn();
	System.out.println(loginPage.getTitle());	
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
