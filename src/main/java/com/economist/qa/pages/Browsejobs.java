package com.economist.qa.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.economist.qa.base.TestBase;

public class Browsejobs extends TestBase {

	// PageFactory/Object repository:
	@FindBy(id ="browsing")
	WebElement bankingHeading;

	// Banking Filter WebElement
	@FindBy(xpath="//em[@class= \"filter__parent-term\"]")
	WebElement bankingFilter;

	// Job List WebElement
	@FindBy(id ="listing")
	WebElement jobList;

	Logger log = Logger.getLogger(Browsejobs.class);

	
	public boolean navigationJobList() {

		boolean found = false;
		//Storing the job listings in a list and traversing through the lisy 
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
	}


	public SelectJobs selectJobList() {

		//boolean found = false;
		//Storing the job listings in a list and traversing through the lisy 
		List<WebElement> links = jobList.findElements(By.tagName("a"));

		//This line will print the number of job listing and the count of job listing.
		log.info("No of jobs links are "+ links.size()); 
		//just selecting the few element in the list
		for(int i=0;i<3;i++)
		{
			WebElement E1= links.get(i);
			String url= E1.getAttribute("href");
			log.info("job listing url are" + url);
			E1.click();
		}
		return new SelectJobs();
	
				
	}
}



