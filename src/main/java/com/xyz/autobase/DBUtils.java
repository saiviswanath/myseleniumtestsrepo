package com.xyz.autobase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class DBUtils {
	public static List<LinkedHashMap<String, String>> getMenuDetails(Connection conn) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement("select * from menu limit 5");
		ResultSet res = stmt.executeQuery();
		List<LinkedHashMap<String, String>> list = new ArrayList<>();
		while (res.next()) {
			LinkedHashMap<String, String> map = new LinkedHashMap<>();
			map.put("MENU_TYPE", res.getString("MENU_TYPE"));
			map.put("ITEM_CATEGORY", res.getString("ITEM_CATEGORY"));
			list.add(map);
		}
		return list;
	}
}
