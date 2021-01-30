package com.economist.qa.testcases;


import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.economist.qa.base.TestBase;
import com.economist.qa.pages.HomePage;
import com.economist.qa.pages.LoginPage;
import com.economist.qa.util.TestUtil;


public class HomeTest extends TestBase {
	HomePage homePage;
	LoginPage loginPage;
	Logger log = Logger.getLogger(HomeTest.class);
	String sheetName = "HomePage";
	
	public HomeTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup(){
		initialization();
		 homePage = new HomePage();
		
	}
	
	/*
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
	*/
	
	@DataProvider
	public Object[][] getEconomistTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=1, dataProvider ="getEconomistTestData")
	public void validateFindJobs(String SectorName ) {
		homePage.findJobs(SectorName);
	}
	
	


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
