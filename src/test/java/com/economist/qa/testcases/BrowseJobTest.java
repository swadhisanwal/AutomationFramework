package com.economist.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.economist.qa.base.TestBase;
import com.economist.qa.pages.BrowseJobs;
import com.economist.qa.pages.HomePage;
import com.economist.qa.util.TestUtil;


public class BrowseJobTest extends TestBase {

	BrowseJobs browseJobs;
	HomePage homePage;
	Logger log = Logger.getLogger(BrowseJobTest.class);
	String sheetName = "HomePage";

	public BrowseJobTest() {
		super();
	}


	@BeforeMethod
	public void setup(){
		initialization();
		homePage = new HomePage();
		browseJobs = new BrowseJobs();	
	}




	@Test(priority=1)
	public void validateSearchTest() {
		try {
			browseJobs.selectJobList();
			log.info("validate search result is working");
		}
		catch (Exception e) {
			log.error("Exception Occured in validateSearchTest "+e.getMessage());
		}
	}
	
	@DataProvider
	public Object[][] getTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority=2,dataProvider="getTestData")

	public void searchResultTest(String SearchData, String SectorName) {
		browseJobs= homePage.searchJobs(SearchData);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

