package com.pageoperations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.utils.ExtentTestReports;
import com.utils.WebDriverUtils;

public class NHSCheckerPageOperations {

	static WebDriver driver;
	static ExtentTest extentTest;
	static Actions actions;

	public NHSCheckerPageOperations(WebDriver driver) {
		NHSCheckerPageOperations.driver = driver;
		extentTest = ExtentTestReports.getExtentTest();
		actions = new Actions(driver);
	}

	@FindBy(id = "next-button")
	private static WebElement startBtn;

	@FindBy(id = "next-button")
	private static WebElement nextBtn;

	@FindBy(xpath = "//input[@name='dateOfBirth.day']")
	private static WebElement dayOfBirth;

	@FindBy(xpath = "//input[@name='dateOfBirth.month']")
	private static WebElement monthOfBirth;

	@FindBy(xpath = "//input[@name='dateOfBirth.year']")
	private static WebElement yearOfBirth;

	@FindBy(xpath = "//input[@value='Yes']")
	private static WebElement yesBtn;

	@FindBy(xpath = "//input[@value='No']")
	private static WebElement noBtn;

	@FindBy(xpath = "//span[contains(text(),'savings')]")
	private static WebElement savingsAmount;

	@FindBy(xpath = "//h3[text()='You get free:']/following-sibling::ul[1]/li")
	private static List<WebElement> whatYouGetFree;

	@FindBy(xpath = "//h3[text()='You get money off:']/following-sibling::ul/li")
	private static List<WebElement> whatYouGetMoneyOff;

	@FindBy(xpath = "//span[@id='prescription-tick']")
	private static WebElement prescription;

	@FindBy(xpath = "//span[@id='sight-test-tick']")
	private static WebElement sightTests;

	public static void clickStartButton() {
		try {
			WebDriverUtils.waitToClickElement(startBtn);
			WebDriverUtils.scrollToViewOfElement(startBtn);
			startBtn.click();
			extentTest.pass("Clicked on start button");
		} catch (Exception e) {
			extentTest.fail("Got exception while clicking on start button. Exception occurred is: " + e.getMessage());
			throw e;
		}
	}

	public static void clickNext() {
		try {
			nextBtn.click();
			extentTest.pass("Clicked on next button");
		} catch (Exception e) {
			extentTest.fail("Got exception while clicking on next button. Exception occurred is: " + e.getMessage());
			throw e;
		}
	}

	public static void selectCountry(String country) {
		try {
			WebElement countryEle = driver.findElement(By.xpath("//input[@value='" + country.toUpperCase() + "']"));
			actions.moveToElement(countryEle).click().build().perform();
			extentTest.pass("Selected country: " + country);
		} catch (Exception e) {
			extentTest.fail(
					"Got exception while selecting country: " + country + ". Exception occurred is: " + e.getMessage());
			throw e;
		}
	}

	public static void enterDateOfBirth(String dob) {
		try {
			dayOfBirth.sendKeys(dob.split("-")[0]);
			monthOfBirth.sendKeys(dob.split("-")[1]);
			yearOfBirth.sendKeys(dob.split("-")[2]);
			extentTest.pass("Enetered date of birth as : " + dob);
		} catch (Exception e) {
			extentTest.fail("Got exception while selecting DOB: " + dob + ". Exception occurred is: " + e.getMessage());
			throw e;
		}
	}

	public static void selectYesOrNo(String option) {
		if (option.equalsIgnoreCase("yes"))
			actions.moveToElement(yesBtn).click().build().perform();
		else
			actions.moveToElement(noBtn).click().build().perform();
	}

	public static void selectPartnerStatus(String isPartner) {
		try {
			selectYesOrNo(isPartner);
			extentTest.pass("Selected partner status: " + isPartner);
		} catch (Exception e) {
			extentTest.fail("Got exception while selecting partner status: " + isPartner + ". Exception occurred is: "
					+ e.getMessage());
			throw e;
		}
	}

	public static void selectTaxClaim(String taxClaim) {
		try {
			selectYesOrNo(taxClaim);
			extentTest.pass("Selected tax claim status: " + taxClaim);
		} catch (Exception e) {
			extentTest.fail("Got exception while selecting tax claim status: " + taxClaim + ". Exception occurred is: "
					+ e.getMessage());
			throw e;
		}
	}

	public static void selectIfPregnant(String isPregnant) {
		try {
			selectYesOrNo(isPregnant);
			extentTest.pass("Selected if pregnant: " + isPregnant);
		} catch (Exception e) {
			extentTest.fail("Got exception while selecting if pregnant: " + isPregnant + ". Exception occurred is: "
					+ e.getMessage());
			throw e;
		}
	}

	public static void selectIllnessInArmedForces(String illnessInArmedForces) {
		try {
			selectYesOrNo(illnessInArmedForces);
			extentTest.pass("Selected if I have an injury or illness caused by serving in the armed forces: "
					+ illnessInArmedForces);
		} catch (Exception e) {
			extentTest.fail("Got exception while selecting illness caused by serving in the armed forces: "
					+ illnessInArmedForces + ". Exception occurred is: " + e.getMessage());
			throw e;
		}
	}

	public static void selectIfHaveDiabetes(String isDiabetes) {
		try {
			selectYesOrNo(isDiabetes);
			extentTest.pass("Selected if I have have diabetes: " + isDiabetes);
		} catch (Exception e) {
			extentTest.fail("Got exception while selecting if I have have glaucoma: " + isDiabetes
					+ ". Exception occurred is: " + e.getMessage());
			throw e;
		}
	}

	public static void selectIfHaveGlaucoma(String isGlaucoma) {
		try {
			selectYesOrNo(isGlaucoma);
			extentTest.pass("Selected if I have have glaucoma: " + isGlaucoma);
		} catch (Exception e) {
			extentTest.fail("Got exception while selecting if I have have glaucoma: " + isGlaucoma
					+ ". Exception occurred is: " + e.getMessage());
			throw e;
		}
	}

	public static void selectIfLivedInCareHome(String inCareHome) {
		try {
			selectYesOrNo(inCareHome);
			extentTest.pass("Selected if I or my partner live permanently in a care home: " + inCareHome);
		} catch (Exception e) {
			extentTest.fail("Got exception while selecting if I or my partner live permanently in a care home: "
					+ inCareHome + ". Exception occurred is: " + e.getMessage());
			throw e;
		}
	}

	public static void selectIfLocalCouncilPays(String payFromLocalCouncil) {
		try {
			selectYesOrNo(payFromLocalCouncil);
			extentTest.pass(
					"Selected if I get help to pay for your care home from your local council: " + payFromLocalCouncil);
			clickNext();
		} catch (Exception e) {
			extentTest.fail(
					"Got exception while selecting if I get help to pay for your care home from your local council: "
							+ payFromLocalCouncil + ". Exception occurred is: " + e.getMessage());
			throw e;
		}
	}

	public static void selectSavingsInCareHome(String isSavings, String amount) {
		try {
			if (savingsAmount.getText().contains(amount))
				extentTest.pass("Amount displayed for savings when lived in care home is: " + amount);
			else
				extentTest.fail(
						"Amount expected to display is: " + amount + ", but displayed is: " + savingsAmount.getText());
			selectYesOrNo(isSavings);
			extentTest.pass("Selected if me and my partner have more than £24,000 in savings, investments or property: "
					+ isSavings);
			clickNext();
		} catch (Exception e) {
			extentTest.fail(
					"Got exception while selecting if me and my partner have more than £24,000 in savings, investments or property: "
							+ isSavings + ". Exception occurred is: " + e.getMessage());
			throw e;
		}
	}

	public static void selectSavingsWhenNotInCareHome(String isSavings, String amount) {
		try {
			if (savingsAmount.getText().contains(amount))
				extentTest.pass("Amount displayed for savings when not lived in care home is: " + amount);
			else
				extentTest.fail(
						"Amount expected to display is: " + amount + ", but displayed is: " + savingsAmount.getText());
			selectYesOrNo(isSavings);
			extentTest.pass("Selected if me and my partner have more than £16,000 in savings, investments or property: "
					+ isSavings);
			clickNext();
		} catch (Exception e) {
			extentTest.fail(
					"Got exception while selecting if me and my partner have more than £16,000 in savings, investments or property: "
							+ isSavings + ". Exception occurred is: " + e.getMessage());
			throw e;
		}
	}

	public static void displayResult() {
		String whatYouGetFreeText = "";
		String whatYouGetMoneyOffText = "";
		try {
			if (prescription.isDisplayed())
				extentTest.pass("You get free: \n" + prescription.getText().trim());
			try {
				if (sightTests.isDisplayed())
					extentTest.pass("You get free: \n" + sightTests.getText().trim());
			} catch (Exception ex) {
				// When there is no free sight test available
			}
		} catch (Exception e) {
			for (int i = 0; i < whatYouGetFree.size(); i++) {
				whatYouGetFreeText = whatYouGetFreeText + String.valueOf(i + 1) + ". "
						+ whatYouGetFree.get(i).getText().trim() + "\n";
			}
			extentTest.pass("You get free: \n" + whatYouGetFreeText);
			try {
				for (int i = 0; i < whatYouGetMoneyOff.size(); i++) {
					whatYouGetMoneyOffText = whatYouGetMoneyOffText + String.valueOf(i + 1) + ". "
							+ whatYouGetMoneyOff.get(i).getText().trim() + "\n";
				}
				extentTest.pass("You get money off: \n" + whatYouGetMoneyOffText);
			} catch (Exception e1) {
				// When there is no ou get money off
			}
		}

	}
}
