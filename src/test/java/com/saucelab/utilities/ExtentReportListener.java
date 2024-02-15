package com.saucelab.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListener implements ITestListener {

	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;

	// Method for report config
	public void configureReport() {
		//ReadConfig readConfig = new ReadConfig();
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String ReportName = "ExtentReport"+timestamp+".html";
		
		//htmlReporter = new ExtentSparkReporter("ExtentReport.html");
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//Reports//"+ReportName);	
		
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// Add environment details
		reports.setSystemInfo("Machine", "TestPC1");
		reports.setSystemInfo("OS", "Windows 11");	
		reports.setSystemInfo("User1", "Test1");
		reports.setSystemInfo("Browser", "Chrome");

		// Configuration to change look and feel
		htmlReporter.config().setDocumentTitle("Extent Report Demo");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	}

	// Invoke before execution of any test only once
	public void onStart(ITestContext Result) {
		configureReport();
		System.out.println("on Start method invoke...");
	}

	// Invoke after execution of all test only once
	public void onFinish(ITestContext Result) {
		System.out.println("on finish method invoke...");
		reports.flush();

	}

	// When Test case is failed
	public void onTestFailure(ITestResult Result) {
		System.out.println("Name of the failed test case : " + Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.FAIL,
				MarkupHelper.createLabel("Name of the failed test case is : " + Result.getName(), ExtentColor.RED));
		test.fail(Result.getThrowable());
	}

	// When Test case is skipped
	public void onTestSkipped(ITestResult Result) {
		System.out.println("Name of the skipped test case : " + Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.SKIP,
				MarkupHelper.createLabel("Name of the failed test case is : " + Result.getName(), ExtentColor.YELLOW));
		test.skip(Result.getThrowable());
	}

	// When Test Case is started then this will invoke for all test cases
	public void onTestStart(ITestResult Result) {
		System.out.println("Name of Test Case method started: " + Result.getName());
	}

	// When Test Case is passed
	public void onTestSuccess(ITestResult Result) {
		System.out.println("Name of Test Case method success : " + Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.PASS,
				MarkupHelper.createLabel("Name of the passed test case is : " + Result.getName(), ExtentColor.GREEN));

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// not implemented
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

}
