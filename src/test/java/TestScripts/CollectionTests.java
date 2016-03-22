package TestScripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Libraries.FormCollection;
import Libraries.FormLogin;
import Libraries.UIToolFunctions;
import Objects.Properties;


public class CollectionTests {
	 static WebDriver browser;
	 static String appName = ".//*[@id='call']/ul/li[1]";
	 static String collectionName = "Collection"+Math.random()*10022212;
	
	@BeforeTest
	public void initiateBrowser() throws InterruptedException 
	{
		browser = UIToolFunctions.initiateChromeBrowser();
		UIToolFunctions.launchURL(browser, Properties.URL);
	}
	
	
	@Test
	public void collectionProcess() throws Exception
	{
		
		FormLogin.userLogin(browser, "login with admin");
		FormCollection.createCollection(browser, collectionName);
		
		// drag and drop the collection
		UIToolFunctions.dragAndDropElement(browser, appName, FormCollection.getCollectionReference(browser,collectionName));
   	    
	    // delete the collection
		// FormCollection.mouseHoverOnCollection(browser, collectionName);
	    FormCollection.deleteCollection(browser, collectionName);
	    
	}	
	
	@AfterTest
	public void closeBrowser() throws InterruptedException 
	{
		browser.close();
	}
	
}
	