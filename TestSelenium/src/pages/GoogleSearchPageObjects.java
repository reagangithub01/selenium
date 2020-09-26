package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageObjects {
	
	WebDriver driver = null;
	
	By textbox_search = By.name("q");
	By button_search = By.xpath("/html/body/div[2]/div[2]/form/div[2]/div[1]/div[3]/center/input[1]");
	
	public GoogleSearchPageObjects(WebDriver driver1) {
		this.driver = driver1;
	}
	
	public void setTextInSearchBox(String text) {
		driver.findElement(textbox_search).sendKeys(text);
	}

	public void clickSearchButton() {
		driver.findElement(button_search).sendKeys(Keys.RETURN);
	}
	
}
