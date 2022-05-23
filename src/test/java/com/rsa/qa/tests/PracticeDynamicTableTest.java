/**
 * 
 */
package com.rsa.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rsa.qa.base.BasePage;
import com.rsa.qa.pages.PracticeDynamicTable;

/**
 * @author Admin
 *
 */
public class PracticeDynamicTableTest extends BasePage{

	PracticeDynamicTable practiceDynamicTable;
	
	
	public PracticeDynamicTableTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setup()
	{
		launch();
		practiceDynamicTable = new PracticeDynamicTable();
	}
	
	
	@Test
	public void getText()
	{
		practiceDynamicTable.getInstructorText();
	}


//body[1]/div[3]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[2]/td[3]
//body[1]/div[3]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[3]/td[3]
//tbody/tr[11]/td[3]
	//tbody/tr[11]/td[1]
@Test
public void test() {
String beforexPath="//body[1]/div[3]/div[1]/fieldset[1]/table[1]/tbody[1]/tr[";
String afterxPath="]/td[3]";

for (int i=2;i<=11;i++)
{
	String name=driver.findElement(By.xpath(beforexPath+ i +afterxPath)).getText();
	//System.out.println(name);
	if (name.contains("Write effective QA Resume that will turn to interview call"))
	{
	System.out.println(driver.findElement(By.xpath("//tbody/tr["+ i +"]/td[1]")).getText());
	}
}
}
}