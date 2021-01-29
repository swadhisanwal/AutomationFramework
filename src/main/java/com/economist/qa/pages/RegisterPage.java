package com.economist.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.economist.qa.base.TestBase;

public class RegisterPage extends TestBase {

	@FindBy(linkText = "Create account")
	WebElement Register;
		
		//Initializing Page Object:
				public RegisterPage(){
					PageFactory.initElements(driver, this);	
				}
		
		//Actions
				
				//For Create account page Title 
				public String verifyRegisteTitle() {
					Register.click();
					return driver.getTitle();
				}
				
				//For Create account page URL
				public String verifyRegisterURL() {
					Register.click();
					return driver.getCurrentUrl();
				}
		
		
	
}
