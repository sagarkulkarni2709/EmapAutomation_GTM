package com.applicationfunction;

import java.io.BufferedWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.test.validation.TestValidations;
import com.utilities.StepExecutor;
import com.utilities.TestInitializer;
import com.utilities.TestResults;

public class ToolMeasurementPage {

	public WebDriver driver;
	public TestValidations testValidations = new TestValidations(driver);
	
	private static By option_MeasurementTool = By.xpath("(//div[contains(@settingid,'Measurement')]/div)[1]");
	private static By option_AreaInMeasurementTool = By.xpath("//div[@class='esriMeasurement']/div/span[1]");
	private static By drpdwn_unit = By.xpath("//div[@class='esriMeasurement']/div[1]/span[4]/span");
	private static By plot_LineFeature = By.xpath("(//*[local-name() = 'svg'])[1]");
	private static By measurement_Result = By.xpath("//div[contains(text(),'Measurement Result')]/following-sibling::div/div");
	private static By option_DistanceInMeasurementTool = By.xpath("//div[@class='esriMeasurement']/div/span[2]");
	private static By option_Originalbox = By.xpath("(//input[@name='originalbox'])[1]");
	private static By option_LocationInMeasurementTool = By.xpath("//div[@class='esriMeasurement']/div/span[3]");
	private static By text_Lat = By.xpath("(//td[@class='esriMeasurementTableCell']/span)[3]");
	private static By text_Long = By.xpath("(//td[@class='esriMeasurementTableCell']/span)[4]");
	
	public ToolMeasurementPage(WebDriver driver)
	{
		super();
		this.driver = driver;
	}
	
	public void ClickMeasurementTool(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_MeasurementTool, "Option - Measurement tool", writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ClickAreaOptionAndDraw(WebDriver driver, String unitName, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_AreaInMeasurementTool, "Option - Area", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", drpdwn_unit, "DropDown - Unit", writer, test);
			By unit_Name = By.xpath("//div[@class='dijitPopup dijitMenuPopup']/table/tbody/tr/td[contains(text(),'"+unitName+"')]");
			StepExecutor.ElementClick(driver, "Xpath", unit_Name, "Unit Name", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", plot_LineFeature, "Point on map", writer, test);
			WebElement source = driver.findElement(plot_LineFeature);
			StepExecutor.DrawPolygonShapeOnMap(driver, source);
			testValidations.ShapeValidation(driver, testValidations.shape_line, "Line",  writer, test);
			String text_Measurementresult = driver.findElement(measurement_Result).getText();
			//TestResults.PrintResultToReportWithScreenshot("Area displayed in " +unitName+ " is " +  text_Measurementresult, test);
			TestResults.PrintResultToReport("Area displayed in " +unitName+ " is " +  text_Measurementresult, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ClickDistanceOptionAndDraw(WebDriver driver, String unitNameDistance, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_DistanceInMeasurementTool, "Option - Distance", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", drpdwn_unit, "DropDown - Unit", writer, test);
			By unit_Name = By.xpath("//div[@class='dijitPopup dijitMenuPopup']/table/tbody/tr/td[contains(text(),'"+unitNameDistance+"')]");
			StepExecutor.ElementClick(driver, "Xpath", unit_Name, "Unit Name", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", plot_LineFeature, "Point on map", writer, test);
			WebElement source = driver.findElement(plot_LineFeature);
			StepExecutor.DrawPolygonShapeOnMap(driver, source);
			String text_Measurementresult = driver.findElement(measurement_Result).getText();
			//TestResults.PrintResultToReportWithScreenshot("Distance displayed in " +unitNameDistance+ " is " +  text_Measurementresult, test);
			TestResults.PrintResultToReport("Distance displayed in " +unitNameDistance+ " is " +  text_Measurementresult, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ClickDistanceOptionAndCreateCircle(WebDriver driver, String unitNameDistance, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_DistanceInMeasurementTool, "Option - Distance", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", drpdwn_unit, "DropDown - Unit", writer, test);
			By unit_Name = By.xpath("//div[@class='dijitPopup dijitMenuPopup']/table/tbody/tr/td[contains(text(),'"+unitNameDistance+"')]");
			StepExecutor.ElementClick(driver, "Xpath", unit_Name, "Unit Name", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_Originalbox, "Click Checkbox to create circle", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", plot_LineFeature, "Point on map", writer, test);
			WebElement source = driver.findElement(plot_LineFeature);
			StepExecutor.DrawPolygonShapeOnMap(driver, source);
			String text_Measurementresult = driver.findElement(measurement_Result).getText();
			Thread.sleep(2000);
			//TestResults.PrintResultToReportWithScreenshot("Distance displayed in " +unitNameDistance+ " is " +  text_Measurementresult, test);
			TestResults.PrintResultToReport("Distance displayed in " +unitNameDistance+ " is " +  text_Measurementresult, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ClickLocationOptionAndPlot(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_LocationInMeasurementTool, "Option - Distance", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", plot_LineFeature, "Point on map", writer, test);
			String text_Latitude = driver.findElement(text_Lat).getText();
			String text_Longitude = driver.findElement(text_Long).getText();
			//TestResults.PrintResultToReportWithScreenshot("Latitude of plotted point is " +text_Latitude+ " and Longitude of plotted point is " +  text_Longitude, test);
			TestResults.PrintResultToReport("Latitude of plotted point is " +text_Latitude+ " and Longitude of plotted point is " +  text_Longitude, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
}
