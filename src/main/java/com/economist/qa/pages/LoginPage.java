package com.economist.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.economist.qa.base.TestBase;

public class LoginPage extends TestBase {
	@FindBy(linkText ="Sign in")
	WebElement login;

	//Initializing Page Object:
	public LoginPage(){
		PageFactory.initElements(driver, this);	
	}

	//Actions
	/***
	 * Description: For Login page Title 
	 * @return
	 */
	public String verifyLoginTitle() {
		login.click();
		return driver.getTitle();
	}
	
	/***
	 * Description: For Login page URL 
	 * @return
	 */
	public String verifyLoginURL() {
		login.click();
		return driver.getCurrentUrl();
	}


}
