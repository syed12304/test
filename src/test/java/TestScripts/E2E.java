package TestScripts;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Libraries.EndToEndFlowFunctions;
import Libraries.FormLogin;
import Libraries.UIToolFunctions;
import Objects.Properties;

public class E2E {

	public   WebDriver browser = null;
	public  String URL =null;
	
	@BeforeMethod
	public  void init() throws InterruptedException
	{
		browser = UIToolFunctions.initiateChromeBrowser();				
	}
	
	@Test
	public  void endToEndTest() throws Exception
	{
		UIToolFunctions.launchURL(browser, Properties.URL);
		FormLogin.userLogin(browser, "login with admin");
		EndToEndFlowFunctions.installApp(browser, Properties.appName);
		EndToEndFlowFunctions.configureApp(browser);
		EndToEndFlowFunctions.runJob(browser);
		
		EndToEndFlowFunctions.enableSharing(browser);
		assert(EndToEndFlowFunctions.checkForSharingEnabled(browser));
		URL = EndToEndFlowFunctions.getLinkOfPublishedVisualization(browser);
		System.out.println(URL);
	}
	
	@Test (dependsOnMethods={"endToEndTest"})
	public  void verifyVisualization() throws Exception
	{
		System.out.println(URL);
		assert(EndToEndFlowFunctions.verifyPublishedVisualization(browser,URL));
	}
	
	
	@Test (dependsOnMethods={"verifyVisualization"})
	public  void uninstallApp() throws Exception
	{
		UIToolFunctions.launchURL(browser, Properties.URL);
		FormLogin.userLogin(browser, "login with admin");
		EndToEndFlowFunctions.uninstallApp(browser, Properties.appName);
	}
	
	
	@AfterMethod
	public  void close() throws InterruptedException
	{		
		UIToolFunctions.closeBrowser(browser);
	}
}
