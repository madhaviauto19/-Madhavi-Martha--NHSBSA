package com.stepdefs;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.constants.TestConstants;
import com.pageoperations.NHSCheckerPageOperations;
import com.testrunner.TestRunner;
import com.utils.ExtentTestReports;
import com.utils.WebDriverUtils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NHSCostCheckerStepDef {

	WebDriver driver;
	ExtentReports extent;
	ExtentTest extentTest;
	SoftAssert softAssert = new SoftAssert();

	@Before
	public void reports(Scenario scenario) {
		extent = TestRunner.extent;
		ExtentTestReports.setExtentTest(extent.createTest(scenario.getName()));
		extentTest = ExtentTestReports.getExtentTest();
	}

	@Given("I have opened NHS Costs Checker in {string} and clicked on start button")
	public void i_have_opened_nhs_costs_checker_in_browser_and_clicked_on_start_button(String browser) {
		if (!WebDriverUtils.browserExecuting.trim().equals(browser.trim()) || WebDriverUtils.driver == null) {
			WebDriverUtils.destroyDriver();
			driver = WebDriverUtils.launchBrowser(browser);
		} else
			driver = WebDriverUtils.driver;
		extentTest.info("Browser launched: " + browser);
		WebDriverUtils.openUrl(TestConstants.launchUrl);
		PageFactory.initElements(driver, NHSCheckerPageOperations.class);
		NHSCheckerPageOperations.clickStartButton();
	}

	@When("I have selected {string} I live in")
	public void i_have_selected_i_live_in(String country) {
		NHSCheckerPageOperations.selectCountry(country);
	}

	@When("click next")
	public void click_next() {
		NHSCheckerPageOperations.clickNext();
	}

	@When("I have provided my {string}")
	public void i_have_provided_my(String dob) {
		NHSCheckerPageOperations.enterDateOfBirth(dob);
	}

	@When("I have answered my partner status as {string}")
	public void i_have_answered_my_partner_status_as(String isPartner) {
		NHSCheckerPageOperations.selectPartnerStatus(isPartner);
	}

	@When("I have answered tax claim as {string}")
	public void i_have_answered_tax_claim_as(String taxClaim) {
		NHSCheckerPageOperations.selectTaxClaim(taxClaim);
	}

	@When("I have answered if I am pregnant as {string}")
	public void i_have_answered_if_i_am_pregnant_as(String isPregnant) {
		NHSCheckerPageOperations.selectIfPregnant(isPregnant);
	}

	@When("I have selected {string} about any illness in armed forces")
	public void i_have_selected_about_any_illness_in_armed_forces(String illnessInArmedForces) {
		NHSCheckerPageOperations.selectIllnessInArmedForces(illnessInArmedForces);
	}

	@When("I have selected {string} for diabetes")
	public void i_have_selected_for_diabetes(String isDiabetes) {
		NHSCheckerPageOperations.selectIfHaveDiabetes(isDiabetes);
	}

	@When("I have selected {string} for glaucoma")
	public void i_have_selected_for_glaucoma(String isGlaucoma) {
		NHSCheckerPageOperations.selectIfHaveGlaucoma(isGlaucoma);
	}

	@When("I have selected if myself or my partner live {string}")
	public void i_have_selected_if_myself_or_my_partner_live(String inCareHome) {
		NHSCheckerPageOperations.selectIfLivedInCareHome(inCareHome);
	}

	@When("If lived in {string} and I have selected {string} and based on pay from local cuncil, I have selected {string} for {string}")
	public void if_lived_in_and_i_have_selected_and_based_on_pay_from_local_cuncil_i_have_selected_for(
			String inCareHome, String payFromLocalCouncil, String isSavings, String amount) {
		if (inCareHome.equalsIgnoreCase("Yes")) {
			NHSCheckerPageOperations.selectIfLocalCouncilPays(payFromLocalCouncil);
			if (payFromLocalCouncil.equalsIgnoreCase("No")) {
				NHSCheckerPageOperations.selectSavingsInCareHome(isSavings, amount);
			}
		}
	}

	@When("If not lived in {string} and I have selected {string} for {string}")
	public void if_not_lived_in_and_i_have_selected_for(String inCareHome, String isSavings, String amount) {
		if (inCareHome.equalsIgnoreCase("No"))
			NHSCheckerPageOperations.selectSavingsWhenNotInCareHome(isSavings, amount);
	}

	@Then("I get the result whether i will get help from NHS or not")
	public void i_get_the_result_whether_i_will_get_help_from_nhs_or_not() {
		NHSCheckerPageOperations.displayResult();
	}

	@After
	public void afterScenario(Scenario scenario) {
		extentTest.addScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64));
	}

}
