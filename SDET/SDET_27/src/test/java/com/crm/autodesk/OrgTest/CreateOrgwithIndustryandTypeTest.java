package com.crm.autodesk.OrgTest;

import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.CreateNewOrganizationPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.OraganizationPage;
import com.crm.autodesk.ObjectRepository.OrganizationInfoPage;
import com.crm.autodesk.genericUtility.BaseClass;


public class CreateOrgwithIndustryandTypeTest extends BaseClass{
	
	@Test(groups="regressionSuite")
	public void createOrgwithIndustryandTypeTest() throws Throwable {


		//get random Number
		int randomNumber = jLib.getRandomNum();


		
		String orgName = eLib.getDataFromExcel("Sheet1", 4, 1)+randomNumber;
		String industry = eLib.getDataFromExcel("Sheet1", 4, 2);
		String type =eLib.getDataFromExcel("Sheet1", 4, 3);


		//Navigate to Organization Tab
		HomePage hp=new HomePage(driver);
		hp.clicOrganizationsLink();

		//click on Create Organization
		OraganizationPage op=new OraganizationPage(driver);
		op.clickCreateOrganizationLookupImg();
		
		
		//Enter the details and click on save
		CreateNewOrganizationPage cop=new CreateNewOrganizationPage(driver);
		cop.createOrganizationWithIndustryAndType(orgName, industry, type);


		//Get the Confirmation Message
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String confirmation_message=oip.fetchConfirmationMessage();
		System.out.println("Confirmataion Message====>> "+confirmation_message);
		
		//Verify the Confirmation Message
		if(confirmation_message.contains(orgName))
		{
			System.out.println("Organization Created ==>> TEST CASE PASS");
		}
		else
		{
			System.out.println("TEST CASE FAIL");
		}		//verify AccountType
		String Account_type=oip.fetchTypeName();
		System.out.println("Account Type ====>> "+Account_type);

		if(Account_type.equals(type))
		{
			System.out.println(type+" is displayed ==>> TEST CASE PASS");
		}
		else
		{
			System.out.println(type+ " is not displayed ===>> TEST CASE FAIL");
		}


		//Verify Industry

		String Account_industy=oip.fetchIndustryName();
		System.out.println("Account_industy ====>> "+Account_industy);


		if(Account_industy.equals(industry))
		{
			System.out.println(industry+" is displayed ==>> TEST CASE PASS");
		}
		else
		{
			System.out.println(industry+ " is not displayed ===>> TEST CASE FAIL");
		}		
	}

}
