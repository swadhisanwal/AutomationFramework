package com.economist.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	static WebDriver driver;
	static Properties prop;
	
	public TestBase() {
		try {
			prop= new Properties();
			FileInputStream ip = new FileInputStream("/TheEconomistTest/src/main/java/com/economist/qa/config/config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e) {
		e.printStackTrace();
		}catch(IOException e) {
		e.printStackTrace();
		}
	}
	
	/**
	 * Method Name: initialization
	 * Description: Method to Initialize the Driver on the selection from various Browser.
	 */
	public static void initialization() {
	String browserName= prop.getProperty("browser");
	if (browserName.equals("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		}
	else if (browserName.equals("firefox"))
		{
		WebDriverManager.firefoxdriver().setup();
		driver= new FirefoxDriver();
		}
	
	else if (browserName.equals("iexplorer"))
	{
	WebDriverManager.iedriver().setup();
	driver= new InternetExplorerDriver();
	}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("url"));
	}
}
