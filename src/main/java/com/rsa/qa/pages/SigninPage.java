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
public class SigninPage extends BasePage{

	public SigninPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="ap_email")
	WebElement emailBox;
	
	@FindBy(id="continue")
	WebElement continueBtn;
	
	public void emailEnter()
	{
		Action.sendKeys(emailBox, prop.getProperty("phone"));
	}
	public PwdEnterPage continueBtn()
	{
		Action.ImplitWait();
		Action.click(continueBtn);
		return new PwdEnterPage();
	}
}
