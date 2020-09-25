package com.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtils {

	public static WebDriver driver;
	static int maxWaitTime = 30;
	public static String browserExecuting = "";

	/*
	 * Initializing WebDriver based on the browser provided
	 */
	public static WebDriver launchBrowser(String browser) {
		switch (browser.toUpperCase()) {
		case "CHROME":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "FIREFOX":
			String osName = System.getProperty("os.name").toUpperCase();
			if (osName.contains("LINUX"))
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/Drivers/linux-geckodriver");
			else if (osName.contains("WINDOWS"))
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/Drivers/geckodriver.exe");
			else if (osName.contains("MAC"))
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/Drivers/mac-geckodriver");
			FirefoxOptions firefoxOptions=new FirefoxOptions();
			firefoxOptions.setCapability("marionette",true);
			driver=new FirefoxDriver(firefoxOptions);
			break;
		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		browserExecuting = browser;
		driver.manage().window().maximize();
		return driver;
	}

	/*
	 * Open the given URL
	 */
	public static void openUrl(String url) {
		if (driver != null)
			driver.get(url);
	}

	/*
	 * It will close all windows and destroy the driver
	 */
	public static WebDriver destroyDriver() {
		if (driver != null)
			driver.quit();
		return driver;
	}

	/*
	 * To wait until element is displayed
	 */
	public static void waitToDisplayElement(WebElement element, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * To wait until element is clickable
	 */
	public static void waitToClickElement(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, maxWaitTime);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * Scroll to the element view
	 */
	public static void scrollToViewOfElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

}
