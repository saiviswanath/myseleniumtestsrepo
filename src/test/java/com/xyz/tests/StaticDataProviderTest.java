package com.xyz.tests;

import org.testng.annotations.Test;

import com.xyz.autobase.BaseTest;

public class StaticDataProviderTest extends BaseTest {
	@Test(enabled=false, dataProvider="files")
	public void staticDataProvider(int no, String filename) {
		logger.info("No: " + no + ", Filename: " + filename);
	}
}
