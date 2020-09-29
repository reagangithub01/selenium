package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
//import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredBrowserCapabilitiesDemo {

	static WebDriver driver = null;
	
	public static void main(String[] args) {
		
		//DesiredCapabilities caps = new DesiredCapabilities();
		InternetExplorerOptions caps = new InternetExplorerOptions();
		caps.setCapability("ignoreProtectedModeSettings", true);
		caps.setCapability("initialBrowserUrl", "https://google.com");
		
		System.setProperty("webdriver.ie.driver","./driver/IEDriverServer.exe");
		driver = new InternetExplorerDriver(caps);
		
		driver.manage().window().maximize();
		//driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("ABCD");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
		driver.close();
		driver.quit();
		System.out.println("Test completed using Internet Explorer");
		
	}


}
