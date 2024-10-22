package com.script.stepdefination;

import com.utilities.SendReport;
import com.utilities.TestInitializer;
import com.utilities.TestResults;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SelectToolStepDefinition extends TestInitializer{
	
	@Given("Application is launched in browser for Directions Tools SheetName {string} and rownumber {int}")				
    public void LaunchApplication(String SheetName , int RowNumber) throws Exception							
    {	
		System.out.println("*******************Test Case started*******************************");
		if(testCaseNo == 1)
		{
			testData = reader.getData(prop.getProperty("tesData"), "SelectTool");
			writer = TestResults.printToTxt(testData.get(RowNumber).get("ReportName"));
			extent = TestResults.TestReport(testData.get(RowNumber).get("ReportName"));
		}
		if(RowNumber == 0)
		{
			testData.clear();
			testData = reader.getData(prop.getProperty("tesData"), "SelectTool");
		}
		test = extent.createTest(testData.get(RowNumber).get("TestName") + " " + testCaseNo, "To Verify " +testData.get(RowNumber).get("TestName"));
		writer.write("\n" + "***************TestResults For" + testData.get(RowNumber).get("TestName") + "***************");
		TestInitializer.LaunchBrowser();
    }
	
	@When("Select tool is clicked and tool is opened")
	public void ClickSelectTool() throws Exception
	{
		homePageObj.HomePagePopupAccept(driver, writer, test);
		homePageObj.BackIconClick(driver, writer, test);
		toolSelectPage.ClickSelectTool(driver, writer, test);
	}
	
	@Then("User should be able to Select reactangle shape and draw on map where features are available to get the details on line SheetName {string} and rownumber {int}")
	public void SelectReactangleAndDrawOnMap(String SheetName , int RowNumber) throws Exception
	{
		toolSelectPage.SelectByShape(driver, testData.get(RowNumber).get("SelectByShape"), writer, test);
		toolSelectPage.SelectLayerItems( driver, writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to Select polygon shape and draw on map where features are available to get the details on line SheetName {string} and rownumber {int}")
	public void SelectpolygonAndDrawOnMap(String SheetName , int RowNumber) throws Exception
	{
		toolSelectPage.SelectByShapePolygon(driver, testData.get(RowNumber).get("SelectByShape"), writer, test);
		toolSelectPage.SelectLayerItems( driver, writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to Select circle shape and draw on map where features are available to get the details on line SheetName {string} and rownumber {int}")
	public void SelectcircleAndDrawOnMap(String SheetName , int RowNumber) throws Exception
	{
		toolSelectPage.SelectByShape(driver, testData.get(RowNumber).get("SelectByShape"), writer, test);
		toolSelectPage.SelectLayerItems( driver, writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to Select zoom to option of layer after selecting shape by reactangle SheetName {string} and rownumber {int}")
	public void SelectZoomToOfLayer(String SheetName , int RowNumber) throws Exception
	{
		toolSelectPage.SelectByShape(driver, testData.get(RowNumber).get("SelectByShape"), writer, test);
		toolSelectPage.ClickoptionZoomTo(driver, writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to Export layer data to CSV after selecting shape by reactangle SheetName {string} and rownumber {int}")
	public void SelectExportTOCSVOfLayer(String SheetName , int RowNumber) throws Exception
	{
		toolSelectPage.SelectByShape(driver, testData.get(RowNumber).get("SelectByShape"), writer, test);
		toolSelectPage.ClickoptionExportToCSV(driver, writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to Export layer data to feature collection after selecting shape by reactangle SheetName {string} and rownumber {int}")
	public void SelectExportToFeatureCollectionOfLayer(String SheetName , int RowNumber) throws Exception
	{
		toolSelectPage.SelectByShape(driver, testData.get(RowNumber).get("SelectByShape"), writer, test);
		toolSelectPage.ClickoptionExportToFeatureCollection(driver, writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be Export layer data to GeoJSON after selecting shape by reactangle SheetName {string} and rownumber {int}")
	public void SelectExportToGeoJsonOfLayer(String SheetName , int RowNumber) throws Exception
	{
		toolSelectPage.SelectByShape(driver, testData.get(RowNumber).get("SelectByShape"), writer, test);
		toolSelectPage.ClickoptionExportToGeoJson(driver, writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be create new layer from layer options after selecting shape by reactangle SheetName {string} and rownumber {int}")
	public void SelectCrateLayerOption(String SheetName , int RowNumber) throws Exception
	{
		toolSelectPage.SelectByShape(driver, testData.get(RowNumber).get("SelectByShape"), writer, test);
		toolSelectPage.ClickoptionCreateLayer(driver, writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be save the content of layer after selecting shape by reactangle SheetName {string} and rownumber {int}")
	public void SelectSaveToMyContentOption(String SheetName , int RowNumber) throws Exception
	{
		toolSelectPage.SelectByShape(driver, testData.get(RowNumber).get("SelectByShape"), writer, test);
		toolSelectPage.ClickoptionSaveToMyContent(driver, writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be view the layer data in attribute table after selecting shape by reactangle SheetName {string} and rownumber {int}")
	public void SelectViewInAttributeTableOption(String SheetName , int RowNumber) throws Exception
	{
		toolSelectPage.SelectByShape(driver, testData.get(RowNumber).get("SelectByShape"), writer, test);
		toolSelectPage.ClickViewInAttributeTable(driver, writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be view the statistics of layer data after selecting shape by reactangle SheetName {string} and rownumber {int}")
	public void SelectStatisticsOption(String SheetName , int RowNumber) throws Exception
	{
		toolSelectPage.SelectByShape(driver, testData.get(RowNumber).get("SelectByShape"), writer, test);
		toolSelectPage.ClickStatistics(driver, writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be clear the selection after selecting shape by reactangle SheetName {string} and rownumber {int}")
	public void SelectClearSelection(String SheetName , int RowNumber) throws Exception
	{
		toolSelectPage.SelectByShape(driver, testData.get(RowNumber).get("SelectByShape"), writer, test);
		toolSelectPage.ClickClearSelection(driver, writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
}
