package com.utilities;

import java.util.ArrayList;
import java.util.List;

import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class TestStatistics implements ITestListener {

	List<ITestNGMethod> passedtests = new ArrayList<ITestNGMethod>();
	List<ITestNGMethod> failedtests = new ArrayList<ITestNGMethod>();
	List<ITestNGMethod> skippedtests = new ArrayList<ITestNGMethod>();

    @Override
    public void onTestSuccess(ITestResult result) {
       //add the passed tests to the passed list
        passedtests.add(result.getMethod());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        //add the failed tests to the failed list
        failedtests.add(result.getMethod());
    }
    @Override

     //This method will automatically be called if a test is skipped
     public void onTestSkipped(ITestResult result) {

         //add the skipped tests to the skipped list
        skippedtests.add(result.getMethod());
    }       
}
