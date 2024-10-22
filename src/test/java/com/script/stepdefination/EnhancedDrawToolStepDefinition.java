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

public class EnhancedDrawToolStepDefinition extends TestInitializer{
	
	@Given("Application is launched in browser for Enhanced Draw Tool SheetName {string} and rownumber {int}")				
    public void LaunchApplication(String SheetName , int RowNumber) throws Exception							
    {	
		System.out.println("*******************Test Case started*******************************");
		if(testCaseNo == 1)
		{
			testData = reader.getData(prop.getProperty("tesData"), "EnhancedDrawTool");
			writer = TestResults.printToTxt(testData.get(RowNumber).get("ReportName"));
			extent = TestResults.TestReport(testData.get(RowNumber).get("ReportName"));
		}
		if(RowNumber == 0)
		{
			testData.clear();
			testData = reader.getData(prop.getProperty("tesData"), "EnhancedDrawTool");
		}
		test = extent.createTest(testData.get(RowNumber).get("TestName") + " " + testCaseNo, "To Verify " +testData.get(RowNumber).get("TestName"));
		writer.write("\n" + "***************TestResults For" + testData.get(RowNumber).get("TestName") + "***************");
		TestInitializer.LaunchBrowser();
    }
	
	@When("Enhanced Draw tool is clicked and tool is opened")
	public void ClickImageryTool() throws Exception
	{
		homePageObj.HomePagePopupAccept(driver, writer, test);
		homePageObj.BackIconClick(driver, writer, test);
		toolEnhancedDrawPage.ClickEnhancedDrawTool(driver, writer, test);
	}
	
	@Then("User should be able to draw point feature on map SheetName {string} and rownumber {int}")
	public void ClickandDrawPoint(String SheetName , int RowNumber) throws Exception
	{
		toolEnhancedDrawPage.ClickAndDrawPoint(driver, testData.get(RowNumber).get("DrawingName"), testData.get(RowNumber).get("DrawingDescription"), testData.get(RowNumber).get("SymbolSize"), testData.get(RowNumber).get("Outlinewidth"), writer, test);
	}
	
	@And("User should be able to edit the drawing details of point SheetName {string} and rownumber {int}")
	public void EditPointDetails(String SheetName , int RowNumber) throws Exception
	{
		toolEnhancedDrawPage.UpdateDrawing(driver, testData.get(RowNumber).get("DrawingName"), testData.get(RowNumber).get("UpdateDrawingName"), testData.get(RowNumber).get("UpdateDrawingDescription"), testData.get(RowNumber).get("UpdateSymbolSize"), testData.get(RowNumber).get("UpdateOutlinewidth"), true, false, false,writer, test);
	}
	
	@And ("User should be able to delete the drawn point shape SheetName {string} and rownumber {int}")
	public void DeletePointShape(String SheetName , int RowNumber) throws Exception
	{
		//toolEnhancedDrawPage.ImportExportDrawing(driver, testData.get(RowNumber).get("DrawingName"), writer, test);
		toolEnhancedDrawPage.DeleteDrawing(driver, testData.get(RowNumber).get("DrawingName"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to draw line feature on map SheetName {string} and rownumber {int}")
	public void ClickandDrawLine(String SheetName , int RowNumber) throws Exception
	{
		toolEnhancedDrawPage.ClickAndDrawLine(driver, testData.get(RowNumber).get("DrawingName"), testData.get(RowNumber).get("DrawingDescription"), testData.get(RowNumber).get("SymbolSize"), testData.get(RowNumber).get("Outlinewidth"), writer, test);
	}
	
	@And("User should be able to edit the drawing details of line SheetName {string} and rownumber {int}")
	public void EditLineDetails(String SheetName , int RowNumber) throws Exception
	{
		toolEnhancedDrawPage.UpdateDrawing(driver, testData.get(RowNumber).get("DrawingName"), testData.get(RowNumber).get("UpdateDrawingName"), testData.get(RowNumber).get("UpdateDrawingDescription"), testData.get(RowNumber).get("UpdateSymbolSize"), testData.get(RowNumber).get("UpdateOutlinewidth"), false, false, true, writer, test);
	}
	
	@And("User should be able to delete the drawn line shape SheetName {string} and rownumber {int}")
	public void DeleteLinetShape(String SheetName , int RowNumber) throws Exception
	{
		toolEnhancedDrawPage.DeleteDrawing(driver, testData.get(RowNumber).get("DrawingName"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to draw polyline feature on map SheetName {string} and rownumber {int}")
	public void ClickandDrawPolyline(String SheetName , int RowNumber) throws Exception
	{
		toolEnhancedDrawPage.ClickAndDrawPolyline(driver, testData.get(RowNumber).get("DrawingName"), testData.get(RowNumber).get("DrawingDescription"), testData.get(RowNumber).get("SymbolSize"), testData.get(RowNumber).get("Outlinewidth"), writer, test);
	}
	
	@And("User should be able to edit the drawing details of polyline SheetName {string} and rownumber {int}")
	public void EditpolylineDetails(String SheetName , int RowNumber) throws Exception
	{
		toolEnhancedDrawPage.UpdateDrawing(driver, testData.get(RowNumber).get("DrawingName"), testData.get(RowNumber).get("UpdateDrawingName"), testData.get(RowNumber).get("UpdateDrawingDescription"), testData.get(RowNumber).get("UpdateSymbolSize"), testData.get(RowNumber).get("UpdateOutlinewidth"), false, false, true, writer, test);
	}
	
	@And("User should be able to delete the drawn polyline shape SheetName {string} and rownumber {int}")
	public void DeletepolylineShape(String SheetName , int RowNumber) throws Exception
	{
		toolEnhancedDrawPage.DeleteDrawing(driver, testData.get(RowNumber).get("DrawingName"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to draw Freehand polyline feature on map SheetName {string} and rownumber {int}")
	public void ClickandDrawFreehandPolyLine(String SheetName , int RowNumber) throws Exception
	{
		toolEnhancedDrawPage.ClickAndDrawFreehandPolyLine(driver, testData.get(RowNumber).get("DrawingName"), testData.get(RowNumber).get("DrawingDescription"), testData.get(RowNumber).get("SymbolSize"), testData.get(RowNumber).get("Outlinewidth"), writer, test);
	}
	
	@And("User should be able to edit the drawing details of Freehand polyline SheetName {string} and rownumber {int}")
	public void EditFreehandpolylineDetails(String SheetName , int RowNumber) throws Exception
	{
		toolEnhancedDrawPage.UpdateDrawing(driver, testData.get(RowNumber).get("DrawingName"), testData.get(RowNumber).get("UpdateDrawingName"), testData.get(RowNumber).get("UpdateDrawingDescription"), testData.get(RowNumber).get("UpdateSymbolSize"), testData.get(RowNumber).get("UpdateOutlinewidth"), false, false, true, writer, test);
	}
	
	@And("User should be able to delete the drawn Freehand polyline shape SheetName {string} and rownumber {int}")
	public void DeleteFreehandpolylineShape(String SheetName , int RowNumber) throws Exception
	{
		toolEnhancedDrawPage.DeleteDrawing(driver, testData.get(RowNumber).get("DrawingName"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to draw Triangle feature on map SheetName {string} and rownumber {int}")
	public void ClickandDrawTriangle(String SheetName , int RowNumber) throws Exception
	{
		toolEnhancedDrawPage.ClickAndDrawTriangle(driver, testData.get(RowNumber).get("DrawingName"), testData.get(RowNumber).get("DrawingDescription"), testData.get(RowNumber).get("Outlinewidth"), writer, test);
	}
	
	@And("User should be able to edit the drawing details of Triangle SheetName {string} and rownumber {int}")
	public void EditTriangleDetails(String SheetName , int RowNumber) throws Exception
	{
		toolEnhancedDrawPage.UpdateDrawing(driver, testData.get(RowNumber).get("DrawingName"), testData.get(RowNumber).get("UpdateDrawingName"), testData.get(RowNumber).get("UpdateDrawingDescription"), testData.get(RowNumber).get("UpdateSymbolSize"), testData.get(RowNumber).get("UpdateOutlinewidth"), false, true, false, writer, test);
	}
	
	@And("User should be able to delete the drawn Triangle shape SheetName {string} and rownumber {int}")
	public void DeleteTriangleShape(String SheetName , int RowNumber) throws Exception
	{
		toolEnhancedDrawPage.DeleteDrawing(driver, testData.get(RowNumber).get("DrawingName"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to draw Extent feature on map SheetName {string} and rownumber {int}")
	public void ClickandDrawExtent(String SheetName , int RowNumber) throws Exception
	{
		toolEnhancedDrawPage.ClickAndDrawExtent(driver, testData.get(RowNumber).get("DrawingName"), testData.get(RowNumber).get("DrawingDescription"), testData.get(RowNumber).get("Outlinewidth"), writer, test);
	}
	
	@And("User should be able to edit the drawing details of Extent SheetName {string} and rownumber {int}")
	public void EditExtentDetails(String SheetName , int RowNumber) throws Exception
	{
		toolEnhancedDrawPage.UpdateDrawing(driver, testData.get(RowNumber).get("DrawingName"), testData.get(RowNumber).get("UpdateDrawingName"), testData.get(RowNumber).get("UpdateDrawingDescription"), testData.get(RowNumber).get("UpdateSymbolSize"), testData.get(RowNumber).get("UpdateOutlinewidth"), false, true, false, writer, test);
	}
	
	@And("User should be able to delete the drawn Extent shape SheetName {string} and rownumber {int}")
	public void DeleteExtentShape(String SheetName , int RowNumber) throws Exception
	{
		toolEnhancedDrawPage.DeleteDrawing(driver, testData.get(RowNumber).get("DrawingName"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to draw Circle feature on map SheetName {string} and rownumber {int}")
	public void ClickandDrawCircle(String SheetName , int RowNumber) throws Exception
	{
		toolEnhancedDrawPage.ClickAndDrawCircle(driver, testData.get(RowNumber).get("DrawingName"), testData.get(RowNumber).get("DrawingDescription"), testData.get(RowNumber).get("Outlinewidth"), writer, test);
	}
	
	@And("User should be able to edit the drawing details of Circle SheetName {string} and rownumber {int}")
	public void EditCircleDetails(String SheetName , int RowNumber) throws Exception
	{
		toolEnhancedDrawPage.UpdateDrawing(driver, testData.get(RowNumber).get("DrawingName"), testData.get(RowNumber).get("UpdateDrawingName"), testData.get(RowNumber).get("UpdateDrawingDescription"), testData.get(RowNumber).get("UpdateSymbolSize"), testData.get(RowNumber).get("UpdateOutlinewidth"), false, true, false, writer, test);
	}
	
	@And("User should be able to delete the drawn Circle shape SheetName {string} and rownumber {int}")
	public void DeleteCircleShape(String SheetName , int RowNumber) throws Exception
	{
		toolEnhancedDrawPage.DeleteDrawing(driver, testData.get(RowNumber).get("DrawingName"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to draw Ellipse feature on map SheetName {string} and rownumber {int}")
	public void ClickandDrawEllipse(String SheetName , int RowNumber) throws Exception
	{
		toolEnhancedDrawPage.ClickAndDrawEllipse(driver, testData.get(RowNumber).get("DrawingName"), testData.get(RowNumber).get("DrawingDescription"), testData.get(RowNumber).get("Outlinewidth"), writer, test);
	}
	
	@And("User should be able to edit the drawing details of Ellipse SheetName {string} and rownumber {int}")
	public void EditEllipseDetails(String SheetName , int RowNumber) throws Exception
	{
		toolEnhancedDrawPage.UpdateDrawing(driver, testData.get(RowNumber).get("DrawingName"), testData.get(RowNumber).get("UpdateDrawingName"), testData.get(RowNumber).get("UpdateDrawingDescription"), testData.get(RowNumber).get("UpdateSymbolSize"), testData.get(RowNumber).get("UpdateOutlinewidth"), false, true, false, writer, test);
	}
	
	@And("User should be able to delete the drawn Ellipse shape SheetName {string} and rownumber {int}")
	public void DeleteEllipseShape(String SheetName , int RowNumber) throws Exception
	{
		toolEnhancedDrawPage.DeleteDrawing(driver, testData.get(RowNumber).get("DrawingName"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to draw Polygon feature on map SheetName {string} and rownumber {int}")
	public void ClickandDrawPolygon(String SheetName , int RowNumber) throws Exception
	{
		toolEnhancedDrawPage.ClickAndDrawPolygon(driver, testData.get(RowNumber).get("DrawingName"), testData.get(RowNumber).get("DrawingDescription"), testData.get(RowNumber).get("Outlinewidth"), writer, test);
	}
	
	@And("User should be able to edit the drawing details of Polygon SheetName {string} and rownumber {int}")
	public void EditPolygonDetails(String SheetName , int RowNumber) throws Exception
	{
		toolEnhancedDrawPage.UpdateDrawing(driver, testData.get(RowNumber).get("DrawingName"), testData.get(RowNumber).get("UpdateDrawingName"), testData.get(RowNumber).get("UpdateDrawingDescription"), testData.get(RowNumber).get("UpdateSymbolSize"), testData.get(RowNumber).get("UpdateOutlinewidth"), false, true, false, writer, test);
	}
	
	@And("User should be able to delete the drawn Polygon shape SheetName {string} and rownumber {int}")
	public void DeletePolygonShape(String SheetName , int RowNumber) throws Exception
	{
		toolEnhancedDrawPage.DeleteDrawing(driver, testData.get(RowNumber).get("DrawingName"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to draw Freehand Polygon feature on map SheetName {string} and rownumber {int}")
	public void ClickandDrawFreehandPolygon(String SheetName , int RowNumber) throws Exception
	{
		toolEnhancedDrawPage.ClickAndDrawFreehandPolygon(driver, testData.get(RowNumber).get("DrawingName"), testData.get(RowNumber).get("DrawingDescription"), testData.get(RowNumber).get("Outlinewidth"), writer, test);
	}
	
	@And("User should be able to edit the drawing details of Freehand Polygon SheetName {string} and rownumber {int}")
	public void EditFreehandPolygonDetails(String SheetName , int RowNumber) throws Exception
	{
		toolEnhancedDrawPage.UpdateDrawing(driver, testData.get(RowNumber).get("DrawingName"), testData.get(RowNumber).get("UpdateDrawingName"), testData.get(RowNumber).get("UpdateDrawingDescription"), testData.get(RowNumber).get("UpdateSymbolSize"), testData.get(RowNumber).get("UpdateOutlinewidth"), false, true, false, writer, test);
	}
	
	@And("User should be able to delete the drawn Freehand Polygon shape SheetName {string} and rownumber {int}")
	public void DeleteFreehandPolygonShape(String SheetName , int RowNumber) throws Exception
	{
		toolEnhancedDrawPage.DeleteDrawing(driver, testData.get(RowNumber).get("DrawingName"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to draw Text feature on map SheetName {string} and rownumber {int}")
	public void ClickandDrawText(String SheetName , int RowNumber) throws Exception
	{
		toolEnhancedDrawPage.ClickAndDrawText(driver, testData.get(RowNumber).get("DrawingName"), testData.get(RowNumber).get("DrawingDescription"), testData.get(RowNumber).get("Outlinewidth"), writer, test);
	}
	
	@And("User should be able to edit the drawing details of Text SheetName {string} and rownumber {int}")
	public void EditTextDetails(String SheetName , int RowNumber) throws Exception
	{
		toolEnhancedDrawPage.UpdateDrawing(driver, testData.get(RowNumber).get("DrawingName"), testData.get(RowNumber).get("UpdateDrawingName"), testData.get(RowNumber).get("UpdateDrawingDescription"), testData.get(RowNumber).get("UpdateSymbolSize"), testData.get(RowNumber).get("UpdateOutlinewidth"), false, false, false, writer, test);
	}
	
	@And("User should be able to delete the drawn Text shape SheetName {string} and rownumber {int}")
	public void DeleteTextShape(String SheetName , int RowNumber) throws Exception
	{
		toolEnhancedDrawPage.DeleteDrawing(driver, testData.get(RowNumber).get("DrawingName"), writer, test);
		TestInitializer.IncrementTestCaseNumber();
	}
	
	@Then("User should be able to import and export drawings {string} and rownumber {int}")
	public void ImportExportDrawings(String SheetName , int RowNumber) throws Exception
	{
		toolEnhancedDrawPage.ClickAndDrawPoint(driver, testData.get(RowNumber).get("DrawingName"), testData.get(RowNumber).get("DrawingDescription"), testData.get(RowNumber).get("SymbolSize"), testData.get(RowNumber).get("Outlinewidth"), writer, test);
		toolEnhancedDrawPage.ImportExportDrawing(driver, writer, test);
	}
	
}

