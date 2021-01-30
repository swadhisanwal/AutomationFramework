package com.economist.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.economist.qa.base.TestBase;

public class RegisterPage extends TestBase {

	@FindBy(linkText = "Create account")
	WebElement register;

	//Initializing Page Object:
	public RegisterPage(){
		PageFactory.initElements(driver, this);	
	}

	//Actions

	/***
	 * Description:For Create account page Title
	 * @return
	 */
	public String verifyRegisteTitle() {
		register.click();
		return driver.getTitle();
	}

	/***
	 * Description: For Create account page URL
	 * @return
	 */
	public String verifyRegisterURL() {
		register.click();
		return driver.getCurrentUrl();
	}



}
