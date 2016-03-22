package TestScripts;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Libraries.FormCollection;
import Libraries.FormLogin;
import Libraries.UIToolFunctions;
import Objects.Properties;

public class test {
	
	static WebDriver browser;

	//@BeforeTest
	public void initiateBrowser() throws Exception 
	{
		browser = UIToolFunctions.initiateChromeBrowser();
		UIToolFunctions.launchURL(browser, Properties.URL);
		FormLogin.userLogin(browser, "login with admin");		

	}

	@Test
	public void getCollectionReference() throws Exception
	{
		
		String collectionName = "Collection" + RandomStringUtils.randomNumeric(3);
		System.out.println(collectionName);
		//FormCollection.deleteCollection(browser, "sdfs");
	
	}
	
	//@AfterTest
	public void closeBrowser() throws InterruptedException 
	{
		browser.close();
	}
	
}
