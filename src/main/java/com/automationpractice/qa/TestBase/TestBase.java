package com.automationpractice.qa.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.automationpractice.qa.util.TestUtil;
import com.automationpractice.qa.util.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
 public TestBase ()
 {
	 try
	 {
	 prop=new Properties();
	 FileInputStream ip=new FileInputStream("D:\\Java_projects\\com.automationpractice.com"
	 		+ "\\src\\main\\java\\com\\automationpractice\\qa\\config\\config.properties");
	 prop.load(ip);
	 }
	 catch (FileNotFoundException e)
	 {
		 e.printStackTrace();
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 	} 
 
 public static void intialization ()
 {
	 String browser=prop.getProperty("browser");
	 if (browser.equalsIgnoreCase(("Chrome")));
	 {
		 System.setProperty("webdriver.chrome.driver", "D:\\Java_projects\\selenium\\driver\\chromedriver.exe");
		 driver=new ChromeDriver();
	 }
	 
	 
	 driver.manage().deleteAllCookies();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 //driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	 driver.get(prop.getProperty("URL"));
 
  
 e_driver = new EventFiringWebDriver(driver);
	// Now create object of EventListerHandler to register it with EventFiringWebDriver
	eventListener = new WebEventListener();
	e_driver.register(eventListener);
	driver = e_driver;
	
	 }
}



