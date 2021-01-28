package com.economist.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.economist.qa.base.TestBase;

public class LoginPage extends TestBase {
	@FindBy(linkText ="Sign in")
	WebElement Login;
	
	//Initializing Page Object:
			public LoginPage(){
				PageFactory.initElements(driver, this);	
			}
	
	//Actions
			
			public String verifyLoginTitle() {
				Login.click();
				return driver.getTitle();
			}
			
			public String verifyLoginURL() {
				Login.click();
				return driver.getCurrentUrl();
			}
	
	
}
