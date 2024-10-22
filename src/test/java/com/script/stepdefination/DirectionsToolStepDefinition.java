package com.script.stepdefination;

import com.utilities.SendReport;
import com.utilities.TestInitializer;
import com.utilities.TestResults;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DirectionsToolStepDefinition extends TestInitializer{
	
	@Given("Application is launched in browser for Directions Tool SheetName {string} and rownumber {int}")				
    public void LaunchApplication(String SheetName , int RowNumber) throws Exception							
    {	
		System.out.println("*******************Test Case started*******************************");
		if(testCaseNo == 1)
		{
			testData = reader.getData(prop.getProperty("tesData"), "DirectionsTool");
			writer = TestResults.printToTxt(testData.get(RowNumber).get("ReportName"));
			extent = TestResults.TestReport(testData.get(RowNumber).get("ReportName"));
		}
		if(RowNumber == 0)
		{
			testData.clear();
			testData = reader.getData(prop.getProperty("tesData"), "DirectionsTool");
		}
		test = extent.createTest(testData.get(RowNumber).get("TestName") + " " + testCaseNo, "To Verify " +testData.get(RowNumber).get("TestName"));
		writer.write("\n" + "***************TestResults For" + testData.get(RowNumber).get("TestName") + "***************");
		TestInitializer.LaunchBrowser();
    }
	
	@When("Directions tool is clicked and tool is opened")
	public void ClickProximityTool() throws Exception
	{
		homePageObj.HomePagePopupAccept(driver, writer, test);
		homePageObj.BackIconClick(driver, writer, test);
		toolDirectionsPage.ClickDirectionsTool(driver, writer, test);
	}
	
	@Then("User should be able to get direction between two locations using Directions tool and also able to get Driving Time SheetName {string} and rownumber {int}")
	public void DirectionForDrivingTime(String SheetName , int RowNumber) throws Exception
	{
		toolDirectionsPage.EnterAddress(driver, testData.get(RowNumber).get("FromAddress"),testData.get(RowNumber).get("ToAddress"), writer, test);
		toolDirectionsPage.SelectTimeDropDown(driver, testData.get(RowNumber).get("TimeDropdown"), writer, test);
		toolDirectionsPage.DirectionValidation(driver, writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to get direction between two locations using Directions tool and also able to get Rural Driving Time SheetName {string} and rownumber {int}")
	public void DirectionRuralDrivingTime(String SheetName , int RowNumber) throws Exception
	{
		toolDirectionsPage.EnterAddress(driver, testData.get(RowNumber).get("FromAddress"),testData.get(RowNumber).get("ToAddress"), writer, test);
		toolDirectionsPage.SelectTimeDropDown(driver, testData.get(RowNumber).get("TimeDropdown"), writer, test);
		toolDirectionsPage.DirectionValidation(driver, writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to get direction between two locations using Directions tool and also able to get Walking Time SheetName {string} and rownumber {int}")
	public void DirectionRuralWalkingTime(String SheetName , int RowNumber) throws Exception
	{
		toolDirectionsPage.EnterAddress(driver, testData.get(RowNumber).get("FromAddress"),testData.get(RowNumber).get("ToAddress"), writer, test);
		toolDirectionsPage.SelectTimeDropDown(driver, testData.get(RowNumber).get("TimeDropdown"), writer, test);
		toolDirectionsPage.DirectionValidation(driver, writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
}
