package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage { //step1 ==>> create separate POM class 


	//step 2 ==>> Identify all the elements in page using @FindBy and Declare as private
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createContactLookupImg;

	@FindBy(xpath = "//a[.='Create Mail Merge templates ']")
	private WebElement createMailMergeTemplatesLink;



	//step3 ==>> Provide the Initialization through constructor
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}





	//step4 ==> Utilize the WebElement using getters
	public WebElement getCreateContactLookupImg() {
		return createContactLookupImg;
	}


	public WebElement getCreateMailMergeTemplatesLink() {
		return createMailMergeTemplatesLink;
	}





	//step5 ==>> Developing the Business Libraries
	public void clickCreateContactLookupImg()
	{
		createContactLookupImg.click();
	}

	public void clickCreateMailMergeTemplatesLink()
	{
		createMailMergeTemplatesLink.click();
	}



}
