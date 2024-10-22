package com.script.runner;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import com.utilities.TestInitializer;
import com.utilities.TestResults;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		glue={"com.script.stepdefination"},
		features = {"Features/ElevationProfileTool.feature"},
		plugin = {"rerun:target/rerun.txt", "pretty", "json:target/cucumber-reports/CucumberPOReport.json" },
		monochrome = true,dryRun=false,
		tags = "@Regressiontest"
		)

public class ElevationProfileToolRunner extends AbstractTestNGCucumberTests{
	
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
