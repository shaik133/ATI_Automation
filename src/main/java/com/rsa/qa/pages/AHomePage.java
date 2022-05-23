/**
 * 
 */
package com.rsa.qa.pages;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rsa.qa.actiondriver.Action;
import com.rsa.qa.base.BasePage;

/**
 * @author Admin
 *
 */
public class AHomePage extends BasePage{

	
	public AHomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchBox;
	
	@FindBy(xpath="//div[@class='s-suggestion-container']/div")
	List<WebElement> listofsearchItems;
	
	@FindBy(css="div[class='navFooterVerticalRow navAccessibility']")
	WebElement footerdriver;
	
	
	
	
	public void searchBoxsuggest()
	{
		Action.sendKeys(searchBox, prop.getProperty("item"));
		Action.ImplitWait();
		
		Action.autoSuggest(listofsearchItems, prop.getProperty("autoSelect"));
	}
	
	
	public void clickEachLink()
	{
		Action.clickEachLink(footerdriver);
	}
	
	public void getBrokenLink() throws MalformedURLException, IOException
	{
		Action.getbrokenLink(footerdriver);
	}
	
	
}
