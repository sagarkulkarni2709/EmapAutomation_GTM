package com.applicationfunctions.common;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import com.utilities.TestInitializer;
import com.utilities.TestResults;

public class BaseClass {
	
	@BeforeClass
	public void BeforeTest() throws Exception
	{
		TestInitializer.ReadData();
	}
	
	@AfterTest
	public static void AfterTest() throws Exception
	{
		TestResults.CloseFile();
	}
}
