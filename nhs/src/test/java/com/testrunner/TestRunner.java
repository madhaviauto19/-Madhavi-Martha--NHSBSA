package com.testrunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.utils.ExtentTestReports;
import com.utils.WebDriverUtils;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = "com/stepdefs", monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {

	public static ExtentReports extent;

	@BeforeClass
	public void before() {
		extent = ExtentTestReports.createInstance();
	}

	@AfterClass
	public void after() {
		WebDriverUtils.destroyDriver();
		extent.flush();
	}
}
