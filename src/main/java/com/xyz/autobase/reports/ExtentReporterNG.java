package com.xyz.autobase.reports;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir") 
				+ File.separator + "test-output" 
				+ File.separator + "extent-reports"
				+ File.separator + getTodaysDate() + File.separator + getSystemTime() + File.separator + "index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Sai Viswanath");
		return extent;
	}
	
	private static String getTodaysDate() {
		return (new SimpleDateFormat("yyyyMMdd").format(new Date()));
	}
	
	private static String getSystemTime() {
		return (new SimpleDateFormat("HHmmssSSS").format(new Date()));
	}
}
