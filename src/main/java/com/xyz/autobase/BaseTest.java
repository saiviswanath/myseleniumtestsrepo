package com.xyz.autobase;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
	private WebDriver driver;
	private Logger logger;
	
	@Parameters({ "browser" })
	@BeforeMethod(alwaysRun = true)
	public void setUp(String browser) {
		logger = LoggerFactory.getLogger(getClass());
		BrowserDriverFactory factory = new BrowserDriverFactory(browser, logger);
		driver = factory.createDriver();
		logger.info("Driver created");
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
}
