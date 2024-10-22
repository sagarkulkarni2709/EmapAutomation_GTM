package com.script.stepdefination;

import com.utilities.TestInitializer;
import com.utilities.TestResults;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExternalToolStepDefinition extends TestInitializer{
	
	@Given("Application is launched in browser for External Tool SheetName {string} and rownumber {int}")				
    public void LaunchApplication(String SheetName , int RowNumber) throws Exception							
    {	
		System.out.println("*******************Test Case started*******************************");
		if(testCaseNo == 1)
		{
			testData = reader.getData(prop.getProperty("tesData"), "ExternalTool");
			writer = TestResults.printToTxt(testData.get(RowNumber).get("ReportName"));
			extent = TestResults.TestReport(testData.get(RowNumber).get("ReportName"));
		}
		if(RowNumber == 0)
		{
			testData.clear();
			testData = reader.getData(prop.getProperty("tesData"), "ExternalTool");
		}
		test = extent.createTest(testData.get(RowNumber).get("TestName") + " " + testCaseNo, "To Verify " +testData.get(RowNumber).get("TestName"));
		writer.write("\n" + "***************TestResults For" + testData.get(RowNumber).get("TestName") + "***************");
		TestInitializer.LaunchBrowser();
    }
	
	@When("External tool is clicked and tool is opened")
	public void ClickImageryTool() throws Exception
	{
		homePageObj.HomePagePopupAccept(driver, writer, test);
		homePageObj.BackIconClick(driver, writer, test);
		externaltoolPage.ClickExternalTool(driver, writer, test);
	}
	
	@Then("Verify that user should be able to open schematics page")
	public void VerifySchematicsPage() throws Exception
	{
		externaltoolPage.VerifySchematicsPage(driver, writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("Verify that user should be able to select BU Segment and Pipeline to see the Schematics")
	public void ViewSchematics() throws Exception
	{
		externaltoolPage.VerifySchematicsPage(driver, writer, test);
		externaltoolPage.ViewSchematics(driver, writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
}
