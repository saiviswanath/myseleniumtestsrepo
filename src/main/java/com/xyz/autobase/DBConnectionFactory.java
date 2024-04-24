package com.xyz.autobase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectionFactory {
	//private ThreadLocal<Connection> conn = new ThreadLocal<>();
	private Connection conn;
	private String db;
	
	public DBConnectionFactory(String db) {
		this.db = db;
	}
	
	public Connection getConnection() throws SQLException {
		switch(db) {
		case "snowflake":
			Properties properties = new Properties();
		    properties.put("user", "saiviswanathpalaparthi");     // replace "" with your username
		    properties.put("password", "Shradha139#"); // replace "" with your password
		    properties.put("account", "xogzozv-ct67552");  // replace "" with your account name
		    properties.put("db", "TASTY_BYTES_SAMPLE_DATA");       // replace "" with target database name
		    properties.put("schema", "RAW_POS");   // replace "" with target schema name
		    //properties.put("tracing", "on");
			String jdbcUrl = "jdbc:snowflake://xogzozv-ct67552.snowflakecomputing.com";
			conn = DriverManager.getConnection(jdbcUrl, properties);
			break;
		}
		return conn;
	}
}
