package com.script.stepdefination;

import com.utilities.SendReport;
import com.utilities.TestInitializer;
import com.utilities.TestResults;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MeasurementToolStepDefinition extends TestInitializer{
	
	@Given("Application is launched in browser for Measurement Tool SheetName {string} and rownumber {int}")				
    public void LaunchApplication(String SheetName , int RowNumber) throws Exception							
    {	
		System.out.println("*******************Test Case started*******************************");
		if(testCaseNo == 1)
		{
			testData = reader.getData(prop.getProperty("tesData"), "MeasurementTool");
			writer = TestResults.printToTxt(testData.get(RowNumber).get("ReportName"));
			extent = TestResults.TestReport(testData.get(RowNumber).get("ReportName"));
		}
		if(RowNumber == 0)
		{
			testData.clear();
			testData = reader.getData(prop.getProperty("tesData"), "MeasurementTool");
		}
		test = extent.createTest(testData.get(RowNumber).get("TestName") + " " + testCaseNo, "To Verify " +testData.get(RowNumber).get("TestName"));
		writer.write("\n" + "***************TestResults For" + testData.get(RowNumber).get("TestName") + "***************");
		TestInitializer.LaunchBrowser();
    }
	
	@When("Measurement tool is clicked and tool is opened")
	public void ClickMeasurementTool() throws Exception
	{
		homePageObj.HomePagePopupAccept(driver, writer, test);
		homePageObj.BackIconClick(driver, writer, test);
		toolMeasurementPage.ClickMeasurementTool(driver, writer, test);
	}
	
	@Then("User should be able to measure distance in Acres unit with measurement tool option Area SheetName {string} and rownumber {int}")
	public void MeasureDistanceInAcres(String SheetName , int RowNumber) throws Exception
	{
		toolMeasurementPage.ClickAreaOptionAndDraw(driver, testData.get(RowNumber).get("UnitName"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to measure distance in Sq Miles unit with measurement tool option Area SheetName {string} and rownumber {int}")
	public void MeasureDistanceInSqMiles(String SheetName , int RowNumber) throws Exception
	{
		toolMeasurementPage.ClickAreaOptionAndDraw(driver, testData.get(RowNumber).get("UnitName"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to measure distance in Sq Kilometers unit with measurement tool option Area SheetName {string} and rownumber {int}")
	public void MeasureDistanceInSqKilometers(String SheetName , int RowNumber) throws Exception
	{
		toolMeasurementPage.ClickAreaOptionAndDraw(driver, testData.get(RowNumber).get("UnitName"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to measure distance in Hectares unit with measurement tool option Area SheetName {string} and rownumber {int}")
	public void MeasureDistanceInHectares(String SheetName , int RowNumber) throws Exception
	{
		toolMeasurementPage.ClickAreaOptionAndDraw(driver, testData.get(RowNumber).get("UnitName"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to measure distance in Sq Yards unit with measurement tool option Area SheetName {string} and rownumber {int}")
	public void MeasureDistanceInSqYards(String SheetName , int RowNumber) throws Exception
	{
		toolMeasurementPage.ClickAreaOptionAndDraw(driver, testData.get(RowNumber).get("UnitName"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to measure distance in Sq Feet unit with measurement tool option Area SheetName {string} and rownumber {int}")
	public void MeasureDistanceInSqFeet(String SheetName , int RowNumber) throws Exception
	{
		toolMeasurementPage.ClickAreaOptionAndDraw(driver, testData.get(RowNumber).get("UnitName"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to measure distance in Sq Feet US unit with measurement tool option Area SheetName {string} and rownumber {int}")
	public void MeasureDistanceInSqFeetUS(String SheetName , int RowNumber) throws Exception
	{
		toolMeasurementPage.ClickAreaOptionAndDraw(driver, testData.get(RowNumber).get("UnitName"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to measure distance in Sq Meters unit with measurement tool option Area SheetName {string} and rownumber {int}")
	public void MeasureDistanceInSqMeters(String SheetName , int RowNumber) throws Exception
	{
		toolMeasurementPage.ClickAreaOptionAndDraw(driver, testData.get(RowNumber).get("UnitName"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to measure distance in Miles unit with measurement tool option Distance SheetName {string} and rownumber {int}")
	public void MeasureDistanceInMiles(String SheetName , int RowNumber) throws Exception
	{
		toolMeasurementPage.ClickDistanceOptionAndDraw(driver, testData.get(RowNumber).get("UnitNameDistance"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to measure distance in Kilometers unit with measurement tool option Distance SheetName {string} and rownumber {int}")
	public void MeasureDistanceInKilometers(String SheetName , int RowNumber) throws Exception
	{
		toolMeasurementPage.ClickDistanceOptionAndDraw(driver, testData.get(RowNumber).get("UnitNameDistance"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to measure distance in Feet unit with measurement tool option Distance SheetName {string} and rownumber {int}")
	public void MeasureDistanceInFeet(String SheetName , int RowNumber) throws Exception
	{
		toolMeasurementPage.ClickDistanceOptionAndDraw(driver, testData.get(RowNumber).get("UnitNameDistance"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to measure distance in Feet US unit with measurement tool option Distance SheetName {string} and rownumber {int}")
	public void MeasureDistanceInFeetUS(String SheetName , int RowNumber) throws Exception
	{
		toolMeasurementPage.ClickDistanceOptionAndDraw(driver, testData.get(RowNumber).get("UnitNameDistance"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to measure distance in Meters unit with measurement tool option Distance SheetName {string} and rownumber {int}")
	public void MeasureDistanceInMeters(String SheetName , int RowNumber) throws Exception
	{
		toolMeasurementPage.ClickDistanceOptionAndDraw(driver, testData.get(RowNumber).get("UnitNameDistance"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to measure distance in Yards unit with measurement tool option Distance SheetName {string} and rownumber {int}")
	public void MeasureDistanceInYards(String SheetName , int RowNumber) throws Exception
	{
		toolMeasurementPage.ClickDistanceOptionAndDraw(driver, testData.get(RowNumber).get("UnitNameDistance"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to measure distance in Nautical Miles unit with measurement tool option Distance SheetName {string} and rownumber {int}")
	public void MeasureDistanceInNauticalMiles(String SheetName , int RowNumber) throws Exception
	{
		toolMeasurementPage.ClickDistanceOptionAndDraw(driver, testData.get(RowNumber).get("UnitNameDistance"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to measure distance by creating circle with measurement tool option Distance SheetName {string} and rownumber {int}")
	public void MeasureDistanceByCreatingCircle(String SheetName , int RowNumber) throws Exception
	{
		toolMeasurementPage.ClickDistanceOptionAndCreateCircle(driver, testData.get(RowNumber).get("UnitNameDistance"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to plot point and measure lat and long with measurement tool option Location SheetName {string} and rownumber {int}")
	public void PlotPointAndMeasureLatLong(String SheetName , int RowNumber) throws Exception
	{
		toolMeasurementPage.ClickLocationOptionAndPlot(driver, writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
}
