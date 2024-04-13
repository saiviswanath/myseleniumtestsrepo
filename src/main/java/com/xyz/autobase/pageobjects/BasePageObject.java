package com.xyz.autobase.pageobjects;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {
	protected WebDriver driver;
	protected Logger logger;
	
	public BasePageObject(WebDriver driver, Logger logger) {
		super();
		this.driver = driver;
		this.logger = logger;
	}
	
	protected void openUrl(String url) {
		driver.get(url);
		logger.info("Opening page");
	}
	
	protected WebElement find(By locator) {
		return driver.findElement(locator);
	}
	
	protected void type(String text, By locator) {
		waitForVisibilityOf(locator, Duration.ofSeconds(5));
		find(locator).sendKeys(text);
	}
	
	public void click(By locator) {
		waitForVisibilityOf(locator, Duration.ofSeconds(5));
		find(locator).click();
		
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	private void waitFor(ExpectedCondition<WebElement> condition, Duration timeOutInSeconds) {
		timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : Duration.ofSeconds(30);
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(condition);
	}
	
	protected void waitForVisibilityOf(By locator, Duration... timeOutInSeconds) {
		int attempts = 0;
		while (attempts < 2) {
			try {
				waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
						(timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
	}

	
	public void waitForWebElementToAppear(WebElement ele, Duration... timeOutInSeconds) {
		int attempts = 0;
		while (attempts < 2) {
			try {
				waitFor(ExpectedConditions.visibilityOf(ele),
						(timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
	}
	
	public void setCookie(Cookie ck) {
		logger.info("Adding cookie " + ck.getName());
		driver.manage().addCookie(ck);
		logger.info("Cookie added");
	}

	public String getCookie(String name) {
		logger.info("Getting value of cookie " + name);
		return driver.manage().getCookieNamed(name).getValue();
	}
	
}
