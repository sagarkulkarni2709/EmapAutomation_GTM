package com.script.stepdefination;

import com.utilities.SendReport;
import com.utilities.TestInitializer;
import com.utilities.TestResults;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InlineToolStepDefinition extends TestInitializer{
	
	@Given("Application is launched in browser for Inline Tool SheetName {string} and rownumber {int}")				
    public void LaunchApplication(String SheetName , int RowNumber) throws Exception							
    {	
		System.out.println("*******************Test Case started*******************************");
		if(testCaseNo == 1)
		{
			testData = reader.getData(prop.getProperty("tesData"), "InlineTool");
			writer = TestResults.printToTxt(testData.get(RowNumber).get("ReportName"));
			extent = TestResults.TestReport(testData.get(RowNumber).get("ReportName"));
		}
		if(RowNumber == 0)
		{
			testData.clear();
			testData = reader.getData(prop.getProperty("tesData"), "InlineTool");
		}
		test = extent.createTest(testData.get(RowNumber).get("TestName") + " " + testCaseNo, "To Verify " +testData.get(RowNumber).get("TestName"));
		writer.write("\n" + "***************TestResults For" + testData.get(RowNumber).get("TestName") + "***************");
		TestInitializer.LaunchBrowser();
    }
	
	@When("Inline tool is clicked and tool is opened SheetName {string} and rownumber {int}")
	public void ClickInlineTool(String SheetName , int RowNumber) throws Exception
	{
		homePageObj.HomePagePopupAccept(driver, writer, test);
		homePageObj.SearchAddress(driver, testData.get(RowNumber).get("Address"), writer,test);
		homePageObj.BackIconClick(driver, writer, test);
		toolInlinePage.ClickInlineTool(driver, writer, test);
	}
	
	@Then("User can able to view data loads in inline widget and red x drawn on map after selecting two points on layer")
	public void InlineToolFunctionality() throws Exception
	{
		toolInlinePage.ClickRestoreOfInline(driver, writer, test);
		toolInlinePage.ClickOnDrawnPointAgain(driver, writer,test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
}
