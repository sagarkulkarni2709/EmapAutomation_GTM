package com.script.stepdefination;

import com.utilities.SendReport;
import com.utilities.TestInitializer;
import com.utilities.TestResults;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PopupFunctionsStepDefinition extends TestInitializer{
	
	@Given("Application is launched in browser for Popup Functions SheetName {string} and rownumber {int}")				
    public void LaunchApplication(String SheetName , int RowNumber) throws Exception							
    {	
		System.out.println("*******************Test Case started*******************************");
		if(testCaseNo == 1)
		{
			testData = reader.getData(prop.getProperty("tesData"), "PopupFunctions");
			writer = TestResults.printToTxt(testData.get(RowNumber).get("ReportName"));
			extent = TestResults.TestReport(testData.get(RowNumber).get("ReportName"));
		}
		if(RowNumber == 0)
		{
			testData.clear();
			testData = reader.getData(prop.getProperty("tesData"), "PopupFunctions");
		}
		test = extent.createTest(testData.get(RowNumber).get("TestName") + " " + testCaseNo, "To Verify " +testData.get(RowNumber).get("TestName"));
		writer.write("\n" + "***************TestResults For" + testData.get(RowNumber).get("TestName") + "***************");
		TestInitializer.LaunchBrowser();
    }
	
	@When("Popup should be opened")
	public void OpenPopup() throws Exception
	{
		homePageObj.HomePagePopupAccept(driver, writer, test);
		popupFunctions.OpenPopup(driver, writer, test);
	}
	
	@Then("User should be able to add the marker to the location from the popup option")
	public void AddMarker() throws Exception
	{
		popupFunctions.AddMarkerToLocation(driver, writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to open attribute table from popup window")
	public void ViewAttributeTable() throws Exception
	{
		popupFunctions.ViewInAttributeTable(driver, writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
}
