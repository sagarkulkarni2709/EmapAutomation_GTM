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

public class ToolInlinePage {
	
	public WebDriver driver;
	public TestValidations testValidations = new TestValidations(driver);
	
	private static By option_Inlinetool = By.xpath("(//div[contains(@settingid,'Inline')]/div)[1]");
	private static By btn_Restore = By.xpath("//span[contains(text(),'Restore')]");
	private static By option_selectRouteandRange = By.xpath("//div[@title='Select route and range']");
	private static By plot_LineFeature = By.xpath("(//*[local-name() = 'svg'])[1]");
	private static By link_ZoomTo = By.xpath("(//span[contains(text(),'Zoom to')])[1]");
	private static By shape_point = By.xpath("(//*[local-name() = 'circle'][last()])");
	private static By close_popup = By.xpath("//div[@title='Close']");
	private static By rectTag = By.xpath("//div[@id='BandContentPOI_chart']/div");
	
	public ToolInlinePage(WebDriver driver)
	{
		super();
		this.driver = driver;
	}
	
	public void ClickInlineTool(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_Inlinetool, "Option - LayerListtool", writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ClickRestoreOfInline(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Thread.sleep(2000);
			StepExecutor.ElementClick(driver, "Xpath", btn_Restore, "Button - Restore", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_selectRouteandRange, "Option selectRouteandRange", writer, test);
			WebElement source = driver.findElement(plot_LineFeature);
			Thread.sleep(2000);
			StepExecutor.DrawLineForInline(driver, source);
			//TestResults.PrintResultToReportWithScreenshot("Data is loaded in Inline tool", test);
			TestResults.PrintResultToReport("Data is loaded in Inline tool", test);
			StepExecutor.ElementClick(driver, "Xpath", link_ZoomTo, "Link - Zoom To", writer, test);
			//TestResults.PrintResultToReportWithScreenshot("After ZoomTo the view is-", test);
			TestResults.PrintResultToReport("After ZoomTo the view is-", test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ClickOnDrawnPointAgain(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Thread.sleep(2000);
			StepExecutor.ElementClick(driver, "Xpath", close_popup, "Close Popup", writer, test);
			WebElement source = driver.findElement(shape_point);
			source.click();
			source.click();
			Thread.sleep(500);
			StepExecutor.ElementClick(driver, "Xpath", rectTag, "Rect Tag", writer, test);
			//TestResults.PrintResultToReportWithScreenshot("Red x is successfully drawn on map", test);
			TestResults.PrintResultToReport("Red x is successfully drawn on map", test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
}
