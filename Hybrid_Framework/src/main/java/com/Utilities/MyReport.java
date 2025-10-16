package com.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MyReport {
	public static ExtentReports generateReport(String name) {
		String path = System.getProperty("user.dir")+"/Reports/"+name+".html";
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setDocumentTitle("Automation Testing");
		sparkReporter.config().setReportName("Sanity Test Cases");
		
		ExtentReports reports = new ExtentReports();
		reports.setSystemInfo("Tester Name ","Shruti");
		reports.setSystemInfo("Environment ","QA");
		reports.setSystemInfo("Browser","Chrome");
		reports.setSystemInfo("Operating System","Window");

		reports.attachReporter(sparkReporter);
		return reports;
	}

}
