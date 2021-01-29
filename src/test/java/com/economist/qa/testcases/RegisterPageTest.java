package com.economist.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.economist.qa.base.TestBase;
import com.economist.qa.pages.RegisterPage;

public class RegisterPageTest extends TestBase {
	
	RegisterPage registerPage;
	Logger log = Logger.getLogger(RegisterPageTest.class);

	public RegisterPageTest() {
		super();
	}

	@BeforeMethod
	public void setup(){
		initialization();
		registerPage = new RegisterPage ();
		
	}
	@Test(priority=1)
	public void verifyRegisterTitleTest() {
		String title= registerPage.verifyRegisteTitle();
		Assert.assertEquals("Register | Jobs.Economist.com", title);
	}
	@Test(priority=2)
	public void verifyRegisterURLTest() {
		String url= registerPage.verifyRegisterURL();
		Assert.assertEquals("https://jobs.economist.com/register/", url);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
