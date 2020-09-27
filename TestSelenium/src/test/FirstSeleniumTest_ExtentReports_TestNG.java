package test;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import config.PropertiesFile;
import pages.GoogleSearchPageObjects;

public class FirstSeleniumTest_ExtentReports_TestNG {

	public static String browser; //this variable is visible outside the Class like Properties.Java 
	static WebDriver driver = null;
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent = null;
	static ExtentTest test2 = null;


	//	public static void main(String[] args) { 
	//	 	try {
	//		
	//		setBrowser(); // calling function w/in the Class=FirstSeleniumTest
	//		PropertiesFile.readPropertiesFile(); 
	//		setBrowserConfig(); 
	//		runTest();
	//		endTest();
	//		//PropertiesFile.writePropertiesFile(); // to call Write Function under PropertiesFile Call
	//		
	//		}catch (Exception exp) { System.out.println("Cause po nito ay " +
	//			exp.getCause()); System.out.println("Message po nito ay " +
	//					exp.getMessage()); exp.printStackTrace(); } 
	//	}

	@BeforeSuite
	public static void setBrowser() { //this FUNCTON will NOT be called due 1) commented function under Main function 2) called properties file instead
		browser="Firefox";
		
		htmlReporter = new ExtentHtmlReporter("extentReportsTestNG.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@BeforeTest
	public static void setBrowserConfig() {
			
		if(browser.contains("Firefox")) {
			System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
			System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			driver = new FirefoxDriver();

		}

		if(browser.contains("Chrome")) {
			System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
			driver = new ChromeDriver();

		}
	}

	@Test
	public static void runTest() {

		test2 = extent.createTest("Google Search Test One", "this is to validate google search functionality");

		test2.log(Status.INFO, "Starting Test Case 2");
		driver.manage().window().maximize();
		String url = "https://google.com";
		driver.get(url); //driver.get("https://google.com");
		System.out.println("Browser running and opening URL " + url);
		test2.pass("Navigated to google.com");

		GoogleSearchPageObjects searchPageObj = new GoogleSearchPageObjects(driver); //calling WebDriver from GoogleSearchPageObject class

		searchPageObj.setTextInSearchBox("ABCD"); //referencing to pages/GoogleSearchObjects class
		test2.pass("Entered text in searchbox");

		searchPageObj.clickSearchButton(); //referencing to pages/GoogleSearchObjects class
		test2.pass("Pressed keyboard enter key");

		try {
			Thread.sleep(3000); //3 sec delay
		} catch (Exception exp) {
			exp.printStackTrace();
		}

	}

	@AfterTest
	public static void endTest() {
		driver.close();
		System.out.println("Browser closed");
		test2.info("Test 2 Completed");
		extent.flush();
	}


}
