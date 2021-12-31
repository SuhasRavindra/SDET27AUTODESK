package com.crm.autodesk.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;

public class BaseClass {

	public WebDriver driver;
	public ExcelUtility eLib=new ExcelUtility();
	public FileUtility fLib=new FileUtility();
	public JavaUtility jLib= new JavaUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public DataBaseUtility dbLib=new DataBaseUtility();
	
	
	@BeforeSuite
	public void openDataBaseConnection() throws Throwable {
		//read the Data
		String DBUrl=fLib.getPropertyKeyValue("dbUrl");
		String DBName=fLib.getPropertyKeyValue("dbName");
		String DBUserName=fLib.getPropertyKeyValue("DBUserName");
		String DBPassword=fLib.getPropertyKeyValue("DBPassword");
		
		dbLib.getDBConnection(DBUrl,DBName,DBUserName,DBPassword);
		System.out.println("=====DataBase Connection Estrablished======");
	}
	
	@BeforeClass
	public void launchBrowser() throws Throwable {
		// read the Data
		String browser=fLib.getPropertyKeyValue("browser");
		String url=fLib.getPropertyKeyValue("url");
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid Browser");
		}
		wLib.waitForPageToLoad(driver);
		wLib.maximizeWindow(driver);
		driver.get(url);
		System.out.println("======Browser Launched======");
	}
	
	@BeforeMethod
	public void LoginToApp() throws Throwable
	{
		//read the Data
		String userName=fLib.getPropertyKeyValue("username");
		String password=fLib.getPropertyKeyValue("password");
		
		LoginPage lp=new LoginPage(driver);
		lp.clickLogin(userName, password);
		System.out.println("========Login Successfull========");
	}
	
	@AfterMethod
	public void logoutApp()
	{
		HomePage hp=new HomePage(driver);
		hp.clickSigout(driver);
		System.out.println("========Logout Successfull========");
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
		System.out.println("========Browser closed========");
	}
	
	@AfterSuite
	public void closeDBConnection() throws Throwable {
		dbLib.closeDBConnection();
		System.out.println("=======DataBase Connection Closed=========");
	}
}