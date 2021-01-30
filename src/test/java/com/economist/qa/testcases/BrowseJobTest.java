package com.economist.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.economist.qa.base.TestBase;
import com.economist.qa.pages.Browsejobs;

public class BrowseJobTest extends TestBase {

	Browsejobs browseJobs;

	Logger log = Logger.getLogger(BrowseJobTest.class);
	String sheetName = "HomePage";

	public BrowseJobTest() {
		super();
	}


	@BeforeMethod
	public void setup(){
		initialization();
		browseJobs = new Browsejobs();
	}

	
		@Test(priority=1)
		public void validateJobList() {
			boolean flag = browseJobs.navigationJobList();
			Assert.assertTrue(flag);

		}
		
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}

	}

