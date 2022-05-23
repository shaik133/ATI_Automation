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
public class LoginPage extends BasePage{

	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(id="email")
	WebElement passEmail;
	
	@FindBy(id ="password")
	WebElement passPwd;
	
	@FindBy(id="remember_me")
	WebElement remember_meCheck;
	
	@FindBy(css="input[value='Login']")
	WebElement Login;
	
	
	public String getTitle()
	{
	return driver.getTitle();
	}
	
	public HomePage SignIn(String username, String pwd, String validation )
	{
		Action.sendKeys(passEmail, username);
		Action.sendKeys(passPwd, pwd);
		Action.click(remember_meCheck);
		Action.click(Login);
		return new HomePage();
	}
	
}
