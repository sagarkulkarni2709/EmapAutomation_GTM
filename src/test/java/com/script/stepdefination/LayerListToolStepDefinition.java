package com.script.stepdefination;

import com.utilities.TestInitializer;
import com.utilities.TestResults;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LayerListToolStepDefinition extends TestInitializer{
	@Given("Application is launched in browser for Layer List Tool SheetName {string} and rownumber {int}")				
    public void LaunchApplication(String SheetName , int RowNumber) throws Exception							
    {	
		
		System.out.println("*******************Test Case started*******************************");
		if(testCaseNo == 1)
		{
			testData = reader.getData(prop.getProperty("tesData"), "LayerListTool");
			writer = TestResults.printToTxt(testData.get(RowNumber).get("ReportName"));
			extent = TestResults.TestReport(testData.get(RowNumber).get("ReportName"));
		}
		if(RowNumber == 0)
		{
			testData.clear();
			testData = reader.getData(prop.getProperty("tesData"), "LayerListTool");
		}
		test = extent.createTest(testData.get(RowNumber).get("TestName") + " " + testCaseNo, "To Verify " +testData.get(RowNumber).get("TestName"));
		writer.write("\n" + "***************TestResults For" + testData.get(RowNumber).get("TestName") + "***************");
		TestInitializer.LaunchBrowser();
    }
	
	@When("Layer list tool is clicked and Layer list tool is opened")
	public void ClickLayerListTool() throws Exception
	{
		
		homePageObj.HomePagePopupAccept(driver, writer, test);
		homePageObj.BackIconClick(driver, writer, test);
		toolLayerListPage.ClickLayerListTool(driver, writer, test);
	}
	
	@Then("User should be able to select and deselect the layer from layerlist tool and as per the selection and deselction visibility of the layer become ON and OFF on map")
	public void SelectDeselectLayer() throws Exception
	{
		toolLayerListPage.CheckLayerVisibility(driver, writer, test); 
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to use the popup menu options like Zoom In and Enable Diable popup of Layer list tool")
	public void SelectPopupMenuOptions() throws Exception
	{
		toolLayerListPage.CheckOptionsLayerList(driver, writer, test); 
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able use the popup menu options like expand and collapsed all layers")
	public void SelectExpandCollapsLayerOption() throws Exception
	{
		toolLayerListPage.ExpandAndCollapsAllLayer(driver, writer, test); 
		TestInitializer.IncrementTestCaseNumber();
	}
	
}
