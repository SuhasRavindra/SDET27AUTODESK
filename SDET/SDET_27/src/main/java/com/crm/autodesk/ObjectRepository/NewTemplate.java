package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericUtility.WebDriverUtility;

public class NewTemplate extends WebDriverUtility{//step1 ==>> create separate POM class

	
	//step 2 ==>> Identify all the elements in page using @FindBy and Declare as private
	@FindBy(xpath="//input[@type='file']")
	private WebElement uploadTemplateFile;
	
	@FindBy(name="target_module")
	private WebElement moduleDropDown;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement saveBtn;
	
	
	
	//step3 ==>> Provide the Initialization through constructor
	public NewTemplate(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	

	//step4 ==> Utilize the WebElement using getters

	public WebElement getUploadTemplateFile() {
		return uploadTemplateFile;
	}



	public WebElement getModuleDropDown() {
		return moduleDropDown;
	}



	public WebElement getSaveBtn() {
		return saveBtn;
	}

	
	
	//step5 ==>> Developing the Business Libraries
	
	public void uploadTemplateFile(String path_testdoc, String moduleName) {
		uploadTemplateFile.sendKeys(path_testdoc);
		select(moduleDropDown, moduleName);
		saveBtn.click();
	}
	

}
