/**
 * 
 */
package com.rsa.qa.tests;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rsa.qa.base.BasePage;
import com.rsa.qa.pages.AHomePage;
import com.rsa.qa.pages.AmazonLandPage;
import com.rsa.qa.pages.PwdEnterPage;
import com.rsa.qa.pages.SigninPage;

/**
 * @author Admin
 *
 */
public class AHomePageTest extends BasePage {

	AmazonLandPage amazonLandPage;
	SigninPage signinPage;
	PwdEnterPage pwdEnterPage;
	AHomePage aHomePage;
	
	
	public  AHomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		launch();
		amazonLandPage= new AmazonLandPage();
		signinPage=amazonLandPage.clickAccList();
		signinPage.emailEnter();
		pwdEnterPage=signinPage.continueBtn();
		pwdEnterPage.enterPwd();
		aHomePage=pwdEnterPage.clicksigninBtn();
	}
	
	
	
	@Test(priority=2)
	public void clickEachLink()
	{
		aHomePage.clickEachLink();
	}
	
	@Test(priority=1)
	public void getBrokenLinkTest() throws MalformedURLException, IOException
	{
		aHomePage.getBrokenLink();
	}
	
	@Test(priority=3)
	public void searchBoxSuggestTest()
	{
		aHomePage.searchBoxsuggest();
	}
	
	
	
	
	
	
	
	
}
