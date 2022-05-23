/**
 * 
 */
package com.rsa.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rsa.qa.base.BasePage;
import com.rsa.qa.pages.CartPage;
import com.rsa.qa.pages.CheckoutPage;

/**
 * @author Admin
 *
 */
public class CartPageTest extends BasePage {

	CartPage cartPage;
	CheckoutPage checkoutPage;
	
	public CartPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		launch();
		cartPage = new CartPage();
	}
	
	@Test(priority=1)
	public void VegItemsTest()
	{
		cartPage.VegItems();
		cartPage.cartBtnclick();
		checkoutPage=cartPage.checkoutBtn();
	}
	
	
//	@Test(priority=2)
//	public void cartBtnclickTest()
//	{
//		cartPage.cartBtnclick();
//	}
//	
	
	
//	@AfterMethod
//	public void tearDown()
//	{
//		driver.close();
//	}
}
