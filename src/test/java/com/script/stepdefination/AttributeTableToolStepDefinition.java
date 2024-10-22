package com.script.stepdefination;

import com.utilities.SendReport;
import com.utilities.TestInitializer;
import com.utilities.TestResults;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AttributeTableToolStepDefinition extends TestInitializer {
	
	@Given("Application is launched in browser for Attribute Table Tool SheetName {string} and rownumber {int}")				
    public void LaunchApplication(String SheetName , int RowNumber) throws Exception							
    {	
		System.out.println("*******************Test Case started*******************************");
		if(testCaseNo == 1)
		{
			testData = reader.getData(prop.getProperty("tesData"), "AttributeTableTool");
			writer = TestResults.printToTxt(testData.get(RowNumber).get("ReportName"));
			extent = TestResults.TestReport(testData.get(RowNumber).get("ReportName"));
		}
		if(RowNumber == 0)
		{
			testData.clear();
			testData = reader.getData(prop.getProperty("tesData"), "AttributeTableTool");
		}
		test = extent.createTest(testData.get(RowNumber).get("TestName") + " " + testCaseNo, "To Verify " +testData.get(RowNumber).get("TestName"));
		writer.write("\n" + "***************TestResults For" + testData.get(RowNumber).get("TestName1") + "***************");
		TestInitializer.LaunchBrowser();
    }
	
	@When("Attribute Table tool is clicked and tool is opened")
	public void ClickAttributeTableTool() throws Exception
	{
		homePageObj.HomePagePopupAccept(driver, writer, test);
		homePageObj.BackIconClick(driver, writer, test);
		toolAttributeTablePage.ClickAttributeTableTool(driver, writer, test);
	}
	
	@Then("User can apply filters to attribute table and the data is getting popultaed as per the applied filters with Add Expression option SheetName {string} and rownumber {int}")
	public void FilterDataWithAddExpression(String SheetName , int RowNumber) throws Exception
	{
		toolAttributeTablePage.ClickOptionsBtn(driver,writer, test);
		toolAttributeTablePage.AddExpression(driver, testData.get(RowNumber).get("FirstFieldofAddExpression"),testData.get(RowNumber).get("SecondFieldOfAddExpression"), testData.get(RowNumber).get("ThirdFieldOfAddExpression"),writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User can apply filters to attribute table and the data is getting popultaed as per the applied filters with Add Set option SheetName {string} and rownumber {int}")
	public void FilterDataWithAddSet(String SheetName , int RowNumber) throws Exception
	{
		toolAttributeTablePage.ClickOptionsBtn(driver,writer, test);
		toolAttributeTablePage.AddSet(driver, testData.get(RowNumber).get("FirstFieldofAddset"),testData.get(RowNumber).get("SecondFieldOfAddset"), testData.get(RowNumber).get("ThirdFieldOfAddset"),testData.get(RowNumber).get("FourthFieldofAddset"), testData.get(RowNumber).get("FifthFieldOfAddset"), testData.get(RowNumber).get("SixthFieldOfAddset"),writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to export the attribute table data to CSV SheetName {string} and rownumber {int}")
	public void ExportDataToCSV(String SheetName , int RowNumber) throws Exception
	{
		toolAttributeTablePage.ClickExportDataToCSV(driver,writer, test);
		toolAttributeTablePage.ExportDataToCSV(driver, writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
}
