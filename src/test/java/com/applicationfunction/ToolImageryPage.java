package com.applicationfunction;

import java.io.BufferedWriter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.applicationfunctions.common.HomePage;
import com.aventstack.extentreports.ExtentTest;
import com.test.validation.TestValidations;
import com.utilities.StepExecutor;
import com.utilities.TestInitializer;
import com.utilities.TestResults;
import com.utilities.Wait;

public class ToolImageryPage {
	
	public WebDriver driver;
	public TestValidations testValidations = new TestValidations(driver);
	public HomePage homePageObj = new HomePage(driver);
	
	private static By option_Imagerytool = By.xpath("(//div[contains(@settingid,'Imagery')]/div)[1]");
	private static By icon_basemapgallery = By.xpath("(//div[@class='widget-icon']/../following-sibling::div)[1]/div[1]");
	private static By basemap_BingRoads = By.xpath("//img[contains(@title, 'Bing Roads')]");
	private static By basemap_Streets = By.xpath("//img[contains(@title, 'Streets')]");
	private static By basemap_BingAerial = By.xpath("//img[contains(@title, 'Bing Aerial')]");
	private static By basemap_BingAerialLabel = By.xpath("//img[contains(@title, 'Bing Aerial - Label')]");
	private static By basemap_NewSoDMostRecent = By.xpath("//img[contains(@title, 'New SoD - Most Recent')]");
	private static By basemap_NewSoDBestResolution = By.xpath("//img[contains(@title, 'New SoD - Best Resolution')]");
	private static By basemap_WorldTopo = By.xpath("//img[contains(@title, 'World Topo')]");
	private static By basemap_USATopo = By.xpath("//img[contains(@title, 'USA Topo')]");
	private static By basemap_LightGrayCanvas = By.xpath("//img[contains(@title, 'Light Gray Canvas')]");
	private static By basemap_DarkGrayCanvas = By.xpath("//img[contains(@title, 'Dark Gray Canvas')]");
	private static By basemap_Oceans = By.xpath("//img[contains(@title, 'Oceans')]");
	private static By basemap_OpenStreetMap = By.xpath("//img[contains(@title, 'Open Street Map')]");
	private static By basemap_AGOWorldBasemapVector = By.xpath("//img[contains(@title, 'AGO World Basemap Vector')]");
	private static By basemap_NewSoDVivid = By.xpath("//img[contains(@title, 'New SoD - Vivid')]");
	
	private static By icon_streetviewAerial = By.xpath("(//div[@class='widget-icon']/../following-sibling::div)[1]/div[5]");
	private static By plot_LineFeature = By.xpath("//*[local-name() = 'svg']");
	private static By text_lat = By.xpath("//span[@id='lat']");
	private static By text_long = By.xpath("//span[@id='long']");
	private static By btn_OpenStreetView = By.xpath("//button[contains(text(),'Open streetview')]");
	private static By btn_Openbirdseyeview = By.xpath("//button[contains(text(),'Open bird')]");
	
	private static By icon_pictometry = By.xpath("(//div[@class='widget-icon']/../following-sibling::div)[1]/div[2]");
	private static By switchToFrame = By.xpath("//iframe[@id='pictometry_ipa']");
	private static By nextImage = By.xpath("(//a[@data-qtip='Next Image'])[1]");
	private static By btn_Close = By.xpath("//div[@title='Close']");
	
	private static By icon_MaxarImagery = By.xpath("(//div[@class='widget-icon']/../following-sibling::div)[1]/div[3]");
	
	
	public ToolImageryPage(WebDriver driver)
	{
		super();
		this.driver = driver;
	}
	
	public void ClickImageryTool(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_Imagerytool, "Option - LayerListtool", writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ClickBasemapGallery(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", icon_basemapgallery, "Icon - basemapgallery", writer, test);
			Thread.sleep(1500);
			StepExecutor.ElementClick(driver, "Xpath", basemap_BingRoads, "Basemap - Bing Roads", writer, test);
			Thread.sleep(1500);
			StepExecutor.ElementClick(driver, "Xpath", basemap_Streets, "Basemap - Streets", writer, test);
			Thread.sleep(1500);
			StepExecutor.ElementClick(driver, "Xpath", basemap_BingAerial, "Basemap - Bing Aerial", writer, test);
			Thread.sleep(1500);
			StepExecutor.ElementClick(driver, "Xpath", basemap_BingAerialLabel, "Basemap - Bing AerialLabel", writer, test);
			Thread.sleep(1500);
			/*
			 * StepExecutor.ElementClick(driver, "Xpath", basemap_NewSoDMostRecent,
			 * "Basemap - NewSoDMostRecent", writer, test); Thread.sleep(1500);
			 */
			/*
			 * StepExecutor.ElementClick(driver, "Xpath", basemap_NewSoDVivid,
			 * "Basemap - NewSoDVivid", writer, test); Thread.sleep(1500);
			 * StepExecutor.ElementClick(driver, "Xpath", basemap_NewSoDBestResolution,
			 * "Basemap - NewSoDBestResolution", writer, test); Thread.sleep(1500);
			 */
			StepExecutor.ElementClick(driver, "Xpath", basemap_WorldTopo, "Basemap - WorldTopo", writer, test);
			Thread.sleep(1500);
			StepExecutor.ElementClick(driver, "Xpath", basemap_USATopo, "Basemap - USATopo", writer, test);
			Thread.sleep(1500);
			StepExecutor.ElementClick(driver, "Xpath", basemap_LightGrayCanvas, "Basemap - LightGrayCanvas", writer, test);
			Thread.sleep(1500);
			StepExecutor.ElementClick(driver, "Xpath", basemap_DarkGrayCanvas, "Basemap - DarkGrayCanvas", writer, test);
			Thread.sleep(1500);
			StepExecutor.ElementClick(driver, "Xpath", basemap_Oceans, "Basemap - Oceans", writer, test);
			Thread.sleep(1500);
			StepExecutor.ElementClick(driver, "Xpath", basemap_OpenStreetMap, "Basemap - OpenStreetMap", writer, test);
			/*
			 * Thread.sleep(1500); StepExecutor.ElementClick(driver, "Xpath",
			 * basemap_AGOWorldBasemapVector, "Basemap - AGOWorldBasemapVector", writer,
			 * test);
			 */
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ClickStreetViewAerial(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", icon_streetviewAerial, "Icon - basemapgallery", writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ClickOpenStreetViewAerial(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", plot_LineFeature, "Plot - Line Feature", writer, test);
			
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void GetLatLongValue(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Thread.sleep(1500);
			String LatValue = driver.findElement(text_lat).getText().toString();
			TestResults.PrintResultToReport("Latitude Value is " +LatValue ,test);
			String LongValue = driver.findElement(text_long).getText().toString();
			TestResults.PrintResultToReport("Latitude Value is " +LongValue ,test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ClickOpenStreetView(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Thread.sleep(2000);
			StepExecutor.ElementClick(driver, "Xpath", btn_OpenStreetView, "Button - Openstreetview", writer, test);
			StepExecutor.SwitchTab(driver, 1);
			if(driver.getTitle().contains("Google Maps"))
				TestResults.PrintResultToReport("Open Streetview is opened in seperate tab!" ,test);
			Thread.sleep(1000);
			StepExecutor.SwitchTab(driver, 0);
			StepExecutor.ElementClick(driver, "Xpath", btn_Openbirdseyeview, "Button - Openstreetview", writer, test);
			StepExecutor.SwitchTab(driver, 2);
			if(driver.getTitle().contains("Bing Maps - Directions, trip planning, traffic cameras & more"));
				TestResults.PrintResultToReport("Open birds eye view is opened in seperate tab!" ,test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ClickPictometry(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			homePageObj.SearchAddressWithSiteType(driver, "TENNESSEE RIVER CROSSING", writer,test);
			Thread.sleep(2000);
			StepExecutor.ElementClick(driver, "Xpath", icon_pictometry, "Icon - Pictometry", writer, test);
			Thread.sleep(3000);
			StepExecutor.ElementClick(driver, "Xpath", btn_Close, "Button - Close", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", plot_LineFeature, "Plot - Line Feature", writer, test);
			TakePictures( driver,  writer,  test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void TakePictures(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Thread.sleep(2000);
			Wait.DynamicWaitToLoadElement(driver, "XPATH", switchToFrame);
			StepExecutor.switchToFrame(driver, switchToFrame);
			By picturepages = By.xpath("(//label[@id='label-1035'])[1]");
			String picturepagesLable = driver.findElement(picturepages).getText();
			if(picturepagesLable!= "" && picturepagesLable!= "NA")
			{
				String[] split = picturepagesLable.split("of");
				String firstSubString = split[0].replaceAll("\\s+","");
				String secondSubString = split[1].replaceAll("\\s+","");
				for(int i=Integer.valueOf(firstSubString); i<=Integer.valueOf(secondSubString);i++ )
				{
					if(i==1)
						//TestResults.PrintResultToReportWithScreenshot("Tool pictometry is opened and user can see the pictures in widget after plotting points on map ", test);
						TestResults.PrintResultToReport("Tool pictometry is opened and user can see the pictures in widget after plotting points on map ", test);
					else
					{
						Thread.sleep(500);
						StepExecutor.ElementClick(driver, "Xpath", nextImage, "Next Image", writer, test);
						//TestResults.PrintResultToReportWithScreenshot("Tool pictometry is opened and user can see the pictures in widget after plotting points on map ", test);
						TestResults.PrintResultToReport("Tool pictometry is opened and user can see the pictures in widget after plotting points on map ", test);
					}
				}
			}
			else
				//TestResults.PrintResultToReportWithScreenshot("Tool pictometry is opened and user can see the pictures in widget after plotting points on map " ,test);
				TestResults.PrintResultToReport("Tool pictometry is opened and user can see the pictures in widget after plotting points on map " ,test);
			
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ClickMaxarImgery(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			homePageObj.SearchAddressWithSiteType(driver, "TENNESSEE RIVER CROSSING", writer,test);
			StepExecutor.ElementClick(driver, "Xpath", icon_MaxarImagery, "Icon - Maxar Imagery", writer, test);
			Thread.sleep(3000);
			StepExecutor.ElementClick(driver, "Xpath", btn_Close, "Button - Close", writer, test);
			checkBoxLayer(driver, writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void checkBoxLayer(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			List<WebElement> checkBoxLayertItems = driver.findElements(By.xpath("//input[@type='checkbox']"));
			for(WebElement ele :checkBoxLayertItems) {
				ele.click();
				Thread.sleep(500);
				//TestResults.PrintResultToReportWithScreenshot("Layer is selected to add on Map " ,test);
				TestResults.PrintResultToReport("Layer is selected to add on Map " ,test);
				ele.click();
			}
			
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
}
