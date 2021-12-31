package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {//step1 ==>> create separate POM class

	
	//step 2 ==>> Identify all the elements in page using @FindBy and Declare as private
	@FindBy(className =  "dvHeaderText")
	private WebElement organizationCNFmsg;
	
	@FindBy(id = "dtlview_Type")
	private WebElement typeCNFmsg;
	
	@FindBy(id = "dtlview_Industry")
	private WebElement industryCNFmsg;
	
	@FindBy(id = "dtlview_Organization Name")
	private WebElement OrganizationNamemsg;
	
	
	//step3 ==>> Provide the Initialization through constructor
	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}



	//step4 ==> Utilize the WebElement using getters
	public WebElement getOrganizationCNFmsg() {
		return organizationCNFmsg;
	}
	
	public WebElement getTypeCNFmsg() {
		return typeCNFmsg;
	}
	
	public WebElement getIndustryCNFmsg() {
		return industryCNFmsg;
	}



	//step5 ==>> Developing the Business Libraries
	public String fetchConfirmationMessage()
	{
		String cnfMsg=organizationCNFmsg.getText();
		return cnfMsg;
	}
	
	public String fetchTypeName()
	{
		
		String type=typeCNFmsg.getText();
		return type;
	}
	
	public String fetchIndustryName()
	{
		String industry=industryCNFmsg.getText();
		return industry;
	}
	

}
