package com.AdvanceSelenium;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;



public class MyListener implements ITestListener {
	
    public static Logger log =LogManager.getLogger(MyListener.class);
	ExtentReports reports;
	ExtentTest test;
    @Override
	public void onStart(ITestContext context) {
		log.info(" start");
		reports=myReport.viewReport();

	}
	
	@Override
	public void onTestStart(ITestResult result) {
		log.info("Test Case Execution Strat ="+result.getName());
       
		test=reports.createTest("test cases");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		log.info("Test Case Pass ="+result.getName());
		test.log(Status.PASS,"Test cases pass "+result.getName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		log.info("Test Case fail ="+result.getName());
		test.log(Status.FAIL,"Test cases fail "+result.getName());
		String screenShotPath=null;
		try {
			screenShotPath=ScreenShots.getInstance(result.getName());
		}catch(IOException e){
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(screenShotPath);
       
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		log.info("Test Case Skipped="+result.getName());
		test.log(Status.SKIP,"Test cases skip "+result.getName());

	}

	

	@Override
	public void onFinish(ITestContext context) {
		log.info("Test Case Execution completed");
		test.info("Execution completed");
		
		reports.flush();
		}
	
	

}
