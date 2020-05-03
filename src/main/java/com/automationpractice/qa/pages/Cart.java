package com.automationpractice.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.qa.TestBase.TestBase;

public class Cart extends TestBase {
	
	@FindBy(xpath="//*[@class='cart_navigation clearfix']//a[@title='Proceed to checkout']")
	WebElement ProceedToCheckoutOnDetail;
	
	@FindBy(xpath="//img[@class='logo img-responsive']")
	WebElement Logo;
	
	@FindBy(xpath="//a[@title='Contact Us']")
	WebElement ContactUs;
	
    @FindBy(xpath="//a[@title='Log in to your customer account']")
    WebElement SignIn;
    
    @FindBy(xpath="View my shopping cart")
    WebElement Shopping_cart;
    
    @FindBy(id="search_query_top")
    WebElement Search;
    
    @FindBy(xpath="//button[@name='submit_search']")
    WebElement SearchButton;
    
    @FindBy(xpath="//a[@title='Continue shopping']")
    WebElement Continue;
    
    public Cart()
    {
    	PageFactory.initElements(driver, this);
    }
    
    public void Logo()
    {
    	Logo.click();
     }
    
    public void SignIn()
    {
    	SignIn.click();
    }
    public void ProceedToCheckoutDetails()
    {
    	ProceedToCheckoutOnDetail.click();
    }
}
