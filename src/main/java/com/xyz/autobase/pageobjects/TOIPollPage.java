package com.xyz.autobase.pageobjects;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TOIPollPage extends BasePageObject {
	public TOIPollPage(WebDriver driver, Logger logger) {
		super(driver, logger);
	}
	
	public void openPage(String pageUrl) {
		logger.info("Opening page: " + pageUrl);
		openUrl(pageUrl);
		logger.info("Page opened!");
	}
	
	public TOIVoteResultPage voteAgree() {
		click(By.xpath("//form[@id='pollform']/table/tbody/tr[2]/td[@class='normtxt']/input[1]"));
		//click(By.cssSelector(".normtxt > input:nth-of-type(1)"));
		textCaptchaProcess();
		return new TOIVoteResultPage(driver, logger);
	}
	
	public TOIVoteResultPage voteDisAgree() {
		click(By.xpath("//form[@id='pollform']/table/tbody/tr[2]/td[@class='normtxt']/input[2]"));
		textCaptchaProcess();
		return new TOIVoteResultPage(driver, logger);
	}
	
	public void textCaptchaProcess() {
		String textCapVal = find(By.xpath("/html//span[@id='mathq2']")).getText();
		String[] nums = textCapVal.split("\\+");
		String sec = nums[1].split("=")[0].trim();
		int sum = Integer.parseInt(nums[0].trim()) + Integer.parseInt(sec);
		type(String.valueOf(sum), By.xpath("/html//input[@id='mathuserans2']"));
		click(By.xpath("//form[@id='pollform']/table//td[@class='button']/div[@class='homesprite vot']"));
	}

}
