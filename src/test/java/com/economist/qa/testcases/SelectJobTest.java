package com.economist.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.economist.qa.base.TestBase;
import com.economist.qa.pages.BrowseJobs;
import com.economist.qa.pages.HomePage;
import com.economist.qa.pages.SelectJobs;

public class SelectJobTest extends TestBase{
	Logger log = Logger.getLogger(SelectJobTest.class);
	SelectJobs selectJob;
	BrowseJobs browseJobs;
	HomePage homePage;
	public SelectJobTest() {
		super();
	}
	@BeforeMethod
	public void setup(){
		initialization();
		homePage = new HomePage();
		browseJobs= homePage.searchJobs("Director");
		browseJobs = new BrowseJobs();
		selectJob= browseJobs.selectJobList();
	}
	
	@Test(priority=1)
	public void validateApplyButtonTest() {
		try {
			Assert.assertTrue(selectJob.validateApplyButton());
			log.info("Apply Button is available ");
		}
		catch (Exception e) {
			log.error("Exception Occured in validateApplyButtonTest "+e.getMessage());
			}
	}
	
	@Test(priority=2)
	public void validateJobDescriptionTest() {
		try {
			Assert.assertTrue(selectJob.validateJobDescription());
			log.info("Job Description is available ");
		}
		catch (Exception e) {
			log.error("Exception Occured in validateJobDescriptionTest "+e.getMessage());
			}
}
}
