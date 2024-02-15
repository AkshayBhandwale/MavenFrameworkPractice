package com.saucelab.TestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.saucelab.utilities.ReadConfig;

public class BaseClass {

	public static WebDriver driver;

	// Create object
	ReadConfig read = new ReadConfig();

	String browser = read.getBrowser();
	String URL = read.getURL();

	@BeforeClass
	public void setUp() {
		switch (browser.toLowerCase()) {

		case "chrome":
			driver = new ChromeDriver();
			break;

		case "firefox":
			driver = new FirefoxDriver();
			break;

		case "edge":
			driver = new EdgeDriver();

		default:
			System.out.println("Provide valid browser");
			break;
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver, String testName) throws IOException {
		TakesScreenshot ss = (TakesScreenshot)driver;
		File src = ss.getScreenshotAs(OutputType.FILE);
		File des = new File(System.getProperty("user.dir") + "/Screenshots/" + testName + ".png");
		FileUtils.copyFile(src, des);
	}

}
