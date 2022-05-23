/**
 * 
 */
package com.rsa.qa.tests;

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
public class PwdEnterPageTest extends BasePage {

	AmazonLandPage amazonLandPage;
	SigninPage signinPage;
	PwdEnterPage pwdEnterPage;
	AHomePage aHomePage;
	
	public PwdEnterPageTest()
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
	}
	
	@Test(priority=1)
	public void signin()
	{
		pwdEnterPage.enterPwd();
		aHomePage=pwdEnterPage.clicksigninBtn();
	}
}
