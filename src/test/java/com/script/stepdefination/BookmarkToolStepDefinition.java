package com.script.stepdefination;

import com.utilities.SendReport;
import com.utilities.TestInitializer;
import com.utilities.TestResults;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookmarkToolStepDefinition extends TestInitializer {
	
	@Given("Application is launched in browser for Bookmark Tool SheetName {string} and rownumber {int}")				
    public void LaunchApplication(String SheetName , int RowNumber) throws Exception							
    {	
		System.out.println("*******************Test Case started*******************************");
		if(testCaseNo == 1)
		{
			testData = reader.getData(prop.getProperty("tesData"), "BookmarkTool");
			writer = TestResults.printToTxt(testData.get(RowNumber).get("ReportName"));
			extent = TestResults.TestReport(testData.get(RowNumber).get("ReportName"));
		}
		if(RowNumber == 0)
		{
			testData.clear();
			testData = reader.getData(prop.getProperty("tesData"), "BookmarkTool");
		}
		test = extent.createTest(testData.get(RowNumber).get("TestName") + " " + testCaseNo, "To Verify " +testData.get(RowNumber).get("TestName"));
		writer.write("\n" + "***************TestResults For" + testData.get(RowNumber).get("TestName1") + "***************");
		TestInitializer.LaunchBrowser();
    }
	
	@When("Bookmark tool is clicked and Bookmark tool is opened SheetName {string} and rownumber {int}")
	public void ClickBookmarkTool(String SheetName , int RowNumber) throws Exception
	{
		homePageObj.HomePagePopupAccept(driver, writer, test);
		//homePageObj.SearchAddress(driver, testData.get(RowNumber).get("Address"), writer,test);
		homePageObj.BackIconClick(driver, writer, test);
		toolBookmarkPage.ClickBoomarkTool(driver, writer, test);
		toolBookmarkPage.DeleteBookmark(driver, writer, test);
	}
	
	@Then("User is able to add the bookmark")
	public void AddBookmark() throws Exception
	{
		toolBookmarkPage.AddBookmark(driver, writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User is able to delete the bookmark which is added")
	public void DeleteBookmark() throws Exception
	{
		toolBookmarkPage.DeleteAddedBookmark(driver, writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User is able to edit the bookmark which is added")
	public void EditBookmark() throws Exception
	{
		toolBookmarkPage.EditAddedBookmark(driver, writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@After 
	public static void AfterTest(Scenario scenario) throws Exception
	{
		if(scenario.isFailed()){
			SendReport.fail++;
			
		}else if(scenario.getStatus().toString().equalsIgnoreCase("passed")){
			SendReport.pass++;
		}
	}
}
