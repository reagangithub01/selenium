package test;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import config.PropertiesFile;
import pages.GoogleSearchPage;
import pages.GoogleSearchPageObjects;

public class FirstSeleniumTest_TestNG {

	//static String browser; //use variable w/in the Class=FirstSeleniumTest
	public static String browser; //this variable is visible outside the Class like Properties.Java 
	static WebDriver driver = null;
	
	
	public static void main(String[] args) {
		try {

			//setBrowser(); // calling function w/in the Class=FirstSeleniumTest
			PropertiesFile.readPropertiesFile();
			setBrowserConfig();
			runTest();
			//PropertiesFile.writePropertiesFile(); // to call Write Function under PropertiesFile Call

		}catch (Exception exp) {
			System.out.println("Cause po nito ay " + exp.getCause());
			System.out.println("Message po nito ay " + exp.getMessage());
			exp.printStackTrace();
		}
	}

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
		}
		
		if(browser.contains("Chrome")) {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		driver = new ChromeDriver();
		}
	}

	public static void runTest() {

		driver.manage().window().maximize();
		String url = "https://hago-pilot-model-portal.herokuapp.com/pilotmodelportal/login";
		driver.get(url); //driver.get("https://google.com");
		System.out.println("Browser running and opening URL " + url);
		
		GoogleSearchPageObjects searchPageObj = new GoogleSearchPageObjects(driver); //calling WebDriver from GoogleSearchPageObject class
		
		//driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
		//GoogleSearchPage.textbox_search(driver).sendKeys("Automation Step by Step"); //referencing to pages/GoogleSearchPage class
		//searchPageObj.setTextInSearchBox("ABCD"); //referencing to pages/GoogleSearchObjects class
		
		//driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		//GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN); //referencing to pages class
		//searchPageObj.clickSearchButton(); //referencing to pages/GoogleSearchObjects class
	
		
		try {
			Thread.sleep(3000); //3 sec delay
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		
		driver.close();
		System.out.println("Browser closed");
		
	}






}
