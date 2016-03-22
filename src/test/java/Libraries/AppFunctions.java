package Libraries;

import static org.testng.AssertJUnit.assertTrue;
import org.openqa.selenium.WebDriver;

import Objects.PageObjects;
import Objects.Properties;

public class AppFunctions {

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
	static String reInstallStatusText = PageObjects.appControlObjects.reInstallStatusText.getObjectReference();
	static String confirmButtonInAppBuilder = PageObjects.appControlObjects.confirmButtonInAppBuilder.getObjectReference();
	static String appNameInBuilder = PageObjects.appControlObjects.appNameInBuilder.getObjectReference();
	static String installButtonInBuilder = PageObjects.appControlObjects.installButtonInBuilder.getObjectReference();
	static String upgradeConfirmationText = PageObjects.appControlObjects.upgradeConfirmationText.getObjectReference();
	static String confirmButtonInUpgradeDialogue = PageObjects.appControlObjects.confirmButtonInUpgradeDialogue.getObjectReference();
	static String edit = PageObjects.appControlObjects.edit.getObjectReference();
	static String version = PageObjects.appControlObjects.version.getObjectReference();
	static String closeInAppBuilder = PageObjects.appControlObjects.closeInAppBuilder.getObjectReference();
	
	public static void reInstallApp(WebDriver driver,String appName) throws InterruptedException
	{
		UIToolFunctions.clickWebElement(driver, allAppsLink);
		Thread.sleep(Properties.timerDefault*5);
		String pathToApp = EndToEndFlowFunctions.getAppLocation(appName);
		UIToolFunctions.setElementText(driver,installAnAppLink,pathToApp);
		Thread.sleep(Properties.timerDefault*5);
		assertTrue("message did not appear",UIToolFunctions.getElementText(driver,reInstallStatusText).equals("saradhi pie app is already installed, would you like to re-install it?"));
		Thread.sleep(Properties.timerDefault*5);
		UIToolFunctions.clickWebElement(driver, confirmButtonInAppBuilder);
	}
	
	public static void cloningApp(WebDriver driver,String appName) throws InterruptedException
	{
		Thread.sleep(Properties.timerDefault*5);
		UIToolFunctions.clickWebElement(driver, allAppsLink);
		Thread.sleep(Properties.timerDefault*5);
		
		int appLocation = UIToolFunctions.getElementLocation(driver, ".//*[@id='call']/ul/li", Properties.appName);
		String appNameRef = "//*[@id='call']/ul/li["+appLocation+"]/div/div[1]/a[2]";
		
	    UIToolFunctions.clickWebElement(driver, appNameRef);
	    Thread.sleep(Properties.timerDefault*5);
	    UIToolFunctions.clearElementText(driver, appNameInBuilder);
	    UIToolFunctions.setElementText(driver, appNameInBuilder,appName);
	    UIToolFunctions.clickWebElement(driver, installButtonInBuilder);
	    Thread.sleep(Properties.timerDefault*5);
	    UIToolFunctions.clickWebElement(driver, allAppsLink);
	    Thread.sleep(Properties.timerDefault*3);
	    assertTrue("App is not present", EndToEndFlowFunctions.isAppInstalled(driver, appName));
	        	
	}
	
	
	public static void upgradeApp(WebDriver driver,String appName) throws InterruptedException
	{
		UIToolFunctions.clickWebElement(driver, allAppsLink);
		Thread.sleep(Properties.timerDefault*5);
		String pathToApp = EndToEndFlowFunctions.getAppLocation(appName);
		UIToolFunctions.setElementText(driver,installAnAppLink,pathToApp);
		Thread.sleep(Properties.timerDefault*5);
		assertTrue("message did not appear", UIToolFunctions.getElementText(driver, upgradeConfirmationText).equals("An older version of Test App is installed (version 1.0), would you like to proceed and upgrade Test App to version 2.0?"));
		UIToolFunctions.clickWebElement(driver, confirmButtonInUpgradeDialogue);
		Thread.sleep(Properties.timerDefault*5);
		UIToolFunctions.clickWebElement(driver, edit);
		Thread.sleep(Properties.timerDefault*5);
		System.out.println(UIToolFunctions.getElementAttributeValue(driver, version, "value"));
		assertTrue("version number did not match", UIToolFunctions.getElementAttributeValue(driver, version, "value").equals("2.0"));
		UIToolFunctions.clickWebElement(driver, closeInAppBuilder);
	
	}
}
