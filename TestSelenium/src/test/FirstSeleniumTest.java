package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumTest {

	public static void main(String[] args) {
		try {
			
			System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			String url = "https://www.selenium.dev/";
			driver.get(url);
			
		}catch (Exception exp) {
			System.out.println("Cause is " + exp.getCause());
			System.out.println("Message is " + exp.getMessage());
			exp.printStackTrace();
		}
	}
	
}
