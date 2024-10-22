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
import com.utilities.Wait;

public class ToolElevationProfilePage {
	
	public WebDriver driver;
	public TestValidations testValidations = new TestValidations(driver);
	
	private static By option_ElevationProfileTool = By.xpath("(//div[contains(@settingid,'ElevationProfile')]/div)[1]");
	private static By btn_Distance = By.xpath("//div[@class='esriMeasurement']/div[1]/span[2]/span");
	private static By plot_LineFeature = By.xpath("(//*[local-name() = 'svg'])[1]");
	private static By drpdwn_unit = By.xpath("//div[@class='esriMeasurement']/div[1]/span[4]");
	private static By btn_GenerateProfile = By.xpath("//span[contains(text(),'Generate Profile')]");
	private static By text_SamplingError  = By.xpath("//span[contains(text(),'Elevation Profile Sampling Error')]");
	private static By btn_OK  = By.xpath("(//div[contains(text(),'OK')])[1]");
	private static By option_ElevationProfile = By.xpath("//div[@title='Result Menu']");
	private static By option_ProfileInformation = By.xpath("//div[contains(text(),'Profile Information')]");
	private static By option_PrepareDownloadImage = By.xpath("//div[contains(text(),'Prepare Download Image...')]");
	private static By option_Flipelevationprofiledirection = By.xpath("//div[contains(text(),'Flip elevation profile direction')]");
	private static By link_download = By.xpath("//div[@class='result-div']/a");
	
	public ToolElevationProfilePage(WebDriver driver)
	{
		super();
		this.driver = driver;
	}
	
	public void ClickElevationProfileTool(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_ElevationProfileTool, "Option - Elevation Profile", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", btn_Distance, "Button - Distance", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", plot_LineFeature, "Point on map", writer, test);
			WebElement source = driver.findElement(plot_LineFeature);
			StepExecutor.DrawLineToCreateProfile(driver, source);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ChangeUnitAndDrawLine(WebDriver driver, String unitName, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", drpdwn_unit, "DropDown - Unit", writer, test);
			By unit_Name = By.xpath("//div[@class='dijitPopup dijitMenuPopup']/table/tbody/tr/td[contains(text(),'"+unitName+"')]");
			StepExecutor.ElementClick(driver, "Xpath", unit_Name, "Unit Name", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", btn_GenerateProfile, "Button - Generate Profile", writer, test);
			HandleProfileSamplingError(driver, writer, test);
			Wait.waitForProgressBarToDisspear(driver);
			Thread.sleep(2000);
			testValidations.ShapeValidation(driver, testValidations.shape_line, "Line",  writer, test);
			//TestResults.PrintResultToReportWithScreenshot("Ground Elevation Profile in " + unitName + " is created!" ,test);
			TestResults.PrintResultToReport("Ground Elevation Profile in " + unitName + " is created!" ,test);
			
			GetProfileInformation(driver, writer, test);
			FileElevationProfileDirection(driver, writer, test);
			PrepareDownloadImage(driver, writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void HandleProfileSamplingError(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception 
	{
		try {
			if(driver.findElement(text_SamplingError).isDisplayed())
				StepExecutor.ElementClick(driver, "Xpath", btn_OK, "Button - OK", writer, test);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void GetProfileInformation(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_ElevationProfile, "Option Elevation Profile", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_ProfileInformation, "Option Profile Information", writer, test);
			String profileInformtion = driver.findElement(By.xpath("//div[@class='content content-static']")).getText();
			//TestResults.PrintResultToReportWithScreenshot("Profile Information is " + profileInformtion , test);
			TestResults.PrintResultToReport("Profile Information is " + profileInformtion , test);
			StepExecutor.ElementClick(driver, "Xpath", btn_OK, "Button - OK", writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void PrepareDownloadImage(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_ElevationProfile, "Option Elevation Profile", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_PrepareDownloadImage, "Option Elevation Profile", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", link_download, "Link Download", writer, test);
			Thread.sleep(2000);
			//TestResults.PrintResultToReportWithScreenshot("Image is downloaded suuccessfully!" , test);
			TestResults.PrintResultToReport("Image is downloaded suuccessfully!" , test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void FileElevationProfileDirection(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_ElevationProfile, "Option Elevation Profile", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_Flipelevationprofiledirection, "File Elevation Profile Direction", writer, test);
			Wait.waitForProgressBarToDisspear(driver);
			//TestResults.PrintResultToReportWithScreenshot("File Elevation Profile Direction is changed!" , test);
			TestResults.PrintResultToReport("File Elevation Profile Direction is changed!" , test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
}
