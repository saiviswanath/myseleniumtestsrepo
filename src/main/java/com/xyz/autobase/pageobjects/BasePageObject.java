package com.xyz.autobase.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

public class BasePageObject {
	private WebDriver driver;
	private Logger logger;
	
	public BasePageObject(WebDriver driver, Logger logger) {
		super();
		this.driver = driver;
		this.logger = logger;
	}
	
	public void openPage(String url) {
		driver.get(url);
		logger.info("Opening page");
	}
	
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}
	
	public void sendText(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	public void click(WebElement element) {
		element.click();
	}
	
	private void visibilityShown(ExpectedCondition<WebElement> condition, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(driver -> condition);
	}
	
	public void waitForElementToAppear(By locator, long timeout) {
		visibilityShown(ExpectedConditions.visibilityOfElementLocated(locator), timeout);
	}
	
	public void waitForWebElementToAppear(WebElement ele, long timeout) {
		visibilityShown(ExpectedConditions.visibilityOf(ele), timeout);
	}
	
}
