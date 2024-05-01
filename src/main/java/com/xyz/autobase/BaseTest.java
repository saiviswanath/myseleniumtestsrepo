package com.xyz.autobase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class BaseTest {
	protected WebDriver driver;
	protected Logger logger;
	protected Connection snowFlakeconn;
	
	protected String testSuiteName;
	protected String testName;
	protected String testMethodName;
	
	//@Parameters({ "browser"})
	@BeforeMethod(alwaysRun = true)
	public void setUp(Method method, 
			//@Optional("chrome") String browser, 
			ITestContext ctx) throws SQLException, IOException {
		
		//Props
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "//src//main//resources//app.properties");
		prop.load(fis);

		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
		
		String testName = ctx.getCurrentXmlTest().getName();
		logger = LogManager.getLogger(testName);
		
		BrowserDriverFactory factory = new BrowserDriverFactory(browserName, logger);
		driver = factory.createDriver();
		logger.info("Driver created");
		
		driver.manage().window().maximize();
		
		this.testSuiteName = ctx.getSuite().getName();
		this.testName = testName;
		this.testMethodName = method.getName();
		
		DBConnectionFactory snowFlakeconnFac = new DBConnectionFactory("snowflake");
		snowFlakeconn = snowFlakeconnFac.getConnection();
		logger.info("Snowflake Connection Created");
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		logger.info("Driver closed");
		driver.quit();
		try {
			snowFlakeconn.close();
			logger.info("Snowflake Connection closed!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="files")
	protected static Object[][] files() {
		return new Object[][] {
			{1,"index.html"},
			{2,"logo.png"},
			{3,"text.txt"}
		};
	}
	
	protected String takeScreenshot(String fileName) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") 
				+ File.separator + "test-output" 
				+ File.separator + "screenshots"
				+ File.separator + getTodaysDate() 
				+ File.separator + testSuiteName 
				+ File.separator + testName
				+ File.separator + testMethodName 
				+ File.separator + getSystemTime() 
				+ " " + fileName + ".png";
		try {
			FileUtils.copyFile(scrFile, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	
	private static String getTodaysDate() {
		return (new SimpleDateFormat("yyyyMMdd").format(new Date()));
	}

	private String getSystemTime() {
		return (new SimpleDateFormat("HHmmssSSS").format(new Date()));
	}
}
