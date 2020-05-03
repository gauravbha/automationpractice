package com.automationpractice.qa.Test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.automationpractice.qa.TestBase.TestBase;
import com.automationpractice.qa.pages.Cart;
import com.automationpractice.qa.pages.HomePage;


public class CartTest extends TestBase {
	Cart cart;
	HomePage HomePages;
	
	public CartTest()
	{
		super();
	}
	
@BeforeSuite
public void setup()
{
	intialization();
		HomePages=new HomePage();
		HomePages.addToCard();
		HomePages.ProceedToCheckout();
		cart=new Cart();
}

@Test
public void Proceed()
{
cart.ProceedToCheckoutDetails();
}




}
