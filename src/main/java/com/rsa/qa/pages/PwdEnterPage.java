/**
 * 
 */
package com.rsa.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rsa.qa.actiondriver.Action;
import com.rsa.qa.base.BasePage;

/**
 * @author Admin
 *
 */
public class PwdEnterPage extends BasePage{

	
	public PwdEnterPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="ap_password")
	WebElement EneterPwd;

	@FindBy(id="signInSubmit")
    WebElement signinBtn;
	
	
	
	
	
	public void enterPwd()
	{
		Action.sendKeys(EneterPwd, prop.getProperty("password"));
	}
	
	public AHomePage clicksigninBtn()
	{
		Action.click(signinBtn);
		return new AHomePage();
	}
	
	
	
	
	
	
	
	
	
	
	
}
