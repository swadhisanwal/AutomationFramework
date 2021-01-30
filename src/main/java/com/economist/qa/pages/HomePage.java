package com.economist.qa.pages;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
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
		
		@FindBy (xpath= "//div[contains(@class,'browse__items')")
		WebElement JobsSector;
		
		@FindBy(linkText = "Banking and finance")
		WebElement Banking;
	
		@FindBy(xpath="//nav[@id=\"primary-nav\"]")
		public WebElement NavigationBar;
		
		@FindBy(xpath="//input[@type =\"submit\"]")
		WebElement SearchButton;
		
		@FindBy(id="keywords")
		WebElement SearchKeyword;
		
		@FindBy(id="location")
		WebElement SearchLocation;
		
		@FindBy(id="RadialLocation")
		WebElement SearchRadialLocation;
		
	
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
			return NavigationBar.isDisplayed();
		}
		
		
		/***
		 * Description: For visibility of Search Button
		 * @return
		 */
		public boolean validateSearchButton() {
			return SearchButton.isDisplayed();
			}
		
		/***
		 * Description: For visibility of component for search keyword
		 * @return
		 */
		public boolean validateSearchKeyword() {
			return SearchKeyword.isDisplayed();
			}
		
		/***
		 * Description: For visibility of component for location search
		 * @return
		 */
		public boolean validateSearchLocation() {
			return SearchLocation.isDisplayed();
			}
		
	
		/***
		 * Description: For visibility of component for radial location search
		 * @return
		 */
		public boolean validateSearchRadialLocation() {
			return SearchRadialLocation.isDisplayed();
			}
		
		/***
		 * Description: For navigating to Login page
		 * @return
		 */
		public LoginPage loginPageVerify() {
			Login.click();
			return new LoginPage();
		}
	
		/***
		 * Description: For navigating to Create account page
		 * @return
		 */
		public RegisterPage registerPageVerify() {
			Register.click();
			return new RegisterPage();
		}
		
		
		/***
		 * Description:To identify number of links within a WebElement 
		 * @return
		 */
		public boolean navigationTabLink() {
			 //Storing the links in a list and traversing through the links
	        List<WebElement> links = NavigationBar.findElements(By.tagName("a"));
	        boolean flag= false;

	        // This line will print the number of links and the count of links.
	        System.out.println("No of links are "+ links.size());  
	      
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
			List<WebElement> links = NavigationBar.findElements(By.tagName("a"));
			System.out.println("No of links are "+links.size());
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
	             System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage()+"is a broken link");
	             flag = false;
	            }    
	       
	            //Fetching and Printing the response code obtained
	            else{
	                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
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
			        List<WebElement> links = JobsSector.findElements(By.tagName("a"));
			        for(WebElement ele:links)
			        {
			        	if(ele.getText()==sectorName)
			        	{
			        		ele.click();
			        	}
			        }
			        return new Browsejobs();
			}
				
				
		}


