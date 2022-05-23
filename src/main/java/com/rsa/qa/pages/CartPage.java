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
public class CartPage extends BasePage {

	
	public CartPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//h4[@class='product-name']")
	List <WebElement> products;
	
	@FindBy(css="img[alt='Cart']")
	WebElement CartBtn;
	
	@FindBy(xpath="//button[text()='PROCEED TO CHECKOUT']")
	WebElement proceedtoCheckOut;
	
	public void VegItems()
	{
		Action.addToCart(products);
	}
	
	public void cartBtnclick()
	{
		Action.click(CartBtn);
	}
	
	public CheckoutPage checkoutBtn()
	{
		Action.click(proceedtoCheckOut);
		return new CheckoutPage();
	}
	
	
	
}
