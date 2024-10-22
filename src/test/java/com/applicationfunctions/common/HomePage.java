package com.applicationfunctions.common;

import java.io.BufferedWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.utilities.*;

public class HomePage {
	
	public WebDriver driver;
	private static By btn_OK = By.xpath("//button[contains(text(),'OK')]");
	private static By btncrossicon_AboutTool = By.xpath("//div[contains(text(),'About')]/../div[4]");
	private static By tool_backicon = By.xpath("//div[@class='previousBtn jimu-corner-left enabled']");
	private static By search_box = By.xpath("//input[contains(@title,'Find address or place')]");
	private static By search_boxSiteType = By.xpath("//input[contains(@title,'Place, Address, Lat/Long, or Asset')]");
	private static By search_Result = By.xpath("//div[@class='searchMenu']/ul/li[1]");
	private static By search_icon = By.xpath("//div[@title='Search']");
	private static By clearSearch = By.xpath("//div[@title='Clear search']");
	private static By searchIn_Drpdwn = By.xpath("//div[@title='Search in']");
	private static By siteType = By.xpath("//li[contains(text(),'Valve Setting')]");
	
	public HomePage(WebDriver driver)
	{
		super();
		this.driver = driver;
	}
	
	public void HomePagePopupAccept(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Wait.waitForLoadingIconToDisspear(driver);
			StepExecutor.ElementClick(driver, "Xpath", btn_OK, "Button - OK", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", btncrossicon_AboutTool, "Button - CrossIconAboutTool", writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void BackIconClick(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			for(int i=0;i<10;i++)
			{
				WebElement tool_backiconEle = driver.findElement(tool_backicon);
				if(tool_backiconEle.isEnabled())
				{
					tool_backiconEle.click();
					Thread.sleep(100);
				}
				else
					break;
			}
		
		} catch (Exception e) {
		}
	}
	
	public void SearchAddress(WebDriver driver, String address, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Wait.waitForElementVisible( driver,  search_box, 10);
			StepExecutor.SetText(driver, "Xpath", search_box, "Search Box", address, writer, test);
			Thread.sleep(2000);
			StepExecutor.ElementClick(driver, "Xpath", search_icon, "SearchIcon", writer, test);
			Thread.sleep(5000);
			Wait.DynamicWaitToLoadElement(driver, "XPATH", search_Result);
			StepExecutor.ElementClick(driver, "Xpath", search_Result, "SearchResult", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", clearSearch, "Clear Search", writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void SearchAddressWithSiteType(WebDriver driver, String address, BufferedWriter writer, ExtentTest test) throws Exception
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
			StepExecutor.ElementClick(driver, "Xpath", clearSearch, "Clear Search", writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
}
