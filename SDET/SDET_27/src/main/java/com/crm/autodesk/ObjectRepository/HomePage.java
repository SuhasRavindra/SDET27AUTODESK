package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtility.WebDriverUtility;

public class HomePage  extends WebDriverUtility{//step1 ==>> create separate POM class

	
	//step 2 ==>> Identify all the elements in page using @FindBy and Declare as private
	@FindBy(linkText  = "Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationsLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement logoutLink;
	
	//step3 ==>> Provide the Initialization through constructor
		public HomePage (WebDriver driver) {
			PageFactory.initElements(driver, this);
		}


		//step4 ==> Utilize the WebElement using getters
		public WebElement getContactsLink() {
			return contactsLink;
		}
		
		public WebElement getOrganizationsLink() {
			return organizationsLink;
		}
		
		public WebElement getAdministratorImg() {
			return administratorImg;
		}


		public WebElement getLogoutLink() {
			return logoutLink;
		}

		
		//step5 ==>> Developing the Business Libraries
		
		

		public void clickContactsLink()
		{
			contactsLink.click();
		}
		
		public void clicOrganizationsLink()
		{
			organizationsLink.click();
		}

		public void clickSigout(WebDriver driver) {
			waitForElementToBeClickable(driver, administratorImg);
			mouseOverOnElement(driver, administratorImg);
			logoutLink.click();		
		}
		
}
