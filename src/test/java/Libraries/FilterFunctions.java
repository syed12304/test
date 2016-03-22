package Libraries;

import org.openqa.selenium.WebDriver;

import Objects.PageObjects;
import Objects.Properties;

public class FilterFunctions {
	
	static String allReportsLink = PageObjects.homeScreenObjects.allReports.getObjectReference();
	static String listView = PageObjects.homeScreenObjects.listView.getObjectReference();
	public static String[][] tableLocationRefs = new String[25][4];
	
	
	public String[] getTableLocationRefs(String colName)
	{
		int i;
		tableLocationRefs[1][1] = "App";
		tableLocationRefs[1][2] = ".//*[@id='results_wrapper']/div[2]/div[1]/div/table/thead/tr[1]/th[1]";
		for(i=1;i<=25;i++)
		{
			if(tableLocationRefs[i][1] == colName)
				return tableLocationRefs[i];
		}
		
		return null;		
		
	}
	
	public static void checkForAscInFilter(WebDriver driver,String colRef) throws InterruptedException
	{
		int i=1;
		String[] values = new String[25];
		UIToolFunctions.clickWebElement(driver, allReportsLink);
		Thread.sleep(Properties.timerDefault * 5);
		UIToolFunctions.clickWebElement(driver, listView);
		Thread.sleep(Properties.timerDefault * 5);
		UIToolFunctions.clickWebElement(driver, colRef);
		Thread.sleep(Properties.timerDefault * 10);
		for(i=1;i<=25;i++)
		{
			//values[i] = UIToolFunctions.getElementText(driver, webelementRef)
		}
		
	}
}
