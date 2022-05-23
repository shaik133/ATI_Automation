/**
 * 
 */
package com.rsa.qa.pages;
import java.io.IOException;
import java.sql.DriverAction;
//QA Click Academy | Selenium,Jmeter,SoapUI,Appium,Database testing,QA Training Academy
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rsa.qa.actiondriver.Action;
import com.rsa.qa.base.BasePage;

/**
 * @author Admin
 *
 */
public class PracticePage extends BasePage{

	public PracticePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="img[class='logoClass']")
	WebElement Logo;
	
	@FindBy(css="input[value='radio1']")
	WebElement radiobtn;
	
	@FindBy(id="autocomplete")
	WebElement autoComplete;

	@FindBy(xpath="//ul[@id='ui-id-1']//li//div")
	List<WebElement> sutosuggestList;
	
	@FindBy(id="dropdown-class-example")
	WebElement selectDropdown;
	
	@FindBy(id="checkBoxOption3")
	WebElement checkBox;
	
	@FindBy(id="openwindow")
	WebElement openNewWindow;
	
	@FindBy(id="opentab")
	WebElement openTabBtn;
	
	@FindBy(id="name")
	WebElement EnterNameinSwitchToAlert;
	
	@FindBy(id="confirmbtn")
	WebElement confirmBtn;
	
	@FindBy(id="show-textbox")
	WebElement showBtn;
	
	@FindBy(id="hide-textbox")
	WebElement hideBtn;
	
	@FindBy(id="displayed-text")
	WebElement displayTextBox;
	
	@FindBy(xpath="//div[@class='tableFixHead']/table/tbody/tr/td[4]")
	List<WebElement> listValues;
	
	@FindBy(css="div[class='totalAmount']")
	WebElement TotalAmountofFixedtable;
	
	@FindBy(xpath="//table[@name='courses']/tbody/tr/td[3]")
	List<WebElement> priceList;
	
	@FindBy(id="mousehover")
	WebElement mouseHover;
	
	@FindBy(xpath="//a[text()='Reload']")
	WebElement ReloadBtn;
	
	@FindBy(css="iframe[id='courses-iframe']")
	WebElement iframe;
	
	@FindBy(xpath="//div[text()='See what our students say about us. We are proud to show some of best ']")
	WebElement getTextFrame; 
	
	@FindBy (id="gf-BIG")
	WebElement remotedriver;
	
	@FindBy(xpath="//div[@id='gf-BIG']/table/tbody/tr/td/ul/li/a")
	List<WebElement> links;
	
	public String getPageTitle()
	{
		return Action.getTitle();
	}
	
	public void clickRadioBtn()
	{
		Action.click(radiobtn);
	}
	
	public String autoCompleteTab()
	{
		Action.sendKeys(autoComplete, prop.getProperty("AutosuggestSendkeys"));
		String text=Action.autoSuggestComplete(sutosuggestList,prop.getProperty("AutosugestEntry"));
		return text;
	}
	
	public void selectDD()
	{
		Action.select1(selectDropdown, prop.getProperty("selectbytext"));
	}
	
	public void checkBox()
	{
		Action.click(checkBox);
	}
	
	public void getwindowSize()
	{
		Action.click(openNewWindow);
		Action.SwitchWindow();	
	System.out.println(driver.findElement(By.xpath("//div[@class='row']/div")).getText());
		Action.switchToDefaultContent();
	}
	
	public String SwitchToNewWindow(String url)
	{
		Action.click(openTabBtn);
		Action.switchNewWinndowTab(url);
		String Title = Action.getTitle();
		Action.switchToDefaultContent();
		return Title;
	}

	public void switchToAlert()
	{
		Action.sendKeys(EnterNameinSwitchToAlert, prop.getProperty("uname"));
		Action.click(confirmBtn);
		Action.ImplitWait();
		Action.SwitchToAlert();
	}
	
	public boolean elementDisplay()
	{
		Action.click(showBtn);
		return Action.isDisplayed(displayTextBox);
	}
	
	public boolean elementNotDisplay()
	{
		Action.click(hideBtn);
		Action.ImplitWait();
//		Action.sendKeys(displayTextBox, "123");
		return Action.isDisplayed(displayTextBox);
	}
	
	public int SumOflistTable()
	{
		return Action.sumValues(listValues);
	}
	public int TotalOfTable()
	{
		return Action.splitText(TotalAmountofFixedtable);
	}
	
	public int TotalPrice()
	{
		return Action.sumOfPrice(priceList);
	}
	
	public void mouseHoverClick()
	{
		Action.JsScroll();
		Action.museHover(driver, mouseHover);
	Action.click(ReloadBtn);
	}
	
	public String iframeSwitch()
	{
		Action.switchToFrame(iframe);
		Action.JsScroll();
		return Action.getText(getTextFrame);
	}
	
	public void getEachLink()
	{
		Action.getLink(remotedriver);
	}
	
	public void getBrokenLink() throws IOException
	{
		Action.getBrokenLink(links);
	}
}
