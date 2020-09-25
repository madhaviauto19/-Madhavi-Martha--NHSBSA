package com.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentTestReports {

	public static ExtentReports extent;

	public static ExtentReports createInstance() {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("reports/test-report.html");

		htmlReporter.config().setEncoding("uft-8");
		htmlReporter.config().setDocumentTitle("Automation Reports");
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		return extent;
	}

	static ExtentTest extentTest;

	public static ExtentTest getExtentTest() {
		return extentTest;
	}

	public static void setExtentTest(ExtentTest extentTest) {
		ExtentTestReports.extentTest = extentTest;
	}
}
