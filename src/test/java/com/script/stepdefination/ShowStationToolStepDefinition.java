package com.script.stepdefination;

import com.utilities.SendReport;
import com.utilities.TestInitializer;
import com.utilities.TestResults;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShowStationToolStepDefinition extends TestInitializer{
	
	@Given("Application is launched in browser for Show Station Tools SheetName {string} and rownumber {int}")				
    public void LaunchApplication(String SheetName , int RowNumber) throws Exception							
    {	
		System.out.println("*******************Test Case started*******************************");
		if(testCaseNo == 1)
		{
			testData = reader.getData(prop.getProperty("tesData"), "ShowStationTool");
			writer = TestResults.printToTxt(testData.get(RowNumber).get("ReportName"));
			extent = TestResults.TestReport(testData.get(RowNumber).get("ReportName"));
		}
		if(RowNumber == 0)
		{
			testData.clear();
			testData = reader.getData(prop.getProperty("tesData"), "ShowStationTool");
		}
		test = extent.createTest(testData.get(RowNumber).get("TestName") + " " + testCaseNo, "To Verify " +testData.get(RowNumber).get("TestName"));
		writer.write("\n" + "***************TestResults For" + testData.get(RowNumber).get("TestName") + "***************");
		TestInitializer.LaunchBrowser();
    }
	
	@When("Show Station tool is clicked and tool is opened SheetName {string} and rownumber {int}")
	public void ClickShowStationTool(String SheetName , int RowNumber) throws Exception
	{
		homePageObj.HomePagePopupAccept(driver, writer, test);
		homePageObj.BackIconClick(driver, writer, test);
		toolShowStationPage.ClickShowStationTool(driver, testData.get(RowNumber).get("Address"), writer, test);
	}
	
	@Then("User should be able to see the station details using show station tool SheetName {string} and rownumber {int}")
	public void ShowStationDetails(String SheetName , int RowNumber) throws Exception
	{
		toolShowStationPage.ShowStationDetails(driver, testData.get(RowNumber).get("Address"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
}
