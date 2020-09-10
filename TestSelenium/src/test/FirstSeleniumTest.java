package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstSeleniumTest {

	public static void main(String[] args) {
		try {
			
			System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
			//WebDriverManager.chromedriver().setup(); // with error
			WebDriver driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			String url = "https://hago-pilot-model-portal.herokuapp.com/";
			driver.get(url);
			System.out.println("Chrome browser running");
			//5 sec delay
			Thread.sleep(5000);
			driver.close();
			System.out.println("Chrome browser closed");
			
		}catch (Exception exp) {
			System.out.println("Cause is " + exp.getCause());
			System.out.println("Message is " + exp.getMessage());
			exp.printStackTrace();
		}
	}
	
}
