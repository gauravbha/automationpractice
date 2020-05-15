package com.automationpractice.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

import com.automationpractice.qa.TestBase.TestBase;

public class SignInPage extends TestBase {

	@FindBy(id="email_create")
	WebElement email_Register;
	
	@FindBy(id="SubmitCreate")
	WebElement CreateAccunt;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="SubmitLogin")
	WebElement Submit;
	
	@FindBy(xpath="//*[@class='lost_password form-group']")
	WebElement ForgotPaswrd;
	
	@FindBy(id="customer_firstname")
	WebElement firstname;
	
	@FindBy(id="customer_lastname")
	WebElement lastname;
	
	@FindBy(id="passwd")
	WebElement password_reg;
	
	@FindBy (id="days")
	WebElement day;
	
	@FindBy(id="months")
	WebElement months;
	
	@FindBy (id="years")
	WebElement years;
	
	@FindBy (id="id_state")
	WebElement state;
	
	//@FindBy (id="id_country")
	//WebElement country;
	
	@FindBy(id="address1")
	WebElement address1;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy (id="postcode")
	WebElement postcode;
	
	@FindBy(id="phone_mobile")
	WebElement phone_Mob;
	
	@FindBy(id="submitAccount")
	WebElement SubmitButtonR;
	
	@FindBy(id="create_account_error")
	WebElement errormessage;
	
	@FindBy(id="email")
	WebElement emailLogin;
	
	@FindBy(id="passwd")
	WebElement Password;
	
	@FindBy(id="SubmitLogin")
	WebElement SignR;
	
	@FindBy(xpath="//button[@class='button btn btn-default button-medium']")
	WebElement CheckoutAfterLogin;
		
	@FindBy(id="cgv")
	WebElement checkbox;
	
	@FindBy(xpath="//button[@name='processCarrier']")
	WebElement finalCheckout;
	
	@FindBy(xpath="//a[@title='Pay by bank wire']")
	WebElement ByBankWire;
	
	@FindBy(xpath="//a[@title='Pay by check.']")
	WebElement Bycheck;
	
	@FindBy(xpath="//a[@class='button-exclusive btn btn-default']")
	WebElement othermethod;
	
	@FindBy(xpath="//button[@class='button btn btn-default button-medium']")
	WebElement confirm;
	
	List<WebElement> PrintOut=driver.findElements(By.className("box order-confirmation"));
	
	@FindBy(xpath="//*[@class='box order-confirmation']")
	WebElement Porder;
	
	
	
	
	public SignInPage()
	{
		PageFactory.initElements(driver, this);
	}

	
		
	//Methods
	public void email_Registation(String email)
	{
		email_Register.sendKeys(email);
	}

	public void submit()
	{
		CreateAccunt.click();
	}

	public void alldetails (String FName, String LName, String pasword, String Address, String City_S,String State_R, String zipcode, String mobile)
	{
		firstname.sendKeys(FName);
		lastname.sendKeys(LName);
		password.sendKeys(pasword);
		//Select select=new Select(day);
		//select.selectByValue(days);
		//select=new Select(months);
		//select.selectByValue(month);
		//select=new Select(years);
		//select.selectByValue(year);
		address1.sendKeys(Address);
		city.sendKeys(City_S);
		Select select=new Select(state);
		select.selectByVisibleText(State_R);
		postcode.sendKeys(zipcode);

		phone_Mob.sendKeys(mobile);
			
	}
public void submitbuttonR()
{
	SubmitButtonR.click();
	}

public String errormessage()
{
	return errormessage.getText();
	
	}

public void Login(String email, String password)
{
	emailLogin.sendKeys(email);
	Password.sendKeys(password);
	SignR.click();
}
public void checkoutAfter()
{
	CheckoutAfterLogin.click();
	//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy(0,450)","");
		
}

public void CheckboxSelect()
{
	if (!checkbox.isSelected())
		
	checkbox.click();	
	finalCheckout.click();
}

public void payment()
{
	ByBankWire.click();
	othermethod.click();
	Bycheck.click();
	confirm.click();
}

public String printorder(){
ArrayList <WebElement> print=new ArrayList<WebElement>(PrintOut);
int size=print.size();
System.out.println("My total size is "+size);
String Order=Porder.getText();
System.out.println("Your order details is-------"+"/n"+Order+"---------------");
 return Order;




	
}
}
