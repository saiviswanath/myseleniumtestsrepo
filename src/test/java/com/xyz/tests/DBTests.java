package com.xyz.tests;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.annotations.Test;

import com.xyz.autobase.BaseTest;
import com.xyz.autobase.DBUtils;

public class DBTests extends BaseTest {
	@Test
	public void menuTest() throws SQLException {
		List<LinkedHashMap<String, String>> list = DBUtils.getMenuDetails(snowFlakeconn, "select * from menu limit 5");
		logger.info("LIST: " + list);
	}
	
	@Test
	public void menuTest1() throws SQLException {
		List<LinkedHashMap<String, String>> list = DBUtils.getMenuDetails(snowFlakeconn, "select * from menu limit 2");
		logger.info("LIST1: " + list);
	}
	
	@Test
	public void menuTest2() throws SQLException {
		List<LinkedHashMap<String, String>> list = DBUtils.getMenuDetails(snowFlakeconn, "select * from menu limit 1");
		logger.info("LIST2: " + list);
	}
	
	@Test
	public void menuTest3() throws SQLException {
		List<LinkedHashMap<String, String>> list = DBUtils.getMenuDetails(snowFlakeconn, "select * from menu limit 3");
		logger.info("LIST3: " + list);
	}
	
	@Test
	public void menuTest4() throws SQLException {
		List<LinkedHashMap<String, String>> list = DBUtils.getMenuDetails(snowFlakeconn, "select * from menu limit 4");
		logger.info("LIST4: " + list);
	}
}
