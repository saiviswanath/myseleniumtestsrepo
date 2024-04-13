package com.xyz.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.xyz.autobase.BaseTest;
import com.xyz.autobase.pageobjects.TOIPollPage;
import com.xyz.autobase.pageobjects.TOIVoteResultPage;

public class TOIPollTests extends BaseTest {
	private static final String TOI_POLL_URL = "https://timesofindia.indiatimes.com/poll.cms";
	private static final String TOI_VOTE_URL = "https://timesofindia.indiatimes.com/vote.cms";
	@Test
	public void pollAgree() {
		TOIPollPage pollPage = new TOIPollPage(driver, logger);
		pollPage.openPage(TOI_POLL_URL);
		takeScreenshot("TOIPollPage");
		TOIVoteResultPage result = pollPage.voteAgree();
		takeScreenshot("TOIResultPage");
		Assert.assertTrue(result.getResultMessage().contains("You have successfully cast your vote"));
		Assert.assertTrue(result.getPercentAgree().matches("\\d{2}"));
		Assert.assertTrue(result.getPercentDisAgree().matches("\\d{2}"));
		Assert.assertEquals(result.getCurrentUrl(), TOI_VOTE_URL);
	}
	
	@Test(enabled = true)
	public void pollDisAgree() {
		TOIPollPage pollPage = new TOIPollPage(driver, logger);
		pollPage.openPage(TOI_POLL_URL);
		takeScreenshot("TOIPollPage");
		TOIVoteResultPage result = pollPage.voteDisAgree();
		takeScreenshot("TOIResultPage");
		Assert.assertTrue(result.getResultMessage().contains("You have successfully cast your vote"));
		Assert.assertTrue(result.getPercentAgree().matches("\\d{2}"));
		Assert.assertTrue(result.getPercentDisAgree().matches("\\d{2}"));
		Assert.assertEquals(result.getCurrentUrl(), TOI_VOTE_URL);
	}
}
