package com.script.stepdefination;

import com.utilities.SendReport;
import com.utilities.TestInitializer;
import com.utilities.TestResults;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PrintToolStepDefinition extends TestInitializer{
	
	@Given("Application is launched in browser for Print Tool SheetName {string} and rownumber {int}")				
    public void LaunchApplication(String SheetName , int RowNumber) throws Exception							
    {	
		System.out.println("*******************Test Case started*******************************");
		if(testCaseNo == 1)
		{
			testData = reader.getData(prop.getProperty("tesData"), "PrintTool");
			writer = TestResults.printToTxt(testData.get(RowNumber).get("ReportName"));
			extent = TestResults.TestReport(testData.get(RowNumber).get("ReportName"));
		}
		if(RowNumber == 0)
		{
			testData.clear();
			testData = reader.getData(prop.getProperty("tesData"), "PrintTool");
		}
		test = extent.createTest(testData.get(RowNumber).get("TestName") + " " + testCaseNo, "To Verify " +testData.get(RowNumber).get("TestName"));
		writer.write("\n" + "***************TestResults For" + testData.get(RowNumber).get("TestName") + "***************");
		TestInitializer.LaunchBrowser();
    }
	
	@When("Print tool is clicked and tool is opened")
	public void ClickPrintTool() throws Exception
	{
		homePageObj.HomePagePopupAccept(driver, writer, test);
		toolPrintPage.ClickPrintTool(driver, writer, test);
	}
	
	@Then("In Enbridge Landscape Template Layout user is able to print in all the different formats SheetName {string} and rownumber {int}")
	public void PrintForEnbridgeLandscapeTemplateLayout(String SheetName , int RowNumber) throws Exception
	{
		toolPrintPage.PrintForEnbridgeTemplateLayout(driver, testData.get(RowNumber).get("LayoutItem"), false,  writer,test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("In Enbridge Landscape Template Attributes Layout user is able to print in all the different formats SheetName {string} and rownumber {int}")
	public void PrintForEnbridgeLandscapeTemplateAttributesLayout(String SheetName , int RowNumber) throws Exception
	{
		toolPrintPage.PrintForEnbridgeTemplateLayout(driver, testData.get(RowNumber).get("LayoutItem"), true, writer,test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("In Enbridge Portrait Template Layout user is able to print in all the different formats SheetName {string} and rownumber {int}")
	public void PrintForEnbridgePortraitTemplateLayout(String SheetName , int RowNumber) throws Exception
	{
		toolPrintPage.PrintForEnbridgeTemplateLayout(driver, testData.get(RowNumber).get("LayoutItem"), false, writer,test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("In Enbridge Portrait Template Attributes Layout user is able to print in all the different formats SheetName {string} and rownumber {int}")
	public void PrintForEnbridgePortraitTemplateAttributesLayout(String SheetName , int RowNumber) throws Exception
	{
		toolPrintPage.PrintForEnbridgeTemplateLayout(driver, testData.get(RowNumber).get("LayoutItem"), true, writer,test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("In LP_ClassLocation_Layout_Static_PROD_10.4 Layout user is able to print in all the different formats SheetName {string} and rownumber {int}")
	public void PrintForLPClassLocationLayoutStaticPRODAttributesLayout(String SheetName , int RowNumber) throws Exception
	{
		toolPrintPage.PrintForEnbridgeTemplateLayout(driver, testData.get(RowNumber).get("LayoutItem"), false, writer,test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
}
