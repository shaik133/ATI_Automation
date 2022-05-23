/**
 * 
 */
package com.rsa.qa.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * @author Admin
 *
 */
public class ExtentReport {

	static ExtentSparkReporter reporter;
	static ExtentReports extent;
	static ExtentTest test;
	
	public static  void reportSetup() throws IOException
	{
		String timestamp= new SimpleDateFormat("yyyy.MM.dd.hh.MM.ss").format(new Date());
		
		reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\Reports\\Test_report_"+timestamp+".html");
		
		reporter.loadXMLConfig("extent-config.xml");
		reporter.config().setReportName("Extent Reports");
		reporter.config().setDocumentTitle("Testing reporter");
		reporter.config().setTheme(Theme.DARK);
	
		extent= new ExtentReports();
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("Tester", "SJS");
		extent.setSystemInfo("Env", "QA");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("OS", "Windows10");
		
	}
	
	public static void flushReport()
	{
		extent.flush();
	}
	
}
