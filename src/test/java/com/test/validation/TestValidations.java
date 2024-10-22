package com.test.validation;

import java.io.BufferedWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import com.utilities.StepExecutor;
import com.utilities.TestInitializer;
import com.utilities.TestResults;

public class TestValidations {
	
	public int IncrementFailedTestcaseCount = 0;
	public WebDriver driver;
	public static By plot_LineFeature = By.xpath("//*[local-name() = 'svg']");
	public static By popup_window = By.xpath("//div[@class='esriPopupWrapper']");
	public static By bookmark_name = By.xpath("(//div[@class='custom editing']/div[1]/div[2]/div/input)[2]");
	
	public By shape_point = By.xpath("(//*[local-name() = 'circle'])[1]");
	public By shape_line = By.xpath("(//*[local-name() = 'path'])[1]");
	public By shape_text = By.xpath("(//*[local-name() = 'text'])[1]");
	public By SampleLayer = By.xpath("(//div[@id='map_layers']//*[local-name() = 'image'])[1]");
	
	public TestValidations(WebDriver driver)
	{
		super();
		this.driver = driver;
	}
	
	public void LayerListValidationONLayer(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Thread.sleep(1000);
			StepExecutor.ElementClick(driver, "Xpath", plot_LineFeature, "Option - LayerONOFF", writer, test);
			Thread.sleep(3000);
			if(driver.findElement(popup_window).isDisplayed())
			{
				TestResults.PrintResultToReport("Layer is ON and displayed on map when option of Turn All Layers ON is selected" ,test);
			}
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void LayerListValidationOFFLayer(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Thread.sleep(2000);
			StepExecutor.ElementClick(driver, "Xpath", plot_LineFeature, "Option - LayerONOFF", writer, test);
			if(!(driver.findElement(popup_window).isDisplayed()))
			{
				TestResults.PrintResultToReport("Layer is OFF and not displayed on map when option of Turn All Layers OFF is selected" ,test);
			}
		} catch (Exception error) {
			TestResults.PrintResultToReport("Layer is OFF and not displayed on map when option of Turn All Layers OFF is selected" ,test);
		}
	}
	
	public void EnablePopupValidation(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Thread.sleep(1000);
			StepExecutor.ElementClick(driver, "Xpath", plot_LineFeature, "Option - LayerONOFF", writer, test);
			Thread.sleep(3000);
			if(driver.findElement(popup_window).isDisplayed())
			{
				TestResults.PrintResultToReport("Popup is Enabled when option Enable popup is selected" ,test);
			}
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void DiablePopupValidation(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Thread.sleep(2000);
			StepExecutor.ElementClick(driver, "Xpath", plot_LineFeature, "Option - LayerONOFF", writer, test);
			if(!(driver.findElement(popup_window).isDisplayed()))
			{
				TestResults.PrintResultToReport("Popup is Diabled when option Diable popup is selected" ,test);
			}
		} catch (Exception error) {
			TestResults.PrintResultToReport("Popup is Diabled when option Diable popup is selected" ,test);
		}
	}
	
	public void BookmarkValidation(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Thread.sleep(1000);
			StepExecutor.ElementClick(driver, "Xpath", plot_LineFeature, "Option - LayerONOFF", writer, test);
			Thread.sleep(3000);
			if(driver.findElement(popup_window).isDisplayed())
			{
				TestResults.PrintResultToReport("Map Extent is on Default Extent" ,test);
			}
		} catch (Exception error) {
			TestResults.PrintResultToReport("Map Extent is on navigated to Extent of added bookmark" ,test);
		}
	}
	
	public void BookmarkDeleteValidation(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Thread.sleep(2000);
			if((driver.findElement(bookmark_name).isDisplayed()))
			{
				TestResults.PrintResultToReport("Added bookmark is not deleted from the bookmark tool!" ,test);
			}
		} catch (Exception e) {
			TestResults.PrintResultToReport("Added bookmark is deleted from the bookmark tool!" ,test);
		}
	}
	
	public void BookmarkEditValidation(WebDriver driver, String BookmarkEditedName, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			String bookmarkName = driver.findElement(bookmark_name).getAttribute("title");
			if(bookmarkName.equals(BookmarkEditedName))
				TestResults.PrintResultToReport("Bookmark Name is changed after edit & changed name is:- " + BookmarkEditedName ,test);
			else	
				TestResults.PrintResultToReport("Bookmark Name not changed after edit", test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ShapeValidation(WebDriver driver, By ShapeEle, String ShapeName, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Thread.sleep(1000);
			if(driver.findElement(ShapeEle).isDisplayed())
			{
				TestResults.PrintResultToReport(ShapeName + " shape is drawn on map!" ,test);
			}
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void AddDataValidation(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Thread.sleep(1000);
			if(driver.findElement(SampleLayer).isDisplayed())
			{
				TestResults.PrintResultToReport("Data is added to the map with Sample URLs!",test);
			}
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
}
