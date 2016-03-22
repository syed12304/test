package TestScripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Libraries.AppFunctions;
import Libraries.EndToEndFlowFunctions;
import Libraries.FormLogin;
import Libraries.UIToolFunctions;
import Objects.Properties;

public class HomePageTests {

	static WebDriver browser;
	static String appName = Properties.appName;
	@BeforeTest
	public void initiateBrowser() throws Exception 
	{
		browser = UIToolFunctions.initiateChromeBrowser();
		UIToolFunctions.launchURL(browser, Properties.URL);
		FormLogin.userLogin(browser, "login with admin");

	}
	
	
	
	@Test(enabled=true)
	/*2008 App installing Test Case
	 * @author rs186098 Ramakrishna Saradhi
	 */
	public void _2008_AppInstall() throws InterruptedException
	{
		EndToEndFlowFunctions.installApp(browser, appName);
	}
	
	
	
	@Test (dependsOnMethods={"_2008_AppInstall"},enabled=true)
	/*2008 App Wiring Test Case
	 * @author rs186098 Ramakrishna Saradhi
	 */
	public void _2008_AppWiring() throws InterruptedException
	{
		EndToEndFlowFunctions.configureApp(browser);
	}
	
	
	
	
	
	@Test (dependsOnMethods={"_2008_AppWiring"},enabled=true)
	/*2008 Running a job 
	 * @author rs186098 Ramakrishna Saradhi
	 */
	public void _2008_RunningAJobInApp() throws InterruptedException
	{
		EndToEndFlowFunctions.runJob(browser);
		EndToEndFlowFunctions.checkForJobCompletion(browser);
	}
	
	
	
	@Test (dependsOnMethods={"_2008_RunningAJobInApp"},enabled=true)
	/*2008 Uninstallling the App a job 
	 * @author rs186098 Ramakrishna Saradhi
	 */
	public void _2008_ReinstallingTheApp() throws InterruptedException
	{
		AppFunctions.reInstallApp(browser, appName);
		
	}
	
	

	@Test (dependsOnMethods={"_2008_ReinstallingTheApp"},enabled=true)
	/*2008 Uninstallling the App a job 
	 * @author rs186098 Ramakrishna Saradhi
	 */
	public void _2008_CloningTheApp() throws InterruptedException
	{
		AppFunctions.cloningApp(browser, Properties.cloneAppName);
		
	}
	
	
	@Test (dependsOnMethods={"_2008_CloningTheApp"},enabled=true)
	public void _2008_UpgradeAppTest() throws InterruptedException
	{
		EndToEndFlowFunctions.installApp(browser, Properties.upgradeAppV1_0);
		AppFunctions.upgradeApp(browser, Properties.upgradeAppV2_0);
		
	}
	
	//@Test (dependsOnMethods={"_2008_UpgradeAppTest"})
	/**
	* <table border="1px">
	* <tr><td><p><b>Description  </b></td> <td> Uninstalling the App.</td></tr>
	* <tr><td><p><b>Author  </b></td> <td>RS186098 </td></tr>
	* <tr><td><p><b>Creation Date  </b></td> <td>23/02/2016 </td></tr>
	* <tr><td colnum="2"><p><b>Input Parameters     </b></td> <td></tr>
	* <tr><td><p><b>driver   </b></td> <td>Specifies browser reference </td></tr>
	* <tr><td><p><b>collectionName  </b></td> <td> Specifies the name of the collection to verify in AppCenter </td></tr></table> 
	* @throws Exception
	*/
	
	public void _2008_UninstallingTheApp() throws InterruptedException
	{
		//EndToEndFlowFunctions.uninstallApp(browser, appName);
		//EndToEndFlowFunctions.uninstallApp(browser, Properties.cloneAppName);
		EndToEndFlowFunctions.uninstallApp(browser, "Test App");
		
	}
	
	
	
	
	@AfterTest
	public void closeBrowser() throws InterruptedException 
	{
		browser.close();
	}
	
	

}
