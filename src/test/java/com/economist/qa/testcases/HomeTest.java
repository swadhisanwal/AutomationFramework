package com.economist.qa.testcases;


import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.economist.qa.base.TestBase;
import com.economist.qa.pages.BrowseJobs;
import com.economist.qa.pages.HomePage;
import com.economist.qa.pages.LoginPage;
//import com.economist.qa.util.TestUtil;


public class HomeTest extends TestBase {
	HomePage homePage;
	LoginPage loginPage;
	BrowseJobs browseJobs;
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
	
	
	@Test(priority=1)
	public void validateSearchButtonTest() {
	try
	{
		boolean flag = homePage.validateSearchButton();
		Assert.assertTrue(flag);
		log.info("Search button visible");
	}
	catch (Exception e) {
		log.error("Exception Occured in validateSearchButtonTest "+e.getMessage());
		}
	}
	
	@Test(priority=2)
	public void validateNavigationBarTest() {
		try {
		boolean flag = homePage.validateNavigationBar();
		Assert.assertTrue(flag);
		log.info("NavigationBar visible");
		}
		catch (Exception e) {
			log.error("Exception Occured in validateNavigationBarTest "+e.getMessage());
			}
		
	}
	
	@Test(priority=3)
	public void validateSearchKeywordTest() {
		try {
		boolean flag = homePage.validateSearchKeyword();
		Assert.assertTrue(flag);
		log.info("Search Keyword visible");
		}
		catch (Exception e) {
			log.error("Exception Occured in validateSearchKeywordTest "+e.getMessage());
			}
	}
	
	@Test(priority=4)
	public void validateSearchLocationTest() {
		try {
		boolean flag = homePage.validateSearchLocation();
		Assert.assertTrue(flag);
		log.info("Search location visible");
		}
		catch (Exception e) {
			log.error("Exception Occured in validateSearchLocationTest "+e.getMessage());
			}
	}
	
	
	@Test(priority=5)
	public void validateSearchRadialLocationTest() {
		try {
		boolean flag = homePage.validateSearchRadialLocation();
		Assert.assertTrue(flag);
		log.info("Search radial location visible");
		}
		catch (Exception e) {
			log.error("Exception Occured in validateSearchRadialLocationTest "+e.getMessage());
			}
	}
	
	@Test(priority=6)
	public void loginTest() {
		try {
		loginPage= homePage.loginPageVerify();
		Assert.assertEquals(loginPage.verifyLoginTitle(),"Logon | Jobs.Economist.com");
		log.info("login page Title is "+ loginPage.verifyLoginTitle());
		}
		catch (Exception e) {
			log.error("Exception Occured in loginTest "+e.getMessage());
			}
	}
	
	@Test(priority=7)
	public void searchJobsTest() {
		try {
		Assert.assertTrue(homePage.navigationTabLink());
		log.info("Verified link test");
		}
		catch (Exception e) {
			log.error("Exception Occured in verifyLinkTest "+e.getMessage());
			}
	
	}
	
	
	@Test(priority=8)
	public void searchJobsSectorTest() {
		try {
			browseJobs= homePage.searchJobs("Director");
			
		log.info("clicked search");
		}
		catch (Exception e) {
			log.error("Exception Occured in searchJobsTest "+e.getMessage());
			}
	
	}
	
	
	/*@DataProvider
	public Object[][] getEconomistTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}*/
	
	@Test(priority=9)
	public void validateBrowseJobsbySector() {
		homePage.findJobsBySector("Director");
	}
	
	


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
