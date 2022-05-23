/**
 * 
 */
package com.rsa.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rsa.qa.actiondriver.Action;
import com.rsa.qa.base.BasePage;

/**
 * @author Admin
 *
 */
public class LandingPage extends BasePage{

	
	public LandingPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "ctl00_mainContent_chk_friendsandfamily")
	WebElement FamilyandFreindsCheckBox;
	
	@FindBy(id="ctl00_mainContent_DropDownListCurrency")
	WebElement SelectDropdown;
	
	@FindBy(id ="divpaxinfo")
	WebElement PassengerDDClick;
	
	@FindBy(id="hrefIncAdt")
	WebElement AdultIncrement;
	
	@FindBy(id="hrefIncChd")
	WebElement ChildIncrement;
	
	@FindBy(id="autosuggest")
	WebElement autoSuggestDD;
	
	@FindBy(xpath="//ul[@id='ui-id-1']/li/a")
	List<WebElement> autosuggestList;
	
	@FindBy(id="ctl00_mainContent_ddl_originStation1_CTXT")
	WebElement clickFromDD;
	
	@FindBy(xpath="//a[text()=' Madurai (IXM)']")
	WebElement fromCity;
	
	@FindBy(xpath="//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[text()=' Patna (PAT)']")
	WebElement toCity;
	
	@FindBy(id="ctl00_mainContent_view_date1")
	WebElement departureDate;
	
	@FindBy(xpath="//table[@class='ui-datepicker-calendar']/tbody/tr[5]/td[3]/a")
	WebElement clickDate;
	
	@FindBy(id="ctl00_mainContent_view_date2")
	WebElement returnDate;
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public void checkBox()
	{
		Action.click(FamilyandFreindsCheckBox);
	}
	
	public void select()
	{
		Action.select(SelectDropdown, "AED");
	}
	
	public void passengerDDClick()
	{
		Action.click(PassengerDDClick);
		Action.ImplitWait();
		Action.IncrementDropdown(AdultIncrement, ChildIncrement);
	}
	
	public void AutoSuggestDD(String text, String text1)
	{
		Action.sendKeys(autoSuggestDD, text);
		Action.autoSuggest(autosuggestList, text1);
	}
	
	public void SelectCities()
	{
		Action.click(clickFromDD);
		Action.click(fromCity);
		Action.click(toCity);
	}
	
	public void SelectDeprtDate()
	{
		Action.click(departureDate);
		Action.click(clickDate);
	}
	public boolean returnDateBox()
	{
		return Action.isEnabled(returnDate);
	}
	
}
