/**
 * 
 */
package com.rsa.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rsa.qa.base.BasePage;

/**
 * @author Admin
 *
 */
public class PracticeDynamicTable extends BasePage{

	
	public PracticeDynamicTable()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table[@name='courses']/tbody/tr[2]/td[3]/preceding-sibling::td[2]")
	WebElement courseInstructorText;
	
	public void getInstructorText()
	{
		String name =courseInstructorText.getText();
		System.out.println(name);
	}
}
