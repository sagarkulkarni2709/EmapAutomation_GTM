package com.applicationfunction;

import java.io.BufferedWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.test.validation.TestValidations;
import com.utilities.StepExecutor;
import com.utilities.TestInitializer;
import com.utilities.TestResults;
import com.utilities.Wait;

public class ToolDirectionsPage {
	
	public WebDriver driver;
	public TestValidations testValidations = new TestValidations(driver);
	
	private static By option_DirectionsTool = By.xpath("(//div[contains(@settingid,'Directions')]/div)[1]");
	private static By text_FromAddress = By.xpath("(//div[@class='searchInputGroup']//input)[2]");
	private static By text_ToAddress = By.xpath("(//div[@class='searchInputGroup']//input)[3]");
	private static By drpdwn_Time = By.xpath("//table[@id='dijit_form_Select_0']");
	private static By btn_GetDirections = By.xpath("//div[contains(text(),'Get Directions')]");
	
	
	public ToolDirectionsPage(WebDriver driver)
	{
		super();
		this.driver = driver;
	}

	public void ClickDirectionsTool(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_DirectionsTool, "Option - Directions tool", writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void EnterAddress(WebDriver driver, String FromAddress,  String ToAddress, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Wait.DynamicWaitToLoadElement(driver, "XPATH", text_FromAddress);
			StepExecutor.SetText(driver, "Xpath", text_FromAddress, "From Address", FromAddress, writer, test);
			Thread.sleep(3000);
			driver.findElement(text_FromAddress).sendKeys(Keys.ENTER);
			StepExecutor.SetText(driver, "Xpath", text_ToAddress, "To Address", ToAddress, writer, test);
			driver.findElement(text_ToAddress).sendKeys(Keys.ENTER);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void SelectTimeDropDown(WebDriver driver, String TimeDropdown, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			By option_DrivingTime = By.xpath("(//div[(text()='"+TimeDropdown+"')])[1]");
			StepExecutor.ElementClick(driver, "Xpath", drpdwn_Time, "DropDown Time", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_DrivingTime, "Option - Driving Time", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", btn_GetDirections, "Button - Get Directions", writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void DirectionValidation(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Thread.sleep(4000);
			Wait.DynamicWaitToLoadElement(driver, "XPATH", testValidations.shape_line);
			testValidations.ShapeValidation(driver, testValidations.shape_line, "Line",  writer, test);
			//TestResults.PrintResultToReportWithScreenshot("Direction for given address is plotted on Map!" ,test);
			TestResults.PrintResultToReport("Direction for given address is plotted on Map!" ,test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
}
