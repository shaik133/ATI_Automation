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
public class LoginHomePage extends BasePage{

	public LoginHomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement LoginBtn;
	
	@FindBy(css="div[class='logo']")
	WebElement getLogo;
	
	public boolean getLogo()
	{
		return Action.isDisplayed(getLogo);
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public LoginPage clickLoginBtn()
	{
		Action.click(LoginBtn);
		return new LoginPage();
	}
}
