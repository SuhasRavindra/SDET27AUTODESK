package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtility.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility{//step1 ==>> create separate POM class

	
	//step 2 ==>> Identify all the elements in page using @FindBy and Declare as private
	@FindBy(name = "lastname")
	private WebElement lastnameEdt;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement orgNameLookUpImg;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement contactSaveBtn;
	
	@FindBy(xpath = "//input[@title='Cancel [Alt+X]']")
	private WebElement contactCancelBtn;
	
	@FindBy(name = "search_text")
	private WebElement orgSearchdEdt;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	
	
	
	//step3 ==>> Provide the Initialization through constructor
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	//step4 ==> Utilize the WebElement using getters

	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}


	public WebElement getOrgNameLookUpImg() {
		return orgNameLookUpImg;
	}


	public WebElement getContactSaveBtn() {
		return contactSaveBtn;
	}
	
	public WebElement getContactCancelBtn() {
		return contactCancelBtn;
	}
	
	public WebElement getOrgSearchdEdt() {
		return orgSearchdEdt;
	}


	public WebElement getSearchBtn() {
		return searchBtn;
	}



	//step5 ==>> Developing the Business Libraries
	public void createContact(String lastname) {
		lastnameEdt.sendKeys(lastname);
		contactSaveBtn.click();
	}
	
	public void clickCancelContact(String lastname) {
		lastnameEdt.sendKeys(lastname);
		contactCancelBtn.click();
	}
	
	public void createContactWithOrgName(String lastname,String orgName, WebDriver driver) {
		lastnameEdt.sendKeys(lastname);
		orgNameLookUpImg.click();
		swithToWindow(driver, "Accounts");
		orgSearchdEdt.sendKeys(orgName);
		searchBtn.click();
       driver.findElement(By.linkText(orgName)).click();
		swithToWindow(driver, "Contacts");
		contactSaveBtn.click();
		
	}
	
	

}
