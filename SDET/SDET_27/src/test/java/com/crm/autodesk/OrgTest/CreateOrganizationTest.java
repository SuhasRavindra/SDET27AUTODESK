package com.crm.autodesk.OrgTest;

import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.CreateNewOrganizationPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.OraganizationPage;
import com.crm.autodesk.ObjectRepository.OrganizationInfoPage;
import com.crm.autodesk.genericUtility.BaseClass;


public class CreateOrganizationTest extends BaseClass {
	@Test(groups="smokeSuite")
	public void createOrganizationTest() throws Throwable {

		//get random Number
		int randomNumber = jLib.getRandomNum();


		//Fetch the data from Properties

		String testdata = eLib.getDataFromExcel("Sheet1", 1, 1)+randomNumber;


		//Navigate to Organization Tab
		HomePage hp=new HomePage(driver);
		hp.clicOrganizationsLink();

		//click on Create Organization
		OraganizationPage op=new OraganizationPage(driver);
		op.clickCreateOrganizationLookupImg();

		//Enter the details and click on save
		CreateNewOrganizationPage cop=new CreateNewOrganizationPage(driver);
		cop.createOrganization(testdata);


		//Get the Confirmation Message
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String confirmation_message=oip.fetchConfirmationMessage();



		//Verify the Confirmation Message
		if(confirmation_message.contains(testdata))
		{
			System.out.println("Organization Created ==>> TEST CASE PASS");
		}
		else
		{
			System.out.println("TEST CASE FAIL");
		}

	}

}
