package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OraganizationPage {
	//step1 ==>> create separate POM class

	
		//step 2 ==>> Identify all the elements in page using @FindBy and Declare as private
		@FindBy(xpath = "//img[@alt='Create Organization...']")
		private WebElement createOrganizationLookupImg;
		
		
		
		//step3 ==>> Provide the Initialization through constructor
		public OraganizationPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}



		//step4 ==> Utilize the WebElement using getters
		public WebElement getCreateOrganizationLookupImg() {
			return createOrganizationLookupImg;
		}

		
		
		
		//step5 ==>> Developing the Business Libraries
		
		public void clickCreateOrganizationLookupImg()
		{
			createOrganizationLookupImg.click();
		}
		
}
