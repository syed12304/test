package Libraries;



import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Objects.PageObjects;
import Objects.Properties;

public class EndToEndFlowFunctions
{
	static String allAppsLink = PageObjects.homeScreenObjects.allApps.getObjectReference();
	static String installAnAppLink = PageObjects.homeScreenObjects.installAnApp.getObjectReference();
	static String confirmDialogOk = PageObjects.homeScreenObjects.confirmDialogOk.getObjectReference();
	static String configureButton = PageObjects.appControlObjects.configureButton.getObjectReference();
	static String connectionProfileDropDown = PageObjects.configureDialogueObjects.connectionProfileDropDown.getObjectReference();
	static String publishingTab = PageObjects.configureDialogueObjects.publishingTab.getObjectReference();
	static String enableSharingCheckBox = PageObjects.configureDialogueObjects.enableSharingCheckBox.getObjectReference();
	static String saveButton = PageObjects.configureDialogueObjects.saveButton.getObjectReference();
	static String title = PageObjects.appControlObjects.title.getObjectReference();
	static String tag = PageObjects.appControlObjects.tag.getObjectReference();
	static String runButton = PageObjects.appControlObjects.runButton.getObjectReference();
	static String close = PageObjects.configureDialogueObjects.close.getObjectReference();
	static String globe = PageObjects.appControlObjects.globe.getObjectReference();
	static String resultId = PageObjects.appControlObjects.firstResultId.getObjectReference();
	static String enablePublishingCheckBox = PageObjects.resultSharingObjects.enablePublishingCheckBox.getObjectReference();
	static String link = PageObjects.resultSharingObjects.link.getObjectReference();
	static String pieVisualization = PageObjects.pieVisualizationObjects.pie.getObjectReference();
	static String firstResultStatus = PageObjects.appControlObjects.firstResultStatus.getObjectReference();
	static HashMap< String, String> appLocations = new HashMap<String,String>();
	
	
	
	public static String getAppLocation(String appName)
	{
		appLocations.put("saradhi pie app",Properties.resourcePath+"saradhi-pie-app.zip");
		appLocations.put("saradhi chord app",Properties.resourcePath+"saradhi-chord-app.zip");
		appLocations.put("Test App v1.0",Properties.resourcePath+"Test-App-v1.0.zip");
		appLocations.put("Test App v2.0",Properties.resourcePath+"Test-App-v2.0.zip");
		
		return appLocations.get(appName);
	}
	
	
	public static void installApp(WebDriver driver,String appName) throws InterruptedException
	{
		String pathToApp = getAppLocation(appName);
		System.out.println(pathToApp);
		Thread.sleep(Properties.timerDefault*5);
		UIToolFunctions.setElementText(driver,installAnAppLink,pathToApp);
		Thread.sleep(Properties.timerDefault*5);
	}
	
	
	public static void configureApp(WebDriver driver) throws InterruptedException
	{
		UIToolFunctions.clickWebElement(driver, configureButton);
		Thread.sleep(Properties.timerDefault*3);
		UIToolFunctions.selectElementFromDropDown(driver, connectionProfileDropDown,Properties.dropDownValue);
		UIToolFunctions.clickWebElement(driver, saveButton);
		Thread.sleep(Properties.timerDefault*5);
	}
	
	public static void runJob(WebDriver driver) throws InterruptedException
	{
		UIToolFunctions.setElementText(driver, title, "sample demo title");
		UIToolFunctions.setElementText(driver, tag, "sample demo tag");
		UIToolFunctions.clickWebElement(driver, runButton);
		Thread.sleep(Properties.timerDefault*20);
	}
	
	public static void enableSharing(WebDriver driver) throws InterruptedException
	{
		UIToolFunctions.clickWebElement(driver, configureButton);
		Thread.sleep(Properties.timerDefault*3);
		UIToolFunctions.clickWebElement(driver, publishingTab);
		Thread.sleep(Properties.timerDefault*2);
		if(!UIToolFunctions.isElementSelected(driver, enableSharingCheckBox))
		{
			UIToolFunctions.clickWebElement(driver, enableSharingCheckBox);
		}
		UIToolFunctions.clickWebElement(driver, saveButton);
		
	}
	
	public static void checkForJobCompletion(WebDriver driver) throws InterruptedException
	{
		System.out.println(UIToolFunctions.getElementText(driver, firstResultStatus));
		assertTrue("Job is Completed",UIToolFunctions.getElementText(driver, firstResultStatus).equals("Completed"));
		Thread.sleep(Properties.timerDefault*5);
	}
	
	public static boolean checkForSharingEnabled(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(Properties.timerDefault*5);
		return (UIToolFunctions.isElementVisible(driver, globe));
	}
	
	
	public static String getLinkOfPublishedVisualization(WebDriver driver) throws InterruptedException
	{
		UIToolFunctions.clickWebElement(driver, globe);
		Thread.sleep(Properties.timerDefault*2);
		UIToolFunctions.clickWebElement(driver, enablePublishingCheckBox);
		Thread.sleep(Properties.timerDefault*2);
		return (UIToolFunctions.getElementText(driver, link));
	}
	
	
	
	public static boolean verifyPublishedVisualization(WebDriver driver,String URL) throws InterruptedException
	{
		System.out.println(URL);
		UIToolFunctions.launchURL(driver, URL);
		Thread.sleep(Properties.timerDefault*10);
		driver.switchTo().frame(0);
		Thread.sleep(Properties.timerDefault*3);
		return (UIToolFunctions.isElementVisible(driver, pieVisualization));
	}
	
	
	public static void uninstallApp(WebDriver driver,String appToDelete) throws InterruptedException
	{
		Thread.sleep(Properties.timerDefault*5);
		UIToolFunctions.clickWebElement(driver, allAppsLink);
		Thread.sleep(Properties.timerDefault*5);
		
		int appLocation = UIToolFunctions.getElementLocation(driver, ".//*[@id='call']/ul/li", appToDelete);

		String appNameRef="//*[@id='call']/ul/li["+appLocation+"]/div/div[1]/a[1]/span";

		
		// Un install the app
	    UIToolFunctions.clickWebElement(driver, appNameRef);
	    Thread.sleep(Properties.timerDefault*5);
	    
	    //driver.switchTo().frame("confirm-modal");
	    UIToolFunctions.clickWebElement(driver, confirmDialogOk);
	    Thread.sleep(3000);
	        	
	}
	
	
	
	public static void clickOnTheGivenApp(WebDriver driver,String appName) throws InterruptedException
	{
			UIToolFunctions.clickWebElement(driver, allAppsLink);
			Thread.sleep(Properties.timerDefault*5);
			int appLocation = UIToolFunctions.getElementLocation(driver, ".//*[@id='call']/ul/li", appName);

			
			String appNameRef=".//*[@id='call']/ul/li["+appLocation+"]/div/div[1]/img";
			driver.findElement(By.xpath(appNameRef)).click();
			Thread.sleep(4000);
			System.out.println(driver.findElement(By.xpath(".//*[@id='results']/tbody/tr[1]/td[6]/span[2]")).getText());
					

	}
	
	
	public static boolean isAppInstalled(WebDriver driver,String appName) throws InterruptedException
	{
		UIToolFunctions.clickWebElement(driver, allAppsLink);
		Thread.sleep(Properties.timerDefault*5);
		int appLocation = UIToolFunctions.getElementLocation(driver, ".//*[@id='call']/ul/li", appName);

		if(appLocation != 0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
	}
	       
	
}