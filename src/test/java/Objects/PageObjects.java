package Objects;

public  class PageObjects {

 
	 public static enum loginObjects{

		userName("//*[@id='inputUsername']"),
		password("//*[@id='inputPassword']"),
		submit("//button[text()='Login']"),
		support("//a[text()='Support']"),
		teradata("//a[text()='Teradata Aster']"),
		loginForm("//form[@id='auth-form']/div"),
		message("//*[@id='inputPassword']");

		 loginObjects(String reference){
			    this.reference = reference;
			  }

			  private String reference;

			  public String getObjectReference(){
			    return this.reference;
			  }			  
			  
			}
	 
	 
	 public static enum collectionObjects{
		 
		 createCollectionButton("//button[text()='Create Collection']"),
		 createCollectionText("//input[@class='form-control name-input']"),
		 delete("//a[contains(text(),'delete')]"),
		 ok("//input[@value='Ok']"),
		edit("//a[contains(text(),'edit')]");
		

		 collectionObjects(String reference){
				    this.reference = reference;
				  }

				  private String reference;

				  public String getObjectReference(){
				    return this.reference;
				  }

	 }
	 
	 public static enum authenticationObjects{
		 
		 password("//input[@name='password']"),
		 confirmPassword("//input[@name='confirmPassword']"),
		 save("//button[@type='submit']"),
		 authenticationTab("//a[text()='Authentication']"),
		 
		 // LDAP Objects
		 modeLDAP("//input[@name='mode-ldap']"),
		 ldapServerURL("//input[@name='ldapServerURL']"),
		 baseDN("//input[@name='ldapServerRootDn']"),
		 ldapAdminUser("//input[@name='ldapAdminUserDn']"),
		 ldapAdminPwd("//input[@name='ldapAdminPwd']"),
		 testLDAP("//button[(text()='Test') and (@data-group='ldap')]"),
		 saveLDAP("//button[(text()='Save') and (@data-group='ldap')]"),
		 cancelLDAP("//button[(text()='Cancel') and (@data-group='ldap')]"),
		 
		 // DB Objects
		 modeAsterDB("//input[@name='mode-db']"),
		 shareApp("//input[@name='can-share']"),
		 asterIp("//input[@name='asterIp']"),
		 asterDBName("//input[@name='asterDb']"),
		 asterUserName("//input[@name='asterUserName']"),
		 asterPassword("//input[@name='asterPassword']"),
		 testDB("//button[(text()='Test') and (@data-group='asterDb')]"),
		 saveDB("//button[(text()='Save') and (@data-group='asterDb')]"),
		 canceDB("//button[(text()='Cancel') and (@data-group='asterDb')]");
		
	
		 authenticationObjects(String reference){
					    this.reference = reference;
					  }

		private String reference;

		public String getObjectReference(){
			  	return this.reference;
				  }

	 }
	 
	 public enum appControlObjects
	 {
		 configureButton("//span[@class='glyphicon glyphicon-cog']"),
		 title("//input[@placeholder='Enter report title']"),
		 tag("//input[@placeholder='Separate tags with space']"),
		 runButton("//button[text()='Run']"),
		 globe(".//*[@id='results']/tbody/tr[1]/td[8]/a[3]/span"),
		 firstResultId(".//*[@id='results']/tbody/tr[1]/td[9]"),
		 firstResultStatus(".//*[@id='results']/tbody/tr[1]/td[6]/span[2]"),
		 reInstallStatusText("//*[@id='system']/div/div/div/div/div[2]/p"),
		 confirmButtonInAppBuilder("//input[@value='Confirm']"),
		 appNameInBuilder("//input[@name='meta.name']"),
		 installButtonInBuilder("//button[text()='Install']"),
		 upgradeConfirmationText("//div[@class='modal-body']/p"),
		 confirmButtonInUpgradeDialogue("//input[@value='Confirm']"),
		 edit("//a[@data-original-title='Edit']"),
		 version("//input[@name='meta.version']"),
		 closeInAppBuilder("//button[@title='Close builder']");
		 
		 					
		 
		 appControlObjects(String reference) {
				this.reference = reference;
			}
			 
		 private String reference;
		 public String getObjectReference()
		 {
			 return this.reference;
		 }
		
		 
	 }

	 public enum resultSharingObjects
	 {
		 enablePublishingCheckBox("//input[@type='checkbox']"),
		 link("//a[contains(text(),'viz/platform')]");
		
		 resultSharingObjects(String reference) {
				this.reference = reference;
			}
			 
		 private String reference;
		 public String getObjectReference()
		 {
			 return this.reference;
		 }
		
	 }


	 public enum allReportsTableObjects
	 {
		 app(".//*[@id='results_wrapper']/div[2]/div[1]/div/table/thead/tr[1]/th[1]"),
		 viz(".//*[@id='results_wrapper']/div[2]/div[1]/div/table/thead/tr[1]/th[2]"),
		 title(".//*[@id='results_wrapper']/div[2]/div[1]/div/table/thead/tr[1]/th[3]"),
		 subtitle(".//*[@id='results_wrapper']/div[2]/div[1]/div/table/thead/tr[1]/th[4]"),
		 tags(".//*[@id='results_wrapper']/div[2]/div[1]/div/table/thead/tr[1]/th[5]"),
		 owner(".//*[@id='results_wrapper']/div[2]/div[1]/div/table/thead/tr[1]/th[6]"),
		 created(".//*[@id='results_wrapper']/div[2]/div[1]/div/table/thead/tr[1]/th[7]"),
		 glyphiconUser(".//*[@id='results_wrapper']/div[2]/div[1]/div/table/thead/tr[1]/th[9]"),
		 glyphiconStar(".//*[@id='results_wrapper']/div[2]/div[1]/div/table/thead/tr[1]/th[10]"),
		 glyphiconFlag(".//*[@id='results_wrapper']/div[2]/div[1]/div/table/thead/tr[1]/th[11]"),
		 id(".//*[@id='results_wrapper']/div[2]/div[1]/div/table/thead/tr[1]/th[12]");
		 
		 allReportsTableObjects(String reference) {
				this.reference = reference;
			}
			 
		 private String reference;
		 public String getObjectReference()
		 {
			 return this.reference;
		 }
		
	 }

	 
	 

	public enum homeScreenObjects{
		
		allApps("//a[text()='All Apps']"),
		installAnApp("//input[@name='files[]']"),
		logout("//a[@data-original-title='Logout']"),
		settings("//a[@data-original-title='Settings']"),
		confirmDialogOk("//input[@type='submit']"),
		allReports("//a[text()='All Reports']"),
		listView("//button[text()='List']");

		homeScreenObjects(String reference) {
		this.reference = reference;
		}

		private String reference;
		public String getObjectReference()
		{
		return this.reference;
		}

	}
	
 public enum configureDialogueObjects{
		 
		 connectionProfileDropDown("//select[@name='connectionProfile.id']"), 
		 publishingTab("//a[@data-type='publish']"),
		 enableSharingCheckBox("//input[@class='allowPublish']"),
		 close("//button[@aria-hidden='true']"),
		 saveButton("//button[@data-loading-text='Saving...']");
		
		 

		 configureDialogueObjects(String reference){
		    this.reference = reference;
		  }

		  private String reference;

		  public String getObjectReference(){
		    return this.reference;
		  }
		}
	 
	 
	 public enum visualizationControlObjects
	 {
		 globe("//*[@id='btn-publish']"),
		 tags("//*[@id='btn-tags']"),
		 save("//*[@id='btn-save']"),
		 saveAs("//*[@id='btn-save-as']"),
		 favorite("//*[@id='btn-favorite']"),
		 flag("//*[@id='btn-flag']"),
		 download("//*[@id='download-btn']"),
		 showParameters(".//*[@id='toggle-params-btn']"),
		 share("//*[@id='btn-share']");
		 
		 visualizationControlObjects(String reference){
			    this.reference = reference;
			  }

			  private String reference;

			  public String getObjectReference(){
			    return this.reference;
			  }
	 }
	 
	 
	 public enum pieVisualizationObjects
	 {
		 
		 pie("//*[@id='svgChart']");
		 
		 pieVisualizationObjects(String reference){
			    this.reference = reference;
			  }

			  private String reference;

			  public String getObjectReference(){
			    return this.reference;
			  }
	 }
}
