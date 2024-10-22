package com.applicationfunction;

import java.io.BufferedWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentTest;
import com.test.validation.TestValidations;
import com.utilities.StepExecutor;
import com.utilities.TestInitializer;
import com.utilities.TestResults;

public class ExternalToolsPage {
	
	public WebDriver driver;
	public TestValidations testValidations = new TestValidations(driver);
	
	private static By option_ExternalTool = By.xpath("(//div[contains(@settingid,'External')]/div)[1]");
	private static By link_Schematics = By.xpath("//a[contains(text(),'Schematics')]");
	private static By title_Schematics = By.xpath("//span[contains(text(),'Schematics')]");
	private static By btn_Submit = By.xpath("//input[@id='MainContent_aspBtnSubmit']");
	
	
	public ExternalToolsPage(WebDriver driver)
	{
		super();
		this.driver = driver;
	}
	
	public void ClickExternalTool(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_ExternalTool, "Option - External tool", writer, test);
			
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void VerifySchematicsPage(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", link_Schematics, "Option - Schematics", writer, test);
			Thread.sleep(1000);
			StepExecutor.SwitchTab(driver, 1);
			if((driver.findElement(title_Schematics).isDisplayed()))
				TestResults.PrintResultToReport("Schematics page is opened in seperate tab!" ,test);
			Thread.sleep(1000);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ViewSchematics(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Thread.sleep(500);
			Select BUdrpdwn = new Select(driver.findElement(By.id("MainContent_cmbBU")));
			BUdrpdwn.selectByVisibleText("TETLP");
			Thread.sleep(500);
			Select segmentdrpdwn = new Select(driver.findElement(By.id("MainContent_cmbSegment")));
			segmentdrpdwn.selectByVisibleText("WIND-WAYN ");
			Thread.sleep(500);
			Select pipelinedropdown = new Select(driver.findElement(By.id("MainContent_cmbLineType")));
			pipelinedropdown.selectByVisibleText("1-AM");
			StepExecutor.ElementClick(driver, "Xpath", btn_Submit, "BU", writer, test);
			Thread.sleep(2000);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
}
