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

public class ToolAttributeTablePage {
	
	public WebDriver driver;
	public TestValidations testValidations = new TestValidations(driver);
	
	private static By option_AttributeTableTool = By.xpath("(//div[contains(@settingid,'AttributeTable')]/div)[1]");
	private static By btn_options = By.xpath("//span[contains(text(),'Options')]");
	private static By option_filter = By.xpath("//td[contains(text(),'Filter')]");
	private static By link_AddExpression = By.xpath("//span[contains(text(),'Add expression')]");
	private static By SecondDrpdwn_Expression = By.xpath("//div[@class='settings-container']/div[1]/following-sibling::table");
	private static By ThirdField_Expression = By.xpath("(//div[@class='settings-container']/div[2]/div//input[1])[2]");
	private static By btn_OK = By.xpath("(//div[contains(text(),'OK')])[1]");
	private static By link_AddSet = By.xpath("//span[contains(text(),'Add set')]");
	private static By addset_firstDropdown = By.xpath("(//div[@class='settings-container']/div[1]/following-sibling::table)[1]");
	private static By addset_secondDropdown = By.xpath("((//div[@class='settings-container'])[2]/div[1]/following-sibling::table)[1]");
	private static By addset_thirdField = By.xpath("(//div[@class='settings-container']/div[2]/div//input[1])[2]");
	private static By addset_sixthField = By.xpath("((//div[@class='settings-container'])[2]/div[2]/div//input[1])[2]");
	private static By option_ExportToCSV = By.xpath("//td[contains(text(),'Export all to CSV')]");
	private static By option_exporttocsvOK = By.xpath("(//div[contains(text(),'Export data to CSV file?')]/../following-sibling::div/div)[1]");
	
	public ToolAttributeTablePage(WebDriver driver)
	{
		super();
		this.driver = driver;
	}
	
	public void ClickAttributeTableTool(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_AttributeTableTool, "Option - Attribute table tool", writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ClickOptionsBtn(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Thread.sleep(5000);
			Wait.DynamicWaitToLoadElement(driver, "XPATH", btn_options);
			StepExecutor.ElementClick(driver, "Xpath", btn_options, "Button - Options", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_filter, "Option Filter", writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ClickExportDataToCSV(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Thread.sleep(5000);
			Wait.DynamicWaitToLoadElement(driver, "XPATH", btn_options);
			StepExecutor.ElementClick(driver, "Xpath", btn_options, "Button - Options", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_ExportToCSV, "Option ExportToCSV", writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void AddExpression(WebDriver driver, String FirstFieldofAddExpression, String SecondFieldOfAddExpression, String ThirdFieldOfAddExpression, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", link_AddExpression, "Link Add Expression", writer, test);
			By drpdwnValue = By.xpath("(//div[@class='settings-container']/div[1]/div[3]/input)[1]");
			StepExecutor.SetText(driver, "Xpath", drpdwnValue, "Field Value", FirstFieldofAddExpression, writer, test);
			StepExecutor.ElementClick(driver, "Xpath", SecondDrpdwn_Expression, "Dropdown Field", writer, test);
			By drpdwnValuesecond = By.xpath("//div[@class='dijitPopup dijitMenuPopup']/table/tbody/tr/td[text()='"+SecondFieldOfAddExpression+"']");
			StepExecutor.ElementClick(driver, "Xpath", drpdwnValuesecond, "Dropdown Field second", writer, test);
			StepExecutor.SetText(driver, "Xpath", ThirdField_Expression, "Third filed of expression", ThirdFieldOfAddExpression, writer, test);
			StepExecutor.ElementClick(driver, "Xpath", btn_OK, "Button OK", writer, test);
			/*
			 * Thread.sleep(2000); By filteredItem =
			 * By.xpath("//span[contains(text(),'"+ThirdFieldOfAddExpression+"')]");
			 * Wait.DynamicWaitToLoadElement(driver, "XPATH", filteredItem);
			 * if(driver.findElement(filteredItem).isDisplayed()) TestResults.
			 * PrintResultToReportWithScreenshot("Record is filtered with applied expression!"
			 * ,test);
			 */
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void AddSet(WebDriver driver, String FirstFieldofAddset, String SecondFieldOfAddset, String ThirdFieldOfAddset, String FourthFieldofAddset, String FifthFieldOfAddset, String SixthFieldOfAddset, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", link_AddSet, "Link Add Set", writer, test);
			By firstFieldofAddset = By.xpath("(//div[@class='settings-container']/div[1]/div[3]/input)[1]");
			StepExecutor.SetText(driver, "Xpath", firstFieldofAddset, "Field Value", FirstFieldofAddset, writer, test);
			StepExecutor.ElementClick(driver, "Xpath", addset_firstDropdown, "Addset firstDropdown", writer, test);
			By secondFieldOfAddset = By.xpath("//div[@class='dijitPopup dijitMenuPopup']/table/tbody/tr/td[text()='"+SecondFieldOfAddset+"']");
			StepExecutor.ElementClick(driver, "Xpath", secondFieldOfAddset, "Dropdown Field second", writer, test);
			StepExecutor.SetText(driver, "Xpath", addset_thirdField, "Third field of Addset", ThirdFieldOfAddset, writer, test);
			By fourthFieldofAddset = By.xpath("((//div[@class='settings-container'])[2]/div[1]/div[3]/input)[1]");
			StepExecutor.SetText(driver, "Xpath", fourthFieldofAddset, "Field Value", FourthFieldofAddset, writer, test);
			StepExecutor.ElementClick(driver, "Xpath", addset_secondDropdown, "Addset secondDropdown", writer, test);
			By fifthFieldOfAddset = By.xpath("(//div[@class='dijitPopup dijitMenuPopup']/table/tbody/tr/td[text()='"+FifthFieldOfAddset+"'])[2]");
			StepExecutor.ElementClick(driver, "Xpath", fifthFieldOfAddset, "Dropdown Field second", writer, test);
			StepExecutor.SetText(driver, "Xpath", addset_sixthField, "Sixth field of Addset", SixthFieldOfAddset, writer, test);
			StepExecutor.ElementClick(driver, "Xpath", btn_OK, "Button OK", writer, test);
			/*
			 * Thread.sleep(4000); By filteredItemOneAddSet =
			 * By.xpath("//span[contains(text(),'"+ThirdFieldOfAddset+"')]"); By
			 * filteredItemSecondAddSet =
			 * By.xpath("//td[contains(text(),'"+SixthFieldOfAddset+"')]");
			 * Wait.DynamicWaitToLoadElement(driver, "XPATH", filteredItemOneAddSet);
			 * if(driver.findElement(filteredItemOneAddSet).isDisplayed() &&
			 * driver.findElement(filteredItemSecondAddSet).isDisplayed()) TestResults.
			 * PrintResultToReportWithScreenshot("Record is filtered with added set!"
			 * ,test);
			 */
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ExportDataToCSV(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_exporttocsvOK, "Button - OK Export To CSV", writer, test);
			Thread.sleep(4000);
			TestResults.PrintResultToReport("CSV file of Attribute table is exported successfully!", test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
}
