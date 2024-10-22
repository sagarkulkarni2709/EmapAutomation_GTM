package com.applicationfunction;

import java.io.BufferedWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.applicationfunctions.common.HomePage;
import com.aventstack.extentreports.ExtentTest;
import com.test.validation.TestValidations;
import com.utilities.StepExecutor;
import com.utilities.TestInitializer;
import com.utilities.TestResults;
import com.utilities.Wait;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToolPrintPage {
	
	public WebDriver driver;
	public TestValidations testValidations = new TestValidations(driver);
	public HomePage homePageObj = new HomePage(driver);
	
	private static By option_PrintTool = By.xpath("(//div[contains(@settingid,'Print')]/div)[1]");
	private static By drpdwn_Layout = By.xpath("(//td[contains(text(),'Layout')]/following-sibling::td)[1]");
	private static By drpdwn_Format = By.xpath("(//td[contains(text(),'Format')]/following-sibling::td)[1]");
	private static By btn_Print = By.xpath("(//div[text()='Print'])[1]");
	private static By btn_Attribute = By.xpath("//div[contains(text(),'Attributes')]");
	private static By print_closebutton = By.xpath("(//div[contains(text(),'Print')]/../div[4])[1]");
	private static By btn_ClearPrint = By.xpath("//div[@class='buttonActionBar']/div");
	
	
	
	public ToolPrintPage(WebDriver driver)
	{
		super();
		this.driver = driver;
	}
	
	public void ClickPrintTool(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_PrintTool, "Option - Print tool", writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void PrintForEnbridgeTemplateLayout(WebDriver driver, String LayoutItem, boolean AttributeFlag, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Thread.sleep(1000);
			StepExecutor.ElementClick(driver, "Xpath", drpdwn_Layout, "DropDown - Layout", writer, test);
			Thread.sleep(2500);
			By drpdwn_LayoutItem = By.xpath("(//td[contains(text(),'"+LayoutItem+"')])[1]");
			StepExecutor.ElementClick(driver, "Xpath", drpdwn_LayoutItem, "DropDown Layout item", writer, test);
			
			if(AttributeFlag)
			{
				AttributeTemplate(driver, writer, test);
			}
			
			int i =1;
			StepExecutor.ElementClick(driver, "Xpath", drpdwn_Format, "DropDown - Format", writer, test);
			List<WebElement> listFormatItems = driver.findElements(By.xpath("(//tbody[@class='dijitReset'])[3]/tr/td[2]"));
			for(WebElement ele :listFormatItems) {
				Thread.sleep(1000);
				if(i!=1) 
					StepExecutor.ElementClick(driver, "Xpath", drpdwn_Format, "DropDown - Format", writer, test);
				ele.click();
				String textItem = driver.findElement(By.xpath("(//td[contains(text(),'Format')])/../td[2]//div[1]/span")).getText().toString();
				Thread.sleep(1000);
				StepExecutor.ElementClick(driver, "Xpath", btn_Print, "DropDown Layout item", writer, test);
				By ArcGisWebMapItem = By.xpath("//span[contains(text(),'ArcGIS Web Map')]");
				Wait.waitForProgressBarToDisspear(driver);
				Thread.sleep(8000);
				Wait.DynamicWaitToLoadElement(driver, "XPATH", ArcGisWebMapItem);
				WebElement element = driver.findElement(ArcGisWebMapItem);
				StepExecutor.ScrollToElement(driver, element);
				element.click();
				Thread.sleep(3000);
				if(i!=1)
					StepExecutor.SwitchTab(driver, i-1);
				//TestResults.PrintResultToReportWithScreenshot("Format - "+textItem+"  is printed successfully" ,test);
				TestResults.PrintResultToReport("Format - "+textItem+"  is printed successfully" ,test);
				Thread.sleep(2000);
				StepExecutor.SwitchTab(driver, 0);
				i = i+1;
				StepExecutor.ElementClick(driver, "Xpath", btn_ClearPrint, "Clear Print Button", writer, test);
			}
			
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void AttributeTemplate(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", print_closebutton, "Print Close Icon", writer, test);
			homePageObj.SearchAddressWithSiteType(driver, "TENNESSEE RIVER CROSSING", writer,test);
			StepExecutor.ElementClick(driver, "Xpath", option_PrintTool, "Option - Measurement tool", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", btn_Attribute, "Attribute Button", writer, test);
			List<WebElement> listAttributeItems = driver.findElements(By.xpath("(//div[@class='dijitTooltipContainer'])[3]//input"));
			for(WebElement ele :listAttributeItems) {
				ele.click();
			}
			StepExecutor.ElementClick(driver, "Xpath", btn_Attribute, "Attribute Button", writer, test);
			
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
}
