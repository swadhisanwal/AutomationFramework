package com.economist.qa.pages;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.economist.qa.base.TestBase;

public class HomePage extends TestBase {

	//PageFactory/Object repository:
	@FindBy(linkText ="Sign in")
	WebElement login;

	@FindBy(linkText = "Create account")
	WebElement register;

	@FindBy (xpath= "//div[contains(@class,'browse__items')")
	WebElement jobsSector;

	@FindBy(linkText = "Banking and finance")
	WebElement banking;

	@FindBy(xpath="//nav[@id=\"primary-nav\"]")
	public WebElement navigationBar;

	@FindBy(xpath="//input[@type =\"submit\"]")
	WebElement searchButton;

	@FindBy(id="keywords")
	WebElement searchKeyword;

	@FindBy(id="location")
	WebElement searchLocation;

	@FindBy(id="RadialLocation")
	WebElement searchRadialLocation;
	Logger log = Logger.getLogger(HomePage.class);


	//Initializing Page Object:
	public HomePage(){
		PageFactory.initElements(driver, this);	
	}
	//Actions:

	/***
	 * Description- For visibility of Navigation Bar
	 * @return
	 */
	public boolean validateNavigationBar() {
		return navigationBar.isDisplayed();
	}


	/***
	 * Description: For visibility of Search Button
	 * @return
	 */
	public boolean validateSearchButton() {
		return searchButton.isDisplayed();
	}

	/***
	 * Description: For visibility of component for search keyword
	 * @return
	 */
	public boolean validateSearchKeyword() {
		return searchKeyword.isDisplayed();
	}

	/***
	 * Description: For visibility of component for location search
	 * @return
	 */
	public boolean validateSearchLocation() {
		return searchLocation.isDisplayed();
	}


	/***
	 * Description: For visibility of component for radial location search
	 * @return
	 */
	public boolean validateSearchRadialLocation() {
		return searchRadialLocation.isDisplayed();
	}

	/***
	 * Description: For navigating to Login page
	 * @return
	 */
	public LoginPage loginPageVerify() {
		login.click();
		return new LoginPage();
	}

	/***
	 * Description: For navigating to Create account page
	 * @return
	 */
	public RegisterPage registerPageVerify() {
		register.click();
		return new RegisterPage();
	}


	/***
	 * Description:To identify number of links within a WebElement 
	 * @return
	 */
	public boolean navigationTabLink() {
		//Storing the links in a list and traversing through the links
		List<WebElement> links = navigationBar.findElements(By.tagName("a"));
		boolean flag= false;

		// This line will print the number of links and the count of links.
		log.info("No of links are "+ links.size());  

		//checking the links fetched.
		for(int i=0;i<links.size();i++)
		{
			WebElement E1= links.get(i);
			String url= E1.getAttribute("href");
			flag = verifyLinks(url);
		}
		return flag;
	}


	/***
	 * Description: to click a link in the specific panel
	 * @param linkUrl
	 * @return
	 */
	public boolean verifyLinks(String linkUrl) {
		boolean flag= false;

		try
		{
			URL url = new URL(linkUrl);

			//Now we will be creating url connection and getting the response code
			HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
			httpURLConnect.setConnectTimeout(5000);
			httpURLConnect.connect();
			if(httpURLConnect.getResponseCode()>=400)
			{
				log.info(linkUrl+" - "+httpURLConnect.getResponseMessage()+"is a broken link");
			}    

			//Fetching and Printing the response code obtained
			else{
				log.info(linkUrl+" - "+httpURLConnect.getResponseMessage());
				flag = true;
			}
		}catch (Exception e) {

		}
		return flag;

	}


	/**
	 * Description: To select Navigation and Banking Finance sector
	 * @param sectorName
	 * @return
	 */
	public Browsejobs findJobs(String sectorName) {
		//Storing the links in a list and traversing through the links
		List<WebElement> links = jobsSector.findElements(By.tagName("a"));
		for(WebElement ele:links)
		{
			if(ele.getText().equalsIgnoreCase(sectorName))
			{
				ele.click();
			}
		}
		return new Browsejobs();
	}


}


