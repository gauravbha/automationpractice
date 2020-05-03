package com.automationpractice.qa.pages;

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
	
		
	public SignInPage()
	{
		PageFactory.initElements(driver, this);
	}

	
		
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

}
