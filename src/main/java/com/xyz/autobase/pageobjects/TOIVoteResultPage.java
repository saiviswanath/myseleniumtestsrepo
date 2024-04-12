package com.xyz.autobase.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;

public class TOIVoteResultPage extends BasePageObject {

	public TOIVoteResultPage(WebDriver driver, Logger logger) {
		super(driver, logger);
	}
	
	public String getResultMessage() {
		WebElement resultEle = findElement(By.xpath("//div[@id='polldiv']/table/tbody/tr/td/table[1]//td/font/b"));
		return resultEle.getText();
	}
	
	public String getPercentAgree() {
		WebElement resultEle = findElement(By.xpath("//div[@id='polldiv']/table/tbody/tr/td/table[2]/tbody/tr[2]/td[2]//font/optionperc"));
		return resultEle.getText();
	}
	
	public String getPercentDisAgree() {
		WebElement resultEle = findElement(By.xpath("//div[@id='polldiv']/table/tbody/tr/td/table[2]/tbody/tr[3]/td[2]//font/optionperc"));
		return resultEle.getText();
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

}
