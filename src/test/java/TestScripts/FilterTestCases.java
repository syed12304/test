package TestScripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Libraries.FormLogin;
import Libraries.UIToolFunctions;
import Objects.Properties;

public class FilterTestCases {
	static WebDriver browser;
	static String appName = Properties.appName;
	
	
	@BeforeTest
	public void initiateBrowser() throws Exception 
	{
		browser = UIToolFunctions.initiateChromeBrowser();
		UIToolFunctions.launchURL(browser, Properties.URL);
		FormLogin.userLogin(browser, "login with admin");

	}
	
	
	
	
	
	

	@AfterTest
	public void closeBrowser() throws InterruptedException 
	{
		browser.close();
	}
	
}
