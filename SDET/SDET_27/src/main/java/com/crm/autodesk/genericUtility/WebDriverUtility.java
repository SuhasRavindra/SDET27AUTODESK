package com.crm.autodesk.genericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;


/**
 * It contains WebDriver Specific Reusable methods/actions
 * @author MOHANKUMAR GOWDA
 *
 */
public class WebDriverUtility {

	/**
	 * It wait for page to load before identifying any synchronized element in DOM [HTML - DOCUMENT]
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver) 
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	/**
	 * It wait for page to load before identifying any assynchronized[java scripts actions] element in DOM [HTML - DOCUMENT]
	 * @param driver
	 */
	public void waitForPageToLoadJSElement (WebDriver driver)
	{
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	}
	
	/**
	 * It is Used to EXPLICITLY wait for the element to be clickable in GUI and check for specific element for every 500 milli seconds 
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element ){
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	
	/**
	 * It is Used to wait for element to be clickable in GUI and check for specific element for every 500 milli Seconds
	 * @param driver
	 * @param element
	 * @param pollingTime
	 * @throws Throwable
	 */
	public void waitForElemenWithCustomTimeOut(WebDriver driver, WebElement element, int pollingTime) throws Throwable
	{
		FluentWait wait=new FluentWait(driver);
		wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
		wait.wait(20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	
	/**
	 * It is used to switch to any window based on window title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void swithToWindow(WebDriver driver, String partialWindowTitle)
	{
		Set<String> set=driver.getWindowHandles();
		Iterator<String> it= set.iterator();
		while(it.hasNext())
		{
			String wID= it.next();
			driver.switchTo().window(wID);
			String currentWindowTitle= driver.getTitle();
			
			if(currentWindowTitle.contains(partialWindowTitle))
			{
				break;
			}
		}
	}
	
	
	/**
	 * It is used to switch to alert window and click on OK button
	 * @param driver
	 */
	public void switchToAlertWindowAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	
	/**
	 * It is used to switch to alert window and click on cancel button
	 * @param driver
	 */
	public void switchToAlertWindowAndCancel(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * used to switch the one frame to another child frame by index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	
	/**
	 * used to switch the one frame to another child frame by id
	 * @param driver
	 * @param id_name_attribute
	 */
	public void switchToFrame(WebDriver driver, String id_name_attribute)
	{
		driver.switchTo().frame(id_name_attribute);
	}
	
	/**
	 * Used to handle the dropdown and select element by index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	
	/**
	 * Used to handle the dropdown and select element by Value
	 * @param element
	 * @param text
	 */
	public void select(WebElement element, String text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	
	
	
	/** 
	 * Used to do mouse hover on the located element
	 * @param driver
	 * @param element
	 */
	public void mouseOverOnElement(WebDriver driver, WebElement element)
	{
		Actions act =new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	
	/**
	 * Used to right click on the element
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	
	/**
	 * 
	 * @param driver
	 * @param javaScript
	 */
	public void executeJavaScript(WebDriver driver, String javaScript)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeAsyncScript(javaScript, null);
	}
	
	
	/**
	 * Used to click the element by giving custom polling period and custom timeout
	 * @param element
	 * @param timeout
	 * @param polling_period
	 * @throws Throwable
	 */
	public void waitAndClick(WebElement element, int timeout, int polling_period) throws Throwable
	{
		int count=0;
	while(count<timeout)
	{
		try {
			element.click();
			break;
		}
		catch(Throwable e)
		{
			Thread.sleep(polling_period);
			count++;
		}
	}
	}
	
	/**
	 * Used to Take screen shot and store in to drive
	 * @param driver
	 * @param screenshotName
	 * @throws Throwable
	 */
	public void takeScreenShot(WebDriver driver, String screenshotName) throws Throwable
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/"+screenshotName+".png");
		Files.copy(src, dest);
	}
	
	
	/**
	 * pass Enter Key in to Browser
	 * @param driver
	 */
	public void passEnterKey(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	
	/**
	 * used to Maximize the browser
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
}
