package com.script.runner;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import com.utilities.TestInitializer;
import com.utilities.TestResults;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		glue={"com.script.stepdefination"},
		features = {"Features/BookmarkTool.feature", "Features/LayerListTool.feature", 
				"Features/ImageryTool.feature", "Features/EnhancedDrawTool.feature", 
				"Features/ElevationProfileTool.feature", "Features/MeasurementTool.feature", 
				"Features/LocatorTool.feature", "Features/ProximityTool.feature", 
				"Features/DirectionsTool.feature", "Features/SelectTool.feature",
				"Features/ShowStationTool.feature", "Features/Appdata.feature", 
				"Features/PrintTool.feature", "Features/PopupFunctions.feature", "Features/ExternalTool.feature"},
		plugin = {"rerun:target/rerun.txt", "pretty", "json:target/cucumber-reports/CucumberPOReport.json" },
		monochrome = true, 
		dryRun=false,
		tags = "@Regressiontest"
		)

public class AllToolsRunner extends AbstractTestNGCucumberTests{
	
	@BeforeClass
	public void BeforeTest() throws Exception
	{
		TestInitializer.ReadData();
	}
	
	@AfterSuite()
	public void SendEmail() throws Exception
	{
		TestResults.CloseFile();
		TestResults.SendEmail();
	}
}