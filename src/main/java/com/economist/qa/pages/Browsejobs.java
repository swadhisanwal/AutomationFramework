package com.economist.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.economist.qa.base.TestBase;

public class Browsejobs extends TestBase {
	
	// PageFactory/Object repository:
			@FindBy(id ="browsing")
			WebElement BankingHeading;
			
			// Banking Filter WebElement
			@FindBy(xpath="//em[@class= \"filter__parent-term\"]")
			WebElement BankingFilter;
			
			// Job List WebElement
			@FindBy(id ="listing")
			WebElement JobList;
			
			
			//TO work on 
			public void navigationJobList() {
				 //Storing the links in a list and traversing through the links
		        //List<WebElement> links = JobList.findElements(By.name("banking"));

		        // This line will print the number of links and the count of links.
		        System.out.println("No of links are "+ links.size()); 
		        for(int i=0;i<links.size();i++){
				    System.out.println(links.get(i));
				}
		        }
			
			//to find the view details option
			public void selectViewDetails() 
			{
				
				
				

}
