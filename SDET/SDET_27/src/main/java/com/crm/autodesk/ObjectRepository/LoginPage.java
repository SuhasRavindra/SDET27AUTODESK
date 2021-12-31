package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { //step1 ==>> create separate POM class for LoginPage

	
	//step 2 ==>> Identify all the elements in page using @FindBy and Declare as private
	@FindBy(name = "user_name")
	private WebElement userNameEdt;
	
	@FindBy(name = "user_password")
	private WebElement passwordEdt;
	
	@FindBy(id = "submitButton")
	private WebElement loginBtn;
	
	
	//step3 ==>> Provide the Initialization through constructor
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//step4 ==> Utilize the WebElement using getters
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
	//step5 ==>> Developing the Business Libraries
	
	public void clickLogin(String userName, String password)
	{
		userNameEdt.sendKeys(userName);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	
	
	
	
	
	
	
}
