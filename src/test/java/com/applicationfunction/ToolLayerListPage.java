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

public class ToolLayerListPage {
	
	public WebDriver driver;
	public TestValidations testValidations = new TestValidations(driver);
	
	private static By option_LayerListtool = By.xpath("(//div[contains(@settingid,'LayerList')]/div)[1]");
	private static By option_LayerONOFF = By.xpath("(//div[@class='jimu-dropmenu'])[1]");
	private static By option_turnAlllayersOn = By.xpath("//div[contains(text(),'Turn all layers on')]");
	private static By option_turnAlllayersOff = By.xpath("//div[contains(text(),'Turn all layers off')]");
	private static By popupmenubutton = By.xpath("//div[contains(text(),'GTM')]/../../td[3]");
	private static By option_ZoomTo = By.xpath("//div[contains(text(),'Zoom to')]");
	private static By option_home = By.xpath("//div[@class='home']");
	private static By option_Diablepopup = By.xpath("//div[contains(text(),'Disable pop-up')]");
	private static By option_Enablepopup = By.xpath("//div[contains(text(),'Enable pop-up')]");
	private static By option_expandalllayer = By.xpath("//div[contains(text(),'Expand all layers')]");
	private static By option_collapsealllayer = By.xpath("//div[contains(text(),'Collapse all layers')]");
	
	private static By option_Transperancy = By.xpath("//div[contains(text(),'Transparency')]");
	private static By option_slider = By.xpath("//div[@class='label']/following-sibling::table//tr[2]/td[2]");
	private static By option_SetVisibilityRange = By.xpath("//div[contains(text(),'Set visibility range')]");
	private static By option_SetVisibilitySlider = By.xpath("//div[@class='esriVisibleScaleRangeSlider']/table/tbody/tr[2]/td[3]/div/div[1]/div");
	private static By option_ViewInAttributeTable = By.xpath("//div[contains(text(),'View in Attribute Table')]");
	private static By text_features = By.xpath("//div[contains(text(),'features')]");
	
	public ToolLayerListPage(WebDriver driver)
	{
		super();
		this.driver = driver;
	}
	
	public void ClickLayerListTool(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_LayerListtool, "Option - LayerListtool", writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void CheckLayerVisibility(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_LayerONOFF, "Option - LayerONOFF", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_turnAlllayersOn, "Option - Turn All Layer ON", writer, test);
			testValidations.LayerListValidationONLayer(driver, writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_LayerListtool, "Option - LayerListtool", writer, test);
			Thread.sleep(500);
			StepExecutor.ElementClick(driver, "Xpath", option_LayerListtool, "Option - LayerListtool", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_LayerONOFF, "Option - LayerONOFF", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_turnAlllayersOff, "Option - Turn All Layer OFF", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_LayerListtool, "Option - LayerListtool", writer, test);
			testValidations.LayerListValidationOFFLayer(driver, writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void CheckOptionsLayerList(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			  OptionDisablePopup(driver, writer, test);
			  OptionEnablePopup(driver, writer,test); 
			  OptionZoomTo(driver, writer, test); 
			  OptionTransperancy(driver, writer,test);
			  OptionViewInAttributeTable(driver, writer, test);
			  OptionSetVisibilityRange(driver, writer, test); 
			
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void OptionDisablePopup(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", popupmenubutton, "Popup menu button", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_Diablepopup, "Option-Diable popup", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_LayerListtool, "Option - LayerListtool", writer, test);
			testValidations.DiablePopupValidation( driver,  writer,  test);
			
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void OptionEnablePopup(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_LayerListtool, "Option - LayerListtool", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", popupmenubutton, "Popup menu button", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_Enablepopup, "Option-Enable popup", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_LayerListtool, "Option - LayerListtool", writer, test);
			testValidations.EnablePopupValidation( driver,  writer,  test);
			
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void OptionZoomTo(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_LayerListtool, "Option - LayerListtool", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_LayerONOFF, "Option - LayerONOFF", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_turnAlllayersOn, "Option - Turn All Layer ON", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", popupmenubutton, "Popup menu button", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_ZoomTo, "Popup option Zoom To", writer, test);
			Thread.sleep(1000);
			StepExecutor.ElementClick(driver, "Xpath", option_home, "Option Home", writer, test);
			
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void OptionTransperancy(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", popupmenubutton, "Popup menu button", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_Transperancy, "Option - Transperancy", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_slider, "Option - Slider", writer, test);
			WebElement sliderOption = driver.findElement(option_slider);
			StepExecutor.DrawShapeOnMap(driver, sliderOption);
			//TestResults.PrintResultToReportWithScreenshot("Layers transperancy got changed!" ,test);
			TestResults.PrintResultToReport("Layers transperancy got changed!" ,test);
			
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void OptionSetVisibilityRange(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", popupmenubutton, "Popup menu button", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_SetVisibilityRange, "Option - Transperancy", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_SetVisibilitySlider, "Option - Transperancy", writer, test);
			WebElement sliderOption = driver.findElement(option_SetVisibilitySlider);
			StepExecutor.DrawShapeOnMap(driver, sliderOption);
			//TestResults.PrintResultToReportWithScreenshot("Layers visibility range got changed!" ,test);
			TestResults.PrintResultToReport("Layers visibility range got changed!" ,test);
			
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void OptionViewInAttributeTable(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", popupmenubutton, "Popup menu button", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_ViewInAttributeTable, "Option - Transperancy", writer, test);
			Thread.sleep(2000);
			Wait.DynamicWaitToLoadElement(driver, "XPATH", text_features);
			String totalFeatures = driver.findElement(text_features).getText();
			//TestResults.PrintResultToReportWithScreenshot("Total Features found in Attribute table" + totalFeatures ,test);
			TestResults.PrintResultToReport("Total Features found in Attribute table" + totalFeatures ,test);
			
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ExpandAndCollapsAllLayer(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_LayerONOFF, "Option - LayerONOFF", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_expandalllayer, "Option - Expand All Layers", writer, test);
			//TestResults.PrintResultToReportWithScreenshot("All the layers got expanded!" ,test);
			TestResults.PrintResultToReport("All the layers got expanded!" ,test);
			StepExecutor.ElementClick(driver, "Xpath", option_LayerONOFF, "Option - LayerONOFF", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_collapsealllayer, "Option - Collapse All Layers", writer, test);
			//TestResults.PrintResultToReportWithScreenshot("All the layers got collapsed!" ,test);
			TestResults.PrintResultToReport("All the layers got collapsed!" ,test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
}
