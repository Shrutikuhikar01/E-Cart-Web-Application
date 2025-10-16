package com.Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class MyListner implements ITestListener {
	
	Logger logger = LogManager.getLogger(MyListner.class);
	ExtentReports reports;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		logger.info("Test Case Execution started" +result.getName());
		test = reports.createTest("Test Case Execution"+result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("Test Case Pass" +result.getName());
		test.log(Status.PASS,"Test Case Pass" +result.getName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.info("Test Case Fail" +result.getName());
		test.log(Status.FAIL,"Test Case Fail" +result.getName());
		String screenshotpath = MyScreenShots.getInstance(result.getName());
		test.addScreenCaptureFromPath(screenshotpath);

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info("Test Case Skipped" +result.getName());
		test.log(Status.SKIP,"Test Case Skip" +result.getName());

	}

	@Override
	public void onStart(ITestContext context) {
		logger.info("Test Suite Started");
		reports = MyReport.generateReport(context.getName());

	}

	@Override
	public void onFinish(ITestContext context) {
		logger.info("Test Suite Completed");
		reports.flush();
	}

}
