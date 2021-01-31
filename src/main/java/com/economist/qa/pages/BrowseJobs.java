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

import com.economist.qa.base.TestBase;

public class BrowseJobs extends TestBase {

	// PageFactory/Object repository:
	@FindBy(id ="browsing")
	WebElement bankingHeading;

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
	

	Logger log = Logger.getLogger(BrowseJobs.class);
	
	//Initializing Page Object:
		public BrowseJobs(){
			PageFactory.initElements(driver, this);	
		}
	
	
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
	 * Description: 
	 * @param sectorName
	 * @return
	 */
	
	/*public boolean navigationJobList(String sectorName) {

	boolean found = false;
	//Storing the job listings in a list and traversing through the list 
	List<WebElement> listForJobs = jobList.findElements(By.tagName("Li"));

	//This line will print the number of job listing and the count of job listing.
	log.info("No of jobs opening are "+ listForJobs.size()); 
	for(WebElement ele:listForJobs)
	{
		if(ele.getText().contains("banking-and-finance")) {
			found=true;
		}
	}
	return found;
}*/


}



