package com.applicationfunction;

import java.io.BufferedWriter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.applicationfunctions.common.HomePage;
import com.aventstack.extentreports.ExtentTest;
import com.utilities.StepExecutor;
import com.utilities.TestInitializer;
import com.utilities.TestResults;

public class ToolShowStationPage {
	
	public WebDriver driver;
	public HomePage homePageObj = new HomePage(driver);
	
	private static By option_ShowStationTool = By.xpath("(//div[contains(@settingid,'WorkflowRunner')])[1]");
	private static By btn_Close = By.xpath("//div[@title='Close']");
	private static By plot_LineFeature = By.xpath("//*[local-name() = 'svg']");
	
	public ToolShowStationPage(WebDriver driver)
	{
		super();
		this.driver = driver;
	}

	public void ClickShowStationTool(WebDriver driver, String Address,BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			homePageObj.SearchAddressWithSiteType(driver, Address, writer,test);
			StepExecutor.ElementClick(driver, "Xpath", btn_Close, "Button - Close", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_ShowStationTool, "Option - Proximity tool", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", btn_Close, "Button - Close", writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ShowStationDetails(WebDriver driver, String Address, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", plot_LineFeature, "Plot - Line Feature", writer, test);
			Thread.sleep(2000);
			//TestResults.PrintResultToReportWithScreenshot("Below are the station details - ", test);
			TestResults.PrintResultToReport("Below are the station details - ", test);
			List<WebElement> staionDetails = driver.findElements(By.xpath("//aside[@id='gcx-forms-text1-11-description']/p"));
			for(WebElement ele :staionDetails) {
				//WebElement eleValue = ele.findElement(By.tagName("strong"));
				TestResults.PrintResultToReport(ele.getText() ,test);
			}
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
}
