package com.applicationfunction;

import java.io.BufferedWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.test.validation.TestValidations;
import com.utilities.StepExecutor;
import com.utilities.TestInitializer;
import com.utilities.TestResults;

public class ToolBookmarkPage {
	
	public WebDriver driver;
	public TestValidations testValidations = new TestValidations(driver);
	private static By option_Bookmarktool = By.xpath("(//div[contains(@settingid,'Bookmark')]/div)[1]");
	private static By icon_delete = By.xpath("//div[@title='Delete the bookmark']");
	private static By btn_Add = By.xpath("(//div[contains(text(),'Add')])[1]");
	private static By bookmark_name = By.xpath("(//div[@class='custom editing']/div[1]/div[2]/div/input)[2]");
	private static By option_home = By.xpath("//div[@class='home']");
	private static By btncrossicon_BookmarkTool = By.xpath("//div[contains(text(),'Bookmark')]/../div[4]");
	private static By bookmark_title = By.xpath("//div[@class='custom editing']/div[1]/div[1]");
	
	public ToolBookmarkPage(WebDriver driver)
	{
		super();
		this.driver = driver;
	}
	
	public void ClickBoomarkTool(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_Bookmarktool, "Option - LayerListtool", writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void DeleteBookmark(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception 
	{
		try {
			if (driver.findElement(icon_delete).isDisplayed())
				StepExecutor.ElementClick(driver, "Xpath", icon_delete, "Icon - Delete", writer, test);

		} catch (Exception e) {
		}
	}
	
	public void AddBookmark(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", btn_Add, "Button - Add", writer, test);
			StepExecutor.SetText(driver, "Xpath", bookmark_name, "Bookmark Name", "Test", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", btncrossicon_BookmarkTool, "CrossIcon - Bookmark tool", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_home, "Home button", writer, test);
			testValidations.BookmarkValidation(driver, writer, test);
			StepExecutor.ElementClick(driver, "Xpath", option_Bookmarktool, "Option - Bookmark Tool", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", bookmark_title, "Title bookmark", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", btncrossicon_BookmarkTool, "CrossIcon - Bookmark tool", writer, test);
			testValidations.BookmarkValidation(driver, writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void DeleteAddedBookmark(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", btn_Add, "Button - Add", writer, test);
			StepExecutor.SetText(driver, "Xpath", bookmark_name, "Bookmark Name", "Test", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", btncrossicon_BookmarkTool, "CrossIcon - Bookmark tool", writer, test);
			Thread.sleep(500);
			StepExecutor.ElementClick(driver, "Xpath", option_Bookmarktool, "Option - Bookmark Tool", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", icon_delete, "Delete button", writer, test);
			testValidations.BookmarkDeleteValidation(driver, writer, test);
			StepExecutor.ElementClick(driver, "Xpath", btncrossicon_BookmarkTool, "CrossIcon - Bookmark tool", writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void EditAddedBookmark(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", btn_Add, "Button - Add", writer, test);
			StepExecutor.SetText(driver, "Xpath", bookmark_name, "Bookmark Name", "Test", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", btncrossicon_BookmarkTool, "CrossIcon - Bookmark tool", writer, test);
			Thread.sleep(500);
			StepExecutor.ElementClick(driver, "Xpath", option_Bookmarktool, "Option - Bookmark Tool", writer, test);
			Thread.sleep(1000);
			StepExecutor.SetText(driver, "Xpath", bookmark_name, "Bookmark Name", "Test1", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", btncrossicon_BookmarkTool, "CrossIcon - Bookmark tool", writer, test);
			Thread.sleep(500);
			StepExecutor.ElementClick(driver, "Xpath", option_Bookmarktool, "Option - Bookmark Tool", writer, test);
			testValidations.BookmarkEditValidation(driver, "Test1", writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
}
