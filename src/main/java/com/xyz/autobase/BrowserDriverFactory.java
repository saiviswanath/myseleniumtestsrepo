package com.xyz.autobase;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserDriverFactory {
	private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	private String browser;
	private Logger logger;
	public BrowserDriverFactory(String browser, Logger logger) {
		this.browser = browser.toLowerCase();
		this.logger = logger;
	}
	
	public WebDriver createDriver() {
		switch(browser) {
		case "chrome": 
			//System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
			logger.info("Created chrome driver");
			break;
		case "firefox": 
			//System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());	
			logger.info("Created firefox driver");
			break;
		default:
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver.set(new ChromeDriver());
			logger.info("Defaultly Created chrome driver");
			break;
		}
		return driver.get();
	}
}
