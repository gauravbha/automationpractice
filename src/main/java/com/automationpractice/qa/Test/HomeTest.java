package com.automationpractice.qa.Test;


import java.util.concurrent.TimeUnit;




import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.automationpractice.qa.TestBase.TestBase;
import com.automationpractice.qa.pages.Cart;
import com.automationpractice.qa.pages.HomePage;



public class HomeTest extends TestBase {
	HomePage HomePages;
	public HomeTest()
	{
		super();
	}
@BeforeSuite
public void Setup()
{
	intialization();
	HomePages=new HomePage();
}


@Test (priority=0)
public void VerifyTitle()
{
	String Title=HomePages.verfiyTitle();
	
	System.out.println(Title);
}
@Test (priority=1)
public Cart addToCard()
{
	HomePages.addToCard();
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	
	HomePages.ContinueShopping();
	HomePages.addToCard();
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	HomePages.ProceedToCheckout();
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	return new Cart();
	
}
@AfterSuite
public void teardown()
{
	driver.quit();
}
}
