package com.xyz.tests;

import org.testng.annotations.Test;

import com.xyz.autobase.BaseTest;
import com.xyz.autobase.pageobjects.TOIPollPage;

public class TOIPollTests extends BaseTest {
	private static final String TOI_POLL_URL = "https://timesofindia.indiatimes.com/poll.cms";
	@Test
	public void pollAgree() {
		TOIPollPage pollPage = new TOIPollPage(driver, logger);
		pollPage.openPage(TOI_POLL_URL);
		pollPage.voteAgree();
	}
	
	@Test(enabled = true)
	public void pollDisAgree() {
		TOIPollPage pollPage = new TOIPollPage(driver, logger);
		pollPage.openPage(TOI_POLL_URL);
		pollPage.voteDisAgree();
	}
}
