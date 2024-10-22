package com.script.stepdefination;

import com.utilities.SendReport;
import com.utilities.TestInitializer;
import com.utilities.TestResults;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ElevationProfileToolStepDefinition extends TestInitializer{
	
	@Given("Application is launched in browser for Elevation profile Tool SheetName {string} and rownumber {int}")				
    public void LaunchApplication(String SheetName , int RowNumber) throws Exception							
    {	
		System.out.println("*******************Test Case started*******************************");
		if(testCaseNo == 1)
		{
			testData = reader.getData(prop.getProperty("tesData"), "ElevationProfileTool");
			writer = TestResults.printToTxt(testData.get(RowNumber).get("ReportName"));
			extent = TestResults.TestReport(testData.get(RowNumber).get("ReportName"));
		}
		if(RowNumber == 0)
		{
			testData.clear();
			testData = reader.getData(prop.getProperty("tesData"), "ElevationProfileTool");
		}
		test = extent.createTest(testData.get(RowNumber).get("TestName") + " " + testCaseNo, "To Verify " +testData.get(RowNumber).get("TestName"));
		writer.write("\n" + "***************TestResults For" + testData.get(RowNumber).get("TestName") + "***************");
		TestInitializer.LaunchBrowser();
    }
	
	@When("Elevation Profile tool is clicked and tool is opened")
	public void ClickElevationProfileTool() throws Exception
	{
		homePageObj.HomePagePopupAccept(driver, writer, test);
		homePageObj.BackIconClick(driver, writer, test);
		toolElevationProfilePage.ClickElevationProfileTool(driver, writer, test);
	}
	
	@Then("User should be able generate elevation profile with measurement unit Miles and also should be able to use profile result option SheetName {string} and rownumber {int}")
	public void ChangeUnitAndDrawLineMiles(String SheetName , int RowNumber) throws Exception
	{
		toolElevationProfilePage.ChangeUnitAndDrawLine(driver, testData.get(RowNumber).get("UnitName"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able generate elevation profile with measurement unit Kilometers and also should be able to use profile result option SheetName {string} and rownumber {int}")
	public void ChangeUnitAndDrawLineKilometers(String SheetName , int RowNumber) throws Exception
	{
		toolElevationProfilePage.ChangeUnitAndDrawLine(driver, testData.get(RowNumber).get("UnitName"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able generate elevation profile with measurement unit Feet and also should be able to use profile result option SheetName {string} and rownumber {int}")
	public void ChangeUnitAndDrawLineFeet(String SheetName , int RowNumber) throws Exception
	{
		toolElevationProfilePage.ChangeUnitAndDrawLine(driver, testData.get(RowNumber).get("UnitName"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able generate elevation profile with measurement unit Feet US and also should be able to use profile result option SheetName {string} and rownumber {int}")
	public void ChangeUnitAndDrawLineFeetUS(String SheetName , int RowNumber) throws Exception
	{
		toolElevationProfilePage.ChangeUnitAndDrawLine(driver, testData.get(RowNumber).get("UnitName"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able generate elevation profile with measurement unit Meters and also should be able to use profile result option SheetName {string} and rownumber {int}")
	public void ChangeUnitAndDrawLineMeters(String SheetName , int RowNumber) throws Exception
	{
		toolElevationProfilePage.ChangeUnitAndDrawLine(driver, testData.get(RowNumber).get("UnitName"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able generate elevation profile with measurement unit Yards and also should be able to use profile result option SheetName {string} and rownumber {int}")
	public void ChangeUnitAndDrawLineYards(String SheetName , int RowNumber) throws Exception
	{
		toolElevationProfilePage.ChangeUnitAndDrawLine(driver, testData.get(RowNumber).get("UnitName"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able generate elevation profile with measurement unit Nautical Miles and also should be able to use profile result option SheetName {string} and rownumber {int}")
	public void ChangeUnitAndDrawLineNauticalMiles(String SheetName , int RowNumber) throws Exception
	{
		toolElevationProfilePage.ChangeUnitAndDrawLine(driver, testData.get(RowNumber).get("UnitName"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
}
