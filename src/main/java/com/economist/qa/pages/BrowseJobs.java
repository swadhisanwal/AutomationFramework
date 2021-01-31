package com.economist.qa.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import com.economist.qa.base.TestBase;
import com.economist.qa.util.TestUtil;

public class BrowseJobs extends TestBase {

	// PageFactory/Object repository:
	@FindBy(id ="browsing")
	WebElement browseJobsHeading;

	// Banking Filter WebElement
	@FindBy(xpath="//em[@class= \"filter__parent-term\"]")
	WebElement bankingFilter;

	// Job List WebElement
	//@FindBy(xpath ="//ul[@id='listing']")
	@FindBy(xpath= "//div[@class='grid-item seven-twelfths lap-seven-twelfths palm-one-whole']")
	WebElement jobList;

	//Search Keyword textbox WebElement 
	@FindBy(id="keyword")
	WebElement searchTextBox;

	//Search button WebElement
	@FindBy(xpath ="//input[@value='Search']")
	WebElement searchButtton;

	//Search Results Heading
	@FindBy(id="searching")
	WebElement searchResultsHeading;


	Logger log = Logger.getLogger(BrowseJobs.class);

	//Initializing Page Object:
	public BrowseJobs(){
		PageFactory.initElements(driver, this);	
	}


	/***
	 * Description: Displaying list of searched jobs and clicking on the job for displaying its details
	 * @return
	 */
	public SelectJobs selectJobList() {


		//Storing the job listings in a list and traversing through the list
		List<WebElement> links = jobList.findElements(By.tagName("a"));
		int count =0;
		for(int i = 0 ; i< links.size() ; i++){
			WebElement e1= links.get(i);
			String message = e1.getAttribute("href");
			if(message.contains("/job/"))
			{
				count++;
			}log.info("No of jobs links are "+ count);
		}


		//This line will print the number of job listing and the count of job listing.
		log.info("No of jobs links are "+ count); 
		//just selecting the few element in the list
		for(int i=0;i<3;i++)
		{
			WebElement e1= links.get(i);
			String url= e1.getAttribute("href");
			if(url.contains("/job/"))
			{
				e1.click();
			}
		}
		return new SelectJobs();

	}

	/***
	 * Description: selecting a sector Name shows applicable data 
	 * @param SectorName
	 * @return
	 */

	public boolean verifySectorHeading(String SectorName) {
		if (browseJobsHeading.getText().contains(SectorName)) {
			return true;
		}
		else return false;


	}
	
	
	
	

	/***
	 * Description: verifying Valid Sector Name heading
	 */			

	public boolean verifySearchResult(String SectorName) {
		if (searchResultsHeading.getText().contains(SectorName)) {
			return true;
		}
		else return false;

	}

}





