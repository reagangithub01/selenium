package test;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import config.PropertiesFile;
import pages.GoogleSearchPage;
import pages.GoogleSearchPageObjects;

public class FirstSeleniumTest_ExtentReports {

	//static String browser; //use variable w/in the Class=FirstSeleniumTest
	public static String browser; //this variable is visible outside the Class like Properties.Java 
	static WebDriver driver = null;
	static ExtentReports extent = null;
	static ExtentTest test1 = null;
	static ExtentHtmlReporter htmlReporter;

	public static void main(String[] args) { try {
		
		htmlReporter = new ExtentHtmlReporter("extentReports.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		test1 = extent.createTest("Google Search Test One", "this is to validate google search functionality");
		
		setBrowser(); // calling function w/in the Class=FirstSeleniumTest
		PropertiesFile.readPropertiesFile(); 
		setBrowserConfig(); 
		runTest();
		endTest();
		//PropertiesFile.writePropertiesFile(); // to call Write Function under PropertiesFile Call
		
		test1.pass("Test Completed");
		extent.flush();

	}catch (Exception exp) { System.out.println("Cause po nito ay " +
			exp.getCause()); System.out.println("Message po nito ay " +
					exp.getMessage()); exp.printStackTrace(); } }


	//Set Functions per Actions
	//setBrowser
	//setBrowserConfig
	//runTest


	public static void setBrowser() { //this FUNCTON will NOT be called due 1) commented function under Main function 2) called properties file instead
		browser="Firefox";
	}


	public static void setBrowserConfig() {

		if(browser.contains("Firefox")) {
			System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
			System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			driver = new FirefoxDriver();
			test1.log(Status.INFO, "Selected Firefox Browser");
		}

		if(browser.contains("Chrome")) {
			System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
			driver = new ChromeDriver();
			test1.log(Status.INFO, "Selected Chrome Browser");
		}
	}


	public static void runTest() {

		test1.log(Status.INFO, "Starting Test Case");
		driver.manage().window().maximize();
		String url = "https://google.com";
		driver.get(url); //driver.get("https://google.com");
		System.out.println("Browser running and opening URL " + url);
		test1.pass("Navigated to google.com");

		GoogleSearchPageObjects searchPageObj = new GoogleSearchPageObjects(driver); //calling WebDriver from GoogleSearchPageObject class

		//driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		//GoogleSearchPage.textbox_search(driver).sendKeys("Automation Step by Step"); //referencing to pages/GoogleSearchPage class
		searchPageObj.setTextInSearchBox("ABCD"); //referencing to pages/GoogleSearchObjects class
		test1.pass("Entered text in searchbox");
		
		//driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		//GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN); //referencing to pages class
		searchPageObj.clickSearchButton(); //referencing to pages/GoogleSearchObjects class
		test1.pass("Pressed keyboard enter key");

		try {
			Thread.sleep(3000); //3 sec delay
		} catch (Exception exp) {
			exp.printStackTrace();
		}

	}
	
	public static void endTest() {
		driver.close();
		System.out.println("Browser closed");
		test1.pass("Closed the browser");
	}

	
}
