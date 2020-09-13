package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import test.FirstSeleniumTest;

public class PropertiesFile {

	static Properties prop = new Properties();
	
	public static void main(String[] args) {
		readPropertiesFile();
		writePropertiesFile();
	}
	
	public static void readPropertiesFile() {
		try {
			InputStream input = new FileInputStream("C:\\JavaProjects\\GitHubRepository\\selenium\\TestSelenium\\src\\config\\config.properties");
			prop.load(input);
			//System.out.println(prop.getProperty("browser"));
			FirstSeleniumTest.browser = prop.getProperty("browser");
			System.out.println(FirstSeleniumTest.browser);
			
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}
	
	public static void writePropertiesFile() {
		try {
			OutputStream output = new FileOutputStream("C:\\JavaProjects\\GitHubRepository\\selenium\\TestSelenium\\src\\config\\config.properties");
			prop.setProperty("browser","Chrome");
			prop.setProperty("result", "Passed"); //adding variable and value via code and NOT setting directly to property file.
			prop.store(output, "Successfully changed value of Browser"); //or put null
			System.out.println("Changed Properties File Browser Value");
			
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		
	}
	
	
}
