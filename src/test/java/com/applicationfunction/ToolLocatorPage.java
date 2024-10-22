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
import com.utilities.Wait;

public class ToolLocatorPage {
	
	public WebDriver driver;
	public TestValidations testValidations = new TestValidations(driver);
	private String SearchOptionNameTrimmed ="";
	private static By option_LocatorTool = By.xpath("(//div[contains(@settingid,'Locaters')]/div)[1]");
	private static By list_searchoptions = By.xpath("(//div[@id='tabCont_tablist']/div/span)[1]");
	
	public ToolLocatorPage(WebDriver driver)
	{
		super();
		this.driver = driver;
	}
	
	public void ClickLocatorTool(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_LocatorTool, "Option - Locator tool", writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ClickSearchOptionIcon(WebDriver driver, String SearchOptionName, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Wait.DynamicWaitToLoadElement(driver, "XPATH", list_searchoptions);
			StepExecutor.ElementClick(driver, "Xpath", list_searchoptions, "List Search options", writer, test);
			SearchOptionNameTrimmed = SearchOptionName.replace(" ","");
			By item_serachoption = By.xpath("//td[text()='"+SearchOptionName+"']");
			StepExecutor.ElementClick(driver, "Xpath", item_serachoption, "Item Search option", writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void SelectBusinessUnit(WebDriver driver, String BusinessUnit, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Thread.sleep(2500);
			By drpdwn_BusinessUnit = By.xpath("//div[@id='"+SearchOptionNameTrimmed+"']//div[contains(text(),'Business Unit')]/../div[2]/table[1]");
			StepExecutor.ElementClick(driver, "Xpath", drpdwn_BusinessUnit, "Dropdown - Business Unit", writer, test);
			By Businessunit = By.xpath("//div[@class='dijitPopup dijitMenuPopup']/table/tbody/tr/td[contains(text(),'"+BusinessUnit+"')]");
			StepExecutor.ElementClick(driver, "Xpath", Businessunit, "Unit Name", writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void SelectSegment(WebDriver driver, String Segment, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Thread.sleep(2500);
			By drpdwn_Segment = By.xpath("//div[@id='"+SearchOptionNameTrimmed+"']//div[contains(text(),'Business Unit')]/../div[4]/table[1]");
			StepExecutor.ElementClick(driver, "Xpath", drpdwn_Segment, "Dropdown - Segment", writer, test);
			By segment = By.xpath("//div[@class='dijitPopup dijitMenuPopup']/table/tbody/tr/td[contains(text(),'"+Segment+"')]");
			StepExecutor.ElementClick(driver, "Xpath", segment, "Segment", writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void SelectPipeline(WebDriver driver, String Pipeline, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Thread.sleep(2500);
			By drpdwn_Pipeline = By.xpath("//div[@id='"+SearchOptionNameTrimmed+"']//div[contains(text(),'Business Unit')]/../div[6]/table[1]");
			StepExecutor.ElementClick(driver, "Xpath", drpdwn_Pipeline, "Dropdown - Pipeline", writer, test);
			By pipeline = By.xpath("//div[@class='dijitPopup dijitMenuPopup']/table/tbody/tr/td[contains(text(),'"+Pipeline+"')]");
			StepExecutor.ElementClick(driver, "Xpath", pipeline, "Pipeline", writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void SelectValveSection(WebDriver driver, String ValveSelection, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Thread.sleep(2500);
			By drpdwn_ValveSelection = By.xpath("//div[@id='"+SearchOptionNameTrimmed+"']//div[contains(text(),'Business Unit')]/../div[8]/table[1]");
			StepExecutor.ElementClick(driver, "Xpath", drpdwn_ValveSelection, "Dropdown - ValveSelection", writer, test);
			By valveSelection = By.xpath("//div[@class='dijitPopup dijitMenuPopup']/table/tbody/tr/td[contains(text(),'"+ValveSelection+"')]");
			StepExecutor.ElementClick(driver, "Xpath", valveSelection, "ValveSelection", writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void SelectStationSite(WebDriver driver, String Site, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Thread.sleep(2500);
			By drpdwn_SiteSelection = By.xpath("//div[@id='"+SearchOptionNameTrimmed+"']//div[contains(text(),'Business Unit')]/../div[4]/table[1]");
			StepExecutor.ElementClick(driver, "Xpath", drpdwn_SiteSelection, "Dropdown - Site", writer, test);
			By site = By.xpath("//div[@class='dijitPopup dijitMenuPopup']/table/tbody/tr/td[contains(text(),'"+Site+"')]");
			StepExecutor.ElementClick(driver, "Xpath", site, "ValveSelection", writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ClickLocateBtn(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			By btn_Locate = By.xpath("//div[@id='"+SearchOptionNameTrimmed+"']//span[contains(text(),'Locate')]");
			StepExecutor.ElementClick(driver, "Xpath", btn_Locate, "Button - Locate", writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void PrintLocatorToolResultToReport(WebDriver driver, String SearchOptionName, BufferedWriter writer, ExtentTest test) throws Exception
	{
		Thread.sleep(3000);
		//TestResults.PrintResultToReportWithScreenshot("Selected "+ SearchOptionName +" is located on map successfully! " , test);
		TestResults.PrintResultToReport("Selected "+ SearchOptionName +" is located on map successfully! " , test);
	}
}
