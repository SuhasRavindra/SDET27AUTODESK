package com.crm.autodesk.contactsTest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.ContactsPage;
import com.crm.autodesk.ObjectRepository.CreateNewContactPage;
import com.crm.autodesk.ObjectRepository.CreateNewOrganizationPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.OraganizationPage;
import com.crm.autodesk.ObjectRepository.OrganizationInfoPage;
import com.crm.autodesk.genericUtility.BaseClass;

public class CreateContactswithOrganizationTest extends BaseClass{
	@Test(groups="regressionSuite")
	public void createContactswithOrganizationTest() throws Throwable {

		
		// get random Number
		int randomNumber = jLib.getRandomNum();

		// Fetch the data from Excel

		String testdata_org = eLib.getDataFromExcel("Sheet1", 1, 1) + randomNumber;
		String testdata_conctact = eLib.getDataFromExcel("Sheet1", 1, 2) + randomNumber;

		
		// Navigate to Organization Tab
		HomePage hp = new HomePage(driver);
		hp.clicOrganizationsLink();

		// click on Create Organization
		OraganizationPage op = new OraganizationPage(driver);
		op.clickCreateOrganizationLookupImg();

		// Enter the details and click on save
		CreateNewOrganizationPage cop = new CreateNewOrganizationPage(driver);
		cop.createOrganization(testdata_org);

		wLib.waitForElementToBeClickable(driver, driver.findElement(By.className("dvHeaderText")));
		// Navigate to Organization Tab
		hp.clickContactsLink();

		// click on Create Contacts
		ContactsPage cp = new ContactsPage(driver);
		cp.clickCreateContactLookupImg();
		// Enter the details and click on save

		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.createContactWithOrgName(testdata_conctact, testdata_org, driver);
		
		System.out.println(testdata_org + "==>> Expected Organization Name");

		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String actual_OrgName = oip.fetchConfirmationMessage();
		System.out.println(actual_OrgName + "==> actual Organization Name");

		// Verify the Confirmation Message
		if (actual_OrgName.trim().equals(testdata_org.trim())) {
			System.out.println(actual_OrgName + " is visible ==>> TEST CASE PASS");
		} else {
			System.out.println(actual_OrgName + " is not visible ==>> TEST CASE FAIL");
		}

	}
}
