package Libraries;


import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import Objects.PageObjects;
import Objects.Properties;

public class FormLogin {
	

	static String userNameObj = PageObjects.loginObjects.userName.getObjectReference();
	static String passwordObj = PageObjects.loginObjects.password.getObjectReference();			
	static String submitObj = PageObjects.loginObjects.submit.getObjectReference();
	static String logoutObj = PageObjects.homeScreenObjects.logout.getObjectReference();
	
	public static void userLogin(WebDriver driver, String testCaseName) throws Exception
	{
		
		HashMap<String,String> dataRepo = ReadExcel.getDataMap(Properties.loginFilePath, testCaseName);
		
		String userNamedata = dataRepo.get("userName").toString();
		String passwordData = dataRepo.get("password").toString();

		Thread.sleep(Properties.timerDefault*2);
		UIToolFunctions.setElementText(driver, userNameObj, userNamedata);
		UIToolFunctions.setElementText(driver, passwordObj, passwordData);
		UIToolFunctions.clickWebElement(driver, submitObj);
		Thread.sleep(Properties.timerDefault*8);    
		
	}
	
	public static void userLogout(WebDriver driver) throws InterruptedException {		
		UIToolFunctions.clickWebElement(driver, logoutObj);	
		Thread.sleep(Properties.timerDefault*3);   
	}	

	public static boolean validateInvalidLogin(WebDriver driver) {		
		return UIToolFunctions.doesPageContainsText(driver, "Invalid user name or password.");	
	}	

	public static boolean validateValidLogin(WebDriver driver) {		
		return (UIToolFunctions.doesPageContainsText(driver, "Welcome,") && UIToolFunctions.doesPageContainsText(driver, "All Apps"));	
	}	
	
	public static boolean validateLoginFormObjects(WebDriver driver)
	{
		boolean flag=true;
		
		for(PageObjects.loginObjects test: PageObjects.loginObjects.values())
		{
			String element = test.getObjectReference();
			System.out.println(test.toString());
			
			if(!UIToolFunctions.isElementVisible(driver, element)){
				flag=false;
				System.out.println(test.toString() + "Element not found");
			}
		}
		
		return flag;
		
	}
}		
	

