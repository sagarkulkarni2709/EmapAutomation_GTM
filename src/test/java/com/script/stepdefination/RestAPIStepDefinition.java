package com.script.stepdefination;

import com.utilities.SendReport;
import com.utilities.TestInitializer;
import com.utilities.TestResults;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class RestAPIStepDefinition extends TestInitializer{
	
	@Given("API URL is ready to get the response time SheetName {string} and rownumber {int}")				
    public void LaunchApplication(String SheetName , int RowNumber) throws Exception							
    {	
		System.out.println("*******************Test Case started*******************************");
		if(testCaseNo == 1)
		{
			testData = reader.getData(prop.getProperty("tesData"), "RestAPI");
			writer = TestResults.printToTxt(testData.get(RowNumber).get("ReportName"));
			extent = TestResults.TestReport(testData.get(RowNumber).get("ReportName"));
		}
		if(RowNumber == 0)
		{
			testData.clear();
			testData = reader.getData(prop.getProperty("tesData"), "RestAPI");
		}
		test = extent.createTest(testData.get(RowNumber).get("TestName") + " " + testCaseNo, "To Verify " +testData.get(RowNumber).get("TestName"));
		writer.write("\n" + "***************TestResults For" + testData.get(RowNumber).get("TestName1") + "***************");
    }
	
	@Then("User should be able get respose time for Regulated Structure polygons SheetName {string} and rownumber {int}")
	public void RegulatedStructurepolygons(String SheetName , int RowNumber) throws Exception
	{
		restAPIFunctions.RestAPI(testData.get(RowNumber).get("URL"), testData.get(RowNumber).get("Token"),writer, test);
		TestInitializer.IncrementTestCaseNumberwithoutDriver();
	}
	
	@Then("User should be able get respose time for Valve Section with spatial query SheetName {string} and rownumber {int}")
	public void Sectionwithspatialquery(String SheetName , int RowNumber) throws Exception
	{
		restAPIFunctions.RestAPI(testData.get(RowNumber).get("URL"), testData.get(RowNumber).get("Token"),writer, test);
		TestInitializer.IncrementTestCaseNumberwithoutDriver();
	}
	
	@Then("User should be able get respose time for MCA PIR SheetName {string} and rownumber {int}")
	public void MCAPIR(String SheetName , int RowNumber) throws Exception
	{
		restAPIFunctions.RestAPI(testData.get(RowNumber).get("URL"), testData.get(RowNumber).get("Token"),writer, test);
		TestInitializer.IncrementTestCaseNumberwithoutDriver();
	}
	
	@Then("User should be able get respose time for Supervisor with spatial query SheetName {string} and rownumber {int}")
	public void Supervisorwithspatialquery(String SheetName , int RowNumber) throws Exception
	{
		restAPIFunctions.RestAPI(testData.get(RowNumber).get("URL"), testData.get(RowNumber).get("Token"),writer, test);
		TestInitializer.IncrementTestCaseNumberwithoutDriver();
	}
	
	@Then("User should be able get respose time for LP Operating Regions SheetName {string} and rownumber {int}")
	public void LPOperatingRegions(String SheetName , int RowNumber) throws Exception
	{
		restAPIFunctions.RestAPI(testData.get(RowNumber).get("URL"), testData.get(RowNumber).get("Token"),writer, test);
		TestInitializer.IncrementTestCaseNumberwithoutDriver();
	}
	
	@Then("User should be able get respose time for LP Valve Section with spatial query SheetName {string} and rownumber {int}")
	public void LPValveSectionwithspatialquery(String SheetName , int RowNumber) throws Exception
	{
		restAPIFunctions.RestAPI(testData.get(RowNumber).get("URL"), testData.get(RowNumber).get("Token"),writer, test);
		TestInitializer.IncrementTestCaseNumberwithoutDriver();
	}
}
