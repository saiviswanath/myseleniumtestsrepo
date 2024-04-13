package com.xyz.tests;

import java.util.Map;

import org.testng.annotations.Test;

import com.xyz.autobase.BaseTest;
import com.xyz.autobase.CsvDataProviders;

public class DataProviderTest extends BaseTest {
	@Test(enabled = false, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void dataProviderTest(Map<String, String> testData) {
		String id = testData.get("id");
		String name = testData.get("name");
		logger.info("ID: " + id + ", Name: " + name);
	}
}
