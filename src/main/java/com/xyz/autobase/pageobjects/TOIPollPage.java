package com.xyz.autobase.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;

public class TOIPollPage extends BasePageObject {
	public TOIPollPage(WebDriver driver, Logger logger) {
		super(driver, logger);
	}
	
	public TOIVoteResultPage voteAgree() {
		WebElement radioele = findElement(By.xpath("//form[@id='pollform']/table/tbody/tr[2]/td[@class='normtxt']/input[1]"));
		click(radioele);
		textCaptchaProcess();
		return new TOIVoteResultPage(driver, logger);
	}
	
	public TOIVoteResultPage voteDisAgree() {
		WebElement radioele = findElement(By.xpath("//form[@id='pollform']/table/tbody/tr[2]/td[@class='normtxt']/input[2]"));
		click(radioele);
		textCaptchaProcess();
		return new TOIVoteResultPage(driver, logger);
	}
	
	public void textCaptchaProcess() {
		String textCapVal = findElement(By.xpath("/html//span[@id='mathq2']")).getText();
		String[] nums = textCapVal.split("\\+");
		String sec = nums[1].split("=")[0].trim();
		int sum = Integer.parseInt(nums[0].trim()) + Integer.parseInt(sec);
		WebElement capText = findElement(By.xpath("/html//input[@id='mathuserans2']"));
		sendText(capText, String.valueOf(sum));
		WebElement voteBut = findElement(By.xpath("//form[@id='pollform']/table//td[@class='button']/div[@class='homesprite vot']"));
		click(voteBut);
	}

}
