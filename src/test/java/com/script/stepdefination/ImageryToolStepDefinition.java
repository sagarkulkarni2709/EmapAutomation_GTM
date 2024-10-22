package com.script.stepdefination;

import com.utilities.SendReport;
import com.utilities.TestInitializer;
import com.utilities.TestResults;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ImageryToolStepDefinition extends TestInitializer{
	public SendReport sendReport = new SendReport();
	
	@Given("Application is launched in browser for Imagery Tool SheetName {string} and rownumber {int}")				
    public void LaunchApplication(String SheetName , int RowNumber) throws Exception							
    {	
		System.out.println("*******************Test Case started*******************************");
		if(testCaseNo == 1)
		{
			testData = reader.getData(prop.getProperty("tesData"), "ImageryTool");
			writer = TestResults.printToTxt(testData.get(RowNumber).get("ReportName"));
			extent = TestResults.TestReport(testData.get(RowNumber).get("ReportName"));
		}
		if(RowNumber == 0)
		{
			testData.clear();
			testData = reader.getData(prop.getProperty("tesData"), "ImageryTool");
		}
		//sendReport.SendMailWithAttachment();
		test = extent.createTest(testData.get(RowNumber).get("TestName") + " " + testCaseNo, "To Verify " +testData.get(RowNumber).get("TestName"));
		writer.write("\n" + "***************TestResults For" + testData.get(RowNumber).get("TestName") + "***************");
		TestInitializer.LaunchBrowser();
    }
	
	@When("Imagery tool is clicked and tool is opened")
	public void ClickImageryTool() throws Exception
	{
		homePageObj.HomePagePopupAccept(driver, writer, test);
		homePageObj.BackIconClick(driver, writer, test);
		toolImageryPage.ClickImageryTool(driver, writer, test);
	}
	
	@Then("User can select basemap from basemap gallery and as per the selection basemap should be changed")
	public void SelectBasemap() throws Exception
	{
		toolImageryPage.ClickBasemapGallery(driver, writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User can open streetview by setting coordinates on map from streetviewAerial widget")
	public void OpenStreetView() throws Exception
	{
		toolImageryPage.ClickStreetViewAerial( driver, writer, test);
		toolImageryPage.ClickOpenStreetViewAerial(driver,writer, test);
		toolImageryPage.GetLatLongValue(driver, writer, test);
		toolImageryPage.ClickOpenStreetView(driver, writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User can open pictometry and can see the pictures in widget by plotting points on map")
	public void OpenPictometry() throws Exception
	{
		toolImageryPage.ClickPictometry(driver, writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User can open Maxar Imagery tool and can add the layer to map")
	public void OpenMaxarImagery() throws Exception
	{
		toolImageryPage.ClickMaxarImgery(driver, writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
}
