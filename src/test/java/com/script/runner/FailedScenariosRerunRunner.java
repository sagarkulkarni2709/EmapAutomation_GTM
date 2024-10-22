package com.script.runner;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import com.utilities.SendReport;
import com.utilities.TestInitializer;
import com.utilities.TestResults;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		glue={"com.script.stepdefination"},
		features = {"@target/rerun.txt"},
		monochrome = true, // to avoid junk characters in output
		dryRun=false, // checks mapping between scenario steps and step definition file
		tags = "@Regressiontest"
		)

public class FailedScenariosRerunRunner extends AbstractTestNGCucumberTests{
	
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
