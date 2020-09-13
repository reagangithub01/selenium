package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstSeleniumTest {

	static String browser;
	static WebDriver driver;

	public static void main(String[] args) {
		try {

			setBrowser();
			setBrowserConfig();
			runTest();

		}catch (Exception exp) {
			System.out.println("Cause is " + exp.getCause());
			System.out.println("Message is " + exp.getMessage());
			exp.printStackTrace();
		}
	}

	//Set Functions per Actions
	//setBrowser
	//setBrowserConfig
	//runTest

	public static void setBrowser() {
		browser="Chrome";
	}

	public static void setBrowserConfig() {
		
		if(browser.contains("Firefox")) {
		//for Firefox
		System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
		System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		driver = new FirefoxDriver();
		}
		
		if(browser.contains("Chrome")) {
		//for Chrome
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		//WebDriverManager.chromedriver().setup(); // with error
		driver = new ChromeDriver();
		}
	}

	public static void runTest() {

		driver.manage().window().maximize();
		//String url = "https://hago-pilot-model-portal.herokuapp.com/";
		String url = "https://twitter.com/";
		driver.get(url);
		System.out.println("Browser running");
		
		//3 sec delay
		try {
			Thread.sleep(3000);
		} catch (Exception exp) {
			// TODO Auto-generated catch block
			exp.printStackTrace();
		}
		driver.close();
		System.out.println("Browser closed");
		
	}






}
