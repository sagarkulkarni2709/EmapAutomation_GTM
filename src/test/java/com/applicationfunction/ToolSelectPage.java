package com.applicationfunction;

import java.io.BufferedWriter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.test.validation.TestValidations;
import com.utilities.StepExecutor;
import com.utilities.TestInitializer;
import com.utilities.TestResults;
import com.utilities.Wait;

public class ToolSelectPage {
	
	public WebDriver driver;
	public TestValidations testValidations = new TestValidations(driver);
	
	private static By option_SelectTool = By.xpath("(//div[contains(@settingid,'Select')]/div)[1]");
	private static By btn_Select = By.xpath("(//div[@class='draw-item-btn']/div/div/div)[2]");
	private static By plot_LineFeature = By.xpath("(//*[local-name() = 'svg'])[1]");
	private static By btn_back = By.xpath("//div[@class='feature-action icon-arrow-back']");
	private static By layer_optionicon = By.xpath("(//div[@class='selectable-layer-item']/div)[1]/div[4]");
	private static By option_ZoomTo = By.xpath("//div[contains(text(),'Zoom to')]");
	private static By option_ExportToCSV = By.xpath("//div[contains(text(),'Export to CSV file')]");
	private static By option_ExportToFeatureCollection = By.xpath("//div[contains(text(),'Export to feature collection')]");
	private static By option_ExportToGeoJson = By.xpath("//div[contains(text(),'Export to GeoJSON')]");
	private static By option_Statistics = By.xpath("//div[contains(text(),'Statistics...')]");
	private static By option_CreateLayer = By.xpath("//div[contains(text(),'Create layer')]");
	private static By input_CreateLayer = By.xpath("//input[@placeholder='Layer name']");
	private static By btn_OK = By.xpath("(//div[contains(text(),'OK')])[1]");
	private static By option_SaveToMyContent = By.xpath("//div[contains(text(),'Save to My Content')]");
	private static By input_SaveToMyContent = By.xpath("//div[contains(text(),'Title')]/following-sibling::div/div[2]/input");
	private static By option_ViewInAttributeTable = By.xpath("//div[contains(text(),'View in Attribute Table')]");
	private static By drpdwn_field = By.xpath("//span[contains(text(),'Field')]/../table/tbody/tr");
	private static By option_ClearSelection = By.xpath("//div[contains(text(),'Clear selection')]");
	
	public ToolSelectPage(WebDriver driver)
	{
		super();
		this.driver = driver;
	}

	public void ClickSelectTool(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_SelectTool, "Option - Proximity tool", writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void SelectByShape(WebDriver driver, String SelectByShapeName, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Wait.DynamicWaitToLoadElement(driver, "XPATH", btn_Select);
			StepExecutor.ElementClick(driver, "Xpath", btn_Select, "Button - Select", writer, test);
			By SelectByShapename = By.xpath("(//div[contains(text(),'"+SelectByShapeName+"')])[1]");
			StepExecutor.ElementClick(driver, "Xpath", SelectByShapename, "Button - Select", writer, test);
			WebElement source = driver.findElement(plot_LineFeature);
			StepExecutor.DrawShapeOnMap(driver, source);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void SelectByShapePolygon(WebDriver driver, String SelectByShapeName, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Wait.DynamicWaitToLoadElement(driver, "XPATH", btn_Select);
			StepExecutor.ElementClick(driver, "Xpath", btn_Select, "Button - Select", writer, test);
			By SelectByShapename = By.xpath("(//div[contains(text(),'"+SelectByShapeName+"')])[1]");
			StepExecutor.ElementClick(driver, "Xpath", SelectByShapename, "Button - Select", writer, test);
			WebElement source = driver.findElement(plot_LineFeature);
			StepExecutor.DrawPolygonShapeForSelectTool(driver, source);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void SelectLayerItems(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			int i = 1;
			Thread.sleep(2000);
			Wait.waitForLoadingNodeDisspear(driver);
			List<WebElement> eleList = driver.findElements(By.xpath("//div[@class='selectable-layer-item']/div"));
			for(WebElement ele : eleList)
			{
				String SerachItem = driver.findElement(By.xpath("(//div[@class='selectable-layer-item']/div/div[2])["+i+"]")).getText().toString();
				String SerachItemCount = driver.findElement(By.xpath("(//div[@class='selectable-layer-item']/div/div[3])["+i+"]")).getText().toString();
				Thread.sleep(3000);
				ele.click();
				Thread.sleep(2000);
				//TestResults.PrintResultToReportWithScreenshot("Serach Results are :- " +  SerachItem + " - " + SerachItemCount,test);
				TestResults.PrintResultToReport("Serach Results are :- " +  SerachItem + " - " + SerachItemCount,test);
				StepExecutor.ElementClick(driver, "Xpath", btn_back, "Button - Back", writer, test);
				i++;
			}
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ClickoptionZoomTo(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Wait.waitForLoadingNodeDisspear(driver);
			StepExecutor.ElementClick(driver, "Xpath", layer_optionicon, "Layer option icon", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_ZoomTo, "Option Zoom to of layer", writer, test);
			//TestResults.PrintResultToReportWithScreenshot("Map is Zoomed to Layer Extent!",test);
			TestResults.PrintResultToReport("Map is Zoomed to Layer Extent!",test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ClickoptionExportToCSV(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Wait.waitForLoadingNodeDisspear(driver);
			StepExecutor.ElementClick(driver, "Xpath", layer_optionicon, "Layer option icon", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_ExportToCSV, "Option ExportToCSV of layer", writer, test);
			Thread.sleep(1000);
			//TestResults.PrintResultToReportWithScreenshot("Export to CSV of layer data is done successfully!",test);
			TestResults.PrintResultToReport("Export to CSV of layer data is done successfully!",test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ClickoptionExportToFeatureCollection(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Wait.waitForLoadingNodeDisspear(driver);
			StepExecutor.ElementClick(driver, "Xpath", layer_optionicon, "Layer option icon", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_ExportToFeatureCollection, "Option ExportToCSV of layer", writer, test);
			Thread.sleep(1000);
			//TestResults.PrintResultToReportWithScreenshot("Export To FeatureCollection of layer data is done successfully!",test);
			TestResults.PrintResultToReport("Export To FeatureCollection of layer data is done successfully!",test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ClickoptionExportToGeoJson(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Wait.waitForLoadingNodeDisspear(driver);
			StepExecutor.ElementClick(driver, "Xpath", layer_optionicon, "Layer option icon", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_ExportToGeoJson, "Option ExportToCSV of layer", writer, test);
			Thread.sleep(1000);
			//TestResults.PrintResultToReportWithScreenshot("Export To GeoJson of layer data is done successfully!",test);
			TestResults.PrintResultToReport("Export To GeoJson of layer data is done successfully!",test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ClickoptionCreateLayer(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Wait.waitForLoadingNodeDisspear(driver);
			StepExecutor.ElementClick(driver, "Xpath", layer_optionicon, "Layer option icon", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_CreateLayer, "Option Create Layer", writer, test);
			Thread.sleep(500);
			StepExecutor.SetText(driver, "Xpath", input_CreateLayer, "Layer Name", "Test Layer", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", btn_OK, "Button - OK", writer, test);
			Thread.sleep(1000);
			//TestResults.PrintResultToReportWithScreenshot("New layer is been added successfully!",test);
			TestResults.PrintResultToReport("New layer is been added successfully!",test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ClickoptionSaveToMyContent(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Wait.waitForLoadingNodeDisspear(driver);
			StepExecutor.ElementClick(driver, "Xpath", layer_optionicon, "Layer option icon", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_SaveToMyContent, "Option SaveToMyContent", writer, test);
			StepExecutor.SetText(driver, "Xpath", input_SaveToMyContent, "Layer Name", "My Content", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", btn_OK, "Button - OK", writer, test);
			Thread.sleep(1000);
			//TestResults.PrintResultToReportWithScreenshot("My content is saved successfully!",test);
			TestResults.PrintResultToReport("My content is saved successfully!",test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ClickViewInAttributeTable(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Wait.waitForLoadingNodeDisspear(driver);
			StepExecutor.ElementClick(driver, "Xpath", layer_optionicon, "Layer option icon", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_ViewInAttributeTable, "Option View In Attribute Table", writer, test);
			Thread.sleep(5000);
			//TestResults.PrintResultToReportWithScreenshot("Layer data is opened in attribute table!",test);
			TestResults.PrintResultToReport("Layer data is opened in attribute table!",test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ClickStatistics(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Wait.waitForLoadingNodeDisspear(driver);
			StepExecutor.ElementClick(driver, "Xpath", layer_optionicon, "Layer option icon", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_Statistics, "Option View In Attribute Table", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", drpdwn_field, "Field drop down", writer, test);
			//TestResults.PrintResultToReportWithScreenshot("Statistics of selected layer!",test);
			TestResults.PrintResultToReport("Statistics of selected layer!",test);
			Thread.sleep(2000);
			//TestResults.PrintResultToReportWithScreenshot("Statistics of selected layer!",test);
			TestResults.PrintResultToReport("Statistics of selected layer!",test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ClickClearSelection(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Wait.waitForLoadingNodeDisspear(driver);
			StepExecutor.ElementClick(driver, "Xpath", layer_optionicon, "Layer option icon", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_ClearSelection, "Option View In Attribute Table", writer, test);
			Thread.sleep(2000);
			//TestResults.PrintResultToReportWithScreenshot("Selection of layer is cleared successfully!",test);
			TestResults.PrintResultToReport("Selection of layer is cleared successfully!",test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
}
