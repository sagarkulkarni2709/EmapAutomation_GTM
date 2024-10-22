package com.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import com.applicationfunction.ExternalToolsPage;
import com.applicationfunction.PopupFunctions;
import com.applicationfunction.RestAPIFunctions;
import com.applicationfunction.ToolAppdataPage;
import com.applicationfunction.ToolAttributeTablePage;
import com.applicationfunction.ToolBookmarkPage;
import com.applicationfunction.ToolDirectionsPage;
import com.applicationfunction.ToolElevationProfilePage;
import com.applicationfunction.ToolEnhancedDrawPage;
import com.applicationfunction.ToolImageryPage;
import com.applicationfunction.ToolInlinePage;
import com.applicationfunction.ToolLayerListPage;
import com.applicationfunction.ToolLocatorPage;
import com.applicationfunction.ToolMeasurementPage;
import com.applicationfunction.ToolPrintPage;
import com.applicationfunction.ToolProximityPage;
import com.applicationfunction.ToolSelectPage;
import com.applicationfunction.ToolShowStationPage;
import com.applicationfunctions.common.HomePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestInitializer {
	
	public static WebDriver driver;
	public static BufferedWriter writer;
	public static ExtentTest test;
	public static ExtentTest test1;
	public static ExtentReports extent;
	//public static Scenario scenario;
	public static Map<String, Object[]> studentData;
	public static String TestName;
	public static int testCaseNo = 1;
	public static Properties prop = new Properties();
	public static Properties propConfig = new Properties();
	public static ExtentHtmlReporter htmlReporter = null;
	public static List<Map<String,String>> testData;
	public ExcelReader reader = new ExcelReader();
	public HomePage homePageObj = new HomePage(driver);
	public ToolLayerListPage toolLayerListPage = new ToolLayerListPage(driver);
	public ToolBookmarkPage toolBookmarkPage = new ToolBookmarkPage(driver);
	public ToolImageryPage toolImageryPage = new ToolImageryPage(driver);
	public ToolEnhancedDrawPage toolEnhancedDrawPage = new ToolEnhancedDrawPage(driver);
	public ToolElevationProfilePage toolElevationProfilePage = new ToolElevationProfilePage(driver);
	public ToolMeasurementPage toolMeasurementPage = new ToolMeasurementPage(driver);
	public ToolLocatorPage toolLocatorPage = new ToolLocatorPage(driver);
	public ToolProximityPage toolProximityPage = new ToolProximityPage(driver);
	public ToolDirectionsPage toolDirectionsPage = new ToolDirectionsPage(driver);
	public ToolSelectPage toolSelectPage = new ToolSelectPage(driver);
	public ToolAppdataPage toolAppdataPage = new ToolAppdataPage(driver);
	public ToolAttributeTablePage toolAttributeTablePage = new ToolAttributeTablePage(driver);
	public RestAPIFunctions restAPIFunctions = new RestAPIFunctions(driver);
	public ToolInlinePage toolInlinePage = new ToolInlinePage(driver);
	public ToolPrintPage toolPrintPage = new ToolPrintPage(driver);
	public ToolShowStationPage toolShowStationPage = new ToolShowStationPage(driver);
	public PopupFunctions popupFunctions = new PopupFunctions(driver);
	public ExternalToolsPage externaltoolPage = new ExternalToolsPage(driver);
	
	public static void LaunchBrowser() throws Exception
	{
		try {
			switch (prop.getProperty("BrowserType").toUpperCase())
			{
			case "CHROME":
				WebDriverManager.chromedriver().clearResolutionCache().setup();
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setAcceptInsecureCerts(true);
				ChromeOptions options = new ChromeOptions();
				if (prop.getProperty("HeadlessMode").toUpperCase().equals("TRUE")  ) {
					//options.addArguments("--incognito");
					options.addArguments("--headless");
					options.addArguments("window-size=1200,1100");
					options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
				}
				options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
				options.merge(caps);
				System.setProperty("webdriver.http.factory", "jdk-http-client");
				driver= new ChromeDriver(options);
				driver.manage().window().maximize();
				break;
			case "IE":
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				break;
			case "FIREFOX":
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
			case "EDGE" :
				System.setProperty("webdriver.edge.driver", "C:\\Users\\kulkars2\\Documents\\Java\\JavaWorkSpace\\AutomationPOCForEnbridge\\Drivers\\msedgedriver.exe"); 
				EdgeOptions edgeOptions = new EdgeOptions();
				edgeOptions.addArguments("--start-maximized");
				edgeOptions.addArguments("-inprivate");
				driver = new EdgeDriver(edgeOptions);
			default:
				break;
			}
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
		LaunchApplication();
	}
	
	public static void LaunchApplication() throws Exception 
	{
		try {
			driver.get(prop.getProperty("AppURL"));
			TestResults.WriteTestContext("Application successfully.", writer);
			TestResults.PrintResultToReport("Application launched successfully.", test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public static void ReadData() 
	{
		File file = new File("./datafile.properties");
		FileInputStream fileInput = null;
		try 
		{
			fileInput = new FileInputStream(file);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		try 
		{
			prop.load(fileInput);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		ReadDataConfig();
	}
	
	public static void ReadDataConfig() 
	{
		File file = new File("./config.properties");
		FileInputStream fileInput = null;
		try 
		{
			fileInput = new FileInputStream(file);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		try 
		{
			propConfig.load(fileInput);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}	
	}
	
	public static void IncrementTestCaseNumber() throws Exception
	{
		testCaseNo++;
		driver.quit();
	}
	
	public static void IncrementTestCaseNumberwithoutDriver() throws Exception
	{
		testCaseNo++;
	}
	
	public static void CopyLatestFileToProjectFolder()
	{
		String projectPath = System.getProperty("user.dir");
		File latestGeneratedPropertiesFile = new File("//usops//Operations//FME_Processes//FME_InputOutput//Test//EMapUIAutomationRegressionTestReport//TestFiles//datafile.properties");
		File dest = new File(projectPath + "//datafile.properties");
		try {
			if(latestGeneratedPropertiesFile.exists())
				FileUtils.copyFile(latestGeneratedPropertiesFile, dest);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
}
