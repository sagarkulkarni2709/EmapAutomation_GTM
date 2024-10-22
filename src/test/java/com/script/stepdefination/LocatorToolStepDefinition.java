package com.script.stepdefination;

import com.utilities.SendReport;
import com.utilities.TestInitializer;
import com.utilities.TestResults;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LocatorToolStepDefinition extends TestInitializer{
	
	@Given("Application is launched in browser for Locator Tool SheetName {string} and rownumber {int}")				
    public void LaunchApplication(String SheetName , int RowNumber) throws Exception							
    {	
		System.out.println("*******************Test Case started*******************************");
		if(testCaseNo == 1)
		{
			testData = reader.getData(prop.getProperty("tesData"), "LocatorTool");
			writer = TestResults.printToTxt(testData.get(RowNumber).get("ReportName"));
			extent = TestResults.TestReport(testData.get(RowNumber).get("ReportName"));
		}
		if(RowNumber == 0)
		{
			testData.clear();
			testData = reader.getData(prop.getProperty("tesData"), "LocatorTool");
		}
		test = extent.createTest(testData.get(RowNumber).get("TestName") + " " + testCaseNo, "To Verify " +testData.get(RowNumber).get("TestName"));
		writer.write("\n" + "***************TestResults For" + testData.get(RowNumber).get("TestName") + "***************");
		TestInitializer.LaunchBrowser();
    }
	
	@When("Locator tool is clicked and tool is opened")
	public void ClickLocatorTool() throws Exception
	{
		homePageObj.HomePagePopupAccept(driver, writer, test);
		homePageObj.BackIconClick(driver, writer, test);
		toolLocatorPage.ClickLocatorTool(driver, writer, test);
	}
	
	@Then("User should be able to use Segment Route serach option to locate an asset, location on the pipeline, or Compliance feature SheetName {string} and rownumber {int}")
	public void LocatewithSegmentRoute(String SheetName , int RowNumber) throws Exception
	{
		toolLocatorPage.ClickSearchOptionIcon(driver, testData.get(RowNumber).get("SearchOptionName"), writer, test);
		toolLocatorPage.SelectBusinessUnit(driver, testData.get(RowNumber).get("BusinessUnit"), writer, test);
		toolLocatorPage.SelectSegment(driver, testData.get(RowNumber).get("Segment"), writer, test);
		toolLocatorPage.ClickLocateBtn(driver, writer, test);
		toolLocatorPage.PrintLocatorToolResultToReport(driver, testData.get(RowNumber).get("SearchOptionName"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to use Valve Section serach option to locate an asset, location on the pipeline, or Compliance feature SheetName {string} and rownumber {int}")
	public void LocatewithValveSelection(String SheetName , int RowNumber) throws Exception
	{
		toolLocatorPage.ClickSearchOptionIcon(driver, testData.get(RowNumber).get("SearchOptionName"), writer, test);
		toolLocatorPage.SelectBusinessUnit(driver, testData.get(RowNumber).get("BusinessUnit"), writer, test);
		toolLocatorPage.SelectSegment(driver, testData.get(RowNumber).get("Segment"), writer, test);
		toolLocatorPage.SelectPipeline(driver, testData.get(RowNumber).get("Pipeline"), writer, test);
		toolLocatorPage.SelectValveSection(driver, testData.get(RowNumber).get("ValveSection"), writer, test);
		toolLocatorPage.ClickLocateBtn(driver, writer, test);
		toolLocatorPage.PrintLocatorToolResultToReport(driver, testData.get(RowNumber).get("SearchOptionName"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to use Station Site serach option to locate an asset, location on the pipeline, or Compliance feature SheetName {string} and rownumber {int}")
	public void LocatewithStationSite(String SheetName , int RowNumber) throws Exception
	{
		toolLocatorPage.ClickSearchOptionIcon(driver, testData.get(RowNumber).get("SearchOptionName"), writer, test);
		toolLocatorPage.SelectBusinessUnit(driver, testData.get(RowNumber).get("BusinessUnit"), writer, test);
		toolLocatorPage.SelectStationSite(driver, testData.get(RowNumber).get("Site"), writer, test);
		toolLocatorPage.ClickLocateBtn(driver, writer, test);
		toolLocatorPage.PrintLocatorToolResultToReport(driver, testData.get(RowNumber).get("SearchOptionName"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to use Meter Station serach option to locate an asset, location on the pipeline, or Compliance feature SheetName {string} and rownumber {int}")
	public void LocatewithMeterStation(String SheetName , int RowNumber) throws Exception
	{
		toolLocatorPage.ClickSearchOptionIcon(driver, testData.get(RowNumber).get("SearchOptionName"), writer, test);
		toolLocatorPage.SelectBusinessUnit(driver, testData.get(RowNumber).get("BusinessUnit"), writer, test);
		toolLocatorPage.SelectSegment(driver, testData.get(RowNumber).get("Segment"), writer, test);
		toolLocatorPage.SelectPipeline(driver, testData.get(RowNumber).get("Site"), writer, test);
		toolLocatorPage.ClickLocateBtn(driver, writer, test);
		toolLocatorPage.PrintLocatorToolResultToReport(driver, testData.get(RowNumber).get("SearchOptionName"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to use Valve Site serach option to locate an asset, location on the pipeline, or Compliance feature SheetName {string} and rownumber {int}")
	public void LocatewithValveSite(String SheetName , int RowNumber) throws Exception
	{
		toolLocatorPage.ClickSearchOptionIcon(driver, testData.get(RowNumber).get("SearchOptionName"), writer, test);
		toolLocatorPage.SelectBusinessUnit(driver, testData.get(RowNumber).get("BusinessUnit"), writer, test);
		toolLocatorPage.SelectSegment(driver, testData.get(RowNumber).get("Segment"), writer, test);
		toolLocatorPage.SelectPipeline(driver, testData.get(RowNumber).get("Site"), writer, test);
		toolLocatorPage.ClickLocateBtn(driver, writer, test);
		toolLocatorPage.PrintLocatorToolResultToReport(driver, testData.get(RowNumber).get("SearchOptionName"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to use Valve serach option to locate an asset, location on the pipeline, or Compliance feature SheetName {string} and rownumber {int}")
	public void LocatewithValve(String SheetName , int RowNumber) throws Exception
	{
		toolLocatorPage.ClickSearchOptionIcon(driver, testData.get(RowNumber).get("SearchOptionName"), writer, test);
		toolLocatorPage.SelectBusinessUnit(driver, testData.get(RowNumber).get("BusinessUnit"), writer, test);
		toolLocatorPage.SelectSegment(driver, testData.get(RowNumber).get("Segment"), writer, test);
		toolLocatorPage.SelectPipeline(driver, testData.get(RowNumber).get("Pipeline"), writer, test);
		toolLocatorPage.SelectValveSection(driver, testData.get(RowNumber).get("ValveSection"), writer, test);
		toolLocatorPage.ClickLocateBtn(driver, writer, test);
		toolLocatorPage.PrintLocatorToolResultToReport(driver, testData.get(RowNumber).get("SearchOptionName"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to use HCA serach option to locate an asset, location on the pipeline, or Compliance feature SheetName {string} and rownumber {int}")
	public void LocatewithHCA(String SheetName , int RowNumber) throws Exception
	{
		toolLocatorPage.ClickSearchOptionIcon(driver, testData.get(RowNumber).get("SearchOptionName"), writer, test);
		toolLocatorPage.SelectBusinessUnit(driver, testData.get(RowNumber).get("BusinessUnit"), writer, test);
		toolLocatorPage.SelectSegment(driver, testData.get(RowNumber).get("Segment"), writer, test);
		toolLocatorPage.SelectPipeline(driver, testData.get(RowNumber).get("HCAID"), writer, test);
		toolLocatorPage.ClickLocateBtn(driver, writer, test);
		toolLocatorPage.PrintLocatorToolResultToReport(driver, testData.get(RowNumber).get("SearchOptionName"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
}
