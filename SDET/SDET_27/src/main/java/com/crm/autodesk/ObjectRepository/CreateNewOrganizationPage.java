package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtility.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility{
	//step1 ==>> create separate POM class

	
		//step 2 ==>> Identify all the elements in page using @FindBy and Declare as private
		@FindBy(name = "accountname")
		private WebElement orgNameEdt;
		
		@FindBy(xpath = "//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;
		
		@FindBy(xpath = "//input[@title='Cancel [Alt+X]']")
		private WebElement cancelBtn;
		
		@FindBy(name = "industry")
		private WebElement industryDropDown;
		
		@FindBy(name = "accounttype")
		private WebElement typeDropDown;
		
		
		//step3 ==>> Provide the Initialization through constructor
		public CreateNewOrganizationPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}


		
		//step4 ==> Utilize the WebElement using getters
		public WebElement getOrgNameEdt() {
			return orgNameEdt;
		}



		public WebElement getSaveBtn() {
			return saveBtn;
		}



		public WebElement getCancelBtn() {
			return cancelBtn;
		}



		public WebElement getIndustryDropDown() {
			return industryDropDown;
		}



		public WebElement getTypeDropDown() {
			return typeDropDown;
		}

		
		
		//step5 ==>> Developing the Business Libraries
		
		public void createOrganization(String orgName) {
			orgNameEdt.sendKeys(orgName);
			saveBtn.click();
		}
		
		public void createOrganizationWithIndustryAndType(String orgName, String industry, String type) {
			orgNameEdt.sendKeys(orgName);
			select(industryDropDown, industry);
			select(typeDropDown, type);			
			saveBtn.click();
		}
		

}
