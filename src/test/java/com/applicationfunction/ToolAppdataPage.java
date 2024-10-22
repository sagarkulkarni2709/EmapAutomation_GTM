package com.applicationfunction;

import java.io.BufferedWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.test.validation.TestValidations;
import com.utilities.StepExecutor;
import com.utilities.TestInitializer;
import com.utilities.TestResults;

public class ToolAppdataPage {
	
	public WebDriver driver;
	public TestValidations testValidations = new TestValidations(driver);
	
	private static By option_AppdataTool = By.xpath("(//div[contains(@settingid,'AddData')]/div)[1]");
	private static By option_URL = By.xpath("//div[contains(text(),'URL')]");
	private static By drpdwn_type = By.xpath("//label[contains(text(),'Type')]/../table/tbody/tr/td[2]");
	private static By link_SampleURLs = By.xpath("//a[contains(text(),'Sample URL(s)')]");
	private static By list_SampleURL = By.xpath("//div[@class='examples show']/div[1]/div[1]");
	private static By input_URL = By.xpath("//label[contains(text(),'URL')]/following-sibling::input");
	private static By btn_Add = By.xpath("//a[contains(text(),'Sample URL(s)')]/following-sibling::a");
	private static By option_Search = By.xpath("//div[contains(text(),'Search')]");
	private static By drpdwn_Region = By.xpath("//span[contains(text(),'My Organization')]/following-sibling::span");
	private static By input_Searchbox = By.xpath("//input[@class='search-textbox']");
	private static By button_search = By.xpath("//input[@class='search-textbox']/following-sibling::button");
	private static By link_Add = By.xpath("(//a[contains(text(),'Add')])[1]");
	private static By btn_ZoomOut = By.xpath("//div[@title='Zoom out']");
	private static By addData_closebutton = By.xpath("(//div[contains(text(),'Add Data')]/../div[4])[1]");
	
	public ToolAppdataPage(WebDriver driver)
	{
		super();
		this.driver = driver;
	}

	public void ClickAppdataTool(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_AppdataTool, "Option - Appdata tool", writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ClickURLSection(WebDriver driver, String TypeDrpdwn, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_URL, "Option - URL", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", drpdwn_type, "Type Dropdown", writer, test);
			By drpdwn_TypeItem = By.xpath("//td[contains(text(),'"+TypeDrpdwn+"')]");
			StepExecutor.ElementClick(driver, "Xpath", drpdwn_TypeItem, "Dropdown Item", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", link_SampleURLs, "Link Sample URLs", writer, test);
			String SampleURL = driver.findElement(list_SampleURL).getText();
			StepExecutor.SetText(driver, "Xpath", input_URL, "URL", SampleURL, writer, test);
			StepExecutor.ElementClick(driver, "Xpath", btn_Add, "Button - Add", writer, test);
			Thread.sleep(500);
			StepExecutor.ElementClick(driver, "Xpath", addData_closebutton, "Close - Add Data", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", btn_ZoomOut, "Button - ZoomOut", writer, test);
			testValidations.AddDataValidation(driver,  writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ClickSearchSection(WebDriver driver, String RegionDropDownItem, String SearchService, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_Search, "Option - Search", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", drpdwn_Region, "Dropdown - Region", writer, test);
			By drpdwn_item = By.xpath("//button[contains(text(),'"+RegionDropDownItem+"')]");
			StepExecutor.ElementClick(driver, "Xpath", drpdwn_item, "Dropdown - Region Item", writer, test);
			StepExecutor.SetText(driver, "Xpath", input_Searchbox, "SearchService", SearchService, writer, test);
			StepExecutor.ElementClick(driver, "Xpath", button_search, "Search button", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", link_Add, "Link Add", writer, test);
			Thread.sleep(2000);
			//TestResults.PrintResultToReportWithScreenshot("Data is added to the map with Sample URLs!",test);
			TestResults.PrintResultToReport("Data is added to the map with Sample URLs!",test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
}
