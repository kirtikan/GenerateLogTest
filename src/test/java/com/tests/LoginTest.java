package com.tests;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
	//what is log? : capturing info/activities at the time of program execution
	//types of logs:
	// info
	// warn
	// debug
	// fatal
	
	//how to generate logs? : use Apache log4j API(log4j jar)
	//how it works? : it reads log4j configuration from log4j.properties file
	//where to create: create inside resources folder
		
	WebDriver driver;
	public final static String current_dir = System.getProperty("user.dir");
	
	Logger log = Logger.getLogger(LoginTest.class);
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", current_dir + "\\chromedriver.exe");
		driver = new ChromeDriver();
		
		log.info("Launching chrome browser");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://freecrm.co.in/");	
		log.info("entering application url");
		//log.warn("Hey! this is just a warning");
		//log.debug("Hey! is just a debug msg");
		//log.fatal("this is fatal error message");
	}
	
	@Test(priority=1)
	public void freeCrmTitleTest() {
		log.info("*****************************Starting test case**********************************************");
		log.info("*****************************freeCrmTitleTest**********************************************");
		
		String title = driver.getTitle();
		Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
		
		log.info("*****************************Ending test case**********************************************");
		log.info("*****************************freeCrmTitleTest**********************************************");
	}
	
	@Test(priority=2)
	public void freeCrmSignUpLinkTest() {
		log.info("*****************************Starting test case**********************************************");
		log.info("*****************************freeCrmSignUpLinkTest**********************************************");
		
		boolean b = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]")).isDisplayed();
		Assert.assertTrue(b);
		
		log.info("*****************************Ending test case**********************************************");
		log.info("*****************************freeCrmSignUpLinkTest**********************************************");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("closing the browser");
	}
	

}
