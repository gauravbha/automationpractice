package com.automationpractice.qa.Test;



import java.util.concurrent.TimeUnit;



import org.junit.Assert;
import org.testng.annotations.AfterSuite;
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
	String SheetName1="email";
	String Reg_email="roja@tie.com";
	String New_email="aman@admin.com";
	String pass="Automation123@";
	
	
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

@DataProvider(name="Email")
public Object [][] getEmailfromSheet()
{
Object data[][]=DataFile.TestData(SheetName1);
return data;
}

@Test (priority=0,dataProvider = "Email")
public void email(String email)
{
	sign.email_Registation(email);
	sign.submit();
	
}

	
@Test (priority=1,dataProvider = "DP")
public void registation(String FName, String LName, String pasword, String Address, String City_S,String State_R, String zipcode, String mobile)
{
	sign.submit();	
	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 try{
		 
	 sign.alldetails(FName, LName, pasword, Address, City_S, State_R, zipcode, mobile);
	 sign.submitbuttonR();
	 }
	 catch (Exception e)
	 {
		 String error=sign.errormessage();
			System.out.println(error);
			Assert.assertEquals("An account using this email address has already been registered. Please enter a valid password or request a new one.", error);
			sign.Login(Reg_email,pass);
			
		 }
}
@Test(priority=1)
public void checkout()
{
	sign.checkoutAfter();
	sign.CheckboxSelect();
		}
@Test(priority =2)
public void payment()
{
	sign.payment();
}

@Test(priority =3)
public void printdata()
{
	sign.printorder();
}


@AfterSuite
public void teardown()
{
	driver.quit();
}

}



