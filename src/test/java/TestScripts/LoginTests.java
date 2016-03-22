package TestScripts;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Libraries.FormAuthentication;
import Libraries.FormLogin;
import Libraries.UIToolFunctions;
import Objects.Properties;


public class LoginTests {
	
	static WebDriver browser;

	@BeforeTest
	public void initiateBrowser() throws InterruptedException 
	{
		browser = UIToolFunctions.initiateChromeBrowser();
		UIToolFunctions.launchURL(browser, Properties.URL);

	}
	
	/** 
	 * <h1>1001_Login should succeed and user should see All Apps page </h1>
	 * <p>This test case validates the admin login
	 * <p> <b>Author</b> : sj186053
	 * @throws Exception
	 */

	@Test
	public void _1001_login_As_Admin() throws Exception
	{
		FormLogin.userLogin(browser, "login with admin");
		Assert.assertEquals(true, FormLogin.validateValidLogin(browser));
		FormLogin.userLogout(browser);
		
	}	
	
	@Test
	public void _1001_Username_should_be_case_insensitive() throws Exception
	{
		FormLogin.userLogin(browser, "username should be case insensitive");
		Assert.assertEquals(true, FormLogin.validateValidLogin(browser));
		FormLogin.userLogout(browser);
		
	}
	
	@Test
	public void _1001_Login_as_DB_User() throws Exception
	{
		FormLogin.userLogin(browser, "login with admin");
		Assert.assertEquals(true, FormLogin.validateValidLogin(browser));
		
		// Configure DB settings
		Assert.assertEquals(true, FormAuthentication.testAndConfigureDB(browser));
		
		// logout and login as DB user
		FormLogin.userLogout(browser);
		FormLogin.userLogin(browser, "login as db user");
		
		// Verify the login
		Assert.assertEquals(true, FormLogin.validateValidLogin(browser));
		FormLogin.userLogout(browser);
	}	

	@Test
	public void _1001_Login_as_LDAP_user() throws Exception
	{
		FormLogin.userLogin(browser, "login with admin");
		Assert.assertEquals(true, FormLogin.validateValidLogin(browser));

	    if(FormAuthentication.testAndConfigureLDAP(browser))
	    {
	    	FormLogin.userLogout(browser);
	    	FormLogin.userLogin(browser, "login with ldap user");
	    	Assert.assertEquals(true, FormLogin.validateValidLogin(browser));   	
	    	
	    }
	    
	    FormLogin.userLogout(browser);
	}	
	
	@Test
	public void _1002_Login_with_Invalid_user() throws Exception
	{
		FormLogin.userLogin(browser, "Invalid login with improper username");
		Assert.assertEquals(true, FormLogin.validateInvalidLogin(browser));	   
	}
	
	@Test
	public void _1002_Login_with_Invalid_password() throws Exception
	{
		FormLogin.userLogin(browser, "Invalid login with improper password");
		Assert.assertEquals(true, FormLogin.validateInvalidLogin(browser));	   
	}
	
	@Test
	public void _1002_Password_should_be_case_sensitive() throws Exception
	{
		FormLogin.userLogin(browser, "password should be case sensitive");
		Assert.assertEquals(true, FormLogin.validateInvalidLogin(browser));	   
	}

	@Test
	public void _1003_Login_page_objects_verification() throws Exception
	{
		Assert.assertEquals(true,FormLogin.validateLoginFormObjects(browser),"all objects not found");
	}
	
	@AfterTest
	public void closeBrowser() throws InterruptedException 
	{
		browser.close();
	}
	
}
	
