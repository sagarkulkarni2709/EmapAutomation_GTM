package com.applicationfunction;

import java.io.BufferedWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.applicationfunctions.common.HomePage;
import com.aventstack.extentreports.ExtentTest;
import com.utilities.StepExecutor;
import com.utilities.TestInitializer;
import com.utilities.TestResults;
import com.utilities.Wait;

public class PopupFunctions {
	
	public WebDriver driver;
	public HomePage homePageObj = new HomePage(driver);
	private static By search_box = By.xpath("//input[contains(@title,'Find address or place')]");
	private static By search_Result = By.xpath("//div[@class='searchMenu']/ul/li[1]");
	private static By search_icon = By.xpath("//div[@title='Search']");
	private static By option_popup = By.xpath("//a[@title='Zoom to']/following-sibling::span");
	private static By option_AddMarker = By.xpath("//div[contains(text(),'Add a marker')]");
	private static By option_ViewInAttributeTable = By.xpath("//div[contains(text(),'View in Attribute Table')]");
	private static By featureCount = By.xpath("//div[contains(text(),'features')]");
	private static By searchIn_Drpdwn = By.xpath("//div[@title='Search in']");
	private static By siteType = By.xpath("//li[contains(text(),'Valve Setting')]");
	private static By search_boxSiteType = By.xpath("//input[contains(@title,'Place, Address, Lat/Long, or Asset')]");
	
	public PopupFunctions(WebDriver driver)
	{
		super();
		this.driver = driver;
	}
	
	public void SearchAddress(WebDriver driver, String address, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Wait.waitForElementVisible( driver,  search_box, 10);
			StepExecutor.ElementClick(driver, "Xpath", searchIn_Drpdwn, "Search-In Dropdown", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", siteType, "Site Type", writer, test);
			StepExecutor.SetText(driver, "Xpath", search_boxSiteType, "Search Box", address, writer, test);
			Thread.sleep(2000);
			StepExecutor.ElementClick(driver, "Xpath", search_icon, "SearchIcon", writer, test);
			Thread.sleep(3000);
			Wait.DynamicWaitToLoadElement(driver, "XPATH", search_Result);
			StepExecutor.ElementClick(driver, "Xpath", search_Result, "SearchResult", writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void OpenPopup(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			SearchAddress(driver, "TENNESSEE RIVER CROSSING", writer,test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void AddMarkerToLocation(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_popup, "Option popup", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_AddMarker, "Option AddMarker", writer, test);
			//TestResults.PrintResultToReportWithScreenshot("Marker is added to the searched location!" ,test);
			TestResults.PrintResultToReport("Marker is added to the searched location!" ,test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ViewInAttributeTable(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_popup, "Option popup", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_ViewInAttributeTable, "Option View In Attribute Table", writer, test);
			Wait.DynamicWaitToLoadElement(driver, "XPATH", featureCount);
			String featurecount = driver.findElement(featureCount).getText().replaceAll("\\s+$", "");
			Assert.assertEquals(featurecount, "1 features");
			//TestResults.PrintResultToReportWithScreenshot("Attribute table is opened and found " + featurecount  ,test);
			TestResults.PrintResultToReport("Attribute table is opened and found " + featurecount  ,test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}

}
