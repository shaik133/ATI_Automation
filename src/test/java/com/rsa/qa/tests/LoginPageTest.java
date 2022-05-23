/**
 * 
 */
package com.rsa.qa.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rsa.qa.base.BasePage;
import com.rsa.qa.pages.HomePage;
import com.rsa.qa.pages.LoginHomePage;
import com.rsa.qa.pages.LoginPage;
import com.rsa.qa.utils.XlUtililty;

/**
 * @author Admin
 *
 */
public class LoginPageTest extends BasePage {

	LoginHomePage loginHomePage;
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		log.info("browser is launching");
		launch();
		loginHomePage= new LoginHomePage();
		loginPage=loginHomePage.clickLoginBtn();
		log.info("login button is clicked and navigating to the login forms page");
	}
	
	
	@Test
	public void getTitleTest()
	{
		log.info("validating the title of the page");
		String title=loginPage.getTitle();
		Assert.assertEquals(title, "Rahul Shetty Academy");
	}
	
	@Test(dataProvider="testData")
	public void loginTest(String username,String pwd, String validation)
	{
		log.info("inputting the username and pwd from excell");
		homePage=loginPage.SignIn(username, pwd, validation);
		
		String homePageTitle=homePage.getTitle();
		String ExpectedTitle="Rahul Shetty Academy";
		
		if(validation.equals("valid"))
		{
			if(homePageTitle.equals(ExpectedTitle))
			{
				Assert.assertTrue(true, "Login Successfull");
				log.debug("title of the page is matched by successfully login to home page");
			}
			else
			{
				Assert.assertTrue(false, "Login failed");
			}
		}
		else if(validation.equals("invalid") )
		{
			if(homePageTitle.equals(ExpectedTitle))
			{
				Assert.assertTrue(false, "invalid login");
			}
			else
			{
				Assert.assertTrue(true, " login is prohibited with invalid credential");
			}
		}
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	
	@DataProvider(name="testData")
	public String[][] getData() throws IOException
	{
	
		String path=System.getProperty("user.dir")+"\\ExcellFolder\\document.xlsx";

		int Totalrownum= XlUtililty.getLastRow(path, "Sheet1");
		int Totalcellnum=XlUtililty.getLastCell(path, "Sheet1", Totalrownum);
		
		String data[][]=new String[Totalrownum][Totalcellnum];
		
		for(int i=1; i<=Totalrownum;i++)
		{
			for(int j=0;j<Totalcellnum;j++)
			{
				data[i-1][j]=XlUtililty.getCellData(path, "Sheet1", i, j);
			}
		}
		return data;
	}
	
	
	
}
