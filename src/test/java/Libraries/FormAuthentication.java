package Libraries;


import org.openqa.selenium.WebDriver;

import Objects.PageObjects;
import Objects.Properties;
public class FormAuthentication {
	
	static String authenticationTab = PageObjects.authenticationObjects.authenticationTab.getObjectReference();
	static String enableLDAP = PageObjects.authenticationObjects.modeLDAP.getObjectReference();
	static String ldapURL = PageObjects.authenticationObjects.ldapServerURL.getObjectReference();
	static String baseDN = PageObjects.authenticationObjects.baseDN.getObjectReference();
	static String ldapAdminUser = PageObjects.authenticationObjects.ldapAdminUser.getObjectReference();
	static String ldapAdminPwd = PageObjects.authenticationObjects.ldapAdminPwd.getObjectReference();
	static String testLDAP = PageObjects.authenticationObjects.testLDAP.getObjectReference();
	static String saveLDAP = PageObjects.authenticationObjects.saveLDAP.getObjectReference();
	static String cancelLDAP = PageObjects.authenticationObjects.cancelLDAP.getObjectReference();	
	static String settings= PageObjects.homeScreenObjects.settings.getObjectReference();
	
	// DB Objects
	static String dbMode= PageObjects.authenticationObjects.modeAsterDB.getObjectReference();
	static String dbShareApp= PageObjects.authenticationObjects.shareApp.getObjectReference();
	static String dbIP = PageObjects.authenticationObjects.asterIp.getObjectReference();
	static String dbName = PageObjects.authenticationObjects.asterDBName.getObjectReference();
	static String dbUser = PageObjects.authenticationObjects.asterUserName.getObjectReference();
	static String dbPassword = PageObjects.authenticationObjects.asterPassword.getObjectReference();
	static String saveDB = PageObjects.authenticationObjects.saveDB.getObjectReference();
	static String cancelDB = PageObjects.authenticationObjects.canceDB.getObjectReference();	
	static String testDB= PageObjects.authenticationObjects.testDB.getObjectReference();
	
	
	
	/**
	   * @author sj186053
	   * @description testLDAP library function is used to test the LDAP settings in AppCenter
	   * @param driver This is browser reference
	   * @param ldapData LDAP details are taken from the /src/objects/properties file
	   * @throws java.lang.Exception
	   * @return boolean This returns boolean value whether or not the test is successful.
	   */
	public static boolean testLDAP(WebDriver driver) throws Exception
	{
		UIToolFunctions.clickWebElement(driver, settings);
		Thread.sleep(Properties.timerDefault*2);
		
		UIToolFunctions.clickWebElement(driver, authenticationTab);
		Thread.sleep(Properties.timerDefault*2);
		
		// Enable the LDAP check box
	    if(!UIToolFunctions.isElementSelected(driver, enableLDAP))
	    		UIToolFunctions.clickWebElement(driver, enableLDAP);
	    		
	    // Provide the LDAP details
	    
	    UIToolFunctions.clearElementText(driver, ldapURL);	
	    UIToolFunctions.setElementText(driver, ldapURL, Properties.ldapURL);
	    
	    UIToolFunctions.clearElementText(driver, baseDN);
	    UIToolFunctions.setElementText(driver, baseDN, Properties.ldapBaseDN);
	    
	    UIToolFunctions.clearElementText(driver, ldapAdminUser);	
	    UIToolFunctions.setElementText(driver, ldapAdminUser, Properties.ldapAdmin);
	    
	    
	    UIToolFunctions.clearElementText(driver, ldapAdminPwd);	
	    UIToolFunctions.setElementText(driver, ldapAdminPwd, Properties.ldapAdminPassword);
	    
	    UIToolFunctions.clickWebElement(driver, testLDAP);
	    Thread.sleep(Properties.timerDefault*8);
	    
	    return UIToolFunctions.isElementVisible(driver, saveLDAP);

	}	
	

	/**
	   * @author sj186053
	   * @description testAndSaveLDAP library function is used to test and configure the LDAP settings in AppCenter
	   * @param driver This is browser reference
	   * @param ldapData LDAP details are taken from the /src/objects/properties file
	   * @throws java.lang.Exception
	   * @return boolean This returns boolean value whether or not the LDAP is configured
	   */
	public static boolean testAndConfigureLDAP(WebDriver driver) throws Exception
	{
		UIToolFunctions.clickWebElement(driver, settings);
		Thread.sleep(Properties.timerDefault*2);
		
		UIToolFunctions.clickWebElement(driver, authenticationTab);
		Thread.sleep(Properties.timerDefault*2);
		
		// Enable the LDAP checkbox
	    if(!UIToolFunctions.isElementSelected(driver, enableLDAP))
	    		UIToolFunctions.clickWebElement(driver, enableLDAP);
	    		
	    // Provide the LDAP details
	    
	    UIToolFunctions.clearElementText(driver, ldapURL);	
	    UIToolFunctions.setElementText(driver, ldapURL, Properties.ldapURL);
	    
	    UIToolFunctions.clearElementText(driver, baseDN);
	    UIToolFunctions.setElementText(driver, baseDN, Properties.ldapBaseDN);
	    
	    UIToolFunctions.clearElementText(driver, ldapAdminUser);	
	    UIToolFunctions.setElementText(driver, ldapAdminUser, Properties.ldapAdmin);
	    
	    
	    UIToolFunctions.clearElementText(driver, ldapAdminPwd);	
	    UIToolFunctions.setElementText(driver, ldapAdminPwd, Properties.ldapAdminPassword);
	    
	    UIToolFunctions.clickWebElement(driver, testLDAP);
	    Thread.sleep(Properties.timerDefault*8);
	    
	    if(UIToolFunctions.isElementVisible(driver, saveLDAP))
	    {
	        UIToolFunctions.clickWebElement(driver, saveLDAP);
		    Thread.sleep(Properties.timerDefault*5);
		    
		    return UIToolFunctions.isElementVisible(driver, testLDAP);
	    }
	    else
	    	return false;

	}
	

	/**
	   * @author sj186053
	   * @description testDB library function is used to test the Aster DB settings in AppCenter
	   * @param driver This is browser reference
	   * @param Aster DB details are taken from the /src/objects/properties file
	   * @throws java.lang.Exception
	   * @return boolean This returns boolean value whether or not the test is successful.
	   */
	public static boolean testDB(WebDriver driver) throws Exception
	{
		UIToolFunctions.clickWebElement(driver, settings);
		Thread.sleep(Properties.timerDefault*2);
		
		UIToolFunctions.clickWebElement(driver, authenticationTab);
		Thread.sleep(Properties.timerDefault*2);
		
		// Enable the AsterDB check box
	    if(!UIToolFunctions.isElementSelected(driver, dbMode))
	    		UIToolFunctions.clickWebElement(driver, dbMode);
	    		
	    // Provide the DB details
	    if((Properties.shareApp==true) && !(UIToolFunctions.isElementSelected(driver, dbShareApp)))
	    	UIToolFunctions.clickWebElement(driver, dbShareApp);
	    else if((Properties.shareApp==false) && UIToolFunctions.isElementSelected(driver, dbShareApp))
	    	UIToolFunctions.clickWebElement(driver, dbShareApp);
	    
	    UIToolFunctions.clearElementText(driver, dbIP);	
	    UIToolFunctions.setElementText(driver, dbIP, Properties.dbHost);
	    
	    UIToolFunctions.clearElementText(driver, dbName);
	    UIToolFunctions.setElementText(driver, dbName, Properties.dbName);
	    
	    UIToolFunctions.clearElementText(driver, dbUser);	
	    UIToolFunctions.setElementText(driver, dbUser, Properties.dbUser);
	    
	    
	    UIToolFunctions.clearElementText(driver, dbPassword);	
	    UIToolFunctions.setElementText(driver, dbPassword, Properties.dbPassword);
	    
	    UIToolFunctions.clickWebElement(driver, testDB);
	    Thread.sleep(Properties.timerDefault*8);
	    
	    return UIToolFunctions.isElementVisible(driver, saveDB);

	}	
	
	/**
	   * @author sj186053
	   * @description testAndSaveDB library function is used to test and configure the Aster DB settings in AppCenter
	   * @param driver This is browser reference
	   * @param Aster DB details are taken from the /src/objects/properties file
	   * @throws java.lang.Exception
	   * @return boolean This returns boolean value whether or not the test is successful.
	   */
	public static boolean testAndConfigureDB(WebDriver driver) throws Exception
	{
		UIToolFunctions.clickWebElement(driver, settings);
		Thread.sleep(Properties.timerDefault*2);
		
		UIToolFunctions.clickWebElement(driver, authenticationTab);
		Thread.sleep(Properties.timerDefault*2);
		
		// Enable the AsterDB check box
	    if(!UIToolFunctions.isElementSelected(driver, dbMode))
	    		UIToolFunctions.clickWebElement(driver, dbMode);
	    		
	    // Provide the DB details
	    if((Properties.shareApp==true) && !(UIToolFunctions.isElementSelected(driver, dbShareApp)))
	    	UIToolFunctions.clickWebElement(driver, dbShareApp);
	    else if((Properties.shareApp==false) && UIToolFunctions.isElementSelected(driver, dbShareApp))
	    	UIToolFunctions.clickWebElement(driver, dbShareApp);
	    
	    UIToolFunctions.clearElementText(driver, dbIP);	
	    UIToolFunctions.setElementText(driver, dbIP, Properties.dbHost);
	    
	    UIToolFunctions.clearElementText(driver, dbName);
	    UIToolFunctions.setElementText(driver, dbName, Properties.dbName);
	    
	    UIToolFunctions.clearElementText(driver, dbUser);	
	    UIToolFunctions.setElementText(driver, dbUser, Properties.dbUser);
	    
	    
	    UIToolFunctions.clearElementText(driver, dbPassword);	
	    UIToolFunctions.setElementText(driver, dbPassword, Properties.dbPassword);
	    
	    UIToolFunctions.clickWebElement(driver, testDB);
	    Thread.sleep(Properties.timerDefault*8);
	    
	    if(UIToolFunctions.isElementVisible(driver, saveDB))
	    {
	        UIToolFunctions.clickWebElement(driver, saveDB);
		    Thread.sleep(Properties.timerDefault*5);
		    
		    return UIToolFunctions.isElementVisible(driver, testDB);
	    }
	    else
	    	return false; 

	}	

}		
	

