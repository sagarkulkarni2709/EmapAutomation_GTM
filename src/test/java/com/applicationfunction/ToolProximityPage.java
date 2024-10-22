package com.applicationfunction;

import java.io.BufferedWriter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import com.test.validation.TestValidations;
import com.utilities.StepExecutor;
import com.utilities.TestInitializer;
import com.utilities.TestResults;
import com.utilities.Wait;

public class ToolProximityPage {
	
	public WebDriver driver;
	public TestValidations testValidations = new TestValidations(driver);
	
	private static By option_ProximityTool = By.xpath("(//div[contains(@settingid,'NearMe')]/div)[1]");
	private static By text_SearchAddress = By.xpath("(//div[@class='searchInputGroup']/form/input)[2]");
	private static By icon_Search = By.xpath("(//div[@title='Search'])[2]");
	private static By name_state = By.xpath("(//div[(@class= 'esriCTItemCount')]/following-sibling::div)[1]");
	private static By input_UnitValue = By.xpath("//div[@class='esriCTSliderDiv']/input");
	private static By drpdwn_Unit = By.xpath("//div[@class='esriCTSliderDiv']/table");
	private static By option_UseSelected = By.xpath("//div[@id='selectFeatureButton']");
	private static By plot_LineFeature = By.xpath("(//*[local-name() = 'svg'])[1]");
	private static By btn_closePopup = By.xpath("//div[@title='Close']");
	private static By option_SetLocation = By.xpath("//div[@title='Set location']");
	//private static By SelectGTM_TransmissionLayer = By.xpath("//div[contains(text(),'GTM_Transmission')]");
	private static By SelectGTM_TransmissionLayer = By.xpath("//div[contains(text(),'[GTM] Transmission')]");
	private static By SelectStructureLayer = By.xpath("//div[(text()='Structures')]/../../td[1]/div[3]/div");
	private static By closeLayerList = By.xpath("//div[contains(text(),'Layer List')]/../div[4]");
	private static By option_nonregulatedpolygon = By.xpath("//div[@class='esriCTItemlList']/div[(text()='Non-Regulated Structure Polygons')]");
	private static By result_nonregulatedpolygon = By.xpath("//div[@class='esriCTFeatureListContent']/div[1]");
	private static By searchResultClass = By.xpath("(//div[@class='searchMenu suggestionsMenu'])[2]");
	private static By addressSearchResult = By.xpath("//div[@class='menuHeader']/../ul/li[1]");
	//private static By addressSearchResult = By.xpath("(//*[local-name() = 'strong'])[1]");
	
	public ToolProximityPage(WebDriver driver)
	{
		super();
		this.driver = driver;
	}

	public void ClickProximityTool(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_ProximityTool, "Option - Proximity tool", writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void EnterAddress(WebDriver driver, String address, String unitName, String unitValue, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Wait.DynamicWaitToLoadElement(driver, "XPATH", text_SearchAddress);
			//StepExecutor.SetText(driver, "Xpath", input_UnitValue, "Unit Value", unitValue, writer, test);
			StepExecutor.SetText(driver, "Xpath", text_SearchAddress, "Address Field", address, writer, test);
			//StepExecutor.ElementClick(driver, "Xpath", icon_Search, "Icon - Search", writer, test);
			Thread.sleep(3000);
			//Wait.DynamicWaitToLoadElement(driver, "XPATH", searchResultClass);
			StepExecutor.ElementClick(driver, "Xpath", addressSearchResult, "Address Result", writer, test);
			Thread.sleep(2000);
			Wait.DynamicWaitToLoadElement(driver, "XPATH", name_state);
//			StepExecutor.ElementClick(driver, "Xpath", drpdwn_Unit, "DropDown - Unit", writer, test);
//			By unit_Name = By.xpath("//div[@class='dijitPopup dijitMenuPopup']/table/tbody/tr/td[contains(text(),'"+unitName+"')]");
//			StepExecutor.ElementClick(driver, "Xpath", unit_Name, "Unit Name", writer, test);
//			Wait.DynamicWaitToLoadElement(driver, "XPATH", name_state);
			//TestResults.PrintResultToReportWithScreenshot("Address is located on map with proximity tool", test);
			TestResults.PrintResultToReport("Address is located on map with proximity tool", test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void GetSearchResults(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			int i = 1;
			List<WebElement> eleList = driver.findElements(By.xpath("//div[(@class= 'esriCTItemCount')]"));
			for(WebElement ele : eleList)
			{
				Thread.sleep(2000);
				String SerachItem = driver.findElement(By.xpath("(//div[(@class= 'esriCTItemCount')]/following-sibling::div)["+i+"]")).getText().toString();
				String SearchItemCount = ele.getText().toString();
				Thread.sleep(500);
				ele.click();
				Thread.sleep(500);
				if(i==1)
					testValidations.ShapeValidation(driver, testValidations.shape_line, "Line",  writer, test);
				//TestResults.PrintResultToReportWithScreenshot("Serach Results are :- " +  SerachItem + " - " + SearchItemCount,test);
				TestResults.PrintResultToReport("Serach Results are :- " +  SerachItem + " - " + SearchItemCount,test);
				driver.findElement(By.xpath("//div[@class='esriCTFeatureList']/div/div[@class='esriCTBackButton']")).click();
				i++;
			}
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ClickUseSelected(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Thread.sleep(2000);
			StepExecutor.ElementClick(driver, "Xpath", plot_LineFeature, "Line Feature", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_UseSelected, "option -UseSelected", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", btn_closePopup, "Close Popup", writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ClickSetLocation(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_SetLocation, "option - SetLocation", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", plot_LineFeature, "Line Feature", writer, test);
			Thread.sleep(2000);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void SelectStructureLayer(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Thread.sleep(1000);
			StepExecutor.ElementClick(driver, "Xpath", SelectGTM_TransmissionLayer, "Select GTM_TransmissionLayer", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", SelectStructureLayer, "Select Structure Layer", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", closeLayerList, "Close Layer List Tool", writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void EnterAddressAndSelectPolygon(WebDriver driver, String address, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Wait.DynamicWaitToLoadElement(driver, "XPATH", text_SearchAddress);
			StepExecutor.SetText(driver, "Xpath", text_SearchAddress, "Address Field", address, writer, test);
			//StepExecutor.ElementClick(driver, "Xpath", icon_Search, "Icon - Search", writer, test);
			Thread.sleep(2000);
			Wait.DynamicWaitToLoadElement(driver, "XPATH", searchResultClass);
			Thread.sleep(3000);
			StepExecutor.ElementClick(driver, "Xpath", addressSearchResult, "Address Result", writer, test);
			Thread.sleep(3000);
			Wait.DynamicWaitToLoadElement(driver, "XPATH", name_state);
			Actions actions = new Actions(driver);
			WebElement ele = driver.findElement(option_nonregulatedpolygon);
			actions.moveToElement(ele);
			StepExecutor.ElementClick(driver, "Xpath", option_nonregulatedpolygon, "Non Regulated structure polygon", writer, test);
			Thread.sleep(1000);
			StepExecutor.ElementClick(driver, "Xpath", result_nonregulatedpolygon, "Result of Non Regulated structure polygon", writer, test);
			Thread.sleep(2000);
			//TestResults.PrintResultToReportWithScreenshot("Non Regulated Structure Polygon record is selected and zoomed to the polygon ",test);
			TestResults.PrintResultToReport("Non Regulated Structure Polygon record is selected and zoomed to the polygon ",test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
}
