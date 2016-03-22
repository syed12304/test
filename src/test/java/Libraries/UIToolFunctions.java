package Libraries;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Objects.Properties;

public class UIToolFunctions {
	
	public static WebDriver initiateChromeBrowser() throws InterruptedException
	{
		System.setProperty(Properties.chromeDriver, Properties.chromeDriverLocation);
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	
	public static void launchURL(WebDriver driver, String URL) throws InterruptedException
	{
		driver.get(URL);
		maximizeBrowser(driver);
		Thread.sleep(Properties.timerDefault*2);
	}
	
	public static void maximizeBrowser(WebDriver driver) throws InterruptedException
	{
		driver.manage().window().maximize();
	}
	
	public static void closeBrowser(WebDriver driver) throws InterruptedException
	{
		driver.close();
	}
	
	public static void pressEnter(WebDriver driver, String webelementRef) throws InterruptedException
	{
		driver.findElement(By.xpath(webelementRef)).sendKeys(Keys.ENTER);
	}
	
	public static List<String> getElementsWithSameReference(WebDriver driver, String webelementRef)
	{
		List<WebElement> myList=driver.findElements(By.xpath(webelementRef));
	    List<String> all_elements_text=new ArrayList<>();

	    for(int i=0; i<myList.size(); i++){

	        //loading text of each element in to array all_elements_text
	        all_elements_text.add(myList.get(i).getText());

	        //to print directly
	        String appName = myList.get(i).getText();
	        System.out.println(appName);
	    }
	    
	    return all_elements_text;
	        
	}
	
	public static int getElementLocation(WebDriver driver, String webelementRef, String searchElement)
	{
		List<WebElement> myList=driver.findElements(By.xpath(webelementRef));
	    List<String> all_elements_text=new ArrayList<>();

	    for(int i=0; i<myList.size(); i++){

	        //loading text of each element in to array all_elements_text
	        all_elements_text.add(myList.get(i).getText());

	        //to print directly
	        String appName = myList.get(i).getText();
	        System.out.println(appName);
	        
	        if(appName.equals(searchElement))
	        	return i+1;
	    }	    
	 
		return 0;
	        
	}
	
	public static  void clickWebElement(WebDriver driver, String webelementRef)
	{
		driver.findElement(By.xpath(webelementRef)).click();
	}
	
	public static String getElementText(WebDriver driver, String webelementRef)
	{
		return driver.findElement(By.xpath(webelementRef)).getText();
	}
	
	public static void setElementText(WebDriver driver, String webelementRef, String text)
	{
		driver.findElement(By.xpath(webelementRef)).sendKeys(text);
	}
	
	public static String getElementAttributeValue(WebDriver driver, String webelementRef, String attribute)
	{
		return driver.findElement(By.xpath(webelementRef)).getAttribute(attribute).toString();
	}
	
	public static void clearElementText(WebDriver driver, String webelementRef)
	{
		driver.findElement(By.xpath(webelementRef)).clear();
	}
	
	public static boolean isElementSelected(WebDriver driver, String webelementRef)
	{
		return driver.findElement(By.xpath(webelementRef)).isSelected();
	}
	
	public static boolean isElementEnabled(WebDriver driver, String webelementRef)
	{
		return driver.findElement(By.xpath(webelementRef)).isEnabled();
	}
	
	public static boolean isElementVisible(WebDriver driver, String webelementRef)
	{
		return driver.findElement(By.xpath(webelementRef)).isDisplayed();
	}
	
	public static boolean doesPageContainsText(WebDriver driver, String text)
	{
		return driver.getPageSource().contains(text);
	}
	
	
	public static void dragAndDropElement(WebDriver driver, String source, String target) throws InterruptedException
	{
		 WebElement from = driver.findElement(By.xpath(source));
		    WebElement to = driver.findElement(By.xpath(target));
		    (new Actions(driver)).dragAndDrop(from, to).perform(); 
		    Thread.sleep(Properties.timerDefault*3);
		    
	}
	
	public static void selectElementFromDropDown(WebDriver driver,String webelementRef,String value)
	{
		Select dropDown = new Select(driver.findElement(By.xpath(webelementRef)));
		dropDown.selectByVisibleText(value);
	}

}
