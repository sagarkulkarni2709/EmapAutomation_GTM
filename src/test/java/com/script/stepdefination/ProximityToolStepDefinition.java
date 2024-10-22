package com.script.stepdefination;


import com.utilities.SendReport;
import com.utilities.TestInitializer;
import com.utilities.TestResults;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProximityToolStepDefinition extends TestInitializer{
	
	@Given("Application is launched in browser for Proximity Tool SheetName {string} and rownumber {int}")				
    public void LaunchApplication(String SheetName , int RowNumber) throws Exception							
    {	
		System.out.println("*******************Test Case started*******************************");
		if(testCaseNo == 1)
		{
			testData = reader.getData(prop.getProperty("tesData"), "ProximityTool");
			writer = TestResults.printToTxt(testData.get(RowNumber).get("ReportName"));
			extent = TestResults.TestReport(testData.get(RowNumber).get("ReportName"));
		}
		if(RowNumber == 0)
		{
			testData.clear();
			testData = reader.getData(prop.getProperty("tesData"), "ProximityTool");
		}
		test = extent.createTest(testData.get(RowNumber).get("TestName") + " " + testCaseNo, "To Verify " +testData.get(RowNumber).get("TestName"));
		writer.write("\n" + "***************TestResults For" + testData.get(RowNumber).get("TestName") + "***************");
		TestInitializer.LaunchBrowser();
    }
	
	@When("Proximity tool is clicked and tool is opened")
	public void ClickProximityTool() throws Exception
	{
		homePageObj.HomePagePopupAccept(driver, writer, test);
		homePageObj.BackIconClick(driver, writer, test);
		toolProximityPage.ClickProximityTool(driver, writer, test);
	}
	
	@Then("User should be able to use proximity tool to locate address on map with Meters unit SheetName {string} and rownumber {int}")
	public void GetProximityOnMapWithMeterUnit(String SheetName , int RowNumber) throws Exception
	{
		toolProximityPage.EnterAddress(driver, testData.get(RowNumber).get("Address"),testData.get(RowNumber).get("Unit"), testData.get(RowNumber).get("Value"), writer, test);
		toolProximityPage.GetSearchResults(driver, writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to use proximity tool to locate address on map with Kilometers unit SheetName {string} and rownumber {int}")
	public void GetProximityOnMapWithKilometersUnit(String SheetName , int RowNumber) throws Exception
	{
		toolProximityPage.EnterAddress(driver, testData.get(RowNumber).get("Address"), testData.get(RowNumber).get("Unit"), testData.get(RowNumber).get("Value"),  writer, test);
		toolProximityPage.GetSearchResults(driver, writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to use proximity tool to locate address on map with Feet unit SheetName {string} and rownumber {int}")
	public void GetProximityOnMapWithFeetUnit(String SheetName , int RowNumber) throws Exception
	{
		toolProximityPage.EnterAddress(driver, testData.get(RowNumber).get("Address"), testData.get(RowNumber).get("Unit"), testData.get(RowNumber).get("Value"), writer, test);
		toolProximityPage.GetSearchResults(driver, writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to use proximity tool to locate address on map with Miles unit SheetName {string} and rownumber {int}")
	public void GetProximityOnMapWithMilesUnit(String SheetName , int RowNumber) throws Exception
	{
		toolProximityPage.EnterAddress(driver, testData.get(RowNumber).get("Address"), testData.get(RowNumber).get("Unit"), testData.get(RowNumber).get("Value"), writer, test);
		toolProximityPage.GetSearchResults(driver, writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to use proximity tool to locate address on map with option Use Selected SheetName {string} and rownumber {int}")
	public void ClickUseSelectedOption(String SheetName , int RowNumber) throws Exception
	{
		toolProximityPage.ClickUseSelected(driver, writer, test);
		toolProximityPage.GetSearchResults(driver, writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to use proximity tool to locate address on map with option Set Location SheetName {string} and rownumber {int}")
	public void ClickSetLocationOption(String SheetName , int RowNumber) throws Exception
	{
		toolProximityPage.ClickSetLocation(driver, writer, test);
		toolProximityPage.GetSearchResults(driver, writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@When("Layer list tool is clicked and Layer list tool is opened for proximity tool scenario")
	public void ClickLayerListTool() throws Exception
	{
		homePageObj.HomePagePopupAccept(driver, writer, test);
		homePageObj.BackIconClick(driver, writer, test);
		toolLayerListPage.ClickLayerListTool(driver, writer, test);
		toolProximityPage.SelectStructureLayer(driver, writer, test);
	}
	
	@And("Proximity tool is opened")
	public void OpenProximityTool() throws Exception
	{
		toolProximityPage.ClickProximityTool(driver, writer, test);
	}
	
	@Then("User should be able to use proximity tool to locate address on map after enabling the structure layer from layer list tool SheetName {string} and rownumber {int}")
	public void EnterAddressAndSelectPolygon(String SheetName , int RowNumber) throws Exception
	{
		toolProximityPage.EnterAddressAndSelectPolygon(driver, testData.get(RowNumber).get("Address"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
}
