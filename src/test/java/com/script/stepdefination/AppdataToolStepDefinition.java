package com.script.stepdefination;

import com.utilities.SendReport;
import com.utilities.TestInitializer;
import com.utilities.TestResults;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AppdataToolStepDefinition extends TestInitializer{
	
	@Given("Application is launched in browser for Appdata Tool SheetName {string} and rownumber {int}")				
    public void LaunchApplication(String SheetName , int RowNumber) throws Exception							
    {	
		System.out.println("*******************Test Case started*******************************");
		if(testCaseNo == 1)
		{
			testData = reader.getData(prop.getProperty("tesData"), "AppdataTool");
			writer = TestResults.printToTxt(testData.get(RowNumber).get("ReportName"));
			extent = TestResults.TestReport(testData.get(RowNumber).get("ReportName"));
		}
		if(RowNumber == 0)
		{
			testData.clear();
			testData = reader.getData(prop.getProperty("tesData"), "AppdataTool");
		}
		test = extent.createTest(testData.get(RowNumber).get("TestName") + " " + testCaseNo, "To Verify " +testData.get(RowNumber).get("TestName"));
		writer.write("\n" + "***************TestResults For" + testData.get(RowNumber).get("TestName") + "***************");
		TestInitializer.LaunchBrowser();
    }
	
	@When("Appdata tool is clicked and tool is opened")
	public void ClickSelectTool() throws Exception
	{
		homePageObj.HomePagePopupAccept(driver, writer, test);
		homePageObj.BackIconClick(driver, writer, test);
		toolAppdataPage.ClickAppdataTool(driver, writer, test);
	}
	
	@Then("User should be able to add data from a web URL in Appdata tool SheetName {string} and rownumber {int}")
	public void AddDataFromWebURL(String SheetName , int RowNumber) throws Exception
	{
		toolAppdataPage.ClickURLSection( driver, testData.get(RowNumber).get("TypeDrpdwn"),  writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to add data using serach section in Appdata tool SheetName {string} and rownumber {int}")
	public void AddDataFromSearch(String SheetName , int RowNumber) throws Exception
	{
		toolAppdataPage.ClickSearchSection(driver, testData.get(RowNumber).get("RegionDropDownItem"), testData.get(RowNumber).get("SearchService"),  writer,  test);
		TestInitializer.IncrementTestCaseNumber();
	}
}
