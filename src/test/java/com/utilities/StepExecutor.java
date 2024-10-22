package com.utilities;

import java.io.BufferedWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

public class StepExecutor {
	
	public static BufferedWriter writer;
	public static ExtentTest test ;
	
	public static void ElementClick(WebDriver driver, String locator, By locatorValue, String locatorName, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			WebElement element;           
			try
			{
				Wait.DynamicWaitToLoadElement(driver, locator, locatorValue);
				element = driver.findElement(locatorValue);
				ScrollToElement(driver, element);
				element.click();
				if (writer != null)
				{
					TestResults.WriteTestContext(locatorName + " is clicked", writer);
					TestResults.PrintResultToReport(locatorName + " is clicked", test);
				}
			}
			catch (Exception e)
			{
				element = driver.findElement(locatorValue);
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", element);
				if (writer != null)
				{
					TestResults.WriteTestContext(locatorName + " is clicked", writer);
					TestResults.PrintResultToReport(locatorName + " is clicked", test);
				}
			}
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}      
	}
	
	public static void SetText(WebDriver driver, String locator, By locatorValue, String locatorName, String Text, BufferedWriter writer, ExtentTest test) throws Exception
    {
		WebElement element;   
        try
        {
        	//Wait.DynamicWaitToLoadElement(driver, locator, locatorValue);
        	Wait.waitForElementVisible(driver, locatorValue, 5);
            element = driver.findElement(locatorValue);
            ScrollToElement(driver, element);
            element.clear();
            element.click();
            element.sendKeys(Text);
            TestResults.WriteTestContext(locatorName + " input field is populated with value : " + Text, writer);
            TestResults.PrintResultToReport(locatorName + " input field is populated with value : " + Text, test);
        }
        catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}      
    }

	public static void ScrollToElement(WebDriver driver, WebElement element) throws Exception
	{
		try
		{
			Actions actions = new Actions(driver);
			actions.moveToElement(element).perform();
		}
		catch( Exception e)
		{
			TestResults.WriteTestContext("Scroll to element action is not performed", writer);
		}
	}
	
	public static void ScrollPageDown(WebDriver driver) throws Exception
	{
		//Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,20000)");
		//((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public static void ScrollPageToHome(WebDriver driver) throws Exception
	{
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-10000)");
	}
	
	public static void AcceptWindowsAlert(WebDriver driver) throws Exception
	{
		try {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			//TestResults.WriteTestContext("Click on alert action is not performed", writer);
		}
	}
	
	public static void SelectDropdown(WebDriver driver, String locator, By locatorValue, String locatorName,String supplier, BufferedWriter writer, ExtentTest test) throws Exception {
		try {
			Wait.DynamicWaitToLoadElement(driver, locator, locatorValue);
			List<WebElement> element = GetElements(driver,locatorValue);
			for(WebElement result : element){
				String option = result.getText();
				if(option.equalsIgnoreCase(supplier)){
					result.click();
					TestResults.WriteTestContext(locatorName + " is clicked", writer);
					TestResults.PrintResultToReport(locatorName + " is clicked", test);
					break;
				}
			}

		} catch (Exception e) {
			TestResults.WriteTestContext(locatorName + " is not clicked", writer);
		}
	}

	public static String getTodayDate() {

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format1 = new SimpleDateFormat("dd-MMM-yyyy");
		String todayDate = format1.format(cal.getTime());
		return todayDate;
	}
	public static String getFutureDate() {

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 5);
		SimpleDateFormat format1 = new SimpleDateFormat("dd-MMM-yyyy");
		String futureDate = format1.format(cal.getTime());
		return futureDate;
	}

	public static String GetText(WebDriver driver,By by) {
		WebElement ele = driver.findElement(by);
		return ele.getText();
	}
	public static List<WebElement> GetList(WebDriver driver,By by) {
		List<WebElement> ele = driver.findElements(by);
		return ele;
	}

	public static WebElement GetElement(WebDriver driver,By by) {
		WebElement ele = driver.findElement(by);
		return ele;
	}
	public static List<WebElement> GetElements(WebDriver driver,By by) {
		List<WebElement> ele = driver.findElements(by);
		return ele;
	}
	public static void switchToFrame(WebDriver driver,By by) {
		WebElement ele = driver.findElement(by);
		driver.switchTo().frame(ele);
	}
	public static String GetPageSource(WebDriver driver) {
		String ele = driver.getPageSource();
		return ele;
	}
	
	public static void SwitchTab(WebDriver driver, int tabIndex)
	{
	 	ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(tabIndex));
	}
	
	public static void SwitchWindow(WebDriver driver)
	{
		String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(mainWindowHandle);
            }
        }
	}
	
	public static void DrawShapeOnMap(WebDriver driver, WebElement ele)
	{
		Actions act = new Actions(driver);
		act.moveToElement(ele);    
		act.clickAndHold();
		act.moveByOffset(100, 100);
		act.release();
		act.build().perform();
	}
	
	public static void DrawPolylineShapeOnMap(WebDriver driver, WebElement ele)
	{
		Actions act = new Actions(driver);
		act.moveToElement(ele);    
		act.clickAndHold();
		act.moveByOffset(100, 100);
		act.moveByOffset(100, 100);
		act.release();
		act.doubleClick();
		act.build().perform();
	}
	
	public static void DrawPolygonShapeOnMap(WebDriver driver, WebElement ele) throws Exception
	{
		Actions act = new Actions(driver);
		act.moveToElement(ele);    
		act.clickAndHold();
		act.moveByOffset(100, 100);
		act.click().build().perform();
		act.moveByOffset(50, 50);
		act.click().build().perform();
		act.moveByOffset(50, -10);
		act.doubleClick().build().perform();
		//act.release();
	}
	
	public static void DrawPolygonShapeForSelectTool(WebDriver driver, WebElement ele) throws Exception
	{
		Actions act = new Actions(driver);
		act.moveToElement(ele);    
		act.clickAndHold();
		act.moveByOffset(50, 50);
		act.click().build().perform();
		act.moveByOffset(20, 20);
		act.click().build().perform();
		act.moveByOffset(50, -10);
		act.doubleClick().build().perform();
		//act.release();
	}
	
	public static void DrawLineToCreateProfile(WebDriver driver, WebElement ele) throws Exception
	{
		Actions act = new Actions(driver);
		act.moveToElement(ele);    
		act.clickAndHold();
		act.moveByOffset(15,15);
		act.click().build().perform();
		act.moveByOffset(5,5);
		act.doubleClick().build().perform();
	}
	
	public static void DrawLineForInline(WebDriver driver, WebElement ele) throws Exception
	{
		Actions act = new Actions(driver);
		act.moveToElement(ele);
		act.clickAndHold();
		act.click().build().perform();
		Thread.sleep(2000);
		act.doubleClick().build().perform();
		Thread.sleep(2000);
		act.click().build().perform();
	}
}
