package com.crm.autodesk.contactsTest;

import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.ContactsPage;
import com.crm.autodesk.ObjectRepository.CreateNewContactPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.genericUtility.BaseClass;

public class CancelButtonsEnableOrNot extends BaseClass{

	@Test(groups="regressionSuite")
	public void cancelButtonsEnabledOrNotTest() throws Throwable {



		//Get the test data from Excel file
		String lastname = eLib.getDataFromExcel("Sheet1", 7, 1);


		//Step3 ==>> Place the mouse cursor and click on "Contact" Link
		HomePage hp=new HomePage(driver);
		hp.clickContactsLink();


		//Step4 ==>> navigate to "create new Contact"page by click on "+" image
		ContactsPage cp=new ContactsPage(driver);
		cp.clickCreateContactLookupImg();

		//Step5 ==>> Create a contact with all mandatory fields and click on cancel
		CreateNewContactPage ccp=new CreateNewContactPage(driver);
		ccp.clickCancelContact(lastname);


		if (driver.getTitle().contains("Contacts"))
		{
			System.out.println("TC PASS");
		}
		else {
			System.out.println("TC FAIL");
		}


	}

}
