package Day_1_practice;

import java.awt.event.InvocationEvent;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	
	@DataProvider
	public Object[] [] getData(){
		Object[][] objArr=new Object[4][2];
		objArr[0][0]="Iphone";
		objArr[0][1]=5;
		
		objArr[1][0]="Samsung";
		objArr[1][1]=10;
		
		objArr[2][0]="Motorola";
		objArr[2][1]= 20;
		
		objArr[3][0]="Vivo";
		objArr[3][1]= 22;
		
		return objArr;	
	}
	
	
	@Test(dataProvider = "getData")
	public void readDataFromDataProviderTest(String MobileNumber, int quantity)
	{
		System.out.println("Mobile Name =====>>> "+MobileNumber +" Quantity =====>>> "+ quantity);
	}

	@Test(priority = -1, invocationCount = 3, dependsOnMethods = "readDataFromDataProviderTest")
	public void test1()
	{
		System.out.println("TestCase1 Pass");
	}


	@Test(priority = -2, enabled = false)
	public void test2()
	{
		System.out.println("TestCase2 Pass");
	}

	@Test(priority = 0)
	public void test3()
	{
		System.out.println("TestCase3 Pass");
	}

	@Test(priority = 1)
	public void test4()
	{
		System.out.println("TestCase4 Pass");
	}

}
