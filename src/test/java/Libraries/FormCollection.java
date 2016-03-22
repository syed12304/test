package Libraries;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Objects.PageObjects;
import Objects.Properties;


public class FormCollection {
	
	static String createCollectionButton = PageObjects.collectionObjects.createCollectionButton.getObjectReference();
	static String createCollectionText = PageObjects.collectionObjects.createCollectionText.getObjectReference();
	static String allApps = PageObjects.homeScreenObjects.allApps.getObjectReference();
	static String delete = PageObjects.collectionObjects.delete.getObjectReference();
	static String ok = PageObjects.collectionObjects.ok.getObjectReference();
	
	// Collection form object references
	static String collectionGridListRef = "//*[@id='apps-grid']/div[2]/div/div";
	static String collectionGridListIndexRef = "//*[@id='apps-grid']/div[2]/div/div[";
	static String collectionGridTextRef = "]/section/div[1]/h3";
	static String collectionGridIDRef= "]/section/div[2]";
	static String appLocationRef=".//*[@id='call']/ul/li";
	static String sideBarRef="//*[@id='sidebar-apps']/li[";
	static String deleteRef="]/span[2]/a[2]";
	
	/**
	 * <p><b>Description : </b> This library creates a collection in the configured AppCenter instance.
	 * <p><b>Author : </b> SJ186053
	 * <p><b>Creation Date : </b> 23/02/2016
	 * <p><h5>Input Parameters :</h5> 
	 * <p><b>driver - </b> Specifies browser reference
	 * <p><b>collectionName - </b> Specifies the name of the collection to be created in AppCenter
	 * @throws Exception
	 */
	public static void createCollection(WebDriver driver, String collectionName) throws Exception
	{
		UIToolFunctions.clickWebElement(driver, allApps);
		Thread.sleep(Properties.timerDefault*2);
		
		UIToolFunctions.clickWebElement(driver, createCollectionButton);
		UIToolFunctions.setElementText(driver, createCollectionText,collectionName);
		UIToolFunctions.pressEnter(driver, createCollectionText);		
		Thread.sleep(Properties.timerDefault*3);		
	}	
	

	/**
	 * <table border="1px">
	 * <tr><td><p><b>Description  </b></td> <td> This library validates whether or not the provided collection exists in AppCenter instance.</td></tr>
	 * <tr><td><p><b>Author  </b></td> <td>SJ186053 </td></tr>
	 * <tr><td><p><b>Creation Date  </b></td> <td>23/02/2016 </td></tr>
	 * <tr><td colnum="2"><p><b>Input Parameters     </b></td> <td></tr>
	 * <tr><td><p><b>driver   </b></td> <td>Specifies browser reference </td></tr>
	 * <tr><td><p><b>collectionName  </b></td> <td> Specifies the name of the collection to verify in AppCenter </td></tr></table> 
	 * @throws Exception
	 */
	public static boolean collectionExists(WebDriver driver, String collectionName) throws Exception
	{
		return UIToolFunctions.isElementVisible(driver, "//a[text()='"+collectionName+"']");
	}
	
	/**
	 * <table border="1px">
	 * <tr><td><p><b>Description  </b></td> <td> This library deletes the collection.</td></tr>
	 * <tr><td><p><b>Author  </b></td> <td>SJ186053 </td></tr>
	 * <tr><td><p><b>Creation Date  </b></td> <td>25/02/2016 </td></tr>
	 * <tr><td colnum="2"><p><b>Input Parameters     </b></td> <td></tr>
	 * <tr><td><p><b>driver   </b></td> <td>Specifies browser reference </td></tr>
	 * <tr><td><p><b>collectionName  </b></td> <td> Specifies the name of the collection to delete in AppCenter </td></tr></table> 
	 * @throws Exception
	 */	
	public static void deleteCollection(WebDriver driver, String collectionName) throws Exception
	{
		//Collect all the collections
		List<WebElement> elements = driver.findElements(By.xpath(collectionGridListRef));
		
		System.out.println(elements.size());
		
		// Iterate through collections
		for(int i =1; i<=elements.size();i++)
		{
			int index=i-1;
			int deleteIndex=i+4;
			
			// Collect the collection reference 
			String collection = UIToolFunctions.getElementText(driver, collectionGridListIndexRef+i+collectionGridTextRef);
			System.out.println(collection);
			if(collection.equals(collectionName)){
				
				// Java script code to enable the delete button
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("(document.getElementsByClassName('hover'))["+index+"].setAttribute('style', 'display:inline;')");
				System.out.println("Element enabled");
				
				// Click on enabled Delete button and click on OK button to delete the collection 
				UIToolFunctions.clickWebElement(driver, sideBarRef+deleteIndex+deleteRef);
				Thread.sleep(Properties.timerDefault*3);
			    UIToolFunctions.clickWebElement(driver, ok);
			    Thread.sleep(Properties.timerDefault*5);
			    return;
				
			}
				
		}	
		
		Thread.sleep(Properties.timerDefault*3);
	}	
	
	/**
	 * <table border="1px">
	 * <tr><td><p><b>Description  </b></td> <td> This library identifies the collection reference to perform any action like update, delete etc. </td></tr>
	 * <tr><td><p><b>Author  </b></td> <td>SJ186053 </td></tr>
	 * <tr><td><p><b>Creation Date  </b></td> <td>25/02/2016 </td></tr>
	 * <tr><td colnum="2"><p><b>Input Parameters     </b></td> <td></tr>
	 * <tr><td><p><b>driver   </b></td> <td>Specifies browser reference </td></tr>
	 * <tr><td><p><b>collectionName  </b></td> <td> Specifies the name of the collection to retrieve the reference </td></tr></table> 
	 * @throws Exception
	 */
	
	public static String getCollectionReference(WebDriver driver, String collectionName)
	{
		String id="";
		List<WebElement> elements = driver.findElements(By.xpath(collectionGridListRef));
		
		System.out.println(elements.size());
		
		for(int i =1; i<=elements.size();i++)
		{
			String collection = UIToolFunctions.getElementText(driver, collectionGridListIndexRef+i+collectionGridTextRef);
			if(collection.equals(collectionName))
				id = UIToolFunctions.getElementAttributeValue(driver, collectionGridListIndexRef+i+collectionGridIDRef, "id");
		}
		
		String collectionID=  "//*[@id='"+id+"']/ul";
	    System.out.println(collectionID);
	    return collectionID;
	}
	
	/**
	 * <table border="1px">
	 * <tr><td><p><b>Description  </b></td> <td> This library identifies the app reference to perform any action like install, move to collection etc. </td></tr>
	 * <tr><td><p><b>Author  </b></td> <td>SJ186053 </td></tr>
	 * <tr><td><p><b>Creation Date  </b></td> <td>25/02/2016 </td></tr>
	 * <tr><td colnum="2"><p><b>Input Parameters     </b></td> <td></tr>
	 * <tr><td><p><b>driver   </b></td> <td>Specifies browser reference </td></tr>
	 * <tr><td><p><b>appName  </b></td> <td> Specifies the name of the app to retrieve the reference </td></tr></table> 
	 * @throws Exception
	 */
	public static String getAppReference(WebDriver driver, String appName)
	{
		int appLocation = UIToolFunctions.getElementLocation(driver, appLocationRef, appName);
		System.out.println(appLocation);
		return appLocationRef+"["+appLocation+"]";		
	}
	
	/**
	 * <table border="1px">
	 * <tr><td><p><b>Description  </b></td> <td> This library drags the application from All Apps to provided collection </td></tr>
	 * <tr><td><p><b>Author  </b></td> <td>SJ186053 </td></tr>
	 * <tr><td><p><b>Creation Date  </b></td> <td>25/02/2016 </td></tr>
	 * <tr><td colnum="2"><p><b>Input Parameters     </b></td> <td></tr>
	 * <tr><td><p><b>driver   </b></td> <td>Specifies browser reference </td></tr>
	 * <tr><td><p><b>appName  </b></td> <td> Specifies the name of the app to move</td></tr></table>
	 * <tr><td><p><b>collectionName  </b></td> <td> Specifies the name of the collection to which app should move</td></tr></table> 
	 * @throws Exception
	 */
	public static void moveAppToCollection(WebDriver driver, String appName, String collectionName) throws Exception
	{
		String appRef = getAppReference(driver, appName);
		System.out.println(appRef);
		String collectionRef = getCollectionReference(driver, collectionName);
		System.out.println(collectionRef);
		
		UIToolFunctions.dragAndDropElement(driver, appRef, collectionRef);
	}

}		
	

