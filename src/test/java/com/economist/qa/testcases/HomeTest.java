package com.economist.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.economist.qa.base.TestBase;
import com.economist.qa.pages.HomePage;
import com.economist.qa.pages.LoginPage;

public class HomeTest extends TestBase {
	HomePage homePage;
	LoginPage loginPage;
	
	public HomeTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup(){
		initialization();
		 homePage = new HomePage();
		
	}
	
	@Test(priority=1)
	public void validateLoginPageTitleTest() {
		String title = homePage.validateLoginPageTitle();
		Assert.assertEquals(title, "Jobs.Economist.com | jobs | Choose from 54 live vacancies");
	}
	
	@Test(priority=2)
	public void validateNavigationBarTest() {
		boolean flag = homePage.validateNavigationBar();
		Assert.assertTrue(flag);
		
	}
	@Test(priority=3)
	public void loginTest() {
		loginPage= homePage.loginPageVerify();
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
