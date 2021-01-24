package com.economist.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.economist.qa.base.TestBase;

public class HomePage extends TestBase {
	
	//PageFactory/Object repository:
		@FindBy(linkText ="Sign in")
		WebElement Login;
		
		@FindBy(linkText = "Create account")
		WebElement Register;
	
		@FindBy(xpath="//nav[@id=\"primary-nav\"]")
		WebElement NavigationBar;
	
	//Initializing Page Object:
		public HomePage(){
			PageFactory.initElements(driver, this);	
		}
	//Actions:
		public String validateLoginPageTitle() {
			return driver.getTitle();
		}
		public boolean validateNavigationBar() {
			return NavigationBar.isDisplayed();
		}
		public LoginPage loginPageVerify() {
			Login.click();
			return new LoginPage();
		}
		}

