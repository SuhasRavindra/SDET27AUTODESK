package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {//step1 ==>> create separate POM class

	
	//step 2 ==>> Identify all the elements in page using @FindBy and Declare as private
	@FindBy(className  = "dvHeaderText")
	private WebElement contactCNFmsg;
	
	
	
	
	//step3 ==>> Provide the Initialization through constructor
	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}



	//step4 ==> Utilize the WebElement using getters
	public WebElement getContactCNFmsg() {
		return contactCNFmsg;
	}

	
	
	
	//step5 ==>> Developing the Business Libraries
	public String fetchConfirmationMessage()
	{
		return(contactCNFmsg.getText());
	}

}
