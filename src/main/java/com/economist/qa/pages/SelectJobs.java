package com.economist.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.economist.qa.base.TestBase;

public class SelectJobs extends TestBase {
	
	// PageFactory/Object repository:

	// Apply Button WebElement
	@FindBy(partialLinkText ="Apply")
	WebElement applyButton;

	//Job Description WebElement
	@FindBy(xpath = "//div[contains(@class,'grid-item seven-twelfths palm-one-whole')]")
	WebElement jobDescription;

	Logger log = Logger.getLogger(SelectJobs.class);

	//Initializing Page Object:
	public SelectJobs(){
		PageFactory.initElements(driver, this);	
	}

	//Actions:
	
	/***
	 * Description- For visibility of Apply
	 * @return
	 */
	public boolean validateApplyButton() {
		return applyButton.isDisplayed();
	}

	
	/***
	 * Description- For visibility of Job Description
	 * @return
	 */
	public boolean validateJobDescription() {
		return jobDescription.isDisplayed();
	}
}