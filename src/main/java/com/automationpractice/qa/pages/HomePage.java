package com.automationpractice.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.qa.TestBase.TestBase;

public class HomePage extends TestBase{

	//Page Factory:
	@FindBy(xpath="//a[@class='product_img_link']//img[@title='Faded Short Sleeve T-shirts']")
WebElement HoverToProduct;

	@FindBy (xpath="//a[@data-id-product='1']/span")
	@CacheLookup
	WebElement product1;
	
	@FindBy (xpath="//a[@data-id-product='2']/span")
	WebElement product2;

	@FindBy (xpath="//a[@title='Proceed to checkout']")
	WebElement ProceedToCheckout;
	
	@FindBy (xpath= "//span[@title='Continue shopping']/span")
	WebElement ContinueShopping;
	
	@FindBy(xpath="//*[@class='cart_navigation clearfix']//a[@title='Proceed to checkout']")
	WebElement ProceedToCheckoutOnDetail;
	
	public HomePage()
	{
	PageFactory.initElements(driver, this);
	}
	
	
	public String verfiyTitle()
	{
		return driver.getTitle();
	}
	//Function is use to add 2 product in cart.
	//Gaurav Bhardwaj
	public void addToCard()
	{
		Actions Act=new Actions(driver);
		Act.moveToElement(HoverToProduct).build().perform();
		product1.click();
		
		//product2.click();
	}
	//Function is use to click on ProceedToCheckout
	//Gaurav Bhardwaj
	public Cart ProceedToCheckout()
	{
		ProceedToCheckout.click();
		return new Cart();
	}
	//Function is use to click on ContinueShopping button
		//Gaurav Bhardwaj
		
	public void ContinueShopping()
	{
		ContinueShopping.click();
			}
	
	public void ProceedToCheckoutOnDetails()
	{
	ProceedToCheckoutOnDetail.click();
	}
}

