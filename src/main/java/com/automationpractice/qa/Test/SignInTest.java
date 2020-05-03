package com.automationpractice.qa.Test;



import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationpractice.com.qa.TestData.DataFile;
import com.automationpractice.qa.TestBase.TestBase;
import com.automationpractice.qa.pages.Cart;
import com.automationpractice.qa.pages.HomePage;
import com.automationpractice.qa.pages.SignInPage;

public class SignInTest extends TestBase {
	HomePage home;
	Cart cart;
	SignInPage sign;
	String SheetName="Register";
	//String SheetName1="email";
	
	public SignInTest()
	{
		super();
	}

	@BeforeSuite
	public void setup()
	{
       intialization();
       home=new HomePage();
       home.addToCard();
       home.ProceedToCheckout();
       cart=new Cart();
       cart.ProceedToCheckoutDetails();
       sign=new SignInPage();
	}
	
@DataProvider(name="DP")
public Object [][] getDatafromSheet()
{
Object data[][]=DataFile.TestData(SheetName);
return data;

}
	
@Test (priority=0)
public void  enter_email()
{
	sign.email_Registation("rama@teami.com");
	}
@Test (priority=1)
public void CreateAccount()
{
 sign.submit();
}

@Test (priority=2,dataProvider = "DP")
public void registation(String FName, String LName, String pasword, String Address, String City_S,String State_R, String zipcode, String mobile)
{
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
sign.alldetails(FName, LName, pasword, Address, City_S, State_R, zipcode, mobile);
}

@Test (priority=3)
public void submitreg()
{
 sign.submitbuttonR();
}

}
