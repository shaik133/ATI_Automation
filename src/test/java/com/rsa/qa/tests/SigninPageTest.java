/**
 * 
 */
package com.rsa.qa.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rsa.qa.base.BasePage;
import com.rsa.qa.pages.AmazonLandPage;
import com.rsa.qa.pages.PwdEnterPage;
import com.rsa.qa.pages.SigninPage;

/**
 * @author Admin
 *
 */
public class SigninPageTest extends BasePage{

	AmazonLandPage amazonLandPage;
	SigninPage signinPage;
	PwdEnterPage pwdEnterPage;
	
	public SigninPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		launch();
		amazonLandPage= new AmazonLandPage();
		signinPage=amazonLandPage.clickAccList();
	}
	
	@Test
	public void enterMobDetailsTest()
	{
		signinPage.emailEnter();
		pwdEnterPage=signinPage.continueBtn();
	}
}
