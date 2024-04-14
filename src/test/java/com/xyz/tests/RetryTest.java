package com.xyz.tests;

import org.testng.annotations.Test;

import com.xyz.autobase.BaseTest;
import com.xyz.autobase.retry.Retry;

public class RetryTest extends BaseTest {
	@Test(enabled=false, retryAnalyzer=Retry.class)
	public void retryTest() {
		logger.info("Retry");
	}
}
