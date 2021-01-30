package com.economist.qa.testcases;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.economist.qa.base.TestBase;
import com.economist.qa.pages.HomePage;
import com.economist.qa.pages.LoginPage;
import com.reddit.test.testCases.HomePageTestCase;

public class HomeTest extends TestBase {
	HomePage homePage;
	LoginPage loginPage;
	Logger log = Logger.getLogger(HomeTest.class);
	
	
	public HomeTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup(){
		initialization();
		 homePage = new HomePage();
		
	}
	
	@Test(priority=1)
	public void validateSearchButtonTest() {
		boolean flag = homePage.validateSearchButton();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void validateNavigationBarTest() {
		boolean flag = homePage.validateNavigationBar();
		Assert.assertTrue(flag);
		
	}
	
	@Test(priority=3)
	public void validateSearchKeywordTest() {
		boolean flag = homePage.validateSearchKeyword();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=4)
	public void validateSearchLocationTest() {
		boolean flag = homePage.validateSearchLocation();
		Assert.assertTrue(flag);
	}
	
	
	@Test(priority=5)
	public void validateSearchRadialLocationTest() {
		boolean flag = homePage.validateSearchRadialLocation();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=6)
	public void loginTest() {
		loginPage= homePage.loginPageVerify();
	}
	
	@Test(priority=7)
	public void verifyLinkTest() {
		
		Assert.assertTrue(homePage.navigationTabLink());
	
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
