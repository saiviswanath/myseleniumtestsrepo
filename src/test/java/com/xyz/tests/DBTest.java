package com.xyz.tests;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.annotations.Test;

import com.xyz.autobase.BaseTest;
import com.xyz.autobase.DBUtils;

public class DBTest extends BaseTest {
	@Test
	public void menuTest() throws SQLException {
		List<LinkedHashMap<String, String>> list = DBUtils.getMenuDetails(snowFlakeconn);
		logger.info("LIST123: " + list);
	}
}
