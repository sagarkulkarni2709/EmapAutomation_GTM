package com.script.runner;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import com.utilities.TestInitializer;
import com.utilities.TestResults;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		glue={"com.script.stepdefination"},
		features = {"Features/BookmarkTool.feature"},
		plugin = {"rerun:target/rerun.txt", "pretty", "json:target/cucumber-reports/CucumberPOReport.json" },
		monochrome = true, // to avoid junk characters in output
		dryRun=false, // checks mapping between scenario steps and step definition file
		tags = "@Regressiontest"
		)

public class BookmarkToolRunner extends AbstractTestNGCucumberTests{
	
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
