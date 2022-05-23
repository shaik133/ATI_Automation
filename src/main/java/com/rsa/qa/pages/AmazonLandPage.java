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
public class AmazonLandPage extends BasePage {

	public AmazonLandPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(css="span[class='nav-line-2 ']")
	WebElement AcctList;
	
	
	public String getTitle()
	{
		return Action.getTitle();
	}
	
	
	public SigninPage clickAccList()
	{
		Action.click(AcctList);
		return new SigninPage();
	}
}
