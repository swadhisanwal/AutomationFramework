package com.economist.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.economist.qa.base.TestBase;
import com.economist.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	public LoginPage loginPage;
	Logger log = Logger.getLogger(LoginPageTest.class);
	
	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup(){
		initialization();
		loginPage = new LoginPage();
		
	}
	@Test(priority=1)
	public void verifyLoginTitleTest() {
		try {
		String title= loginPage.verifyLoginTitle();
		Assert.assertEquals("Logon | Jobs.Economist.com", title);
		log.info("Verified login page title");
		}
		catch (Exception e) {
			log.error("Exception Occured in verifyLoginTitleTest "+e.getMessage());
			}
	}
	@Test(priority=2)
	public void verifyLoginURLTest() {
		try {
		String url= loginPage.verifyLoginURL();
		Assert.assertEquals(url, "https://jobs.economist.com/logon/");
		}
		catch (Exception e) {
			log.error("Exception Occured in verifyLoginURLTest "+e.getMessage());
			}
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
