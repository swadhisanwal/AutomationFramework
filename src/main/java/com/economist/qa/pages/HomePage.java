package com.economist.qa.pages;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
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
		
		public boolean validateNavigationBar() {
			return NavigationBar.isDisplayed();
		}
		
		public boolean validateSearchButton() {
			return SearchButton.isDisplayed();
			}
		
		public boolean validateSearchKeyword() {
			return SearchKeyword.isDisplayed();
			}
		
		public boolean validateSearchLocation() {
			return SearchLocation.isDisplayed();
			}
		
		public boolean validateSearchRadialLocation() {
			return SearchRadialLocation.isDisplayed();
			}
		
		public LoginPage loginPageVerify() {
			Login.click();
			return new LoginPage();
		}
		public RegisterPage registerPageVerify() {
			Register.click();
			return new RegisterPage();
		}
		
		
		//to identify number of links within a WebElement 
		public void navigationTabLink() {
			 //Storing the links in a list and traversing through the links
	        List<WebElement> links = NavigationBar.findElements(By.tagName("a"));

	        // This line will print the number of links and the count of links.
	        System.out.println("No of links are "+ links.size());  
	      
	        //checking the links fetched.
	        for(int i=0;i<links.size();i++)
	        {
	            WebElement E1= links.get(i);
	            String url= E1.getAttribute("href");
	            verifyLinks(url);
	        }
		}
		
		// to click a link in the specific panel 
		public void verifyLinks(String linkUrl) {
			List<WebElement> links = NavigationBar.findElements(By.tagName("a"));
			System.out.println("No of links are "+links.size());
			
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
	            }    
	       
	            //Fetching and Printing the response code obtained
	            else{
	                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
	            }
	        }catch (Exception e) {
	      }
			
		}
		
		}

