/**
 * 
 */
package com.rsa.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.rsa.qa.base.BasePage;

/**
 * @author Admin
 *
 */
public class HomePage extends BasePage{

	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String getTitle()
	{
	return driver.getTitle();
	}
}
