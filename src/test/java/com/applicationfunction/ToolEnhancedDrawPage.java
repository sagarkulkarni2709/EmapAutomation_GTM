package com.applicationfunction;

import java.io.BufferedWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.test.validation.TestValidations;
import com.utilities.StepExecutor;
import com.utilities.TestInitializer;
import com.utilities.TestResults;

public class ToolEnhancedDrawPage {
	
	public WebDriver driver;
	public TestValidations testValidations = new TestValidations(driver);
	
	private static By option_EnhancedDrawtool = By.xpath("(//div[contains(@settingid,'eDraw')]/div)[1]");
	private static By option_DrawPoint = By.xpath("//div[@class='draw-items']/div[@title='Point']");
	private static By plot_LineFeature = By.xpath("(//*[local-name() = 'svg'])[1]");
	private static By text_name = By.xpath("//input[@id='nameField']");
	private static By text_Description = By.xpath("//textarea[@id='descriptionField']");
	private static By text_SymbolSize = By.xpath("//span[contains(text(),'Symbol size')]/../following-sibling::td/div/div[3]/input[1]");
	private static By text_Outlinewidth = By.xpath("(//span[contains(text(),'Outline width')]/../following-sibling::td/div/div[3]/input[1])[1]");
	private static By btn_Save = By.xpath("((//div[@class='footer'])[1]/div/input[1])[1]");
	private static By option_DrawLine = By.xpath("//div[@class='draw-items']/div[@title='Line']");
	private static By text_Linewidth = By.xpath("(//span[contains(text(),'Width')]/../following-sibling::td/div/div[3]/input[1])[1]");
	private static By option_DrawPolyline = By.xpath("//div[@class='draw-items']/div[@title='Polyline']");
	private static By option_DrawFreehandPolyline = By.xpath("//div[@class='draw-items']/div[@title='Freehand polyline']");
	private static By option_DrawTriangle = By.xpath("//div[@class='draw-items']/div[@title='Triangle']");
	private static By text_OutlinewidthTriangle = By.xpath("(//span[contains(text(),'Outline width')]/../following-sibling::td/div/div[3]/input[1])[2]");
	private static By option_DrawExtent = By.xpath("//div[@class='draw-items']/div[@title='Extent']");
	private static By option_DrawCircle = By.xpath("//div[@class='draw-items']/div[@title='Circle']");
	private static By option_DrawEllipse = By.xpath("//div[@class='draw-items']/div[@title='Ellipse']");
	private static By option_DrawPolygon = By.xpath("//div[@class='draw-items']/div[@title='Polygon']");
	private static By option_DrawFreehandPolygon = By.xpath("//div[@class='draw-items']/div[@title='Freehand polygon']");
	private static By option_DrawText = By.xpath("//div[@class='draw-items']/div[@title='Text']");
	
	private static By btn_EditDrawing = By.xpath("//span[@class='edit blue-button']");
	private static By btn_DeleteDrawing = By.xpath("(//span[@class='clear red-button'])[1]");
	
	private static By option_importExport = By.xpath("//img[@title='Import or export drawings']");
	private static By input_Filename = By.xpath("//input[@name='exportFilename']");
	private static By btn_export = By.xpath("//span[@class='export blue-button']");
	private static By option_DrawingList = By.xpath("//img[@title='Import or export drawings']");
	private static By input_ImportFile = By.xpath("//input[@class='file']");
	private static By btn_import = By.xpath("//span[@class='import blue-button']");
	
	
	public ToolEnhancedDrawPage(WebDriver driver)
	{
		super();
		this.driver = driver;
	}
	
	public void ClickEnhancedDrawTool(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_EnhancedDrawtool, "Option - LayerListtool", writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ClickAndDrawPoint(WebDriver driver, String DrawingName, String DrawingDescription, String SymbolSize, String Outlinewidth, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_DrawPoint, "Option Draw Point", writer, test);
			AddDrawingPoint(driver, DrawingName, DrawingDescription, SymbolSize, Outlinewidth, writer, test);
			StepExecutor.ElementClick(driver, "Xpath", plot_LineFeature, "Point on map", writer, test);
			testValidations.ShapeValidation(driver, testValidations.shape_point, "Point",  writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void AddDrawingPoint(WebDriver driver, String DrawingName, String DrawingDescription, String SymbolSize, String Outlinewidth, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.SetText(driver, "Xpath", text_name, "Drawing Name", DrawingName, writer, test);
			StepExecutor.SetText(driver, "Xpath", text_Description, "Drawing Description", DrawingDescription, writer, test);
			StepExecutor.SetText(driver, "Xpath", text_SymbolSize, "Drawing SymbolSize", SymbolSize, writer, test);
			StepExecutor.SetText(driver, "Xpath", text_Outlinewidth, "Drawing Outlinewidth", Outlinewidth, writer, test);
			driver.findElement(text_Outlinewidth).sendKeys(Keys.TAB);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ClickAndDrawLine(WebDriver driver, String DrawingName, String DrawingDescription, String SymbolSize, String Outlinewidth, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_DrawLine, "Option Draw Line", writer, test);
			AddDrawingLine(driver, DrawingName, DrawingDescription, Outlinewidth, writer, test);
			StepExecutor.ElementClick(driver, "Xpath", plot_LineFeature, "Point on map", writer, test);
			WebElement source = driver.findElement(plot_LineFeature);
			StepExecutor.DrawShapeOnMap(driver, source);
			testValidations.ShapeValidation(driver, testValidations.shape_line, "Line",  writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void AddDrawingLine(WebDriver driver, String DrawingName, String DrawingDescription, String Outlinewidth, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.SetText(driver, "Xpath", text_name, "Drawing Name", DrawingName, writer, test);
			StepExecutor.SetText(driver, "Xpath", text_Description, "Drawing Description", DrawingDescription, writer, test);
			StepExecutor.SetText(driver, "Xpath", text_Linewidth, "Drawing Width", Outlinewidth, writer, test);
			driver.findElement(text_Linewidth).sendKeys(Keys.TAB);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ClickAndDrawPolyline(WebDriver driver, String DrawingName, String DrawingDescription, String SymbolSize, String Outlinewidth, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_DrawPolyline, "Option Draw Line", writer, test);
			AddDrawingLine(driver, DrawingName, DrawingDescription, Outlinewidth, writer, test);
			StepExecutor.ElementClick(driver, "Xpath", plot_LineFeature, "Point on map", writer, test);
			WebElement source = driver.findElement(plot_LineFeature);
			StepExecutor.DrawPolylineShapeOnMap(driver, source);
			testValidations.ShapeValidation(driver, testValidations.shape_line, "PolyLine",  writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ClickAndDrawFreehandPolyLine(WebDriver driver, String DrawingName, String DrawingDescription, String SymbolSize, String Outlinewidth, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_DrawFreehandPolyline, "Option Draw Freehand PolyLine", writer, test);
			AddDrawingLine(driver, DrawingName, DrawingDescription, Outlinewidth, writer, test);
			StepExecutor.ElementClick(driver, "Xpath", plot_LineFeature, "Point on map", writer, test);
			WebElement source = driver.findElement(plot_LineFeature);
			StepExecutor.DrawShapeOnMap(driver, source);
			testValidations.ShapeValidation(driver, testValidations.shape_line, "Freehand PolyLine",  writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ClickAndDrawTriangle(WebDriver driver, String DrawingName, String DrawingDescription, String Outlinewidth, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_DrawTriangle, "Option Draw Triangle", writer, test);
			AddDrawingTriangle( driver,  DrawingName,  DrawingDescription, Outlinewidth,  writer,  test);
			StepExecutor.ElementClick(driver, "Xpath", plot_LineFeature, "Point on map", writer, test);
			testValidations.ShapeValidation(driver, testValidations.shape_line, "Triangle",  writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void AddDrawingTriangle(WebDriver driver, String DrawingName, String DrawingDescription, String Outlinewidth, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.SetText(driver, "Xpath", text_name, "Drawing Name", DrawingName, writer, test);
			StepExecutor.SetText(driver, "Xpath", text_Description, "Drawing Description", DrawingDescription, writer, test);
			StepExecutor.SetText(driver, "Xpath", text_OutlinewidthTriangle, "Drawing Outlinewidth", Outlinewidth, writer, test);
			driver.findElement(text_OutlinewidthTriangle).sendKeys(Keys.TAB);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ClickAndDrawExtent(WebDriver driver, String DrawingName, String DrawingDescription, String Outlinewidth, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_DrawExtent, "Option Draw Extent", writer, test);
			AddDrawingExtent( driver,  DrawingName,  DrawingDescription, Outlinewidth,  writer,  test);
			StepExecutor.ElementClick(driver, "Xpath", plot_LineFeature, "Point on map", writer, test);
			WebElement source = driver.findElement(plot_LineFeature);
			StepExecutor.DrawShapeOnMap(driver, source);
			testValidations.ShapeValidation(driver, testValidations.shape_line, "Extent",  writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void AddDrawingExtent(WebDriver driver, String DrawingName, String DrawingDescription, String Outlinewidth, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.SetText(driver, "Xpath", text_name, "Drawing Name", DrawingName, writer, test);
			StepExecutor.SetText(driver, "Xpath", text_Description, "Drawing Description", DrawingDescription, writer, test);
			StepExecutor.SetText(driver, "Xpath", text_OutlinewidthTriangle, "Drawing Outlinewidth", Outlinewidth, writer, test);
			driver.findElement(text_OutlinewidthTriangle).sendKeys(Keys.TAB);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ClickAndDrawCircle(WebDriver driver, String DrawingName, String DrawingDescription, String Outlinewidth, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_DrawCircle, "Option Draw Circle", writer, test);
			AddDrawingCircle( driver,  DrawingName,  DrawingDescription, Outlinewidth,  writer,  test);
			StepExecutor.ElementClick(driver, "Xpath", plot_LineFeature, "Point on map", writer, test);
			testValidations.ShapeValidation(driver, testValidations.shape_line, "Circle",  writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void AddDrawingCircle(WebDriver driver, String DrawingName, String DrawingDescription, String Outlinewidth, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.SetText(driver, "Xpath", text_name, "Drawing Name", DrawingName, writer, test);
			StepExecutor.SetText(driver, "Xpath", text_Description, "Drawing Description", DrawingDescription, writer, test);
			StepExecutor.SetText(driver, "Xpath", text_OutlinewidthTriangle, "Drawing Outlinewidth", Outlinewidth, writer, test);
			driver.findElement(text_OutlinewidthTriangle).sendKeys(Keys.TAB);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ClickAndDrawEllipse(WebDriver driver, String DrawingName, String DrawingDescription, String Outlinewidth, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_DrawEllipse, "Option Draw Ellipse", writer, test);
			AddDrawingEllipse( driver,  DrawingName,  DrawingDescription, Outlinewidth,  writer,  test);
			StepExecutor.ElementClick(driver, "Xpath", plot_LineFeature, "Point on map", writer, test);
			testValidations.ShapeValidation(driver, testValidations.shape_line, "Ellipse",  writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void AddDrawingEllipse(WebDriver driver, String DrawingName, String DrawingDescription, String Outlinewidth, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.SetText(driver, "Xpath", text_name, "Drawing Name", DrawingName, writer, test);
			StepExecutor.SetText(driver, "Xpath", text_Description, "Drawing Description", DrawingDescription, writer, test);
			StepExecutor.SetText(driver, "Xpath", text_OutlinewidthTriangle, "Drawing Outlinewidth", Outlinewidth, writer, test);
			driver.findElement(text_OutlinewidthTriangle).sendKeys(Keys.TAB);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ClickAndDrawPolygon(WebDriver driver, String DrawingName, String DrawingDescription, String Outlinewidth, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_DrawPolygon, "Option Draw Polygon", writer, test);
			AddDrawingPolygon( driver,  DrawingName,  DrawingDescription, Outlinewidth,  writer,  test);
			StepExecutor.ElementClick(driver, "Xpath", plot_LineFeature, "Point on map", writer, test);
			WebElement source = driver.findElement(plot_LineFeature);
			StepExecutor.DrawPolygonShapeOnMap(driver, source);
			testValidations.ShapeValidation(driver, testValidations.shape_line, "Polygon",  writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void AddDrawingPolygon(WebDriver driver, String DrawingName, String DrawingDescription, String Outlinewidth, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.SetText(driver, "Xpath", text_name, "Drawing Name", DrawingName, writer, test);
			StepExecutor.SetText(driver, "Xpath", text_Description, "Drawing Description", DrawingDescription, writer, test);
			StepExecutor.SetText(driver, "Xpath", text_OutlinewidthTriangle, "Drawing Outlinewidth", Outlinewidth, writer, test);
			driver.findElement(text_OutlinewidthTriangle).sendKeys(Keys.TAB);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ClickAndDrawFreehandPolygon(WebDriver driver, String DrawingName, String DrawingDescription, String Outlinewidth, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_DrawFreehandPolygon, "Option Draw Freehand Polygon", writer, test);
			AddDrawingFreehandPolygon( driver,  DrawingName,  DrawingDescription, Outlinewidth,  writer,  test);
			StepExecutor.ElementClick(driver, "Xpath", plot_LineFeature, "Point on map", writer, test);
			WebElement source = driver.findElement(plot_LineFeature);
			StepExecutor.DrawShapeOnMap(driver, source);
			testValidations.ShapeValidation(driver, testValidations.shape_line, "Freehand Polygon",  writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void AddDrawingFreehandPolygon(WebDriver driver, String DrawingName, String DrawingDescription, String Outlinewidth, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.SetText(driver, "Xpath", text_name, "Drawing Name", DrawingName, writer, test);
			StepExecutor.SetText(driver, "Xpath", text_Description, "Drawing Description", DrawingDescription, writer, test);
			StepExecutor.SetText(driver, "Xpath", text_OutlinewidthTriangle, "Drawing Outlinewidth", Outlinewidth, writer, test);
			driver.findElement(text_OutlinewidthTriangle).sendKeys(Keys.TAB);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ClickAndDrawText(WebDriver driver, String DrawingName, String DrawingDescription, String Outlinewidth, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.ElementClick(driver, "Xpath", option_DrawText, "Option Draw Text", writer, test);
			AddDrawingText( driver,  DrawingName,  DrawingDescription, Outlinewidth,  writer,  test);
			StepExecutor.ElementClick(driver, "Xpath", plot_LineFeature, "Point on map", writer, test);
			testValidations.ShapeValidation(driver, testValidations.shape_text, "Text",  writer, test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void AddDrawingText(WebDriver driver, String DrawingName, String DrawingDescription, String Outlinewidth, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			StepExecutor.SetText(driver, "Xpath", text_name, "Drawing Name", DrawingName, writer, test);
			StepExecutor.SetText(driver, "Xpath", text_Description, "Drawing Description", DrawingDescription, writer, test);
			driver.findElement(text_Description).sendKeys(Keys.TAB);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void UpdateDrawing(WebDriver driver, String DrawingName, String UpdateDrawingName, String UpdateDrawingDescription, String UpdateSymbolSize, String UpdateOutlinewidth, boolean OutlineWidth, boolean trianglewidth, boolean linewidth, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Thread.sleep(3000);
			StepExecutor.ElementClick(driver, "Xpath", btn_EditDrawing, "Button - Edit", writer, test);
			StepExecutor.SetText(driver, "Xpath", text_name, "Drawing Name", UpdateDrawingName, writer, test);
			StepExecutor.SetText(driver, "Xpath", text_Description, "Drawing Description", UpdateDrawingDescription, writer, test);
			if(OutlineWidth)
				StepExecutor.SetText(driver, "Xpath", text_Outlinewidth, "Outline Width",UpdateOutlinewidth, writer, test);
			else if(trianglewidth)
				StepExecutor.SetText(driver, "Xpath", text_OutlinewidthTriangle, "Width", UpdateOutlinewidth, writer, test);
			else if(linewidth)
				StepExecutor.SetText(driver, "Xpath", text_Linewidth, "Width", UpdateOutlinewidth, writer, test);
			StepExecutor.ElementClick(driver, "Xpath", btn_Save, "Button - Save", writer, test);
			//TestResults.PrintResultToReportWithScreenshot(DrawingName + " shape details updated successfully!" ,test);
			TestResults.PrintResultToReport(DrawingName + " shape details updated successfully!" ,test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void DeleteDrawing(WebDriver driver, String DrawingName, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Thread.sleep(3000);
			StepExecutor.ElementClick(driver, "Xpath", btn_DeleteDrawing, "Button - Edit", writer, test);
			StepExecutor.AcceptWindowsAlert(driver);
			//TestResults.PrintResultToReportWithScreenshot(DrawingName + " shape deleted successfully!" ,test);
			TestResults.PrintResultToReport(DrawingName + " shape deleted successfully!" ,test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
	
	public void ImportExportDrawing(WebDriver driver, BufferedWriter writer, ExtentTest test) throws Exception
	{
		try {
			Thread.sleep(2000);
			StepExecutor.ElementClick(driver, "Xpath", option_importExport, "Button - Edit", writer, test);
			StepExecutor.SetText(driver, "Xpath", input_Filename, "FileName", "ExportDrawing", writer, test);
			StepExecutor.ElementClick(driver, "Xpath", btn_export, "Button - Export", writer, test);
			//TestResults.PrintResultToReportWithScreenshot("Drawing is exported successfully!" ,test);
			TestResults.PrintResultToReport("Drawing is exported successfully!" ,test);
			String projectPath = System.getProperty("user.dir");
			WebElement eleupload = driver.findElement(By.xpath("//input[@class='file']"));
			Thread.sleep(2500);
			eleupload.sendKeys(projectPath+ "\\ImportFile\\LP Transmission [TEST].json");
			eleupload.sendKeys("C:\\Users\\kulkars2\\Downloads\\LP Transmission [TEST].json");
			StepExecutor.ElementClick(driver, "Xpath", btn_import, "Button - Import", writer, test);
			//TestResults.PrintResultToReportWithScreenshot("Drawing is imported successfully!" ,test);
			TestResults.PrintResultToReport("Drawing is imported successfully!" ,test);
		} catch (Exception error) {
			TestResults.PrintFailResultToReport(error.getMessage(), test);
			TestInitializer.IncrementTestCaseNumber();
			Assert.fail();
		}
	}
}
